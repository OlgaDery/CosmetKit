/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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
	@BeforeClass
	public static void setUpBeforeClass() 
			throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() 
			throws Exception {
	}

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
	public void tearDown() throws Exception {
	}

//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}
	
    @Test
  //to test that the target matches one of the static values
    public void testSerumTarget() {
        Serum serum = new Serum();
        serum.setTarget("aging");
        
        assertEquals(serum.getTarget(), Arrays.asList(ComponentsAndTargets.targets).get(serum.getTargetIndex()));
        
        //test that the map has been initialized and not null
        assertEquals(serum.getComponents().size(), 0);
    }

 // to test that the minimum nesessary fields are being initialized within the constructor
    @Test
    public void testSerumConstructor() {
        Serum serum1 = new Serum("Algenist anti-age", "aging");
        assertEquals(serum1.isBeforeSleep(), false);
    }
   
    
 // to test that the equals method works properly
    @Test
    public void testSerumEquals() {
        //int length, int width, int lotLength, int lotWidth
    	Serum s1 = new Serum ("Algenist anti-age", "aging");
    	Serum s2 = new Serum ("Algenist anti-age", "dryness");
    	s2.setBeforeSleep(true);
    	assertEquals(true, s1.equals(s2));
    }

}
