package aritmetiikanharjoittelua;

import aritmetiikanharjoittelua.Murtoluku;

/**
 * 
 * @author Turunen Joonas
 * @version 1.1
 */
public class Yhteenlasku implements Laskutoimitus {

    /**
     * Yhteenlaskun ensimmäinen jäsen
     */
    private Murtoluku eka;
    
    /**
     * Yhteenlaskun toinen jäsen
     */
    private Murtoluku toka;

    /**
     * Konstruktori luo Yhteenlasku-olion.
     * Olion tietosisältönä ovat murtoluvut eka ja toka.
     * 
     * @param eka Ensimmäinen murtoluku
     * @param toka Toinen murtoluku
     */
    public Yhteenlasku(Murtoluku eka, Murtoluku toka) {
        this.eka = eka;
        this.toka = toka;
    }

    /**
     * Metodi laskee laskutoimituksen tietosisältönä olevat
     * murtoluvut yhteen.
     * 
     * @return murtolukujen summa 
     */
    @Override
    public Murtoluku laske() {
        return eka.lisaa(toka);
    }
    
    /**
     * Metodi palauttaa Yhteenlaskun ensimmäisen jäsenen.
     * 
     * @return ensimmäinen murtoluku 
     */
    @Override
    public Murtoluku haeEka() {
        return eka;
    }
    
    /**
     * Metodi palauttaa Yhteenlaskun toisen jäsenen.
     * 
     * @return toinen murtoluku 
     */
    @Override
    public Murtoluku haeToka() {
        return toka;
    }

    /**
     * Metodi palauttaa Yhteenlaskun esityksen tulostusta varten.
     * Yhteenlasku esitetään String-muodossa "ensimmäinen murtoluku + toinen
     * murtoluku". Jos toinen murtoluku on negatiivinen, on sen ympärillä sulut.
     * 
     * @return yhteenlaskun esitys 
     */
    @Override
    public String toString() {
        if (toka.haeOsoittaja() < 0) {
            return eka.toString() + " + (" + toka.toString() + ")";
        } else {
            return eka.toString() + " + " + toka.toString();
        }
    }
}