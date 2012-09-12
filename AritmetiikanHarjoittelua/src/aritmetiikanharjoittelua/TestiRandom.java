
package aritmetiikanharjoittelua;

import java.util.ArrayList;
import java.util.Random;

public class TestiRandom extends Random {
    
    private ArrayList<Integer> luvut = new ArrayList<Integer>();
    private static int i = -1;
    
    public TestiRandom() {
        
        luvut.add(2);
        luvut.add(0);
        luvut.add(2);
        luvut.add(3);
        
    }
    
    
    public int arvoLuvut() {
         i++;
        return luvut.get(i);
    }
}
