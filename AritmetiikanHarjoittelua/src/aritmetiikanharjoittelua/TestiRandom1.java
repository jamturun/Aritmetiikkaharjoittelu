
package aritmetiikanharjoittelua;

import java.util.ArrayList;
import java.util.Random;

/**
 * 
 * @author Turunen Joonas
 * @version 1.1
 */
public class TestiRandom1 extends Random {
    
    /**
     * Sisältää luvut, joilla Harjoittelu-luokan metodeita halutaan testata
     */
    private ArrayList<Integer> luvut = new ArrayList<Integer>();
    /**
     * Muuttuja, jolla poimitaan haluttu luku listasta luvut
     */
    private int i = -1;
    
    /**
     * Kasvatetaan muuttujaa i halutun kokoiseksi.
     * 
     * @param n Muuttujan i haluttu koko vähennettynä luvulla 1 
     */
     public void kasvataInttia(int n) {
        i += n;
    }
    
     /**
      * Luodaan luvut-lista.
      */
    public TestiRandom1() {
        
        luvut.add(2);
        luvut.add(3);
        luvut.add(4);
        luvut.add(0);
        luvut.add(3);
        luvut.add(4);
        luvut.add(-8);
        luvut.add(-7);
        
    }
    
    /**
     * Metodi korvaa Random-luokan nextInt-metodin.
     * Valitaan luvut-listasta luku muuttujan i mukaan.
     * 
     * @param ylaraja nextInt-metodia varten vaadittu yläraja
     * 
     * @return luku listasta luvut 
     */
    @Override
    public int nextInt(int ylaraja) {
         i++;
        return (int) (luvut.get(i) + 10 - 1);
    }
}
