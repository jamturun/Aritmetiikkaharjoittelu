package aritmetiikanharjoittelua;

import java.util.*;

public class Harjoittelu {

    public static Scanner input = new Scanner(System.in);
    private ArrayList<Integer> laskutoimitukset = new ArrayList<Integer>();
    private boolean pelkatKokonaisluvut;
    private boolean negatiiviLuvutMukana;
    private boolean salliNegatiiviVastaus;
    private boolean vainKokonaislukuVastaus;
    private int numerot;
    private Random arpoja;
    private ArrayList<Laskutoimitus> oikeinMenneet;
    private ArrayList<Laskutoimitus> vaarinMenneet;

    public Harjoittelu(Random arpoja, boolean kokonaisluvut, boolean negatiiviluvut,
            boolean negatiivivastaus, boolean kokonaislukuvastaus, int numerot,
            ArrayList<Integer> laskutoimitukset) {
        this.arpoja = arpoja;
        this.pelkatKokonaisluvut = kokonaisluvut;
        this.negatiiviLuvutMukana = negatiiviluvut;
        this.salliNegatiiviVastaus = negatiivivastaus;
        this.vainKokonaislukuVastaus = kokonaislukuvastaus;
        this.numerot = numerot;
        this.laskutoimitukset = laskutoimitukset;
        if (laskutoimitukset.contains(3) || laskutoimitukset.contains(4)) {
            if (this.numerot > 4) {
                this.numerot = 4;
            }
        } else if (this.numerot < 1) {
            this.numerot = 1;
        } else {
            if (this.numerot > 9) {
                this.numerot = 9;
            }
        }
    }

    public Harjoittelu(Random arpoja, boolean kokonaisluvut, boolean negatiiviluvut,
            boolean negatiivivastaus, boolean kokonaislukuvastaus, int numerot) {
        this.arpoja = arpoja;
        this.pelkatKokonaisluvut = kokonaisluvut;
        this.negatiiviLuvutMukana = negatiiviluvut;
        this.salliNegatiiviVastaus = negatiivivastaus;
        this.vainKokonaislukuVastaus = kokonaislukuvastaus;
        this.numerot = numerot;
    }

    public Harjoittelu(Random arpoja, int numerot) {
        this.arpoja = arpoja;
        this.numerot = numerot;
    }
    
    public int haeNumerot() {
        return this.numerot;
    }

    public int arvoLuvut() {

        int ylaraja = (int) (2 * Math.pow(10, numerot) - 2);
        return (int) (arpoja.nextInt(ylaraja) - Math.pow(10, numerot) + 1);
    }

    public int arvoLaskutoimitus() {
        int maara = laskutoimitukset.size();
        Collections.shuffle(laskutoimitukset);
        return laskutoimitukset.get(maara - 1);
    }

    public Murtoluku arvoMurtoluku() {
        int osoittaja = arvoLuvut();
        int nimittaja = arvoLuvut();
        if (nimittaja == 0) {
            nimittaja = 1;
        }
        Murtoluku murtoluku = new Murtoluku(osoittaja, nimittaja);
        return murtoluku;
    }

    public Murtoluku arvoKokonaisluku() {
        int luku = arvoLuvut();
        Murtoluku kokonaisluku = new Murtoluku(luku);
        return kokonaisluku;
    }

    public Murtoluku arvoPositiiviMurtoluku() {
        Murtoluku murtoluku = arvoMurtoluku();
        int osoittaja = Math.abs(murtoluku.haeOsoittaja());
        int nimittaja = murtoluku.haeNimittaja();
        Murtoluku uusi = new Murtoluku(osoittaja, nimittaja);
        return uusi;
    }

    public Murtoluku arvoPositiiviKokonaisluku() {
        int luku = arvoLuvut();
        luku = Math.abs(luku);
        Murtoluku kokonaisluku = new Murtoluku(luku);
        return kokonaisluku;
    }

    public Laskutoimitus arvoSatunnainenLasku(int toimitus) {
        Murtoluku eka = arvoMurtoluku();
        Murtoluku toka = arvoMurtoluku();
        Laskutoimitus laskutoimitus = valitseLaskutoimitus(toimitus, eka, toka);
        return laskutoimitus;
    }

    public Laskutoimitus arvoLaskuKokonaisluvuilla(int toimitus) {
        int kokonaisluku1 = arvoLuvut();
        int kokonaisluku2 = arvoLuvut();
        Murtoluku eka = new Murtoluku(kokonaisluku1);
        Murtoluku toka = new Murtoluku(kokonaisluku2);
        Laskutoimitus laskutoimitus = valitseLaskutoimitus(toimitus, eka, toka);
        return laskutoimitus;
    }

    public Laskutoimitus arvoLaskuPositiiviKokonaisluvuilla(int toimitus) {
        Laskutoimitus laskutoimitus = arvoLaskuKokonaisluvuilla(toimitus);
        while (true) {
            int eka = laskutoimitus.haeEka().haeOsoittaja();
            int toka = laskutoimitus.haeToka().haeOsoittaja();
            if (eka >= 0 && toka >= 0) {
                break;
            }
            laskutoimitus = arvoLaskuKokonaisluvuilla(toimitus);
        }
        return laskutoimitus;
    }

    public Laskutoimitus arvoLaskuPositiiviLuvuilla(int toimitus) {
        Laskutoimitus laskutoimitus = arvoSatunnainenLasku(toimitus);
        while (true) {
            int eka = laskutoimitus.haeEka().haeOsoittaja();
            int toka = laskutoimitus.haeToka().haeOsoittaja();
            if (eka >= 0 && toka >= 0) {
                break;
            }
            laskutoimitus = arvoSatunnainenLasku(toimitus);
        }
        return laskutoimitus;
    }

    public Laskutoimitus arvoPositiiviTulosLaskuPositiiviLuvuilla(int toimitus) {
        Laskutoimitus laskutoimitus = arvoLaskuPositiiviLuvuilla(toimitus);
        while (true) {
            Murtoluku tulos = laskutoimitus.laske();
            if (tulos.haeOsoittaja() >= 0) {
                break;
            }
            laskutoimitus = arvoLaskuPositiiviLuvuilla(toimitus);
        }
        return laskutoimitus;
    }

    public Laskutoimitus arvoKokonaislukuTulosLaskuKokonaisluvuilla(int toimitus) {
        Laskutoimitus laskutoimitus = arvoLaskuKokonaisluvuilla(toimitus);
        while (true) {
            if (laskutoimitus.laske().haeNimittaja() == 1) {
                break;
            }
            laskutoimitus = arvoLaskuKokonaisluvuilla(toimitus);
        }
        return laskutoimitus;
    }

    public Laskutoimitus arvoKokonaislukuTulosLaskuPositiiviKokonaisluvuilla(int toimitus) {
        Laskutoimitus laskutoimitus = arvoLaskuPositiiviKokonaisluvuilla(toimitus);
        if (toimitus == 4) {
            while (true) {
                if (laskutoimitus.laske().haeNimittaja() == 1) {
                    break;
                }
                laskutoimitus = arvoLaskuPositiiviKokonaisluvuilla(toimitus);
            }
        }
        return laskutoimitus;
    }

    public Laskutoimitus arvoPositiiviTulosLaskuPositiiviKokonaisluvuilla(int toimitus) {
        Laskutoimitus laskutoimitus = arvoLaskuPositiiviKokonaisluvuilla(toimitus);
        while (true) {
            if (laskutoimitus.laske().haeOsoittaja() >= 0) {
                break;
            }
            laskutoimitus = arvoLaskuPositiiviKokonaisluvuilla(toimitus);
        }
        return laskutoimitus;
    }

    public Murtoluku vaihdaNolla(Murtoluku murtoluku) {
        while (true) {
            if (murtoluku.haeOsoittaja() != 0) {
                break;
            }
            murtoluku = arvoMurtoluku();
        }
        return murtoluku;
    }

    public Laskutoimitus valitseLaskutoimitus(int toimitus, Murtoluku eka,
            Murtoluku toka) {
        if (toimitus == 1) {
            Yhteenlasku summa = new Yhteenlasku(eka, toka);
            return summa;
        } else if (toimitus == 2) {
            Vahennyslasku erotus = new Vahennyslasku(eka, toka);
            return erotus;
        } else if (toimitus == 3) {
            Kertolasku tulo = new Kertolasku(eka, toka);
            return tulo;
        } else {
            toka = vaihdaNolla(toka);
            Jakolasku osamaara = new Jakolasku(eka, toka);
            return osamaara;
        }
    }

    public int valitseTapaus() {
        int tapaus = (pelkatKokonaisluvut) ? 1 : 0;
        tapaus = (negatiiviLuvutMukana) ? tapaus + 2 : tapaus;
        tapaus = (salliNegatiiviVastaus) ? tapaus + 4 : tapaus;
        tapaus = (vainKokonaislukuVastaus) ? tapaus + 8 : tapaus;
        return tapaus;
    }

    public Laskutoimitus arvoLasku(int toimitus) {

        switch (valitseTapaus()) {
            case 0:
                return arvoPositiiviTulosLaskuPositiiviLuvuilla(toimitus);
            case 1:
                return arvoPositiiviTulosLaskuPositiiviKokonaisluvuilla(toimitus);
            case 4:
                return arvoLaskuPositiiviLuvuilla(toimitus);
            case 5:
                return arvoLaskuPositiiviKokonaisluvuilla(toimitus);
            case 6:
                return arvoSatunnainenLasku(toimitus);
            case 7:
                return arvoLaskuKokonaisluvuilla(toimitus);
            case 9:
                if (toimitus == 4) {
                    return arvoKokonaislukuTulosLaskuPositiiviKokonaisluvuilla(toimitus);
                } else {
                    return arvoPositiiviTulosLaskuPositiiviKokonaisluvuilla(toimitus);
                }
            case 13:
                return arvoKokonaislukuTulosLaskuPositiiviKokonaisluvuilla(toimitus);
            case 15:
                return arvoKokonaislukuTulosLaskuKokonaisluvuilla(toimitus);
            default:
                return arvoSatunnainenLasku(toimitus);
        }
    }

    public String toString(Laskutoimitus laskutoimitus) {
        return laskutoimitus.toString() + " = ";
    }
}
