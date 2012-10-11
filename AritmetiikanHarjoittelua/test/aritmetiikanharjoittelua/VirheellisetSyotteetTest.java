package aritmetiikanharjoittelua;



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


    }

    @After
    public void tearDown() {
    }

    @Test
    public void muuttaaNegatiivisenNumeroidenMaaranYkkoseksi() {
        Harjoittelu harjoittelu = new Harjoittelu(arpoja, true, true, true, true, -2, laskutoimitukset);
        int numerot = harjoittelu.haeNumerot();
        assertEquals(1, numerot);
    }

    @Test
    public void muuttaaNollaNumeroMaaranYkkoseksi() {
        Harjoittelu harjoittelu = new Harjoittelu(arpoja, true, true, true, true, 0, laskutoimitukset);
        int numerot = harjoittelu.haeNumerot();
        assertEquals(1, numerot);
    }

    @Test
    public void muuttaaYsiaSuuremmatNumerotYsiksiYhteenlaskussa() {
        Harjoittelu harjoittelu = new Harjoittelu(arpoja, true, true, true, true, 10, laskutoimitukset);
        int numerot = harjoittelu.haeNumerot();
        assertEquals(9, numerot);
    }

    @Test
    public void muuttaaNelostaSuuremmatNumerotNeloseksiKertolaskussa() {
        laskutoimitukset.add(3);
        Harjoittelu harjoittelu = new Harjoittelu(arpoja, true, true, true, true, 5, laskutoimitukset);
        int numerot = harjoittelu.haeNumerot();
        assertEquals(4, numerot);
    }
    
    @Test
    public void muuttaaNelostaSuuremmatNumerotNeloseksiJakolaskussa() {
        laskutoimitukset.add(4);
        Harjoittelu harjoittelu = new Harjoittelu(arpoja, true, true, true, true, 7, laskutoimitukset);
        int numerot = harjoittelu.haeNumerot();
        assertEquals(4, numerot);
    }
    
    @Test
    public void sailyttaaYsinYhteenlaskussa() {
        Harjoittelu harjoittelu = new Harjoittelu(arpoja, true, true, true, true, 9, laskutoimitukset);
        int numerot = harjoittelu.haeNumerot();
        assertEquals(9, numerot);
    }
    
    @Test
    public void sailyttaaNelosenKertolaskussa() {
        laskutoimitukset.add(3);
        Harjoittelu harjoittelu = new Harjoittelu(arpoja, true, true, true, true, 4, laskutoimitukset);
        int numerot = harjoittelu.haeNumerot();
        assertEquals(4, numerot);
    }
    
    @Test
    public void sailyttaaNelosenJakolaskussa() {
        laskutoimitukset.add(4);
        Harjoittelu harjoittelu = new Harjoittelu(arpoja, true, true, true, true, 4, laskutoimitukset);
        int numerot = harjoittelu.haeNumerot();
        assertEquals(4, numerot);
    }
    
    
}
