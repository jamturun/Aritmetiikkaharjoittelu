package aritmetiikanharjoittelua;

public class Jakolasku implements Laskutoimitus {

    private Murtoluku eka;
    private Murtoluku toka;

    public Jakolasku(Murtoluku eka, Murtoluku toka) {
        this.eka = eka;
        this.toka = toka;
    }

    public Murtoluku laske() {
        return eka.jaa(toka);
    }

    public String toString() {
        if (eka.haeNimittaja() == 1 && toka.haeNimittaja() == 1) {
            return eka.toString() + " / " + toka.toString();
        } else if (eka.haeNimittaja() == 1 && toka.haeNimittaja() != 1) {
            return eka.toString() + " / (" + toka.toString() + ")";
        } else if (eka.haeNimittaja() != 1 && toka.haeNimittaja() == 1) {
            return "(" + eka.toString() + ") / " + toka.toString();
        } else {
            return "(" + eka.toString() + ") / (" + toka.toString() + ")";
        }
    }
}
