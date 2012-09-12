package aritmetiikanharjoittelua;

import java.util.Random;
import java.util.TreeMap;

public class AritmetiikanHarjoittelua {

    public static TreeMap lukujenListaus(Harjoittelu harjoittelu) {
        TreeMap<Integer, Integer> lukumaarat = new TreeMap<Integer, Integer>();
        for (int i = 1; i < 10000; i++) {
            int luku = harjoittelu.arvoLuvut();
            if (lukumaarat.containsKey(luku)) {
                int vanhaMaara = lukumaarat.get(luku);
                int uusiMaara = vanhaMaara + 1;
                lukumaarat.put(luku, uusiMaara);
            } else {
                lukumaarat.put(luku, 1);
            }
        }
        return lukumaarat;
    }

    public static void main(String[] args) {

          Random arpoja = new Random();
        Harjoittelu harjoittelu = new Harjoittelu(arpoja, 1);
        TreeMap<Integer, Integer> lukumaarat = lukujenListaus(harjoittelu);
        for (int luku : lukumaarat.keySet()) {
            System.out.println(luku + " : " + lukumaarat.get(luku));
            
        }
    }
}