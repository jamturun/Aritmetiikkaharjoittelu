

import aritmetiikanharjoittelua.Murtoluku;
import aritmetiikanharjoittelua.Vahennyslasku;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class VahennyslaskuTest {
    
    public VahennyslaskuTest() {
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
    Murtoluku eka = new Murtoluku(1, 4);
    Murtoluku toka = new Murtoluku(1, 2);
    Vahennyslasku erotus = new Vahennyslasku(eka, toka);
    
    assertEquals("1/4 - 1/2", erotus.toString());
}
    
    @Test
    public void testaaToSringNegatiivisella() {
        Murtoluku eka = new Murtoluku(-1, 5);
        Murtoluku toka = new Murtoluku(-3, 4);
        Vahennyslasku erotus = new Vahennyslasku(eka, toka);
        
        assertEquals("-1/5 - (-3/4)", erotus.toString());
    }
    
    @Test
    public void testaaToSringNollalla() {
        Murtoluku eka = new Murtoluku(1, 5);
        Murtoluku toka = new Murtoluku(0);
        Vahennyslasku erotus = new Vahennyslasku(eka, toka);
        
        assertEquals("1/5 - 0", erotus.toString());
    }
    
}
