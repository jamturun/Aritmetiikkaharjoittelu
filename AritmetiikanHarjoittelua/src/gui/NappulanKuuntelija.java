package gui;

import java.awt.event.*;
import javax.swing.*;

public class NappulanKuuntelija implements ActionListener {

    private GraafinenOhjelma ohjelma;

    public NappulanKuuntelija(GraafinenOhjelma ohjelma) {
        this.ohjelma = ohjelma;
    }

    public void actionPerformed(ActionEvent e) {
        JButton nappula = ((JButton) e.getSource());
        if (nappula.getText().equals("Kyllä")) {
            ohjelma.teeValinta("Kyllä");
            ohjelma.paivitaSeuraavaTilanne();
        }
        if (nappula.getText().equals("Ei")) {
            ohjelma.teeValinta("Ei");
            ohjelma.paivitaSeuraavaTilanne();
        }
        if (nappula.getText().equals("1")) {
            ohjelma.tallennaNumerot(1);
            ohjelma.aloitaHarjoittelu();
        }
        if (nappula.getText().equals("2")) {
            ohjelma.tallennaNumerot(2);
            ohjelma.aloitaHarjoittelu();
        }
        if (nappula.getText().equals("3")) {
            ohjelma.tallennaNumerot(3);
            ohjelma.aloitaHarjoittelu();
        }
        if (nappula.getText().equals("4")) {
            ohjelma.tallennaNumerot(4);
            ohjelma.aloitaHarjoittelu();
        }
        if (nappula.getText().equals("5")) {
            ohjelma.tallennaNumerot(5);
            ohjelma.aloitaHarjoittelu();
        }
        if (nappula.getText().equals("6")) {
            ohjelma.tallennaNumerot(6);
            ohjelma.aloitaHarjoittelu();
        }
        if (nappula.getText().equals("7")) {
            ohjelma.tallennaNumerot(7);
            ohjelma.aloitaHarjoittelu();
        }
        if (nappula.getText().equals("8")) {
            ohjelma.tallennaNumerot(8);
            ohjelma.aloitaHarjoittelu();
        }
        if (nappula.getText().equals("9")) {
            ohjelma.tallennaNumerot(9);
            ohjelma.aloitaHarjoittelu();
        }
        if(nappula.getText().equals("Tarkista")) {
//            ohjelma.tarkistaVastaus(tehtava);
        }
    }
}