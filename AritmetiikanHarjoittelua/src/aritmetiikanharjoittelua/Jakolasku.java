package aritmetiikanharjoittelua;

/**
 * 
 * @author jamturun
 * @version 1.1
 */
public class Jakolasku implements Laskutoimitus {

    /**
     * Jakolaskun ensimmäinen jäsen
     */
    private Murtoluku eka;
    
    /**
     * Jakolaskun toinen jäsen
     */
    private Murtoluku toka;

    /**
    * Konstruktori luo Jakolasku-olion. Olion tietosisältönä ovat
     * murtoluvut eka ja toka.
     * 
     * @param eka ensimmäinen murtoluku
     * @param toka toinen murtoluku
     */
    public Jakolasku(Murtoluku eka, Murtoluku toka) {
        this.eka = eka;
        this.toka = toka;
    }

     /**
     * Metodi laskee laskutoimituksen tietosisältönä olevien
     * murtolukujen osamäärän.
     * 
     * @return murtolukujen osamäärä 
     */
    @Override
    public Murtoluku laske() {
        return eka.jaa(toka);
    }
    
    /**
     * Metodi palauttaa Jakolaskun ensimmäisen jäsenen.
     * 
     * @return ensimmäinen murtoluku 
     */
    @Override
     public Murtoluku haeEka() {
        return eka;
    }
    
    /**
     * Metodi palauttaa Jakolaskun toisen jäsenen.
     * 
     * @return toinen murtoluku 
     */
    @Override
    public Murtoluku haeToka() {
        return toka;
    }

    /**
     * Metodi palauttaa Jakolaskun esityksen tulostusta varten.
     * Jakolasku esitetään String-muodossa "ensimmäinen murtoluku / toinen
     * murtoluku". Sulkuja käytetään laskujärjestyksen osoittamiseksi, mikäli
     * lasketaan "aidoilla" murtoluvuilla.
     * 
     * @return jakolaskun esitys 
     */
    @Override
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
