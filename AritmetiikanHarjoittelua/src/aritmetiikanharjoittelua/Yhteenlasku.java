package aritmetiikanharjoittelua;

import aritmetiikanharjoittelua.Murtoluku;

public class Yhteenlasku implements Laskutoimitus {

    private Murtoluku eka;
    private Murtoluku toka;

    public Yhteenlasku(Murtoluku eka, Murtoluku toka) {
        this.eka = eka;
        this.toka = toka;
    }

    public Murtoluku laske() {
        return eka.lisaa(toka);
    }

    @Override
    public String toString() {
        if (toka.haeOsoittaja() < 0) {
            return eka.toString() + " + (" + toka.toString() + ")";
        } else {
            return eka.toString() + " + " + toka.toString();
        }
    }
}