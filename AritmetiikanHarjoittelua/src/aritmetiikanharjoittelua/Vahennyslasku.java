package aritmetiikanharjoittelua;

/**
 *
 * @author Turunen Joonas
 * @version 1.1
 */
public class Vahennyslasku implements Laskutoimitus {

    /*
     * Vähennyslaskun ensimmäinen jäsen
     */
    private Murtoluku eka;
    /**
     * Vähennyslaskun toinen jäsen
     */
    private Murtoluku toka;

    /**
     * Konstruktori luo Vahennyslasku-olion. Olion tietosisältönä ovat
     * murtoluvut eka ja toka.
     *
     * @param eka Ensimmäinen murtoluku
     * @param toka Toinen murtoluku
     */
    public Vahennyslasku(Murtoluku eka, Murtoluku toka) {
        this.eka = eka;
        this.toka = toka;
    }

    /**
     * Metodi laskee laskutoimituksen tietosisältönä olevien
     * murtolukujen erotuksen.
     * 
     * @return murtolukujen erotus 
     */
    @Override
    public Murtoluku laske() {
        return eka.vahenna(toka);
    }

    /**
     * Metodi palauttaa Vahennyslaskun ensimmäisen jäsenen.
     * 
     * @return ensimmäinen murtoluku 
     */
    @Override
    public Murtoluku haeEka() {
        return eka;
    }

    /**
     * Metodi palauttaa Vahennyslaskun toisen jäsenen.
     * 
     * @return toinen murtoluku 
     */
    @Override
    public Murtoluku haeToka() {
        return toka;
    }

    /**
     * Metodi palauttaa Vahennyslaskun esityksen tulostusta varten.
     * Vähennyslasku esitetään String-muodossa "ensimmäinen murtoluku - toinen
     * murtoluku". Jos toinen murtoluku on negatiivinen, on sen ympärillä sulut.
     * 
     * @return vähennyslaskun esitys 
     */
    @Override
    public String toString() {
        if (toka.haeOsoittaja() < 0) {
            return eka.toString() + " - (" + toka.toString() + ")";
        } else {
            return eka.toString() + " - " + toka.toString();
        }
    }
}
