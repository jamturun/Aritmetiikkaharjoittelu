package aritmetiikanharjoittelua;

/**
 * 
 * @author Turunen Joonas
 * @version 1.1
 */
public class Kertolasku implements Laskutoimitus {

    /**
     * Kertolaskun ensimmäinen jäsen
     */
    private Murtoluku eka;
    
    /**
     * Kertolaskun toinen jäsen
     */
    private Murtoluku toka;

    /**
     * Konstruktori luo Kertolasku-olion. Olion tietosisältönä ovat
     * murtoluvut eka ja toka.
     * 
     * @param eka ensimmäinen murtoluku
     * @param toka toinen murtoluku
     */
    public Kertolasku(Murtoluku eka, Murtoluku toka) {
        this.eka = eka;
        this.toka = toka;
    }

    /**
     * Metodi laskee laskutoimituksen tietosisältönä olevien
     * murtolukujen tulon.
     * 
     * @return murtolukujen tulo 
     */
    @Override
    public Murtoluku laske() {
        return eka.kerro(toka);
    }
    
    /**
     * Metodi palauttaa Kertolaskun ensimmäisen jäsenen.
     * 
     * @return ensimmäinen murtoluku 
     */
    @Override
     public Murtoluku haeEka() {
        return eka;
    }
    
    /**
     * Metodi palauttaa Kertolaskun toisen jäsenen.
     * 
     * @return toinen murtoluku 
     */
    @Override
    public Murtoluku haeToka() {
        return toka;
    }

    /**
     * Metodi palauttaa Kertolaskun esityksen tulostusta varten.
     * Kertolasku esitetään String-muodossa "ensimmäinen murtoluku * toinen
     * murtoluku". Jos toinen murtoluku on negatiivinen, on sen ympärillä sulut.
     * 
     * @return kertolaskun esitys 
     */
    @Override
    public String toString() {
        if (toka.haeOsoittaja() < 0) {
            return eka.toString() + " * (" + toka.toString() + ")";
        } else {
            return eka.toString() + " * " + toka.toString();
        }
    }
}
