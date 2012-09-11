
package aritmetiikanharjoittelua;

import java.util.ArrayList;
import java.util.Random;

public class TestiRandom extends Random {
    
    private static ArrayList<Integer> luvut = new ArrayList<Integer>();
    
    public TestiRandom() {
        luvut.add(3);
        luvut.add(0);
        
    }
    
    @Override
    public int nextInt(){
        return luvut.get(0);
    }
}
