
package aritmetiikanharjoittelua;

import java.util.ArrayList;
import java.util.Random;

public class TestiRandom2 extends Random {
    
    private ArrayList<Integer> luvut = new ArrayList<Integer>();
    private int i = -1;
    
    public void kasvataInttia(int n) {
        i += n;
    }
    
    public TestiRandom2() {
        
        luvut.add(1);
        luvut.add(2);
        luvut.add(-3);
        luvut.add(4);
        luvut.add(-2);
        luvut.add(5);
        luvut.add(3);
        luvut.add(-5);
        luvut.add(1);
        luvut.add(4);
        luvut.add(3);
        luvut.add(4);
        luvut.add(7);
        luvut.add(-5);
        luvut.add(1);
        luvut.add(2);
        luvut.add(5);
        luvut.add(7);
        luvut.add(1);
        luvut.add(4);
        luvut.add(1);
        luvut.add(2);
        luvut.add(2);
        luvut.add(3);
        luvut.add(1);
        luvut.add(3);
        luvut.add(7);
        luvut.add(3);
        luvut.add(8);
        luvut.add(-4);
        luvut.add(8);
        luvut.add(-2);
        luvut.add(7);
        luvut.add(3);
        luvut.add(8);
        luvut.add(4);
        luvut.add(7);
        luvut.add(8);
        luvut.add(9);
        luvut.add(8);
         luvut.add(4);
        luvut.add(1);
        luvut.add(0);
        luvut.add(3);
        luvut.add(3);
        luvut.add(1);
        
     }
    
    
    public int nextInt(int ylaraja) {
         i++;
        return (int) (luvut.get(i) + 10 - 1);
    }
}