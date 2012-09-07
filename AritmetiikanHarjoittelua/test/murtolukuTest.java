
import aritmetiikanharjoittelua.Murtoluku;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class murtolukuTest {

    public murtolukuTest() {
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
    public void konstruktoriLuoKokonaisluvun() {
        Murtoluku murtoluku = new Murtoluku(5);

        assertEquals(5, murtoluku.haeOsoittaja());
        assertEquals(1, murtoluku.haeNimittaja());
    }

    @Test
    public void konstruktoriLuoSievennetynMurtoluvun() {
        Murtoluku murtoluku = new Murtoluku(4, 6);

        assertEquals(2, murtoluku.haeOsoittaja());
        assertEquals(3, murtoluku.haeNimittaja());
    }

    @Test
    public void konstruktoriSieventaaKokonaisluvuksi() {
        Murtoluku murtoluku = new Murtoluku(26, 13);

        assertEquals(2, murtoluku.haeOsoittaja());
    }

    @Test
    public void konstruktoriSieventaaNegatiivisenNimittajan() {
        Murtoluku murtoluku = new Murtoluku(2, -12);

        assertEquals(-1, murtoluku.haeOsoittaja());
        assertEquals(6, murtoluku.haeNimittaja());
    }

    @Test
    public void toStringToimiiMurtoluvulla() {
        Murtoluku murtoluku = new Murtoluku(9, 10);

        assertEquals("9/10", murtoluku.toString());
    }

    @Test
    public void toStringToimiiKokonaisluvulla() {
        Murtoluku murtoluku = new Murtoluku(12, 1);

        assertEquals("12", murtoluku.toString());
    }

    @Test
    public void yhteenlaskuToimii() {
        Murtoluku eka = new Murtoluku(1, 2);
        Murtoluku toka = new Murtoluku(1, 6);
        Murtoluku uusi = eka.lisaa(toka);

        assertEquals(2, uusi.haeOsoittaja());
        assertEquals(3, uusi.haeNimittaja());
    }

    @Test
    public void vahennyslaskuToimii() {
        Murtoluku eka = new Murtoluku(1, 3);
        Murtoluku toka = new Murtoluku(5, 6);
        Murtoluku uusi = eka.vahenna(toka);

        assertEquals(-1, uusi.haeOsoittaja());
        assertEquals(2, uusi.haeNimittaja());
    }

    @Test
    public void kertolaskuToimii() {
        Murtoluku eka = new Murtoluku(7, 8);
        Murtoluku toka = new Murtoluku(-11, 9);
        Murtoluku uusi = eka.kerro(toka);

        assertEquals(-77, uusi.haeOsoittaja());
        assertEquals(72, uusi.haeNimittaja());
    }

    @Test
    public void jakolaskuToimii() {
        Murtoluku eka = new Murtoluku(-2, 5);
        Murtoluku toka = new Murtoluku(8);
        Murtoluku uusi = eka.jaa(toka);

        assertEquals(-1, uusi.haeOsoittaja());
        assertEquals(20, uusi.haeNimittaja());
    }
}
