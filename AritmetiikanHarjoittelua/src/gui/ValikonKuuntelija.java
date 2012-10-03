
package gui;

import java.awt.event.*;
import javax.swing.*;
 
public class ValikonKuuntelija implements ActionListener {
    GraafinenOhjelma ohjelma;
 
    public ValikonKuuntelija(GraafinenOhjelma ohjelma) {
        this.ohjelma = ohjelma;
    }
 
    public void actionPerformed(ActionEvent tapahtuma) {
        String valinta = ((JMenuItem)tapahtuma.getSource()).getText();
        if (valinta.equals("Uusi peli")) {
           ohjelma.run();
        }
        if (valinta.equals("Sulje")) {
            System.exit(0);
        }
        
    }
}
