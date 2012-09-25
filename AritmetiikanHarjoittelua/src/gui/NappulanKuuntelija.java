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
    }
}