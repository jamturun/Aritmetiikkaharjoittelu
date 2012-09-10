package aritmetiikanharjoittelua;

public class AritmetiikanHarjoittelua {

    public static void main(String[] args) {
       
        Murtoluku eka = new Murtoluku(1, 2);
        Murtoluku toka = new Murtoluku(1, 3);
        
        Yhteenlasku summa = new Yhteenlasku(eka, toka);
        System.out.println(summa);
        Harjoittelu harjoittelu = new Harjoittelu();
        harjoittelu.harjoittele();
    }
}
