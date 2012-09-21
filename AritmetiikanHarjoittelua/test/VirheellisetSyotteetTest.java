
import aritmetiikanharjoittelua.Harjoittelu;
import aritmetiikanharjoittelua.Laskutoimitus;
import java.util.ArrayList;
import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VirheellisetSyotteetTest {
    Random arpoja;
    Harjoittelu harjoittelu;
    ArrayList<Integer> laskutoimitukset;

    public VirheellisetSyotteetTest() {
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
        laskutoimitukset = new ArrayList<Integer>();
        laskutoimitukset.add(1);
        harjoittelu = new Harjoittelu(arpoja, true, true, true, true, -2, laskutoimitukset);
        
    }

    @After
    public void tearDown() {
    }

    @Test
    public void muuttaaNegatiivisenNumeroidenMaaranYkkoseksi() {

        
        int numerot = harjoittelu.haeNumerot();
        assertEquals(1, numerot);
    }
}
