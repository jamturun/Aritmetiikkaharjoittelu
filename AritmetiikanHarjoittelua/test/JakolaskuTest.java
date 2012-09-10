

import aritmetiikanharjoittelua.Jakolasku;
import aritmetiikanharjoittelua.Murtoluku;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class JakolaskuTest {
    
    public JakolaskuTest() {
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
    public void testaaToStringKahdellaMurtoluvulla() {
        Murtoluku eka = new Murtoluku(-11, 13);
        Murtoluku toka = new Murtoluku(15, 16);
        Jakolasku osamaara = new Jakolasku(eka, toka);
        
        assertEquals("(-11/13) / (15/16)", osamaara.toString());
       
    }
    
    @Test
    public void testaaToStringKahdellaKokonaisluvulla() {
        Murtoluku eka = new Murtoluku(2);
        Murtoluku toka = new Murtoluku(-3);
        Jakolasku osamaara = new Jakolasku(eka, toka);
        
        assertEquals("2 / -3", osamaara.toString());
                
    }
    
    @Test
    public void testaaToStringMurtoJaKokonaisluvulla() {
        Murtoluku eka = new Murtoluku(2, 3);
        Murtoluku toka = new Murtoluku(-5);
        Jakolasku osamaara = new Jakolasku(eka, toka);
        
        assertEquals("(2/3) / -5", osamaara.toString());
    }
    
    @Test
    public void testaaToStringKokonaisJaMurtoluvulla() {
        Murtoluku eka = new Murtoluku(7);
        Murtoluku toka = new Murtoluku(3, 4);
        Jakolasku osamaara = new Jakolasku(eka, toka);
        
        assertEquals("7 / (3/4)", osamaara.toString());
    }
   
}
