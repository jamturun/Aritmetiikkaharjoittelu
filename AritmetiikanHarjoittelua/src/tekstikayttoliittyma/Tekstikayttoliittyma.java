package tekstikayttoliittyma;

import aritmetiikanharjoittelua.Harjoittelu;
import aritmetiikanharjoittelua.Laskutoimitus;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

public class Tekstikayttoliittyma {

    public static Scanner input = new Scanner(System.in);

    public void uusiPeli() {
        Random arpoja = new Random();

        boolean kokonaisluvut = true;
        boolean negatiiviluvut = false;
        boolean negatiivivastaus = false;
        boolean kokonaislukuvastaus = true;
        ArrayList<Integer> laskutoimitukset = new ArrayList<Integer>();

        System.out.println("Valitaan laskutoimitukset.");
        System.out.println("");
        System.out.print("Yhteenlasku (k/e) ");
        String yhteenlasku = input.nextLine();
        if (yhteenlasku.equals("k")) {
            laskutoimitukset.add(1);
        }
        System.out.print("Vähennyslasku (k/e) ");
        String vahennyslasku = input.nextLine();
        if (vahennyslasku.equals("k")) {
            laskutoimitukset.add(2);
        }
        System.out.print("Kertolasku (k/e) ");
        String kertolasku = input.nextLine();
        if (kertolasku.equals("k")) {
            laskutoimitukset.add(3);
        }
        System.out.print("Jakolasku (k/e) ");
        String jakolasku = input.nextLine();
        if (jakolasku.equals("k")) {
            laskutoimitukset.add(4);
        }
        System.out.println("");
        System.out.println("Valitaan vaikeusaste.");
        System.out.println("");

        System.out.print("Pelkät kokonaisluvut? (k/e) ");
        String vastaus1 = input.nextLine();

        if (vastaus1.equals("e")) {
            kokonaisluvut = false;
            kokonaislukuvastaus = false;
        }
        System.out.print("Negatiiviset luvut mukana? (k/e) ");
        String vastaus2 = input.nextLine();

        if (vastaus2.equals("k")) {
            negatiiviluvut = true;
            negatiivivastaus = true;
        }

        if (kokonaisluvut == true && laskutoimitukset.contains(4)) {
            System.out.print("Onko vastaus aina kokonaisluku? (k/e) ");
            String vastaus3 = input.nextLine();
            if (vastaus3.equals("e")) {
                kokonaislukuvastaus = false;
            }
        }

        if (negatiiviluvut == false && laskutoimitukset.contains(2)) {
            System.out.print("Voiko vastaus olla negatiivinen? (k/e) ");
            String vastaus4 = input.nextLine();
            if (vastaus4.equals("k")) {
                negatiivivastaus = true;
            }
        }

        System.out.print("Anna kysyttävien lukujen enimmäispituus numeroina: ");
        int numerot = Integer.parseInt(input.nextLine());

        Harjoittelu harjoittelu = new Harjoittelu(arpoja, kokonaisluvut,
                negatiiviluvut, negatiivivastaus, kokonaislukuvastaus, numerot,
                laskutoimitukset);
        System.out.println("");
        System.out.println("Aloitetaan harjoittelu.");
        System.out.println("");
        while (true) {
            int toimitus = harjoittelu.arvoLaskutoimitus();
            Laskutoimitus lasku = harjoittelu.arvoLasku(toimitus);
            System.out.println(lasku);
            System.out.println("");
            int osoittaja = 1;
            int nimittaja = 1;
            if (!kokonaislukuvastaus) {
                System.out.print("Anna osoittaja: ");
                osoittaja = Integer.parseInt(input.nextLine());
                System.out.print("Anna nimittäjä: ");
                nimittaja = Integer.parseInt(input.nextLine());
            } else {
                System.out.print("Anna vastaus (kokonaisluku): ");
                osoittaja = Integer.parseInt(input.nextLine());
                nimittaja = 1;
            }
            if (osoittaja == lasku.laske().haeOsoittaja()
                    && nimittaja == lasku.laske().haeNimittaja()) {
                System.out.println("");
                System.out.println("Oikein! ");
                System.out.println("");
            } else {
                System.out.println("");
                System.out.println("Väärin! ");
                System.out.println("");
                System.out.println("Oikea vastaus: " + lasku.laske());
                System.out.println("");
            }
        }

    }
}
