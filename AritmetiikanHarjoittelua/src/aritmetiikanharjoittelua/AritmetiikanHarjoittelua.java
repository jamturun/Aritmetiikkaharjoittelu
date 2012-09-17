package aritmetiikanharjoittelua;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

public class AritmetiikanHarjoittelua {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        Random arpoja = new Random();

        boolean kokonaisluvut = true;
        boolean negatiiviluvut = false;
        boolean negatiivivastaus = false;
        boolean kokonaislukuvastaus = true;
        ArrayList<Integer> laskutoimitukset = new ArrayList<Integer>();

        System.out.println("Valitaan laskutoimitukset.");
        System.out.println("Yhteenlasku (k/e) ");
        String yhteenlasku = input.nextLine();
        if (yhteenlasku.equals("k")) {
            laskutoimitukset.add(1);
        }
        System.out.println("Vähennyslasku (k/e) ");
        String vahennyslasku = input.nextLine();
        if (vahennyslasku.equals("k")) {
            laskutoimitukset.add(2);
        }
        System.out.println("Kertolasku (k/e) ");
        String kertolasku = input.nextLine();
        if (kertolasku.equals("k")) {
            laskutoimitukset.add(3);
        }
        System.out.println("Jakolasku (k/e) ");
        String jakolasku = input.nextLine();
        if (jakolasku.equals("k")) {
            laskutoimitukset.add(4);
        }


        System.out.println("Pelkät kokonaisluvut? (k/e) ");
        String vastaus1 = input.nextLine();

        if (vastaus1.equals("e")) {
            kokonaisluvut = false;
            kokonaislukuvastaus = false;
        }
        System.out.println("Negatiiviset luvut mukana? (k/e) ");
        String vastaus2 = input.nextLine();

        if (vastaus2.equals("k")) {
            negatiiviluvut = true;
            negatiivivastaus = true;
        }

        if (kokonaisluvut == true && laskutoimitukset.contains(4)) {
            System.out.println("Onko vastaus aina kokonaisluku? (k/e) ");
            String vastaus3 = input.nextLine();
            if (vastaus3.equals("e")) {
                kokonaislukuvastaus = false;
            }
        }

        if (negatiiviluvut == false && laskutoimitukset.contains(2)) {
            System.out.println("Voiko vastaus olla negatiivinen? (k/e) ");
            String vastaus4 = input.nextLine();
            if (vastaus4.equals("k")) {
                negatiivivastaus = true;
            }
        }

        System.out.println("Anna kysyttävien lukujen enimmäispituus numeroina:");
        int numerot = Integer.parseInt(input.nextLine());

        Harjoittelu harjoittelu = new Harjoittelu(arpoja, kokonaisluvut,
                negatiiviluvut, negatiivivastaus, kokonaislukuvastaus, numerot,
                laskutoimitukset);
        System.out.println("Aloitetaan harjoittelu.");
        System.out.println("");
        while (true) {
            int toimitus = harjoittelu.arvoLaskutoimitus();
            Laskutoimitus lasku = harjoittelu.arvoLasku(toimitus);
            System.out.println(lasku);
            System.out.println("");
            System.out.println("Anna osoittaja: ");
            int osoittaja = Integer.parseInt(input.nextLine());
            System.out.println("Anna nimittäjä: ");
            int nimittaja = Integer.parseInt(input.nextLine());
            if (osoittaja == lasku.laske().haeOsoittaja()
                    && nimittaja == lasku.laske().haeNimittaja()) {
                System.out.println("Oikein! ");
                System.out.println("");
            } else {
                System.out.println("Väärin! ");
                System.out.println("");
                System.out.println("Oikea vastaus: " + lasku.laske());
            }
        }

    }
}
