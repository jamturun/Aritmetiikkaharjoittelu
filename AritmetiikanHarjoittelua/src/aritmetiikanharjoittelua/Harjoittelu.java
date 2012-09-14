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

    public Harjoittelu(Random arpoja, int numerot) {
        this.arpoja = arpoja;
        this.numerot = numerot;
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
        int osoittaja = arvoLuvut();
        int nimittaja = arvoLuvut();
        if (nimittaja == 0) {
            nimittaja = 1;
        }
        Murtoluku murtoluku = new Murtoluku(Math.abs(osoittaja),
                Math.abs(nimittaja));
        return murtoluku;
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
            laskutoimitus = arvoLaskuPositiiviKokonaisluvuilla(toimitus);
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
        while (true) {
            if (laskutoimitus.laske().haeNimittaja() == 1) {
                break;
            }
            laskutoimitus = arvoLaskuPositiiviKokonaisluvuilla(toimitus);
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

    public boolean onkoVahennyslasku(int laskutoimitus) {
        if (laskutoimitus == 2) {
            return true;
        } else {
            return false;
        }
    }

    public boolean onkoJakolasku(int laskutoimitus) {
        if (laskutoimitus == 4) {
            return true;
        } else {
            return false;
        }
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

    public void harjoittele() {
        while (true) {
            int toimitus = arvoLaskutoimitus();
            Laskutoimitus laskutoimitus = arvoLasku(toimitus);
            System.out.println(laskutoimitus);
            System.out.println("Anna osoittaja: ");
            int osoittaja = Integer.parseInt(input.nextLine());
            System.out.println("Anna nimittäjä:");
            int nimittaja = Integer.parseInt(input.nextLine());
            Murtoluku vastaus = new Murtoluku(osoittaja, nimittaja);
            System.out.println("Vastaus: " + vastaus);
            if (laskutoimitus.laske().haeOsoittaja() == osoittaja
                    && laskutoimitus.laske().haeNimittaja() == nimittaja) {
                System.out.println("Oikein!");
            } else {
                System.out.println("Väärin!");
            }
        }
    }

    public Laskutoimitus arvoLasku(int toimitus) {
        if (pelkatKokonaisluvut == true && negatiiviLuvutMukana == false
                && salliNegatiiviVastaus == true
                && vainKokonaislukuVastaus == true) {
            if (toimitus == 4) {
                return arvoKokonaislukuTulosLaskuPositiiviKokonaisluvuilla(toimitus);
            } else {
                return arvoPositiiviTulosLaskuPositiiviKokonaisluvuilla(toimitus);
            }
        } else if (pelkatKokonaisluvut == true && negatiiviLuvutMukana == false
                && salliNegatiiviVastaus == false
                && vainKokonaislukuVastaus == false) {
            return arvoPositiiviTulosLaskuPositiiviKokonaisluvuilla(toimitus);
        } else if (pelkatKokonaisluvut == true && negatiiviLuvutMukana == true
                && salliNegatiiviVastaus == true
                && vainKokonaislukuVastaus == true) {
            if (toimitus == 4) {
                return arvoKokonaislukuTulosLaskuKokonaisluvuilla(toimitus);
            } else {
                return arvoLaskuKokonaisluvuilla(toimitus);
            }
        } else if (pelkatKokonaisluvut == true && negatiiviLuvutMukana == true
                && salliNegatiiviVastaus == true
                && vainKokonaislukuVastaus == false) {
            return arvoLaskuKokonaisluvuilla(toimitus);
        } else if (pelkatKokonaisluvut == false && negatiiviLuvutMukana == false
                && salliNegatiiviVastaus == true
                && vainKokonaislukuVastaus == false) {
            return arvoLaskuPositiiviLuvuilla(toimitus);
        } else if (pelkatKokonaisluvut == false && negatiiviLuvutMukana == false
                && salliNegatiiviVastaus == false
                && vainKokonaislukuVastaus == false) {
            return arvoPositiiviTulosLaskuPositiiviKokonaisluvuilla(toimitus);
        } else {
            return arvoSatunnainenLasku(toimitus);
        }
    }
}
