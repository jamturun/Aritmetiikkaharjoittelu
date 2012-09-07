
import aritmetiikanharjoittelua.Yhteenlasku;
import aritmetiikanharjoittelua.Murtoluku;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class YhteenlaskuTest {

    public YhteenlaskuTest() {
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
        Murtoluku eka = new Murtoluku(1, 2);
        Murtoluku toka = new Murtoluku(1, 3);
        Yhteenlasku summa = new Yhteenlasku(eka, toka);

        assertEquals("1/2 + 1/3", summa.toString());
    }

    @Test
    public void testaaToStringNegatiivisella() {
        Murtoluku eka = new Murtoluku(1, 2);
        Murtoluku toka = new Murtoluku(-1, 3);
        Yhteenlasku summa = new Yhteenlasku(eka, toka);

        assertEquals("1/2 + (-1/3)", summa.toString());
    }

    @Test
    public void testaaToStringNollalla() {
        Murtoluku eka = new Murtoluku(1, 2);
        Murtoluku toka = new Murtoluku(0);
        Yhteenlasku summa = new Yhteenlasku(eka, toka);

        assertEquals("1/2 + 0", summa.toString());
    }
}
