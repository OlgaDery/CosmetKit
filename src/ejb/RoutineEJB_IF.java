/**
 * 
 */
package ejb;

import java.util.Set;

import domain.Item;
import domain.Routine;

/**
 * @author Olga
 *This is the interface providing the methods for Local Singleton EJB class to manipulate Routines and Items. 
 */
public interface RoutineEJB_IF 
{
		
		//Stores all the routines during the app lifecycle.
		public Set <?extends Routine> getRoutines();
		
		//Stores all the implementations of the Item interface during the app lifecycle.
		public Set <?extends Item> getItems();
		
		//Creates a Serum and adds it to the set
		public boolean createSerum (Item i);
		
		//Creates a Cleanser and adds it to the set
		public boolean createCleanser (Item i);
		
		//Creates a Exfoliator and adds it to the set
		public boolean createExfoliator (Item i);
		
		//Creates a Routine and adds it to the Routine set
		public void createRoutine (String name, String descript);
		
		//Adds an Item implementation to the selected Routine (it`s name is being provided as a parameter).
		//This method should be responsible for checking of the size of the Item list of the Routine 
		//and verification that all the Items are the instances of different classes.
		public int addItemToRoutine (Item i, String routeName);
		
		//Selects the Items with the specified component, adds them to a new set and returns it.
		public Set <Item> getItemsWithComponent (String component);
		
		//Selects the Routines with the specified target, adds them to a new set and returns it.
		public Set <Routine> getRoutinesWithTarget (String target);
		

}
