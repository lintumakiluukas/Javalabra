/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import laivanupotus.domain.Laiva;
import laivanupotus.domain.Kentta;
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
        kentta= new Kentta("Hubert Cumberdale");
        laiva=new Laiva(2, kentta, 0,0);
        
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
       assertEquals("Hubert Cumberdale ampui koordinaatteihin (2,0) onnistuneesti.",kentta.ammu(2, 0));
    }
    @Test
    public void laivanVahingoittaminen(){
        assertEquals("Hubert Cumberdale ampui koordinaatteihin (0,0) onnistuneesti. Vahingoitettiin alusta!",kentta.ammu(0,0));
    }
    @Test
    public void laivaTulostaaItsensaOikein(){
    assertEquals("Koko: 2. {0=0, 1=0}, Hubert Cumberdale", laiva.toString());
    }

}
