
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AjastimenKuuntelija implements ActionListener {

    private GraafinenOhjelma ohjelma;

    public AjastimenKuuntelija(GraafinenOhjelma ohjelma) {
        this.ohjelma = ohjelma;
    }

    @Override
    public void actionPerformed(ActionEvent tapahtuma) {
       
        if (ohjelma.aikalaskuri > 0) {
            ohjelma.vahennaAikaa();
        }
       
    }
}