
import aritmetiikanharjoittelua.Harjoittelu;
import aritmetiikanharjoittelua.Murtoluku;
import aritmetiikanharjoittelua.TestiRandom;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class HarjoitteluLukujenLuontiTest {

    TestiRandom arpoja;
    Harjoittelu harjoittelu;

    public HarjoitteluLukujenLuontiTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        arpoja = new TestiRandom();
        harjoittelu = new Harjoittelu(arpoja, 1);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void arpooMurtoluvun() {
        Murtoluku murtoluku = harjoittelu.arvoMurtoluku();

        assertEquals(2, murtoluku.haeOsoittaja(), 0.001);
        assertEquals(3, murtoluku.haeNimittaja(), 0.001);
    }
}
