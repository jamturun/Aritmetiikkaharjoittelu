package aritmetiikanharjoittelua;



import testirandomit.TestiRandom3;
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
        arpoja.kasvataInttia(2);
        Harjoittelu harjoittelu = new Harjoittelu(arpoja, true, true, true, true, 1);
        Laskutoimitus lasku = harjoittelu.arvoLasku(3);

        assertEquals("4 * (-7)", lasku.toString());
    }

    @Test
    public void negatiiviVastausSallittu1111() {
        arpoja.kasvataInttia(4);
        Harjoittelu harjoittelu = new Harjoittelu(arpoja, true, true, true, true, 1);
        Laskutoimitus lasku = harjoittelu.arvoLasku(2);

        assertEquals("1 - 2", lasku.toString());
    }

    @Test
    public void vainKokonaislukuVastaus1111() {
        arpoja.kasvataInttia(6);
        Harjoittelu harjoittelu = new Harjoittelu(arpoja, true, true, true, true, 1);
        Laskutoimitus lasku = harjoittelu.arvoLasku(4);

        assertEquals("4 / 2", lasku.toString());
    }

    @Test
    public void vainKokonaislukuja1110() {
        arpoja.kasvataInttia(10);
        Harjoittelu harjoittelu = new Harjoittelu(arpoja, true, true, true, false, 1);
        Laskutoimitus lasku = harjoittelu.arvoLasku(1);

        assertEquals("6 + 8", lasku.toString());
    }

    @Test
    public void negatiivisetMukana1110() {
        arpoja.kasvataInttia(12);
        Harjoittelu harjoittelu = new Harjoittelu(arpoja, true, true, true, false, 1);
        Laskutoimitus lasku = harjoittelu.arvoLasku(3);

        assertEquals("-1 * (-9)", lasku.toString());
    }

    @Test
    public void negatiiviVastausSallittu1110() {
        arpoja.kasvataInttia(14);
        Harjoittelu harjoittelu = new Harjoittelu(arpoja, true, true, true, false, 1);
        Laskutoimitus lasku = harjoittelu.arvoLasku(1);

        assertEquals("1 + (-2)", lasku.toString());
    }

    @Test
    public void murtolukuVastausSallittu1110() {
        arpoja.kasvataInttia(16);
        Harjoittelu harjoittelu = new Harjoittelu(arpoja, true, true, true, false, 1);
        Laskutoimitus lasku = harjoittelu.arvoLasku(4);

        assertEquals("4 / 7", lasku.toString());
    }

    @Test
    public void vainKokonaislukuja1011() {
        arpoja.kasvataInttia(18);
        Harjoittelu harjoittelu = new Harjoittelu(arpoja, true, false, true, true, 1);
        Laskutoimitus lasku = harjoittelu.arvoLasku(1);

        assertEquals("3 + 3", lasku.toString());
    }

    @Test
    public void eiNegatiivisiaMukana1011() {
        arpoja.kasvataInttia(20);
        Harjoittelu harjoittelu = new Harjoittelu(arpoja, true, false, true, true, 1);
        Laskutoimitus lasku = harjoittelu.arvoLasku(3);

        assertEquals("7 * 8", lasku.toString());
    }

    @Test
    public void negatiiviVastausSallittu1011() {
        arpoja.kasvataInttia(24);
        Harjoittelu harjoittelu = new Harjoittelu(arpoja, true, false, true, true, 1);
        Laskutoimitus lasku = harjoittelu.arvoLasku(2);

        assertEquals("5 - 7", lasku.toString());
    }

    @Test
    public void vainKokonaislukuVastaus1011() {
        arpoja.kasvataInttia(24);
        Harjoittelu harjoittelu = new Harjoittelu(arpoja, true, false, true, true, 1);
        Laskutoimitus lasku = harjoittelu.arvoLasku(4);

        assertEquals("4 / 2", lasku.toString());
    }

    @Test
    public void vainKokonaislukuja1010() {
        arpoja.kasvataInttia(30);
        Harjoittelu harjoittelu = new Harjoittelu(arpoja, true, false, true, false, 1);
        Laskutoimitus lasku = harjoittelu.arvoLasku(1);

        assertEquals("6 + 7", lasku.toString());
    }

    @Test
    public void eiNegatiivisiaMukana1010() {
        arpoja.kasvataInttia(32);
        Harjoittelu harjoittelu = new Harjoittelu(arpoja, true, false, true, false, 1);
        Laskutoimitus lasku = harjoittelu.arvoLasku(3);

        assertEquals("7 * 8", lasku.toString());
    }

    @Test
    public void negatiiviVastausSallittu1010() {
        arpoja.kasvataInttia(36);
        Harjoittelu harjoittelu = new Harjoittelu(arpoja, true, false, true, false, 1);
        Laskutoimitus lasku = harjoittelu.arvoLasku(2);

        assertEquals("5 - 7", lasku.toString());
    }

    @Test
    public void murtolukuVastausSallittu1010() {
        arpoja.kasvataInttia(38);
        Harjoittelu harjoittelu = new Harjoittelu(arpoja, true, false, true, false, 1);
        Laskutoimitus lasku = harjoittelu.arvoLasku(4);

        assertEquals("6 / 5", lasku.toString());
    }

    @Test
    public void vainKokonaislukuja1001() {
        arpoja.kasvataInttia(40);
        Harjoittelu harjoittelu = new Harjoittelu(arpoja, true, false, false, true, 1);
        Laskutoimitus lasku = harjoittelu.arvoLasku(1);

        assertEquals("6 + 7", lasku.toString());
    }

    @Test
    public void eiNegatiivisiaMukana1001() {
        arpoja.kasvataInttia(42);
        Harjoittelu harjoittelu = new Harjoittelu(arpoja, true, false, false, true, 1);
        Laskutoimitus lasku = harjoittelu.arvoLasku(3);

        assertEquals("7 * 8", lasku.toString());
    }

    @Test
    public void vastausPositiivinen1001() {
        arpoja.kasvataInttia(46);
        Harjoittelu harjoittelu = new Harjoittelu(arpoja, true, false, false, true, 1);
        Laskutoimitus lasku = harjoittelu.arvoLasku(2);

        assertEquals("2 - 1", lasku.toString());
    }

    @Test
    public void vainKokonaislukuVastaus1001() {
        arpoja.kasvataInttia(50);
        Harjoittelu harjoittelu = new Harjoittelu(arpoja, true, false, false, true, 1);
        Laskutoimitus lasku = harjoittelu.arvoLasku(4);

        assertEquals("4 / 2", lasku.toString());
    }

    @Test
    public void vainKokonaislukuja1000() {
        arpoja.kasvataInttia(54);
        Harjoittelu harjoittelu = new Harjoittelu(arpoja, true, false, false, false, 1);
        Laskutoimitus lasku = harjoittelu.arvoLasku(1);

        assertEquals("6 + 7", lasku.toString());
    }

    @Test
    public void eiNegatiivisiaMukana1000() {
        arpoja.kasvataInttia(56);
        Harjoittelu harjoittelu = new Harjoittelu(arpoja, true, false, false, false, 1);
        Laskutoimitus lasku = harjoittelu.arvoLasku(3);

        assertEquals("7 * 8", lasku.toString());
    }

    @Test
    public void vastausPositiivinen1000() {
        arpoja.kasvataInttia(62);
        Harjoittelu harjoittelu = new Harjoittelu(arpoja, true, false, false, false, 1);
        Laskutoimitus lasku = harjoittelu.arvoLasku(2);

        assertEquals("2 - 1", lasku.toString());
    }

    @Test
    public void murtolukuVastausSallittu1000() {
        arpoja.kasvataInttia(66);
        Harjoittelu harjoittelu = new Harjoittelu(arpoja, true, false, false, false, 1);
        Laskutoimitus lasku = harjoittelu.arvoLasku(4);

        assertEquals("6 / 5", lasku.toString());
    }

    @Test
    public void murtoluvutMukana0110() {
        arpoja.kasvataInttia(68);
        Harjoittelu harjoittelu = new Harjoittelu(arpoja, false, true, true, false, 1);
        Laskutoimitus lasku = harjoittelu.arvoLasku(3);

        assertEquals("2/3 * 7/3", lasku.toString());
    }

    @Test
    public void negatiivisetMukana0110() {
        arpoja.kasvataInttia(72);
        Harjoittelu harjoittelu = new Harjoittelu(arpoja, false, true, true, false, 1);
        Laskutoimitus lasku = harjoittelu.arvoLasku(1);

        assertEquals("-1/6 + (-9/8)", lasku.toString());
    }

    @Test
    public void negatiiviVastausSallittu0110() {
        arpoja.kasvataInttia(76);
        Harjoittelu harjoittelu = new Harjoittelu(arpoja, false, true, true, false, 1);
        Laskutoimitus lasku = harjoittelu.arvoLasku(2);

        assertEquals("5/6 - 7/8", lasku.toString());
    }

    @Test
    public void murtolukuVastausSallittu0110() {
        arpoja.kasvataInttia(80);
        Harjoittelu harjoittelu = new Harjoittelu(arpoja, false, true, true, false, 1);
        Laskutoimitus lasku = harjoittelu.arvoLasku(4);

        assertEquals("(1/2) / (2/3)", lasku.toString());
    }

    @Test
    public void murtoluvutMukana0010() {
        arpoja.kasvataInttia(84);
        Harjoittelu harjoittelu = new Harjoittelu(arpoja, false, false, true, false, 1);
        Laskutoimitus lasku = harjoittelu.arvoLasku(3);

        assertEquals("2/3 * 7/3", lasku.toString());
    }
    
    @Test
    public void eiNegatiivisiaMukana0010() {
        arpoja.kasvataInttia(88);
        Harjoittelu harjoittelu = new Harjoittelu(arpoja, false, false, true, false, 1);
        Laskutoimitus lasku = harjoittelu.arvoLasku(3);

        assertEquals("7/5 * 1/8", lasku.toString());
    }
    
    @Test
    public void negatiiviVastausSallittu0010() {
        arpoja.kasvataInttia(96);
        Harjoittelu harjoittelu = new Harjoittelu(arpoja, false, false, true, false, 1);
        Laskutoimitus lasku = harjoittelu.arvoLasku(2);

        assertEquals("5 - 11/2", lasku.toString());
    }
    
    @Test
    public void murtolukuVastausSallittu0010() {
        arpoja.kasvataInttia(80);
        Harjoittelu harjoittelu = new Harjoittelu(arpoja, false, false, true, false, 1);
        Laskutoimitus lasku = harjoittelu.arvoLasku(4);

        assertEquals("(1/2) / (2/3)", lasku.toString());
    }
    
    @Test
    public void murtoluvutMukana0000() {
        arpoja.kasvataInttia(84);
        Harjoittelu harjoittelu = new Harjoittelu(arpoja, false, false, false, false, 1);
        Laskutoimitus lasku = harjoittelu.arvoLasku(3);

        assertEquals("2/3 * 7/3", lasku.toString());
    }
    
    @Test
    public void eiNegatiivisiaMukana0000() {
        arpoja.kasvataInttia(101);
        Harjoittelu harjoittelu = new Harjoittelu(arpoja, false, false, false, false, 1);
        Laskutoimitus lasku = harjoittelu.arvoLasku(3);

        assertEquals("7/5 * 1/8", lasku.toString());
    }
    
    @Test
    public void vastausPositiivinen0000() {
        arpoja.kasvataInttia(109);
        Harjoittelu harjoittelu = new Harjoittelu(arpoja, false, false, false, false, 1);
        Laskutoimitus lasku = harjoittelu.arvoLasku(2);

        assertEquals("1/2 - 1/4", lasku.toString());
    }
    
    @Test
    public void murtolukuVastausSallittu0000() {
        arpoja.kasvataInttia(80);
        Harjoittelu harjoittelu = new Harjoittelu(arpoja, false, false, false, false, 1);
        Laskutoimitus lasku = harjoittelu.arvoLasku(4);

        assertEquals("(1/2) / (2/3)", lasku.toString());
    }
    
}