package aritmetiikanharjoittelua;

public class Vahennyslasku implements Laskutoimitus {

    private Murtoluku eka;
    private Murtoluku toka;

    public Vahennyslasku(Murtoluku eka, Murtoluku toka) {
        this.eka = eka;
        this.toka = toka;
    }

    @Override
    public Murtoluku laske() {
        return eka.vahenna(toka);
    }
    
    @Override
     public Murtoluku haeEka() {
        return eka;
    }
    
    @Override
    public Murtoluku haeToka() {
        return toka;
    }

    @Override
    public String toString() {
        if (toka.haeOsoittaja() < 0) {
            return eka.toString() + " - (" + toka.toString() + ")";
        } else {
            return eka.toString() + " - " + toka.toString();
        }
    }
}
