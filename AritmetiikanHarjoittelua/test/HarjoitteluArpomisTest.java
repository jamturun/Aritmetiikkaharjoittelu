
import aritmetiikanharjoittelua.Harjoittelu;
import aritmetiikanharjoittelua.Murtoluku;
import aritmetiikanharjoittelua.TestiRandom1;
import java.util.ArrayList;
import java.util.Random;
import java.util.TreeMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class HarjoitteluArpomisTest {

    Random arpoja;
    Harjoittelu harjoittelu;
    

    public HarjoitteluArpomisTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        arpoja = new Random();
        harjoittelu = new Harjoittelu(arpoja, 1);
    }

    @After
    public void tearDown() {
    }

    public TreeMap lukujenListaus() {
        TreeMap<Integer, Integer> lukumaarat = new TreeMap<Integer, Integer>();
        for (int i = 1; i < 10000; i++) {
            int luku = harjoittelu.arvoLuvut();
            if (lukumaarat.containsKey(luku)) {
                int vanhaMaara = lukumaarat.get(luku);
                int uusiMaara = vanhaMaara + 1;
                lukumaarat.put(luku, uusiMaara);
            } else {
                lukumaarat.put(luku, 1);
            }
        }
        return lukumaarat;
    }

    public boolean loytyykoKaikkiLuvut() {
        TreeMap<Integer, Integer> lukumaarat = lukujenListaus();
        for (int luku : lukumaarat.keySet()) {
            if (lukumaarat.get(luku) <= 1) {
                return false;
            }
        }
        return true;
    }

    public boolean onkoYlimaaraisia() {
        TreeMap<Integer, Integer> lukumaarat = lukujenListaus();
        for (int luku : lukumaarat.keySet()) {
            if (luku < -9 || luku > 9) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void arvoLuvutArpooKaikkiLuvut() {
        boolean loytyyko = loytyykoKaikkiLuvut();

        assertEquals(true, loytyyko);
    }

    @Test
    public void arvoLuvutEiArvoYlimaaraisia() {
        boolean loytyyko = onkoYlimaaraisia();

        assertEquals(false, loytyyko);
    }
}
