package aritmetiikanharjoittelua;



import java.util.ArrayList;
import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class HarjoitteluVaikeidenLaskujenArpomisTest {

    Random arpoja;
    ArrayList<Laskutoimitus> vaarinMenneet;
    ArrayList<Laskutoimitus> tarkistuslista;
    Harjoittelu harjoittelu;

    public HarjoitteluVaikeidenLaskujenArpomisTest() {
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
        vaarinMenneet = new ArrayList<Laskutoimitus>();
        tarkistuslista = new ArrayList<Laskutoimitus>();
        Murtoluku ekaM = new Murtoluku(2, 3);
        Murtoluku tokaM = new Murtoluku(1, 2);
        Murtoluku ekaK = new Murtoluku(4);
        Yhteenlasku eka = new Yhteenlasku(ekaM, tokaM);
        Vahennyslasku toka = new Vahennyslasku(ekaM, tokaM);
        Kertolasku kolmas = new Kertolasku(ekaM, tokaM);
        Jakolasku neljas = new Jakolasku(ekaM, tokaM);
        Yhteenlasku viides = new Yhteenlasku(ekaM, ekaK);
        Vahennyslasku kuudes = new Vahennyslasku(ekaM, ekaK);
        Kertolasku seiska = new Kertolasku(ekaM, ekaK);
        Jakolasku kasi = new Jakolasku(ekaM, ekaK);
        Yhteenlasku ysi = new Yhteenlasku(tokaM, ekaK);
        Vahennyslasku kyba = new Vahennyslasku(tokaM, ekaK);
        Kertolasku ykstoist = new Kertolasku(tokaM, ekaK);
        Yhteenlasku kakstoist = new Yhteenlasku(tokaM, ekaM);
        vaarinMenneet.add(eka);
        vaarinMenneet.add(toka);
        vaarinMenneet.add(kolmas);
        vaarinMenneet.add(neljas);
        vaarinMenneet.add(viides);
        vaarinMenneet.add(kuudes);
        vaarinMenneet.add(seiska);
        vaarinMenneet.add(kasi);
        vaarinMenneet.add(ysi);
        vaarinMenneet.add(kyba);
        vaarinMenneet.add(ykstoist);
        vaarinMenneet.add(kakstoist);

        harjoittelu = new Harjoittelu(arpoja, false, true, true, false, 1, vaarinMenneet, 0);
    }

    @After
    public void tearDown() {
    }

    public void taytaTarkistuslista() {
        for (int i = 0; i < 10000; i++) {
            Laskutoimitus lasku = harjoittelu.arvoLasku(1);
            tarkistuslista.add(lasku);
            vaarinMenneet.add(lasku);
        }
    }

    public boolean LoytyykoKaikkiLaskut() {
        taytaTarkistuslista();
        for (Laskutoimitus lasku : tarkistuslista) {
            if (!vaarinMenneet.contains(lasku)) {
                return false;
            }
        }
        return true;
    }
    
    @Test
    public void arpookoKaiken() {
        boolean arpooko = LoytyykoKaikkiLaskut();
        
        assertEquals(true, arpooko);
    }
    
   
}
