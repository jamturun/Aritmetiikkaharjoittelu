
import aritmetiikanharjoittelua.Harjoittelu;
import aritmetiikanharjoittelua.Murtoluku;
import aritmetiikanharjoittelua.TestiRandom1;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class HarjoitteluLukujenLuontiTest {

    TestiRandom1 arpoja;
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
        arpoja = new TestiRandom1();
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
    
    @Test
    public void vaihtaaNollanMurtoluvussa() {
        arpoja.kasvataInttia(2);
        Murtoluku murtoluku = harjoittelu.arvoMurtoluku();
        
        assertEquals(4, murtoluku.haeOsoittaja(), 0.001);
        assertEquals(1, murtoluku.haeNimittaja(), 0.001);
    }
    
    @Test
    public void arpooKokonaisluvun() {
        arpoja.kasvataInttia(4);
        Murtoluku kokonaisluku = harjoittelu.arvoKokonaisluku();
        
        assertEquals(3, kokonaisluku.haeOsoittaja(), 0.001);
        assertEquals(1, kokonaisluku.haeNimittaja(), 0.001);
    }
    
    @Test
    public void arpooPositiiviMurtoluvun() {
        arpoja.kasvataInttia(5);
        Murtoluku murtoluku = harjoittelu.arvoPositiiviMurtoluku();
        
        assertEquals(1, murtoluku.haeOsoittaja(), 0.001);
        assertEquals(2, murtoluku.haeNimittaja(), 0.001);
    }
    
    
    
    @Test
    public void arpooPositiiviKokonaisluvun() {
        arpoja.kasvataInttia(7);
        Murtoluku kokonaisluku = harjoittelu.arvoPositiiviKokonaisluku();
        
        assertEquals(7, kokonaisluku.haeOsoittaja(), 0.001);
        assertEquals(1, kokonaisluku.haeNimittaja(), 0.001);
    }
    
    
}
