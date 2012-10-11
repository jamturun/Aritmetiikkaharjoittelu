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
            ohjelma.mitaTehdaan();
        }
        if (e.getKeyCode() == 113) {
            ohjelma.mitaTehdaan();
            ohjelma.haeIkkuna().dispose();
            ohjelma.run();
        }
        if (e.getKeyCode() == 81) {
            System.exit(0);
        }
    }

    public void keyReleased(KeyEvent e) {
    }
}