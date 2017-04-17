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

import domain.Cleanser;
import domain.ComponentsAndTargets;
import domain.Item;
import domain.Serum;

/**
 * @author Olga
 *
 */
public class CleanserTest {

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
	public void tearDown() 
			throws Exception {
	}
	
	@Test
    public void testSerumEquals() {
       //to assure that two objects implementing the same interface are not equal
    	Item item1 = new Cleanser ("Cleanser A", "aging", "mask");
    	Item item2 = new Serum ("Cleanser A", "dryness");
    	
    	assertEquals(false, item1.equals(item2));
    	
    	//to test the comparison of 2 cleansers 
    	Cleanser cleanser = new Cleanser ();
    	cleanser.setName("Cleanser A");
    	cleanser.setTarget("dryness");
    	
    	assertEquals(true, item1.equals(cleanser));
    	
    }
	
	public void testCleanserTargetAndFormat() {
		Cleanser cleanser = new Cleanser ();
    	cleanser.setTarget("dryness");
    	cleanser.setFormat("mask");
        assertEquals(cleanser.getTarget(), Arrays.asList(ComponentsAndTargets.targets).get(cleanser.getTargetIndex()));
        
        assertEquals(true, Arrays.asList(ComponentsAndTargets.formats).contains(cleanser.getFormat()));
    
    }

	

}
