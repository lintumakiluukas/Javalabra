/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import laivanupotus.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Luce
 */
public class LaivanupotusTest {
    
    Kentta kentta;
    Laiva laiva;
    
    public LaivanupotusTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        kentta= new Kentta();
        laiva=new Laiva(2, 0,0);
        kentta.lisaaLaiva(laiva);
    }

    @Test
    public void laivanPituusOnOikein(){
       assertEquals(2,laiva.getPituus());
    }

    @Test
    public void laivanSijaintiMaaritetaan(){
        assertNotNull(laiva.getX());
        assertNotNull(laiva.getY());
    }
    @Test
    public void laivanSijantiMaaritetaanOikein(){
        assertEquals(0, laiva.getX());
        assertEquals(0, laiva.getY());
    }
    @Test
    public void ampuminenTyhjaanOnnistuu(){
       assertEquals("Ammuttiin koordinaatteihin (2,0) onnistuneesti.",kentta.ammu(2, 0));
    }
    @Test
    public void laivanVahingoittaminen(){
        assertEquals("Ammuttiin koordinaatteihin (0,0) onnistuneesti. Vahingoitettiin vihollisalusta!",kentta.ammu(0,0));
    }
    @Test
    public void laivaTulostaaItsensaOikein(){
    assertEquals("Koko: 2. {0=0, 1=0}", laiva.toString());
    }

}
