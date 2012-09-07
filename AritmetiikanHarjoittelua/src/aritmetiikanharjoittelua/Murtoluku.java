package aritmetiikanharjoittelua;

public class Murtoluku {

    private int osoittaja;
    private int nimittaja;

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

    public Murtoluku(int osoittaja) {
        this.osoittaja = osoittaja;
        this.nimittaja = 1;
    }

    public int haeOsoittaja() {
        return this.osoittaja;
    }

    public int haeNimittaja() {
        return this.nimittaja;
    }

    public String toString() {
        if (nimittaja == 1) {
            return osoittaja + "";
        } else if (osoittaja != nimittaja) {
            return osoittaja + "/" + nimittaja;
        } else {
            return osoittaja + "";
        }
    }

    public Murtoluku lisaa(Murtoluku toinen) {
        int uusiosoittaja = this.osoittaja * toinen.nimittaja + toinen.osoittaja * this.nimittaja;
        int uusinimittaja = this.nimittaja * toinen.nimittaja;
        Murtoluku uusi = new Murtoluku(uusiosoittaja, uusinimittaja);
        return uusi;
    }

    public Murtoluku vahenna(Murtoluku toinen) {
        int uusiosoittaja = this.osoittaja * toinen.nimittaja - toinen.osoittaja * this.nimittaja;
        int uusinimittaja = this.nimittaja * toinen.nimittaja;
        Murtoluku uusi = new Murtoluku(uusiosoittaja, uusinimittaja);
        return uusi;
    }

    public Murtoluku kerro(Murtoluku toinen) {
        int uusiosoittaja = this.osoittaja * toinen.osoittaja;
        int uusinimittaja = this.nimittaja * toinen.nimittaja;
        Murtoluku uusi = new Murtoluku(uusiosoittaja, uusinimittaja);
        return uusi;
    }

    public Murtoluku jaa(Murtoluku toinen) {
        int uusiosoittaja = this.osoittaja * toinen.nimittaja;
        int uusinimittaja = this.nimittaja * toinen.osoittaja;
        Murtoluku uusi = new Murtoluku(uusiosoittaja, uusinimittaja);
        return uusi;
    }
}
