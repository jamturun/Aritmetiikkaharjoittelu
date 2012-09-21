
package aritmetiikanharjoittelua;

/**
 * 
 * @author Turunen Joonas
 * @version 1.1
 */
public interface Laskutoimitus {
    
    /**
     * Metodi suorittaa kahden murtoluvun välisen laskutoimituksen.
     * 
     * @return laskutoimituksen tulos 
     */
    public Murtoluku laske();
    
    /**
     * Metodi palauttaa laskutoimituksen esityksen tulostusta varten.
     * Esitys on String-muodossa.
     * 
     * @return laskutoimituksen esitys
     */
    public String toString();
    
    /**
     * Metodi palaittaa laskutoimituksen ensimmäisen jäsenen.
     * 
     * @return ensimmäinen murtoluku
     */
    public Murtoluku haeEka();
    
    /**
     * Metodi palauttaa laskutoimituksen toisen jäsenen.
     * 
     * @return toinen murtoluku 
     */
    public Murtoluku haeToka();

}
