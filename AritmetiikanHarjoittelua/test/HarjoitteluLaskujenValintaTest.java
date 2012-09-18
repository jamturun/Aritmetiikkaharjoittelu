
import aritmetiikanharjoittelua.Harjoittelu;
import aritmetiikanharjoittelua.Laskutoimitus;
import aritmetiikanharjoittelua.TestiRandom3;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class HarjoitteluLaskujenValintaTest {

    TestiRandom3 arpoja;

    public HarjoitteluLaskujenValintaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        arpoja = new TestiRandom3();

    }

    @After
    public void tearDown() {
    }

    @Test
    public void vainKokonaislukuja1111() {
        Harjoittelu harjoittelu = new Harjoittelu(arpoja, true, true, true, true, 1);
        Laskutoimitus lasku = harjoittelu.arvoLasku(1);

        assertEquals("2 + 3", lasku.toString());
    }

    @Test
    public void negatiivisetMukana1111() {
        Harjoittelu harjoittelu = new Harjoittelu(arpoja, true, true, true, true, 1);
        Laskutoimitus lasku = harjoittelu.arvoLasku(3);

        assertEquals("4 * (-7)", lasku.toString());
    }

    @Test
    public void negatiiviVastausSallittu1111() {
        Harjoittelu harjoittelu = new Harjoittelu(arpoja, true, true, true, true, 1);
        Laskutoimitus lasku = harjoittelu.arvoLasku(2);

        assertEquals("1 - 2", lasku.toString());
    }

    @Test
    public void vainKokonaislukuVastaus1111() {
        Harjoittelu harjoittelu = new Harjoittelu(arpoja, true, true, true, true, 1);
        Laskutoimitus lasku = harjoittelu.arvoLasku(4);

        assertEquals("4 / 2", lasku.toString());
    }

    @Test
    public void vainKokonaislukuja1110() {
        Harjoittelu harjoittelu = new Harjoittelu(arpoja, true, true, true, false, 1);
        Laskutoimitus lasku = harjoittelu.arvoLasku(1);

        assertEquals("6 + 8", lasku.toString());
    }

    @Test
    public void negatiivisetMukana1110() {
        Harjoittelu harjoittelu = new Harjoittelu(arpoja, true, true, true, false, 1);
        Laskutoimitus lasku = harjoittelu.arvoLasku(3);

        assertEquals("-1 * (-9)", lasku.toString());
    }

    @Test
    public void negatiiviVastausSallittu1110() {
        Harjoittelu harjoittelu = new Harjoittelu(arpoja, true, true, true, false, 1);
        Laskutoimitus lasku = harjoittelu.arvoLasku(1);

        assertEquals("1 + (-2)", lasku.toString());
    }

    @Test
    public void murtolukuVastausSallittu1110() {
        Harjoittelu harjoittelu = new Harjoittelu(arpoja, true, true, true, false, 1);
        Laskutoimitus lasku = harjoittelu.arvoLasku(4);

        assertEquals("4 / 7", lasku.toString());
    }

    @Test
    public void vainKokonaislukuja1011() {
        Harjoittelu harjoittelu = new Harjoittelu(arpoja, true, false, true, true, 1);
        Laskutoimitus lasku = harjoittelu.arvoLasku(1);

        assertEquals("3 + 3", lasku.toString());
    }
    
    @Test
    public void eiNegatiivisiaMukana1011() {
        Harjoittelu harjoittelu = new Harjoittelu(arpoja, true, false, true, true, 1);
        Laskutoimitus lasku = harjoittelu.arvoLasku(3);
        
        assertEquals("7 * 8", lasku.toString());
    }
    
    @Test
    public void negatiiviVastausSallittu1011() {
        Harjoittelu harjoittelu = new Harjoittelu(arpoja, true, false, true, true, 1);
        Laskutoimitus lasku = harjoittelu.arvoLasku(2);

        assertEquals("2 - 4", lasku.toString());
    } 
    
}
