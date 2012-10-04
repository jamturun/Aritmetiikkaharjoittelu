package gui;

import java.awt.event.*;
import javax.swing.*;

public class NappaimistonKuuntelija implements KeyListener {

    private GraafinenOhjelma ohjelma;

    public NappaimistonKuuntelija(GraafinenOhjelma ohjelma) {
        this.ohjelma = ohjelma;
    }

   
    public void keyTyped(KeyEvent er) {
    }

   
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 27) {
            ohjelma.suljePeli();
        } else if (e.getKeyCode() == 113) {
            ohjelma.run();
        } else if (e.getKeyCode() == 13) {
            ohjelma.tarkistaVastaus();
        }
       
    }


    public void keyReleased(KeyEvent e) {
    }
}