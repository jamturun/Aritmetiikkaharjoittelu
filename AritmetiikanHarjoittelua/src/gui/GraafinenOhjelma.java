package gui;

import aritmetiikanharjoittelua.Harjoittelu;
import aritmetiikanharjoittelua.Laskutoimitus;
import aritmetiikanharjoittelua.Murtoluku;
import java.util.Calendar;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.*;

/**
 *
 * @author jamturun
 * @version 1.1
 *
 * Graafinen käyttöliittymä
 */
public class GraafinenOhjelma implements Runnable {

    public static Scanner input = new Scanner(System.in);
    private JFrame ikkuna;
    private Container pohja;
    private Container otsikkoboksi;
    private Container kysymysboksi1;
    private Container kysymysboksi2;
    private Container nappulat1;
    private Container nappulat2;
    private Container nappulat3;
    private JTextField vastauskentta1;
    private JTextField vastauskentta2;
    private JButton viisi;
    private JButton kuusi;
    private JButton seiska;
    private JButton kasi;
    private JButton ysi;
    private JButton tarkista;
    private JButton lopeta;
    private JButton jatka;
    private JLabel otsikko;
    private JLabel pisteet;
    private JLabel aika;
    private JLabel kysymys1;
    private JLabel kysymys2;
    private JLabel lasku;
    Random arpoja = new Random();
    private boolean kokonaisluvut;
    private boolean negatiiviluvut;
    private boolean negatiivivastaus;
    private boolean kokonaislukuvastaus;
    private boolean aikaraja;
    private int numerot;
    ArrayList<Integer> laskutoimitukset = new ArrayList<Integer>();
    private Laskutoimitus tehtava;
    private Murtoluku ratkaisu;
    private Harjoittelu harjoittelu;
    int laskurinArvo = 0;
    private Timer ajastin;
    int aikalaskuri = 60;

    /**
     * Metodi käynnistää ohjelman.
     */
    @Override
    public void run() {

        ikkuna = new JFrame("Aritmetiikan harjoittelua");
        ikkuna.setPreferredSize(new Dimension(500, 300));

        alustaParametrit();
        luoKomponentit();
        luoValikko();
        ajastin = new Timer(1000, new AjastimenKuuntelija(this));

        ikkuna.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ikkuna.pack();
        ikkuna.setVisible(true);
        ikkuna.addKeyListener(new NappaimistonKuuntelija(this));
    }

    /**
     * Metodi luo käyttöliittymän komponentit.
     */
    private void luoKomponentit() {

        pohja = ikkuna.getContentPane();
        pohja.setLayout(new BoxLayout(pohja, BoxLayout.Y_AXIS));
        pohja.setBackground(Color.PINK);

        luoBoksit();
        luoJLabelit();
        luoVastauskentat();
        luoNappulasailiot();

        JButton kylla = teeNappi("Kyllä");

        JButton ei = teeNappi("Ei");

        JButton yksi = teeNappi("1");

        JButton kaksi = teeNappi("2");

        JButton kolme = teeNappi("3");

        JButton nelja = teeNappi("4");

        viisi = teeNappi("5");

        kuusi = teeNappi("6");

        seiska = teeNappi("7");

        kasi = teeNappi("8");

        ysi = teeNappi("9");

        tarkista = teeNappi("Tarkista");

        lopeta = teeNappi("Lopeta");

        jatka = teeNappi("Jatka");

        lisaaNappuloita(kylla, ei, yksi, kaksi, kolme, nelja);
        lisaaPohjaan();

    }

    /**
     * Metodi päivittää seuraavan tilanteen käyttäjän valitessa parametreja
     * aiemmin valittujen parametrien mukaisesti.
     */
    public void paivitaSeuraavaTilanne() {
        while (true) {
            if (kysymys1.getText().equals("Yhteenlasku?")) {
                kysymys1.setText("Vähennyslasku?");
                break;
            } else if (kysymys1.getText().equals("Vähennyslasku?")) {
                kysymys1.setText("Kertolasku?");
                break;
            } else if (kysymys1.getText().equals("Kertolasku?")) {
                kysymys1.setText("Jakolasku?");
                break;
            } else if (kysymys1.getText().equals("Jakolasku?")) {
                otsikko.setText("Valitaan harjoittelumuoto.");
                kysymys1.setText("Onko harjoittelussa aikaraja (60 s)?");
            } else if (kysymys1.getText().equals("Onko harjoittelussa aikaraja (60 s)?")) {
                otsikko.setText("Valitaan vaikeusaste.");
                kysymys1.setText("Pelkät kokonaisluvut?");
            } else if (kysymys1.getText().equals("Pelkät kokonaisluvut?")) {
                kysymys1.setText("Negatiiviset luvut mukana?");
                break;
            } else if (kysymys1.getText().equals("Negatiiviset luvut mukana?")) {
                if (kokonaisluvut && laskutoimitukset.contains(4)) {
                    kysymys1.setText("Onko vastaus aina kokonaisluku?");
                } else if (negatiiviluvut == false && laskutoimitukset.contains(2)) {
                    kysymys1.setText("Voiko vastaus olla negatiivinen?");
                } else {
                    kysymys1.setText("Anna kysyttävien lukujen enimmäispituus numeroina:");
                    tyhjennaNappulat1();
                }
                break;
            } else if (kysymys1.getText().equals("Onko vastaus aina kokonaisluku?")) {
                if (negatiiviluvut == false && laskutoimitukset.contains(2)) {
                    kysymys1.setText("Voiko vastaus olla negatiivinen?");
                } else {
                    kysymys1.setText("Anna kysyttävien lukujen enimmäispituus numeroina:");
                    tyhjennaNappulat1();
                }
                break;
            } else if (kysymys1.getText().equals("Voiko vastaus olla negatiivinen?")) {
                kysymys1.setText("Anna kysyttävien lukujen enimmäispituus numeroina:");
                tyhjennaNappulat1();
                break;
            }
            break;
        }

    }

    /**
     * Metodi asettaa käyttäjän valitsemat parametrit.
     */
    public void teeValinta(String valinta) {
        if (kysymys1.getText().equals("Yhteenlasku?")) {
            if (valinta.equals("Kyllä")) {
                laskutoimitukset.add(1);
            }
        }
        if (kysymys1.getText().equals("Vähennyslasku?")) {
            if (valinta.equals("Kyllä")) {
                laskutoimitukset.add(2);
            }
        }
        if (kysymys1.getText().equals("Kertolasku?")) {
            if (valinta.equals("Kyllä")) {
                laskutoimitukset.add(3);
            }
        }
        if (kysymys1.getText().equals("Jakolasku?")) {
            if (valinta.equals("Kyllä")) {
                laskutoimitukset.add(4);
            }
        }
        if (kysymys1.getText().equals("Pelkät kokonaisluvut?")) {
            if (valinta.equals("Ei")) {
                kokonaisluvut = false;
                kokonaislukuvastaus = false;
            }
        }
        if (kysymys1.getText().equals("Negatiiviset luvut mukana?")) {
            if (valinta.equals("Kyllä")) {
                negatiiviluvut = true;
                negatiivivastaus = true;
            }
        }
        if (kysymys1.getText().equals("Onko vastaus aina kokonaisluku?")) {
            if (valinta.equals("Ei")) {
                kokonaislukuvastaus = false;
            }
        }
        if (kysymys1.getText().equals("Voiko vastaus olla negatiivinen?")) {
            if (valinta.equals("Kyllä")) {
                negatiivivastaus = true;
            }
        }
        if (kysymys1.getText().equals("Onko harjoittelussa aikaraja (60 s)?")) {
            if (valinta.equals("Kyllä")) {
                aikaraja = true;
            }
        }

    }

    /**
     * Metodi tallentaa laskutoimitusten lukujen enimmäispituuden numeroina.
     * Käyttäjä valitsee numeron klikkaamalla sopivaa nappulaa.
     *
     * @param numero Käyttäjän valitsema lukujen enimmäispituus
     */
    public void tallennaNumerot(int numero) {
        numerot = numero;
    }

    /**
     * Metodi lisää uusia nappuloita käyttöliittymän näkymään.
     */
    public void lisaaNappulat() {
        if (!laskutoimitukset.contains(3) && !laskutoimitukset.contains(4)) {
            nappulat2.add(viisi);
            nappulat2.add(kuusi);
            nappulat2.add(seiska);
            nappulat2.add(kasi);
            nappulat2.add(ysi);
            pohja.add(nappulat2);

        } else {
            pohja.add(nappulat2);
        }
    }

    /**
     * Metodi aloittaa uuden harjoittelun. Metodi huolehtii lisäksi, että
     * ainakin yksi laskutoimitus on valittu.
     */
    public void aloitaHarjoittelu() {
        if (laskutoimitukset.isEmpty()) {
            laskutoimitukset.add(1);
        }
        otsikko.setText("Harjoittelu   ");
        otsikkoboksi.add(pisteet);
        if (aikaraja) {
            otsikkoboksi.add(aika);
            ajastin.start();
        } else {
            aika.setVisible(false);
        }

        harjoittelu = new Harjoittelu(arpoja, kokonaisluvut,
                negatiiviluvut, negatiivivastaus, kokonaislukuvastaus, numerot,
                laskutoimitukset);

        kysymysboksi1.removeAll();
        kysymysboksi2.removeAll();
        pohja.remove(nappulat2);

        harjoittele();
    }

    /**
     * Tallentaa käyttäjän syöttämän vastauksen ensimmäisestä vastauskentästä.
     *
     * @return käyttäjän antama vastaus
     */
    public int oikeaMuotoinenVastaus1() {

        int vastaus = 0;
        try {
            vastaus = Integer.parseInt(vastauskentta1.getText());
        } catch (Exception e) {
            vastaus = ratkaisu.haeOsoittaja() + 1;

        }
        return vastaus;
    }

    /**
     * Tallentaa käyttäjän syöttämän vastauksen toisesta vastauskentästä.
     *
     * @return käyttäjän antama vastaus
     */
    public int oikeaMuotoinenVastaus2() {

        int vastaus = 0;
        try {
            vastaus = Integer.parseInt(vastauskentta2.getText());
        } catch (Exception e) {
            vastaus = ratkaisu.haeNimittaja();

        }
        return vastaus;
    }

    /**
     * Tarkistaa käyttäjän antaman vastauksen ja lisää tai vähentää pisteitä.
     */
    public void tarkistaVastaus() {
        if (kysymys1.getText().equals("Anna kokonaislukuvastaus")) {
            int vastaus = oikeaMuotoinenVastaus1();
            piilotaObjekteja();

            if (vastaus == ratkaisu.haeOsoittaja()) {
                kysymys1.setText("Oikein!");
                lisaaLukua();
                pohja.add(jatka);
            } else {
                kasitteleVaara();
            }
        } else {
            int osoittajavastaus = oikeaMuotoinenVastaus1();
            int nimittajavastaus = oikeaMuotoinenVastaus2();

            kysymysboksi2.setVisible(false);
            piilotaObjekteja();
            vastauskentta2.setVisible(false);

            if (osoittajavastaus == ratkaisu.haeOsoittaja()
                    && nimittajavastaus == ratkaisu.haeNimittaja()) {
                kysymysboksi1.setVisible(true);

                kysymys1.setText("Oikein!");
                lisaaLukua();
                pohja.add(jatka);
            } else {
                kasitteleVaara();
            }
        }
    }

    /**
     * Hallinnoi harjoittelunäkymää.
     */
    public void harjoittele() {
        if (kokonaislukuvastaus) {
            valmisteleNakyma();
            kysymys1.setText("Anna kokonaislukuvastaus");
            pohja.add(nappulat3);

        } else {
            valmisteleNakyma();
            kysymys1.setText("Anna osoittaja");
            pohja.add(kysymysboksi2);
            kysymysboksi2.add(kysymys2);
            pohja.add(vastauskentta2);
            pohja.add(nappulat3);
        }
        if (aikalaskuri == 0) {
            ajastin.stop();
            mitaTehdaan();
        }
    }

    /**
     * Luo nappulan.
     *
     * @param napinTeksti Nappulaan tuleva teksti
     *
     * @return luotu nappula
     */
    private JButton teeNappi(String napinTeksti) {
        JButton nappi = new JButton(napinTeksti);
        nappi.addActionListener(new NappulanKuuntelija(this));
        nappi.setAlignmentX(Component.LEFT_ALIGNMENT);
        nappi.setFocusable(false);
        return nappi;
    }

    /**
     * Palauttaa harjoittelun käyttäjän vastaustilaan.
     */
    public void palautaVastaustila() {
        pohja.removeAll();
        vastauskentta1.setVisible(true);
        vastauskentta1.setText("");
        if (!kokonaislukuvastaus) {
            vastauskentta2.setVisible(true);
            vastauskentta2.setText("");
            kysymysboksi2.setVisible(true);
        }
        lasku.setVisible(true);
        nappulat3.setVisible(true);

        pohja.add(otsikkoboksi);
        pohja.add(lasku);

    }

    /**
     * Luo näkymän, jossa käyttäjän on valittava aloittaako uuden pelin vai
     * sulkeeko ohjelman.
     */
    public void mitaTehdaan() {
        nappulat1.setVisible(false);
        nappulat3.setVisible(false);
        vastauskentta2.setVisible(false);
        kysymysboksi2.setVisible(false);
        vastauskentta1.setVisible(false);
        kysymysboksi1.setVisible(false);
        lasku.setVisible(false);
        otsikko.setText("Valitse uusi peli tai sulje ohjelma.   ");
        ajastin.stop();
        aika.setVisible(false);
    }

    /**
     * Luo käyttöliittymään valikon.
     */
    private void luoValikko() {
        JMenuBar valikko = new JMenuBar();

        JMenu valikkoPeli = new JMenu("Peli");
        valikko.add(valikkoPeli);

        JMenuItem valikkoUusi = new JMenuItem("Uusi peli");
        valikkoUusi.addActionListener(new ValikonKuuntelija(this));
        valikkoPeli.add(valikkoUusi);

        JMenuItem valikkoSulje = new JMenuItem("Sulje");
        valikkoSulje.addActionListener(new ValikonKuuntelija(this));
        valikkoPeli.add(valikkoSulje);

        ikkuna.setJMenuBar(valikko);
    }

    /**
     * Alustaa parametrit oletusarvoisiksi ennen uuden harjoittelun
     * aloittamista.
     */
    private void alustaParametrit() {
        laskutoimitukset.clear();
        kokonaisluvut = true;
        negatiiviluvut = false;
        negatiivivastaus = false;
        kokonaislukuvastaus = true;
        aikaraja = false;
        laskurinArvo = 0;
        aikalaskuri = 60;
    }

    /**
     * Luo nappuloiden säiliöt.
     */
    private void luoNappulasailiot() {
        nappulat1 = new Container();
        nappulat1.setLayout(new FlowLayout());

        nappulat2 = new Container();
        nappulat2.setLayout(new FlowLayout());

        nappulat3 = new Container();
        nappulat3.setLayout(new FlowLayout());
    }

    /**
     * Lisää nappuloita säiliöihin.
     *
     * @param kylla Nappulan nimi
     * @param ei Nappulan nimi
     * @param yksi Nappulan nimi
     * @param kaksi Nappulan nimi
     * @param kolme Nappulan nimi
     * @param nelja Nappulan nimi
     */
    private void lisaaNappuloita(JButton kylla, JButton ei, JButton yksi, JButton kaksi, JButton kolme, JButton nelja) {
        nappulat1.add(kylla);
        nappulat1.add(ei);
        nappulat2.add(yksi);
        nappulat2.add(kaksi);
        nappulat2.add(kolme);
        nappulat2.add(nelja);
        nappulat3.add(tarkista);
        nappulat3.add(lopeta);
    }

    /**
     * Luo otsikko- ja kysymyssäiliöt.
     */
    private void luoBoksit() {
        otsikkoboksi = new Container();
        otsikkoboksi.setLayout(new FlowLayout());

        kysymysboksi1 = new Container();
        kysymysboksi1.setLayout(new FlowLayout());

        kysymysboksi2 = new Container();
        kysymysboksi2.setLayout(new FlowLayout());
    }

    /**
     * Luo käyttöliittymän otsikot.
     */
    private void luoJLabelit() {
        otsikko = new JLabel("Valitaan laskutoimitukset.");
        otsikko.setAlignmentX(Component.LEFT_ALIGNMENT);
        otsikkoboksi.add(otsikko);

        pisteet = new JLabel("Pisteet: " + laskurinArvo + "   ");
        pisteet.setAlignmentX(Component.RIGHT_ALIGNMENT);

        aika = new JLabel("Aika: " + aikalaskuri);
        aika.setAlignmentX(Component.RIGHT_ALIGNMENT);

        kysymys1 = new JLabel("Yhteenlasku?");
        kysymys1.setAlignmentX(Component.LEFT_ALIGNMENT);
        kysymysboksi1.add(kysymys1);

        kysymys2 = new JLabel("Anna nimittäjä");
        kysymys2.setAlignmentX(Component.LEFT_ALIGNMENT);
        kysymysboksi2.add(kysymys2);

        lasku = new JLabel("");
        lasku.setAlignmentX(Component.LEFT_ALIGNMENT);

    }

    /**
     * Luo vastauskentät.
     */
    private void luoVastauskentat() {
        vastauskentta1 = new JTextField();
        vastauskentta2 = new JTextField();
    }

    /**
     * Lisää komponentteja pohjaan.
     */
    private void lisaaPohjaan() {
        pohja.add(otsikkoboksi);
        pohja.add(kysymysboksi1);
        pohja.add(nappulat1);
    }

    /**
     * Lisää väärin menneen laskun väärin menneiden laskujen listaan ja
     * ilmoittaa käyttäjälle laskun menneen väärin.
     */
    private void kasitteleVaara() {
        harjoittelu.lisaaVaikea(tehtava);
        System.out.println(harjoittelu.haeVaarinMenneet());
        kysymys1.setText("Väärin!");
        vahennaLukua();
        pohja.add(jatka);
    }

    /**
     * Piilottaa objekteja uutta näkymää varten.
     */
    private void piilotaObjekteja() {
        vastauskentta1.setVisible(false);
        lasku.setVisible(false);
        nappulat3.setVisible(false);
    }

    /**
     * Valmistelee näkymää harjoittelutilassa.
     */
    private void valmisteleNakyma() {

        pohja.add(lasku);
        int toimitus = harjoittelu.arvoLaskutoimitus();
        tehtava = harjoittelu.arvoLasku(toimitus);
        ratkaisu = tehtava.laske();
        lasku.setText(harjoittelu.toString(tehtava));
        pohja.add(kysymysboksi1);
        kysymysboksi1.add(kysymys1);
        pohja.add(vastauskentta1);
    }

    /**
     * Poistaa nappulat1-säiliöstä nappulat.
     */
    private void tyhjennaNappulat1() {
        nappulat1.removeAll();
        lisaaNappulat();
    }

    /**
     * Lisää pistelaskurin arvoa yhdellä oikean vastauksen jälkeen.
     */
    public void lisaaLukua() {
        laskurinArvo++;
        pisteet.setText("Pisteet: " + laskurinArvo + "   ");
    }

    /**
     * Vähentää pistelaskurin arvoa yhdellä väärän vastauksen jälkeen.
     */
    public void vahennaLukua() {
        laskurinArvo--;
        pisteet.setText("Pisteet: " + laskurinArvo + "   ");
    }

    /**
     * Vähentää aikalaskurin lukemaa sekunnin välein.
     */
    public void vahennaAikaa() {
        aikalaskuri--;
        aika.setText("Aika: " + aikalaskuri);
    }
}
