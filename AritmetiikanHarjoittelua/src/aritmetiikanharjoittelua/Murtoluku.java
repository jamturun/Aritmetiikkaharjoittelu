                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     package aritmetiikanharjoittelua;

/**
 * 
 * @author Turunen Joonas
 * @version 1.1
 * 
 * Luokka, jonka ilmentymänä on Murtoluku-olio. Tämän luokan tehtävänä on koota 
 * murtoluku annetuista kokonaisluvuista.
 
 */
public class Murtoluku {

    /**
     * Luotavan murtoluvun osoittaja
     */
    private int osoittaja;
    
    /**
     * Luotavan murtoluvun nimittäjä
     */
    private int nimittaja;
    
/**
 * Konstruktori, joka luo murtoluvun.
 * Murtoluku sievennetään soveltaen Eukleideen algoritmia.
 * Negatiivista nimittäjää ei sallita.
 * 
 * @param osoittaja Murtoluvun osoittaja
 * @param nimittaja Murtoluvun nimittäja
 */
    public Murtoluku(int osoittaja, int nimittaja) {
        int a = osoittaja;
        int b = nimittaja;

        while (b != 0) {
            int c = a;
            a = b;
            b = c % b;
        }
        if (nimittaja / a > 0) {
            this.osoittaja = osoittaja / a;
            this.nimittaja = nimittaja / a;
        } else {
            this.osoittaja = -1 * osoittaja / a;
            this.nimittaja = -1 * nimittaja / a;
        }
    }

    /**
     * Konstruktori, joka luo kokonaisluvun.
     * Nimittäjäksi asetetaan 1.
     * 
     * @param osoittaja Luotava kokonaisluku
     */
    public Murtoluku(int osoittaja) {
        this.osoittaja = osoittaja;
        this.nimittaja = 1;
    }

    /**
     * Metodi palauttaa murtoluvun osoittajan.
     * 
     * @return osoittaja
     */
    public int haeOsoittaja() {
        return osoittaja;
    }

    /**
     * Metodi palauttaa murtoluvun nimittäjän.
     * 
     * @return nimittäjä
     */
    public int haeNimittaja() {
        return this.nimittaja;
    }

    /**
     * Metodi palauttaa murtoluvun esityksen tulostusta varten.
     * Murtoluku esitetään String-muodossa "osoittaja/nimittäjä",
     * kokonaisluku muodossa "kokonaisluku"
     * 
     * @return murtoluvun esitys 
     */
    public String toString() {
        if (nimittaja == 1) {
            return osoittaja + "";
        } else if (osoittaja != nimittaja) {
            return osoittaja + "/" + nimittaja;
        } else {
            return osoittaja + "";
        }
    }

    /**
     * Metodi summaa kaksi murtolukua.
     * 
     * @param toinen Murtoluku, joka summataan ensimmäiseen
     * 
     * @return murtolukujen summa
     */
    public Murtoluku lisaa(Murtoluku toinen) {
        int uusiosoittaja = this.osoittaja * toinen.nimittaja + toinen.osoittaja * this.nimittaja;
        int uusinimittaja = this.nimittaja * toinen.nimittaja;
        Murtoluku uusi = new Murtoluku(uusiosoittaja, uusinimittaja);
        return uusi;
    }

    /**
     * Metodi laskee kahden murtoluvun erotuksen.
     * 
     * @param toinen Murtoluku, joka vähennetään ensimmäisestä
     * 
     * @return murtolukujen erotus 
     */
    public Murtoluku vahenna(Murtoluku toinen) {
        int uusiosoittaja = this.osoittaja * toinen.nimittaja - toinen.osoittaja * this.nimittaja;
        int uusinimittaja = this.nimittaja * toinen.nimittaja;
        Murtoluku uusi = new Murtoluku(uusiosoittaja, uusinimittaja);
        return uusi;
    }

    /**
     * Metod kertoo kaksi murtolukua keskenään.
     * 
     * @param toinen Murtoluku, joka kerrotaan ensimmäisen kanssa
     * 
     * @return murtolukujen tulo 
     */
    public Murtoluku kerro(Murtoluku toinen) {
        int uusiosoittaja = this.osoittaja * toinen.osoittaja;
        int uusinimittaja = this.nimittaja * toinen.nimittaja;
        Murtoluku uusi = new Murtoluku(uusiosoittaja, uusinimittaja);
        return uusi;
    }

    /**
     * Metodi laskee kahden murtoluvun osamäärän.
     * 
     * @param toinen Murtoluku, jolla ensimmäinen murtoluku jaetaan
     * 
     * @return murtolukujen osamäärä 
     */
    public Murtoluku jaa(Murtoluku toinen) {
        int uusiosoittaja = this.osoittaja * toinen.nimittaja;
        int uusinimittaja = this.nimittaja * toinen.osoittaja;
        Murtoluku uusi = new Murtoluku(uusiosoittaja, uusinimittaja);
        return uusi;
    }
}
