package gui;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class GraafinenOhjelma implements Runnable {

    private JFrame ikkuna;
    private Container pohja;
    private Container otsikkoboksi;
    private Container kysymysboksi;
    private Container nappulat;
    private JLabel otsikko;
    private JLabel kysymys;
    private JTextField tekstikentta;
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
        
        tekstikentta = new JTextField();
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
            } else if (kysymys.getText().equals("Jakolasku?")) {
                otsikko.setText("Valitaan vaikeusaste.");
                kysymys.setText("Pelkät kokonaisluvut?");
            } else if (kysymys.getText().equals("Pelkät kokonaisluvut?")) {
                kysymys.setText("Negatiiviset luvut mukana?");
                break;
            } else if (kysymys.getText().equals("Negatiiviset luvut mukana?")) {
                if (kokonaisluvut && laskutoimitukset.contains(4)) {
                    kysymys.setText("Onko vastaus aina kokonaisluku?");
                } else if (negatiiviluvut == false && laskutoimitukset.contains(2)) {
                    kysymys.setText("Voiko vastaus olla negatiivinen?");
                } else {
                    kysymys.setText("Anna kysyttävien lukujen enimmäispituus numeroina:");
                }
                break;
            } else if (kysymys.getText().equals("Onko vastaus aina kokonaisluku?")) {
                if (negatiiviluvut == false && laskutoimitukset.contains(2)) {
                    kysymys.setText("Voiko vastaus olla negatiivinen?");
                } else {
                    kysymys.setText("Anna kysyttävien lukujen enimmäispituus numeroina:");
                }
                break;
            } else if (kysymys.getText().equals("Voiko vastaus olla negatiivinen?")) {
                kysymys.setText("Anna kysyttävien lukujen enimmäispituus numeroina:");
                break;
            }
            break;
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
        if (kysymys.getText().equals("Pelkät kokonaisluvut?")) {
            if (valinta.equals("Ei")) {
                kokonaisluvut = false;
                kokonaislukuvastaus = false;
            }
        }
        if (kysymys.getText().equals("Negatiiviset luvut mukana?")) {
            if (valinta.equals("Kyllä")) {
                negatiiviluvut = true;
                negatiivivastaus = true;
            }
        }
        if (kysymys.getText().equals("Onko vastaus aina kokonaisluku?")) {
            if (valinta.equals("Ei")) {
                kokonaislukuvastaus = false;
            }
        }
        if (kysymys.getText().equals("Voiko vastaus olla negatiivinen?")) {
            if (valinta.equals("Kyllä")) {
                negatiivivastaus = true;
            }
        }
        if(kysymys.getText().equals("Anna kysyttävien lukujen enimmäispituus numeroina:")) {
           
//            pohja.add(tekstikentta);
        }
    }
}
