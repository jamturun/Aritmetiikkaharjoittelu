package gui;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class GraafinenOhjelma implements Runnable {

    private JFrame ikkuna;
    private Container otsikkoboksi;
    private Container kysymysboksi;
    private Container nappulat;
    private JLabel otsikko;
    private JLabel kysymys;
    Random arpoja = new Random();
    boolean kokonaisluvut = true;
    boolean negatiiviluvut = false;
    boolean negatiivivastaus = false;
    boolean kokonaislukuvastaus = true;
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
        Container pohja = ikkuna.getContentPane();
        pohja.setLayout(new BoxLayout(pohja, BoxLayout.Y_AXIS));

        otsikkoboksi = new Container();
        otsikkoboksi.setLayout(new FlowLayout());

        otsikko = new JLabel("Valitaan laskutoimitukset.");
        otsikko.setAlignmentX(Component.CENTER_ALIGNMENT);
        otsikkoboksi.add(otsikko);

        kysymysboksi = new Container();
        kysymysboksi.setLayout(new FlowLayout());

        kysymys = new JLabel("Yhteenlasku?");
        kysymys.setAlignmentX(Component.CENTER_ALIGNMENT);
        kysymysboksi.add(kysymys);

        nappulat = new Container();
        nappulat.setLayout(new FlowLayout());

        JButton kylla = new JButton("Kyllä");
        kylla.addActionListener(new NappulanKuuntelija(this));
        kylla.setAlignmentX(Component.LEFT_ALIGNMENT);

        JButton ei = new JButton("Ei");
        ei.addActionListener(new NappulanKuuntelija(this));
        ei.setAlignmentX(Component.LEFT_ALIGNMENT);


        nappulat.add(kylla);
        nappulat.add(ei);

        pohja.add(otsikkoboksi);
        pohja.add(kysymysboksi);
        pohja.add(nappulat);
    }

    public void paivitaSeuraavaTilanne() {
        while (true) {
            if (kysymys.getText().equals("Yhteenlasku?")) {
                kysymys.setText("Vähennyslasku?");
                break;
            } else if (kysymys.getText().equals("Vähennyslasku?")) {
                kysymys.setText("Kertolasku?");
                break;
            } else if (kysymys.getText().equals("Kertolasku?")) {
                kysymys.setText("Jakolasku?");
                break;
            }
        }
    }

    public void teeValinta(String valinta) {
        if (kysymys.getText().equals("Yhteenlasku?")) {
            if (valinta.equals("Kyllä")) {
                laskutoimitukset.add(1);
            }
        }
        if (kysymys.getText().equals("Vähennyslasku?")) {
            if (valinta.equals("Kyllä")) {
                laskutoimitukset.add(2);
            }
        }
        if (kysymys.getText().equals("Kertolasku?")) {
            if (valinta.equals("Kyllä")) {
                laskutoimitukset.add(3);
            }
        }
        if (kysymys.getText().equals("Jakolasku?")) {
            if (valinta.equals("Kyllä")) {
                laskutoimitukset.add(4);
            }
        }
    }
}
