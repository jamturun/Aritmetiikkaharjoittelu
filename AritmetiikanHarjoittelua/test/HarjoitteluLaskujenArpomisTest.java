
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
        Laskutoimitus lasku = harjoittelu.arvoLaskuKokonaisluvuilla(2);

        assertEquals("-2 - 5", lasku.toString());
    }

    @Test
    public void arpooLaskunPositiiviKokonaisluvuilla() {
        Laskutoimitus lasku = harjoittelu.arvoLaskuPositiiviKokonaisluvuilla(3);

        assertEquals("1 * 4", lasku.toString());
    }

    @Test
    public void arpooLaskunPositiiviLuvuilla() {
        Laskutoimitus lasku = harjoittelu.arvoLaskuPositiiviLuvuilla(4);

        assertEquals("(1/2) / (5/7)", lasku.toString());
    }

    @Test
    public void arpooPositiiviTulosLaskunPositiiviLuvuilla() {
        Laskutoimitus lasku = harjoittelu.arvoPositiiviTulosLaskuPositiiviLuvuilla(2);

        assertEquals("2/3 - 1/3", lasku.toString());
    }

    @Test
    public void arpooKokonaislukuTulosLaskunKokonaisluvuilla() {
        Laskutoimitus lasku = harjoittelu.arvoKokonaislukuTulosLaskuKokonaisluvuilla(4);

        assertEquals("8 / -4", lasku.toString());
    }

    @Test
    public void arpooKokonaislukuTulosLaskunPositiiviKokonaisluvuilla() {
        Laskutoimitus lasku = harjoittelu.arvoKokonaislukuTulosLaskuPositiiviKokonaisluvuilla(4);

        assertEquals("8 / 4", lasku.toString());
    }

    @Test
    public void arpooPositiiviTulosLaskuPositiiviKokonaisluvuilla() {
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
        Laskutoimitus lasku = harjoittelu.arvoSatunnainenLasku(4);
        
        assertEquals("4 / 3", lasku.toString());
    }
}
