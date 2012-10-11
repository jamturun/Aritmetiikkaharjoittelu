package aritmetiikanharjoittelua;



import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KertolaskuTest {

    public KertolaskuTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testaaToStringPositiivisella() {
        Murtoluku eka = new Murtoluku(2, 3);
        Murtoluku toka = new Murtoluku(7, 8);
        Kertolasku tulo = new Kertolasku(eka, toka);

        assertEquals("2/3 * 7/8", tulo.toString());
    }

    @Test
    public void testaaToStringNegatiivisella() {
        Murtoluku eka = new Murtoluku(1, 3);
        Murtoluku toka = new Murtoluku(-5, 6);
        Kertolasku tulo = new Kertolasku(eka, toka);
        
        assertEquals("1/3 * (-5/6)", tulo.toString());
    }
    
    @Test
    public void testaaToStringNollalla() {
        Murtoluku eka = new Murtoluku(3,4);
        Murtoluku toka = new Murtoluku(0);
        Kertolasku tulo = new Kertolasku(eka, toka);
        
        assertEquals("3/4 * 0", tulo.toString());
    }
}
