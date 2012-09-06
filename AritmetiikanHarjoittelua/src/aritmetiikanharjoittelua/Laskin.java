package aritmetiikanharjoittelua;

public class Laskin {

    public Murtoluku summaaLuvut(Murtoluku a, Murtoluku b) {
        return a.lisaa(b);
    }

    public Murtoluku vahennaLuvut(Murtoluku a, Murtoluku b) {
        return a.vahenna(b);
    }

    public Murtoluku kerroLuvut(Murtoluku a, Murtoluku b) {
        return a.kerro(b);
    }

    public Murtoluku jaaLuvut(Murtoluku a, Murtoluku b) {
        return a.jaa(b);
    }
}
