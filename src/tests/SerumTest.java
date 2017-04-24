/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import domain.ComponentsAndTargets;
import domain.Serum;

/**
 * @author Olga
 *
 */
public class SerumTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() 
			throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() 
			throws Exception {
	}

	
    @Test
  //To test that the target matches one of the static values in the declared 
	//in the ComponentsAndTargets class
    public void testSerumTarget() {
        Serum serum = new Serum();
        serum.setTarget("aging");
        
        assertEquals(serum.getTarget(), Arrays.asList(ComponentsAndTargets.targets).get(serum.getTargetIndex()));
        
        //To test that the map has been initialized and not null
        assertNotNull(serum.getComponents());
    }
    
    @Test
  //To test that the map has been initialized and not null
      public void TestMapInit() {
          Serum serum = new Serum();
          assertNotNull(serum.getComponents());
      }

 // To test that the minimum necessary fields are being initialized within the constructor
    @Test
    public void testSerumConstructor() {
        Serum serum1 = new Serum("Algenist anti-age", "aging");
        assertEquals(serum1.isBeforeSleep(), false);
    }
   
    
 // To test that the equals method works properly
    @Test
    public void testSerumEquals() {
        //int length, int width, int lotLength, int lotWidth
    	Serum s1 = new Serum ("Algenist anti-age", "aging");
    	Serum s2 = new Serum ("Algenist anti-age", "dryness");
    	s2.setBeforeSleep(true);
    	assertEquals(true, s1.equals(s2));
    }

}
