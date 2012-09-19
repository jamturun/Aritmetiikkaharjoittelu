
import aritmetiikanharjoittelua.Harjoittelu;
import aritmetiikanharjoittelua.TestiRandom1;
import aritmetiikanharjoittelua.TestiRandom2;
import aritmetiikanharjoittelua.Yhteenlasku;
import aritmetiikanharjoittelua.Vahennyslasku;
import aritmetiikanharjoittelua.Kertolasku;
import aritmetiikanharjoittelua.Jakolasku;
import aritmetiikanharjoittelua.Laskutoimitus;
import aritmetiikanharjoittelua.Murtoluku;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class HarjoitteluLaskujenArpomisTest {

    TestiRandom2 arpoja;
    Harjoittelu harjoittelu;

    public HarjoitteluLaskujenArpomisTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        arpoja = new TestiRandom2();
        harjoittelu = new Harjoittelu(arpoja, 1);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void arpooSatunnaisenLaskun() {
        Laskutoimitus lasku = harjoittelu.arvoSatunnainenLasku(1);

        assertEquals("1/2 + (-3/4)", lasku.toString());
    }

    @Test
    public void arpooLaskunKokonaisluvuilla() {
        arpoja.kasvataInttia(4);
        Laskutoimitus lasku = harjoittelu.arvoLaskuKokonaisluvuilla(2);

        assertEquals("-2 - 5", lasku.toString());
    }

    @Test
    public void arpooLaskunPositiiviKokonaisluvuilla() {
        arpoja.kasvataInttia(6);
        Laskutoimitus lasku = harjoittelu.arvoLaskuPositiiviKokonaisluvuilla(3);

        assertEquals("1 * 4", lasku.toString());
    }

    @Test
    public void arpooLaskunPositiiviLuvuilla() {
        arpoja.kasvataInttia(14);
        Laskutoimitus lasku = harjoittelu.arvoLaskuPositiiviLuvuilla(4);

        assertEquals("(1/2) / (5/7)", lasku.toString());
    }

    @Test
    public void arpooPositiiviTulosLaskunPositiiviLuvuilla() {
        arpoja.kasvataInttia(22);
        Laskutoimitus lasku = harjoittelu.arvoPositiiviTulosLaskuPositiiviLuvuilla(2);

        assertEquals("2/3 - 1/3", lasku.toString());
    }

    @Test
    public void arpooKokonaislukuTulosLaskunKokonaisluvuilla() {
        arpoja.kasvataInttia(26);
        Laskutoimitus lasku = harjoittelu.arvoKokonaislukuTulosLaskuKokonaisluvuilla(4);

        assertEquals("8 / -4", lasku.toString());
    }

    @Test
    public void arpooKokonaislukuTulosLaskunPositiiviKokonaisluvuilla() {
        arpoja.kasvataInttia(30);
        Laskutoimitus lasku = harjoittelu.arvoKokonaislukuTulosLaskuPositiiviKokonaisluvuilla(4);

        assertEquals("8 / 4", lasku.toString());
    }

    @Test
    public void arpooPositiiviTulosLaskunPositiiviKokonaisluvuilla() {
        arpoja.kasvataInttia(36);
        Laskutoimitus lasku = harjoittelu.arvoPositiiviTulosLaskuPositiiviKokonaisluvuilla(2);

        assertEquals("9 - 8", lasku.toString());
    }

    @Test
    public void vaihdaNollaToimii() {
        Murtoluku murtoluku = new Murtoluku(0);

        assertEquals(1, harjoittelu.vaihdaNolla(murtoluku).haeOsoittaja(), 0.0001);
    }
    
    @Test
    public void vaihtaaNollanJakolaskussa() {
        arpoja.kasvataInttia(40);
        Laskutoimitus lasku = harjoittelu.arvoSatunnainenLasku(4);
        
        assertEquals("4 / 3", lasku.toString());
    }
}
