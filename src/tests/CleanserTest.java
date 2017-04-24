/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import java.util.Arrays;

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

	
	
	@Test
    public void testSerumEquals() {
       //To assure that two objects implementing the same interface are not equal
    	Item item1 = new Cleanser ("Cleanser A", "aging", "mask");
    	Item item2 = new Serum ("Cleanser A", "dryness");
    	
    	assertEquals(false, item1.equals(item2));
    	
    	//To test the comparison of 2 cleansers 
    	Cleanser cleanser = new Cleanser ();
    	cleanser.setName("Cleanser A");
    	cleanser.setTarget("dryness");
    	
    	assertEquals(true, item1.equals(cleanser));
    	
    }
	
	public void testCleanserTargetAndFormat() {
		//To assure that the provided target and format are the elements of static arrays declared 
		//in the ComponentsAndTargets class
		Cleanser cleanser = new Cleanser (); 
    	cleanser.setTarget("dryness");
    	cleanser.setFormat("mask");
        assertEquals(cleanser.getTarget(), Arrays.asList(ComponentsAndTargets.targets).get(cleanser.getTargetIndex()));
        
        assertEquals(true, Arrays.asList(ComponentsAndTargets.formats).contains(cleanser.getFormat()));
    
    }

	

}
