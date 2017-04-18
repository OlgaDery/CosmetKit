package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.Cleanser;
import domain.Exfoliator;

public class ExfoliatorTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
    public void testEquals() {
       //to assure that two objects implementing the same interface are not equal
		Cleanser item1 = new Cleanser ("Cleanser A", "aging", "mask");
		Cleanser item2 = new Exfoliator ("Cleanser A", "aging");
    	
    	assertEquals(false, item1.equals(item2));
    	
    	
    }
	
	@Test
    public void testConstructor() {
       //to assure that two objects implementing the same interface are not equal
		Exfoliator item1 = new Exfoliator ("Cleanser A", "aging");
    	
    	assertEquals("Cleanser A", item1.getName());
    	assertEquals("aging", item1.getTarget());
    	assertEquals(3, item1.getDaysPerWeek().intValue());
    	
    }

}
