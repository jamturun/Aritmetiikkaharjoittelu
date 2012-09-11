package aritmetiikanharjoittelua;

import java.util.*;

public class Harjoittelu {

    public static Scanner input = new Scanner(System.in);
    private ArrayList<Integer> laskutoimitukset = new ArrayList<Integer>();
    private boolean pelkatKokonaisluvut;
    private boolean negatiiviLuvutMukana;
    private boolean salliNegatiivinenVastaus;
    private boolean vainKokonaislukuVastaus;
    private int numerot;
    private Random arpoja;
    
    public Harjoittelu(Random arpoja) {
        this.arpoja = arpoja;
    }
    
     public int arvoLuvut() {
        int numerot = this.numerot;
        int ylaraja = (int) (2 * Math.pow(10, numerot) - 1);
        return (int) (arpoja.nextInt(ylaraja) - Math.pow(10, ylaraja) + 1);
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
        Murtoluku murtoluku = new Murtoluku(Math.abs(osoittaja), Math.abs(nimittaja));
        return murtoluku;
    }

    public Murtoluku arvoPositiiviKokonaisluku() {
        int luku = arvoLuvut();
        luku = Math.abs(luku);
        Murtoluku kokonaisluku = new Murtoluku(luku);
        return kokonaisluku;
    }

    public void harjoittele() {
        while (true) {
            Laskutoimitus laskutoimitus = arvoSatunnainenLasku();
            System.out.println(laskutoimitus);
            System.out.println("Anna osoittaja: ");
            int osoittaja = Integer.parseInt(input.nextLine());
            System.out.println("Anna nimittäjä:");
            int nimittaja = Integer.parseInt(input.nextLine());
            Murtoluku vastaus = new Murtoluku(osoittaja, nimittaja);
            System.out.println("Vastaus: " + vastaus);
            if (laskutoimitus.laske().haeOsoittaja() == osoittaja && laskutoimitus.laske().haeNimittaja() == nimittaja) {
                System.out.println("Oikein!");
            } else {
                System.out.println("Väärin!");
            }
        }
    }

    public Laskutoimitus arvoSatunnainenLasku() {
        Murtoluku eka = arvoMurtoluku();
        Murtoluku toka = arvoMurtoluku();
        int toimitus = arvoLaskutoimitus();
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

    public Laskutoimitus arvoPositiiviTulosLasku() {
        Laskutoimitus laskutoimitus = arvoSatunnainenLasku();
        while (true) {
            if (laskutoimitus.laske().haeOsoittaja() >= 0) {
                break;
            }
            laskutoimitus = arvoSatunnainenLasku();
        }
        return laskutoimitus;
    }

    public Laskutoimitus arvoKokonaislukuTulosLasku() {
        Laskutoimitus laskutoimitus = arvoSatunnainenLasku();
        while (true) {
            if (laskutoimitus.laske().haeNimittaja() == 1) {
                break;
            }
            laskutoimitus = arvoSatunnainenLasku();
        }
        return laskutoimitus;
    }

    public Laskutoimitus arvoSatunnainenLaskuKokonaisluvuilla() {
        int kokonaisluku1 = arvoLuvut();
        int kokonaisluku2 = arvoLuvut();
        Murtoluku eka = new Murtoluku(kokonaisluku1);
        Murtoluku toka = new Murtoluku(kokonaisluku2);
        int toimitus = arvoLaskutoimitus();
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

    public Laskutoimitus arvoLaskuPositiiviKokonaisluvuilla() {
        Laskutoimitus laskutoimitus = arvoSatunnainenLaskuKokonaisluvuilla();
        while (true) {
            int eka = laskutoimitus.haeEka().haeOsoittaja();
            int toka = laskutoimitus.haeToka().haeOsoittaja();
            if (eka >= 0 && toka >= 0) {
                break;
            }
            laskutoimitus = arvoSatunnainenLaskuKokonaisluvuilla();
        }
        return laskutoimitus;
    }

    public Laskutoimitus arvoPositiiviTulosLaskuPositiiviKokonaisluvuilla() {
        Laskutoimitus laskutoimitus = arvoLaskuPositiiviKokonaisluvuilla();
        while (true) {
            Murtoluku tulos = laskutoimitus.laske();
            if (tulos.haeOsoittaja() >= 0) {
                break;
            }
            laskutoimitus = arvoLaskuPositiiviKokonaisluvuilla();
        }
        return laskutoimitus;
    }

    public Murtoluku vaihdaNolla(Murtoluku murtoluku) {
        while(true) {
            if(murtoluku.haeOsoittaja() != 0) {
                break;
            }
            murtoluku = arvoMurtoluku();
        }
        return murtoluku;
    }
}
