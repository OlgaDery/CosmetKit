/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import domain.Cleanser;
import domain.Exfoliator;
import domain.Item;
import domain.Serum;
import ejb.EJBLocal;
import ejb.RoutineEJB_IF;

/**
 * @author Olga
 *
 */
public class EJBLocalTest {
	
	private static RoutineEJB_IF ejb;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() 
			throws Exception {
		//To instantiate the EJB class
		ejb = new EJBLocal ();
		
	}

	
	//To test if all the singleton lists have been initialized
	@Test
	public void testInit () 
	{
		assertNotNull(ejb.getItems());
		assertNotNull(ejb.getRoutines());
		
	}
	
	@Test
	//To assure that the methods are saving to the static sets objects of the proper class only
	public void testCreates() 
	{
		
	//Method "createSerum" does not add Cleanser to the set and returns "false"
		assertEquals(false, ejb.createSerum(new Cleanser("Cl_1", "aging", "fluid")));
	
	//Method "createSerum" adds Serum to the set and returns "true"
		assertEquals(true, ejb.createSerum(new Serum("S_1", "aging")));
	
	//Method "createCleanser" does not add Serum to the set and returns "false"
		assertEquals(false, ejb.createCleanser(new Serum("S_1", "aging")));
		
	//Method "createCleanser" adds Cleanser to the set and returns "true"
		assertEquals(true, ejb.createCleanser(new Cleanser("Cl_1", "dryness", "fluid")));
	
	//Method "createExfoliator" does not add Cleanser to the set and returns "false"
		assertEquals(false, ejb.createExfoliator(new Cleanser("Cl_1", "aging", "fluid")));
		
	//Method "createExfoliator" adds Exfoliator to the set and returns "true"
		assertEquals(true, ejb.createExfoliator(new Exfoliator("Exf_1", "aging")));
		
	
		//assertEquals(3, ejb.getItems().size());
	}
	
	@Test
	//To test if Routines are created and stored in the singleton set of the EJB
	public void routineCreation ()
	{
		ejb.createRoutine("Routine1", "descript1");
		ejb.createRoutine("Routine2", "descript2");
		ejb.createRoutine("Routine3", "descript3");
		
	//To check the size of the set
		assertEquals(3, ejb.getRoutines().size());
		
		Item item = new Cleanser("Cl_1", "aging", "fluid");
		Item item2 = new Serum("S_1", "aging");
		Item item3 = new Exfoliator("S_1", "aging");
	
	//Must return 4 as soon as there is no "Bla" routine
		assertEquals(4, ejb.addItemToRoutine(item, "Bla"));
	
	//Must return 1 as soon as the Item has been added to the Routine
		assertEquals(1, ejb.addItemToRoutine(item, "Routine2"));
	
	//Must return 1 as soon as the Item has been added to the Routine
		assertEquals(1, ejb.addItemToRoutine(item2, "Routine2"));
	
	//Must return 2 as soon as the Item of the same class exists in the Routine
		assertEquals(2, ejb.addItemToRoutine(item2, "Routine2"));
		
	//Must return 1 as soon as the Item has been added to the Routine	
		assertEquals(1, ejb.addItemToRoutine(item3, "Routine2"));
		
	//Must return 0 as soon as no more Items are allowed in the Routine
		assertEquals(0, ejb.addItemToRoutine(item3, "Routine2"));
	}
	
	@Test
	//To assure that all the items and routines are being stored in the singleton list of the EJB class
	public void assertSize ()
	{
		assertEquals(3, ejb.getRoutines().size());
		assertEquals(3, ejb.getItems().size());
		
	//To test the method getRoutinesWithTarget, which must return one Routine with "aging" target.
		assertEquals(1, ejb.getRoutinesWithTarget("aging").size());
	}
	
	
	

}
