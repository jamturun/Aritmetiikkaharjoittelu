
package aritmetiikanharjoittelua;

import java.util.ArrayList;
import java.util.Random;

public class TestiRandom3 extends Random {
    
    private ArrayList<Integer> luvut = new ArrayList<Integer>();
    private static int i = -1;
    
    public TestiRandom3() {
        
        luvut.add(2);
        luvut.add(3);
        luvut.add(4);
        luvut.add(-7);
        luvut.add(1);
        luvut.add(2);
        luvut.add(1);
        luvut.add(3);
        luvut.add(4);
        luvut.add(2);
        luvut.add(6);
        luvut.add(8);
        luvut.add(-1);
        luvut.add(-9);
        luvut.add(1);
        luvut.add(-2);
        luvut.add(4);
        luvut.add(7);
        luvut.add(3);
        luvut.add(3);
        luvut.add(-2);
        luvut.add(2);
        luvut.add(7);
        luvut.add(8);
        luvut.add(2);
        luvut.add(4);
     }
    
    
    public int nextInt(int ylaraja) {
         i++;
        return (int) (luvut.get(i) + 10 - 1);
    }
}