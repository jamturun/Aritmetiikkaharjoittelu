
package aritmetiikanharjoittelua;

import java.util.ArrayList;
import java.util.Random;

public class TestiRandom1 extends Random {
    
    private ArrayList<Integer> luvut = new ArrayList<Integer>();
    private static int i = -1;
    
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
    
    
    public int nextInt(int ylaraja) {
         i++;
        return (int) (luvut.get(i) + 10 - 1);
    }
}