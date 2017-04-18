/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
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
		ejb = new EJBLocal ();
		
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
	
	//to test if all the singleton lists have been initialized
	@Test
	public void testInit () 
	{
		assertEquals(0, ejb.getItems().size());
		assertEquals(0, ejb.getRoutines().size());
		
	}
	
	@Test
	public void testCreates() 
	{
		//to assure that the methods saving to the static lists proper objects only
		
		assertEquals(false, ejb.createSerum(new Cleanser("Cl_1", "aging", "fluid")));
		assertEquals(true, ejb.createSerum(new Serum("S_1", "aging")));
		
		assertEquals(false, ejb.createCleanser(new Serum("S_1", "aging")));
		assertEquals(true, ejb.createCleanser(new Cleanser("Cl_1", "dryness", "fluid")));
		
		assertEquals(false, ejb.createExfoliator(new Cleanser("Cl_1", "aging", "fluid")));
		assertEquals(true, ejb.createExfoliator(new Exfoliator("Exf_1", "aging")));
		
		//to assure that the items are being stored in the singleton list of the EJB class
		assertEquals(3, ejb.getItems().size());
	}
	
	@Test
	public void routineCreation ()
	{
		ejb.createRoutine("Routine1", "descript1");
		ejb.createRoutine("Routine2", "descript2");
		ejb.createRoutine("Routine3", "descript3");
		
		assertEquals(3, ejb.getRoutines().size());
		Item item = new Cleanser("Cl_1", "aging", "fluid");
		Item item2 = new Serum("S_1", "aging");
		Item item3 = new Exfoliator("S_1", "aging");
		
		assertEquals(4, ejb.addItemToRoutine(item, "Bla"));
		assertEquals(1, ejb.addItemToRoutine(item, "Routine2"));
		assertEquals(1, ejb.addItemToRoutine(item2, "Routine2"));
		assertEquals(2, ejb.addItemToRoutine(item2, "Routine2"));
		assertEquals(1, ejb.addItemToRoutine(item3, "Routine2"));
		assertEquals(0, ejb.addItemToRoutine(item3, "Routine2"));
		assertEquals(4, ejb.addItemToRoutine(item, "Bla"));
		
		
	}
	
	@Test
	public void assertSize ()
	
	{
		assertEquals(3, ejb.getRoutines().size());
		assertEquals(3, ejb.getItems().size());
		assertEquals(1, ejb.getRoutinesWithTarget("aging").size());
	}
	
	
	

}
