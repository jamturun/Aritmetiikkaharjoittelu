package aritmetiikanharjoittelua;

import java.util.*;

/**
 *
 * @author Turunen Joonas
 * @version 1.1
 *
 * Luokka, jonka ilmentymänä on Harjoittelu-olio. Tämä luokka muodostaa
 * sovelluslogiikan rungon. Luokan sisällä tapahtuu laskutoimitusten arvonta
 * käyttäjän valitsemin parametrein.
 *
 */
public class Harjoittelu {

    /**
     * Scanner-olio arvojen syöttämistä varten
     */
    public static Scanner input = new Scanner(System.in);
    
    /**
     * Lista, joka sisältää harjoittelussa kysyttävät laskutoimitukset
     */
    private ArrayList<Integer> laskutoimitukset = new ArrayList<Integer>();
    
    /**
     * Kertoo, sisältävätkö laskutoimitukset pelkkiä kokonaislukuja
     */
    private boolean pelkatKokonaisluvut;
    
    /**
     * Kertoo, ovatko negatiiviset luvut mukana laskutoimituksissa
     */
    private boolean negatiiviLuvutMukana;
    
    /**
     * Kertoo, sallitaanko arvottavan laskutoimituksen tulokseksi negatiivinen
     * vastaus
     */
    private boolean salliNegatiiviVastaus;
    
    /**
     * Kertoo, sallitaanko vain laskutoimitukset, joiden tulos on kokonaisluku
     */
    private boolean vainKokonaislukuVastaus;
    
    /**
     * Kertoo, kuinka monta numeroa laskutoimituksissa esiintyvissä
     * kokonaisluvuissa (sisältäen osoittajat ja nimittäjät) voi enimmillään
     * esiintyä
     */
    private int numerot;
    
    /**
     * Satunnaislukugeneraattori
     */
    private Random arpoja;
    
    /**
     * Lista, johon tallennetaan väärin menneet laskutoimitukset
     */
    private ArrayList<Laskutoimitus> vaarinMenneet;

    /**
     * Konstruktori luo laskutoimitus-olion valituin parametrein. Konstruktori
     * luo satunnaislukugeneraattorin, ja sille annetaan parametreina käyttäjän
     * tekemät valinnat koskien niin vaikeusastetta kuin myös laskutoimitusten
     * määrää.
     *
     * @param arpoja Satunnaislukugeneraattori
     * @param kokonaisluvut Totuusarvo sille, sallitaanko pelkät kokonaisluvut
     * @param negatiiviluvut Totuusarvo sille, sallitaanko negatiiviset luvut
     * @param negatiivivastaus Totuusarvo sille, sallitaanko negatiivinen
     * vastaus
     * @param kokonaislukuvastaus Totuusarvo sille, sallitaanko vain
     * kokonaislukuvastaus
     * @param numerot Laskutoimituksessa esiintyvien kokonaislukujen
     * enimmäispituus numeroina
     * @param laskutoimitukset Lista, joka sisältää valitut laskutoimitukset
     */
    public Harjoittelu(Random arpoja, boolean kokonaisluvut, boolean negatiiviluvut,
            boolean negatiivivastaus, boolean kokonaislukuvastaus, int numerot,
            ArrayList<Integer> laskutoimitukset) {
        this.arpoja = arpoja;
        this.pelkatKokonaisluvut = kokonaisluvut;
        this.negatiiviLuvutMukana = negatiiviluvut;
        this.salliNegatiiviVastaus = negatiivivastaus;
        this.vainKokonaislukuVastaus = kokonaislukuvastaus;
        this.numerot = numerot;
        this.laskutoimitukset = laskutoimitukset;
        this.numerot = korjaaNumerot(numerot);
        vaarinMenneet = new ArrayList<Laskutoimitus>();
    }

    /**
     * Metodi korjaa numerot-muuttujan arvon sallituksi. Varmistetaan, että
     * int-tyypin ala- ja yläraja-arvot eivät tuota ongelmia laskutoimituksissa.
     * Estetään siis liian pienten ja suurten lukujen käsittely
     * tekstikäyttöliittymässä.
     *
     * @param numerot Laskutoimituksessa esiintyvien kokonaislukujen
     * enimmäispituus numeroina
     * @return kokonaislukujen enimmäispituus korjattuna
     */
    public int korjaaNumerot(int numerot) {
        if (laskutoimitukset.contains(3) || laskutoimitukset.contains(4)) {
            if (this.numerot > 4) {
                this.numerot = 4;
            }
        } else if (this.numerot < 1) {
            this.numerot = 1;
        } else {
            if (this.numerot > 9) {
                this.numerot = 9;
            }
        }
        return this.numerot;
    }

    /**
     * Vaihtoehtoinen konstruktori, jolle ei anneta laskutoimituksia. Käytetään
     * ohjelman testaamiseen.
     *
     * @param arpoja Satunnaislukugeneraattori
     * @param kokonaisluvut Totuusarvo sille, sallitaanko pelkät kokonaisluvut
     * @param negatiiviluvut Totuusarvo sille, sallitaanko negatiiviset luvut
     * @param negatiivivastaus Totuusarvo sille, sallitaanko negatiivinen
     * vastaus
     * @param kokonaislukuvastaus Totuusarvo sille, sallitaanko vain
     * kokonaislukuvastaus
     * @param numerot Laskutoimituksessa esiintyvien kokonaislukujen
     * enimmäispituus numeroina
     */
    public Harjoittelu(Random arpoja, boolean kokonaisluvut, boolean negatiiviluvut,
            boolean negatiivivastaus, boolean kokonaislukuvastaus, int numerot) {
        this.arpoja = arpoja;
        this.pelkatKokonaisluvut = kokonaisluvut;
        this.negatiiviLuvutMukana = negatiiviluvut;
        this.salliNegatiiviVastaus = negatiivivastaus;
        this.vainKokonaislukuVastaus = kokonaislukuvastaus;
        this.numerot = numerot;
    }

    /**
     * Vaihtoehtoinen konstruktori, jolle annetaan vain
     * satunnaislukugeneraattori ja lukujen pituus numeroina. Käytetään ohjelman
     * testaamiseen.
     *
     * @param arpoja Satunnaislukugeneraattori
     * @param numerot Laskutoimituksessa esiintyvien kokonaislukujen
     * enimmäispituus numeroina
     */
    public Harjoittelu(Random arpoja, int numerot) {
        this.arpoja = arpoja;
        this.numerot = numerot;
    }

    /**
     * Vaihtoehtoinen konstruktori, jolle annetaan myös lista "väärin menneitä"
     * laskutoimituksia. Käytetään ohjelman testaamiseen.
     *
     * @param arpoja Satunnaislukugeneraattori
     * @param vaarinMenneet Lista "väärin menneitä" laskutoimituksia
     */
    public Harjoittelu(Random arpoja, boolean kokonaisluvut, boolean negatiiviluvut,
            boolean negatiivivastaus, boolean kokonaislukuvastaus, int numerot,
            ArrayList<Laskutoimitus> vaarinMenneet, int turha) {
        this.vaarinMenneet = vaarinMenneet;
    }

    /**
     * Palauttaa käyttäjän antaman lukujen enimmäispituuden numeroina. Käytetään
     * ohjelman testaamiseen.
     *
     * @return lukujen enimmäispituus numeroina
     */
    public int haeNumerot() {
        return this.numerot;
    }

    /**
     * Arpoo satunnaisen luvun kiinteän ylä- ja alarajan väliltä. Ylä- ja
     * alarajat määräytyvät käyttäjän antaman lukujen enimmäispituuden mukaan.
     * Esimerkiksi enimmäispituuden ollessa 2 arvotaan luvut väliltä -99...99.
     *
     * @return satunnainen, enintään enimmäispituuden mittainen luku
     */
    public int arvoLuvut() {

        int ylaraja = (int) (2 * Math.pow(10, numerot) - 2);
        return (int) (arpoja.nextInt(ylaraja) - Math.pow(10, numerot) + 1);
    }

    /**
     * Arpoo kysyttävän laskutoimituksen tyypin laskutoimituslistasta. Määrätään
     * onko kyse yhteen-, vähennys-, kerto- vai jakolaskusta.
     *
     * @return kysyttävän laskutoimituksen tyyppi
     */
    public int arvoLaskutoimitus() {
        int maara = laskutoimitukset.size();
        Collections.shuffle(laskutoimitukset);
        return laskutoimitukset.get(maara - 1);
    }

    /**
     * Arpoo satunnaisen murtoluvun laskutoimituksia varten. Jos murtoluvun
     * nimittäjäksi arvotaan 0, vaihdetaan nimittäjä luvuksi 1.
     *
     * @return satunnainen murtoluku
     */
    public Murtoluku arvoMurtoluku() {
        int osoittaja = arvoLuvut();
        int nimittaja = arvoLuvut();
        if (nimittaja == 0) {
            nimittaja = 1;
        }
        Murtoluku murtoluku = new Murtoluku(osoittaja, nimittaja);
        return murtoluku;
    }

    /**
     * Arpoo satunnaisen kokonaisluvun.
     *
     * @return satunnainen kokonaisluku
     */
    public Murtoluku arvoKokonaisluku() {
        int luku = arvoLuvut();
        Murtoluku kokonaisluku = new Murtoluku(luku);
        return kokonaisluku;
    }

    /**
     * Arpoo positiivisen murtoluvun
     *
     * @return positiivinen murtoluku
     */
    public Murtoluku arvoPositiiviMurtoluku() {
        Murtoluku murtoluku = arvoMurtoluku();
        int osoittaja = Math.abs(murtoluku.haeOsoittaja());
        int nimittaja = murtoluku.haeNimittaja();
        Murtoluku uusi = new Murtoluku(osoittaja, nimittaja);
        return uusi;
    }

    /**
     * Arpoo positiivisen kokonaisluvun.
     *
     * @return positiivinen kokonaisluku
     */
    public Murtoluku arvoPositiiviKokonaisluku() {
        int luku = arvoLuvut();
        luku = Math.abs(luku);
        Murtoluku kokonaisluku = new Murtoluku(luku);
        return kokonaisluku;
    }

    /**
     * Arpoo laskun satunnaisilla murtoluvuilla.
     *
     * @param toimitus Laskutoimituksen tyyppi
     *
     * @return kysyttävä lasku
     */
    public Laskutoimitus arvoSatunnainenLasku(int toimitus) {
        Murtoluku eka = arvoMurtoluku();
        Murtoluku toka = arvoMurtoluku();
        Laskutoimitus laskutoimitus = kokoaLaskutoimitus(toimitus, eka, toka);
        return laskutoimitus;
    }

    /**
     * Arpoo laskun satunnaisilla kokonaisluvuilla.
     *
     * @param toimitus Laskutoimituksen tyyppi
     *
     * @return kysyttävä lasku
     */
    public Laskutoimitus arvoLaskuKokonaisluvuilla(int toimitus) {
        int kokonaisluku1 = arvoLuvut();
        int kokonaisluku2 = arvoLuvut();
        Murtoluku eka = new Murtoluku(kokonaisluku1);
        Murtoluku toka = new Murtoluku(kokonaisluku2);
        Laskutoimitus laskutoimitus = kokoaLaskutoimitus(toimitus, eka, toka);
        return laskutoimitus;
    }

    /**
     * Arpoo laskun positiivisilla kokonaisluvuilla.
     *
     * @param toimitus Laskutoimituksen tyyppi
     *
     * @return kysyttävä lasku
     */
    public Laskutoimitus arvoLaskuPositiiviKokonaisluvuilla(int toimitus) {
        Laskutoimitus laskutoimitus = arvoLaskuKokonaisluvuilla(toimitus);
        while (true) {
            int eka = laskutoimitus.haeEka().haeOsoittaja();
            int toka = laskutoimitus.haeToka().haeOsoittaja();
            if (eka >= 0 && toka >= 0) {
                break;
            }
            laskutoimitus = arvoLaskuKokonaisluvuilla(toimitus);
        }
        return laskutoimitus;
    }

    /**
     * Arpoo laskun positiivisilla murtoluvuilla.
     *
     * @param toimitus Laskutoimituksen tyyppi
     *
     * @return kysyttävä lasku
     */
    public Laskutoimitus arvoLaskuPositiiviLuvuilla(int toimitus) {
        Laskutoimitus laskutoimitus = arvoSatunnainenLasku(toimitus);
        while (true) {
            int eka = laskutoimitus.haeEka().haeOsoittaja();
            int toka = laskutoimitus.haeToka().haeOsoittaja();
            if (eka >= 0 && toka >= 0) {
                break;
            }
            laskutoimitus = arvoSatunnainenLasku(toimitus);
        }
        return laskutoimitus;
    }

    /**
     * Arpoo laskun positiivisilla murtoluvuilla, jonka tulos on positiivinen
     * murtoluku. Olennainen positiivisten lukujen vähennyslaskussa, mikäli
     * halutaan positiivinen vastaus.
     *
     * @param toimitus Laskutoimituksen tyyppi
     *
     * @return kysyttävä lasku
     */
    public Laskutoimitus arvoPositiiviTulosLaskuPositiiviLuvuilla(int toimitus) {
        Laskutoimitus laskutoimitus = arvoLaskuPositiiviLuvuilla(toimitus);
        while (true) {
            Murtoluku tulos = laskutoimitus.laske();
            if (tulos.haeOsoittaja() >= 0) {
                break;
            }
            laskutoimitus = arvoLaskuPositiiviLuvuilla(toimitus);
        }
        return laskutoimitus;
    }

    /**
     * Arpoo laskun kokonaisluvuilla, jonka tulos on kokonaisluku. Olennainen,
     * mikäli halutaan, että kokonaislukujen jakolaskun tulos on kokonaisluku.
     *
     * @param toimitus Laskutoimituksen tyyppi
     *
     * @return kysyttävä lasku
     */
    public Laskutoimitus arvoKokonaislukuTulosLaskuKokonaisluvuilla(int toimitus) {
        Laskutoimitus laskutoimitus = arvoLaskuKokonaisluvuilla(toimitus);
        while (true) {
            if (laskutoimitus.laske().haeNimittaja() == 1) {
                break;
            }
            laskutoimitus = arvoLaskuKokonaisluvuilla(toimitus);
        }
        return laskutoimitus;
    }

    /**
     * Arpoo laskun positiivisilla kokonaisluvuilla, jonka tulos on
     * kokonaisluku. Olennainen, mikäli halutaan, että positiivisten
     * kokonaislukujen jakolaskun tulos on kokonaisluku.
     *
     * @param toimitus Laskutoimituksen tyyppi
     *
     * @return kysyttävä lasku
     */
    public Laskutoimitus arvoKokonaislukuTulosLaskuPositiiviKokonaisluvuilla(int toimitus) {
        Laskutoimitus laskutoimitus = arvoLaskuPositiiviKokonaisluvuilla(toimitus);
        if (toimitus == 4) {
            while (true) {
                if (laskutoimitus.laske().haeNimittaja() == 1) {
                    break;
                }
                laskutoimitus = arvoLaskuPositiiviKokonaisluvuilla(toimitus);
            }
        }
        return laskutoimitus;
    }

    /**
     * Arpoo laskun positiivisilla kokonaisluvuilla, jonka tulos on
     * positiivinen. Olennainen positiivisten kokonaislukujen vähennyslaskussa,
     * mikäli halutaan positiivinen vastaus.
     *
     * @param toimitus Laskutoimituksen tyyppi
     *
     * @return kysyttävä lasku
     */
    public Laskutoimitus arvoPositiiviTulosLaskuPositiiviKokonaisluvuilla(int toimitus) {
        Laskutoimitus laskutoimitus = arvoLaskuPositiiviKokonaisluvuilla(toimitus);
        while (true) {
            if (laskutoimitus.laske().haeOsoittaja() >= 0) {
                break;
            }
            laskutoimitus = arvoLaskuPositiiviKokonaisluvuilla(toimitus);
        }
        return laskutoimitus;
    }

    /**
     * Vaihtaa parametrina annetun murtoluvun nollasta eroavaksi, mikäli se on
     * nolla. Suorittamalla metodi estetään nollalla jakaminen jakolaskussa.
     *
     * @param murtoluku Tarkistettava, mahdollisesti vaihdettava murtoluku
     *
     * @return nollasta eroava murtoluku
     */
    public Murtoluku vaihdaNolla(Murtoluku murtoluku) {
        while (true) {
            if (murtoluku.haeOsoittaja() != 0) {
                break;
            }
            murtoluku = arvoMurtoluku();
        }
        return murtoluku;
    }

    /**
     * Kokoaa ja palauttaa laskutoimituksen arvotuista tyypistä ja
     * murtoluvuista.
     *
     * @param toimitus Laskutoimituksen tyyppi
     * @param eka Laskutoimituksen ensimmäinen jäsen
     * @param toka Laskutoimituksen toinen jäsen
     *
     * @return laskutoimitus valmiissa muodossa
     */
    public Laskutoimitus kokoaLaskutoimitus(int toimitus, Murtoluku eka,
            Murtoluku toka) {
        if (toimitus == 1) {
            Yhteenlasku summa = new Yhteenlasku(eka, toka);
            return summa;
        } else if (toimitus == 2) {
            Vahennyslasku erotus = new Vahennyslasku(eka, toka);
            return erotus;
        } else if (toimitus == 3) {
            Kertolasku tulo = new Kertolasku(eka, toka);
            return tulo;
        } else {
            toka = vaihdaNolla(toka);
            Jakolasku osamaara = new Jakolasku(eka, toka);
            return osamaara;
        }
    }

    /**
     * Numeroi ja palauttaa eri totuusarvovalintoja vastaavat tapaukset.
     *
     * @return totuusarvoja vastaava tapaus kokonaislukuna väliltä 0...15
     */
    public int valitseTapaus() {
        int tapaus = (pelkatKokonaisluvut) ? 1 : 0;
        tapaus = (negatiiviLuvutMukana) ? tapaus + 2 : tapaus;
        tapaus = (salliNegatiiviVastaus) ? tapaus + 4 : tapaus;
        tapaus = (vainKokonaislukuVastaus) ? tapaus + 8 : tapaus;
        return tapaus;
    }

    /**
     * Arpoo laskutoimituksen valittujen totuusarvojen mukaisesti. Ohjelman
     * toiminnan kannalta merkityksettömät valinnat on karsittu pois. Jos väärin
     * menneiden listalla on yli 10 laskua, arvotaan lasku tältä listalta.
     *
     * @param toimitus Laskutoimituksen tyyppi
     *
     * @return kysyttävä lasku
     */
    public Laskutoimitus arvoLasku(int toimitus) {

        if (onVaikeaa()) {
            return arvoVaikea();
        } else {
            switch (valitseTapaus()) {
                case 0:
                    return arvoPositiiviTulosLaskuPositiiviLuvuilla(toimitus);
                case 1:
                    return arvoPositiiviTulosLaskuPositiiviKokonaisluvuilla(toimitus);
                case 4:
                    return arvoLaskuPositiiviLuvuilla(toimitus);
                case 5:
                    return arvoLaskuPositiiviKokonaisluvuilla(toimitus);
                case 6:
                    return arvoSatunnainenLasku(toimitus);
                case 7:
                    return arvoLaskuKokonaisluvuilla(toimitus);
                case 9:
                    if (toimitus == 4) {
                        return arvoKokonaislukuTulosLaskuPositiiviKokonaisluvuilla(toimitus);
                    } else {
                        return arvoPositiiviTulosLaskuPositiiviKokonaisluvuilla(toimitus);
                    }
                case 13:
                    return arvoKokonaislukuTulosLaskuPositiiviKokonaisluvuilla(toimitus);
                case 15:
                    return arvoKokonaislukuTulosLaskuKokonaisluvuilla(toimitus);
                default:
                    return arvoSatunnainenLasku(toimitus);
            }
        }
    }

    /**
     * Palauttaa laskutoimituksen tulostusasun täydennettynä
     * yhtäsuuruusmerkillä.
     *
     * @param laskutoimitus Kysyttävä lasku
     *
     * @return kysyttävän laskun esitys
     */
    public String toString(Laskutoimitus laskutoimitus) {
        return laskutoimitus.toString() + " = ";
    }

    /**
     * Tarkistaa, onko väärin menneiden laskujen listalla yli 10 laskua.
     *
     * @return totuusarvo, onko väärin menneiden listalla yli 10 laskua
     */
    public boolean onVaikeaa() {
        if (vaarinMenneet == null) {
            return false;
        }
        if (vaarinMenneet.size() > 10) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Arpoo laskun väärin menneiden laskujen listalta. Laskun arpomisen jälkeen
     * kyseinen lasku poistetaan listalta.
     *
     * @return aiemmin väärin mennyt lasku
     */
    public Laskutoimitus arvoVaikea() {
        Collections.shuffle(vaarinMenneet);
        Laskutoimitus lasku = (vaarinMenneet.get(vaarinMenneet.size() - 1));
        vaarinMenneet.remove(lasku);
        return lasku;
    }

    /**
     * Lisää väärin menneen laskun väärin menneiden listalle.
     *
     * @param lasku Väärin mennyt lasku
     */
    public void lisaaVaikea(Laskutoimitus lasku) {
        vaarinMenneet.add(lasku);
    }

    public ArrayList<Laskutoimitus> haeVaarinMenneet() {
        return vaarinMenneet;
    }
}
