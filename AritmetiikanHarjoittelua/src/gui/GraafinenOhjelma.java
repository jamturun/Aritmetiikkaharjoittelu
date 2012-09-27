package gui;

import aritmetiikanharjoittelua.Harjoittelu;
import aritmetiikanharjoittelua.Laskutoimitus;
import java.util.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class GraafinenOhjelma implements Runnable {

    public static Scanner input = new Scanner(System.in);
    private JFrame ikkuna;
    private Container pohja;
    private Container otsikkoboksi;
    private Container kysymysboksi1;
    private Container kysymysboksi2;
    private Container nappulat1;
    private Container nappulat2;
    private JTextField vastauskentta1;
    private JTextField vastauskentta2;
    private JButton viisi;
    private JButton kuusi;
    private JButton seiska;
    private JButton kasi;
    private JButton ysi;
    private JButton tarkista;
    private JButton jatka;
    private JLabel otsikko;
    private JLabel kysymys1;
    private JLabel kysymys2;
    private JLabel lasku;
    Random arpoja = new Random();
    private boolean kokonaisluvut = true;
    private boolean negatiiviluvut = false;
    private boolean negatiivivastaus = false;
    private boolean kokonaislukuvastaus = true;
    private int numerot;
    ArrayList<Integer> laskutoimitukset = new ArrayList<Integer>();

    public void run() {

        ikkuna = new JFrame("Aritmetiikan harjoittelua");
        ikkuna.setPreferredSize(new Dimension(500, 300));

        luoKomponentit();

        ikkuna.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ikkuna.pack();
        ikkuna.setVisible(true);
    }

    private void luoMuuttujat() {
    }

    private void luoKomponentit() {
        pohja = ikkuna.getContentPane();
        pohja.setLayout(new BoxLayout(pohja, BoxLayout.Y_AXIS));

        otsikkoboksi = new Container();
        otsikkoboksi.setLayout(new FlowLayout());

        otsikko = new JLabel("Valitaan laskutoimitukset.");
        otsikko.setAlignmentX(Component.CENTER_ALIGNMENT);
        otsikkoboksi.add(otsikko);

        kysymysboksi1 = new Container();
        kysymysboksi1.setLayout(new FlowLayout());

        kysymysboksi2 = new Container();
        kysymysboksi2.setLayout(new FlowLayout());

        kysymys1 = new JLabel("Yhteenlasku?");
        kysymys1.setAlignmentX(Component.CENTER_ALIGNMENT);
        kysymysboksi1.add(kysymys1);

        kysymys2 = new JLabel("Anna nimittäjä");
        kysymys2.setAlignmentX(Component.CENTER_ALIGNMENT);
        kysymysboksi2.add(kysymys2);

        lasku = new JLabel("");
        lasku.setAlignmentX(Component.LEFT_ALIGNMENT);

        vastauskentta1 = new JTextField();
        vastauskentta2 = new JTextField();

        nappulat1 = new Container();
        nappulat1.setLayout(new FlowLayout());

        nappulat2 = new Container();
        nappulat2.setLayout(new FlowLayout());

        JButton kylla = new JButton("Kyllä");
        kylla.addActionListener(new NappulanKuuntelija(this));
        kylla.setAlignmentX(Component.LEFT_ALIGNMENT);

        JButton ei = new JButton("Ei");
        ei.addActionListener(new NappulanKuuntelija(this));
        ei.setAlignmentX(Component.LEFT_ALIGNMENT);

        JButton yksi = new JButton("1");
        yksi.addActionListener(new NappulanKuuntelija(this));
        yksi.setAlignmentX(Component.LEFT_ALIGNMENT);

        JButton kaksi = new JButton("2");
        kaksi.addActionListener(new NappulanKuuntelija(this));
        kaksi.setAlignmentX(Component.LEFT_ALIGNMENT);

        JButton kolme = new JButton("3");
        kolme.addActionListener(new NappulanKuuntelija(this));
        kolme.setAlignmentX(Component.LEFT_ALIGNMENT);

        JButton nelja = new JButton("4");
        nelja.addActionListener(new NappulanKuuntelija(this));
        nelja.setAlignmentX(Component.LEFT_ALIGNMENT);

        viisi = new JButton("5");
        viisi.addActionListener(new NappulanKuuntelija(this));
        viisi.setAlignmentX(Component.LEFT_ALIGNMENT);

        kuusi = new JButton("6");
        kuusi.addActionListener(new NappulanKuuntelija(this));
        kuusi.setAlignmentX(Component.LEFT_ALIGNMENT);

        seiska = new JButton("7");
        seiska.addActionListener(new NappulanKuuntelija(this));
        seiska.setAlignmentX(Component.LEFT_ALIGNMENT);

        kasi = new JButton("8");
        kasi.addActionListener(new NappulanKuuntelija(this));
        kasi.setAlignmentX(Component.LEFT_ALIGNMENT);

        ysi = new JButton("9");
        ysi.addActionListener(new NappulanKuuntelija(this));
        ysi.setAlignmentX(Component.LEFT_ALIGNMENT);

        tarkista = new JButton("Tarkista");
        tarkista.addActionListener(new NappulanKuuntelija(this));
        
        jatka = new JButton("Jatka");
        jatka.addActionListener(new NappulanKuuntelija(this));

        nappulat1.add(kylla);
        nappulat1.add(ei);
        nappulat2.add(yksi);
        nappulat2.add(kaksi);
        nappulat2.add(kolme);
        nappulat2.add(nelja);


        pohja.add(otsikkoboksi);
        pohja.add(kysymysboksi1);
        pohja.add(nappulat1);

    }

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
                    nappulat1.removeAll();
                    lisaaNappulat();
                }
                break;
            } else if (kysymys1.getText().equals("Onko vastaus aina kokonaisluku?")) {
                if (negatiiviluvut == false && laskutoimitukset.contains(2)) {
                    kysymys1.setText("Voiko vastaus olla negatiivinen?");
                } else {
                    kysymys1.setText("Anna kysyttävien lukujen enimmäispituus numeroina:");
                    nappulat1.removeAll();
                    lisaaNappulat();
                }
                break;
            } else if (kysymys1.getText().equals("Voiko vastaus olla negatiivinen?")) {
                kysymys1.setText("Anna kysyttävien lukujen enimmäispituus numeroina:");
                nappulat1.removeAll();
                lisaaNappulat();
                break;
            }
            break;
        }

    }

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
        if (kysymys1.getText().equals("Anna kysyttävien lukujen enimmäispituus numeroina:")) {
            int numerot = Integer.parseInt(input.nextLine());
        }
    }

    public void tallennaNumerot(int numero) {
        numerot = numero;
    }

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

    public void aloitaHarjoittelu() {
        otsikko.setText("Harjoittelu");
        Harjoittelu harjoittelu = new Harjoittelu(arpoja, kokonaisluvut,
                negatiiviluvut, negatiivivastaus, kokonaislukuvastaus, numerot,
                laskutoimitukset);

        kysymysboksi1.removeAll();
        nappulat1.removeAll();
        nappulat2.removeAll();

        harjoittele(harjoittelu);
    }

    public void tarkistaVastaus(Laskutoimitus tehtava) {
        if (kysymys1.getText().equals("Anna kokonaislukuvastaus")) {
            int vastaus = Integer.parseInt(vastauskentta1.getText());
            kysymysboksi1.removeAll();
            vastauskentta1.removeAll();
            if (vastaus == tehtava.laske().haeOsoittaja()) {
                kysymys1.setText("Oikein!");
                pohja.add(jatka);
            }
        }
    }

    public void harjoittele(Harjoittelu harjoittelu) {
        if (kokonaislukuvastaus) {
            pohja.add(lasku);
            int toimitus = harjoittelu.arvoLaskutoimitus();
            Laskutoimitus tehtava = harjoittelu.arvoLasku(toimitus);
            lasku.setText(harjoittelu.toString(tehtava));
            pohja.add(kysymysboksi1);
            kysymysboksi1.add(kysymys1);
            kysymys1.setText("Anna kokonaislukuvastaus");
            pohja.add(vastauskentta1);
            pohja.add(tarkista);
        } else {
            pohja.add(lasku);
            int toimitus = harjoittelu.arvoLaskutoimitus();
            Laskutoimitus tehtava = harjoittelu.arvoLasku(toimitus);
            lasku.setText(harjoittelu.toString(tehtava));
            pohja.add(kysymysboksi1);
            kysymysboksi1.add(kysymys1);
            kysymys1.setText("Anna osoittaja");
            pohja.add(vastauskentta1);
            pohja.add(kysymysboksi2);
            kysymysboksi2.add(kysymys2);
            pohja.add(vastauskentta2);
            pohja.add(tarkista);
        }
    }
}
