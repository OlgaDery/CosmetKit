/**
 * 
 */
package ejb;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.ejb.Local;
import javax.ejb.Singleton;

import domain.Cleanser;
import domain.Exfoliator;
import domain.Item;
import domain.Routine;
import domain.RoutineClass;
import domain.Serum;

@Singleton
@Local(RoutineEJB_IF.class)
/**
 * @author Olga
 * This class is the implementation of the RoutineEJB_IF interface. It contains the inherited methods,
 * 2 locally used private helper methods and two sets - for Routines and Items, 
 * to store these objects during the app lifecycle
 */

public class EJBLocal implements RoutineEJB_IF
{
	//The set to store Routines
	private Set<Routine> routines = new HashSet <Routine> ();
	//The set to store Items
	private Set<Item> items = new HashSet <Item> ();
	

	@Override
	public Set<? extends Routine> getRoutines() {
		// TODO Auto-generated method stub
		return routines;
	}

	@Override
	public Set<? extends Item> getItems() {
		// TODO Auto-generated method stub
		return items;
	}

	//Adds the Serum object to the set of Items. 
	@Override
	public boolean createSerum(Item i) 
	{
		//To check if the Item is Serum, if no, not to add the object to the set.
		if (!i.getClass().equals(Serum.class)) 
		{
			return false;
		} else {
			items.add(i);
			return true;
		}
		
	}

	
	//Adds the Cleanser object to the set of Items. 
	@Override
	public boolean createCleanser(Item i) {
		//To check if the Item is Cleanser, if no, not to add the object to the set.
		if (!i.getClass().equals(Cleanser.class)) 
		{
			System.out.println("&&&&");
			return false;
		} else {
			items.add(i);
			return true;
		}
	}
	
	//Adds the Exfoliator object to the set of Items. 
	@Override
	public boolean createExfoliator(Item i) {
		//To check if the Item is Exfoliator, if no, not to add the object to the set.
		if (!i.getClass().equals(Exfoliator.class)) 
		{
			System.out.println("&&&&");
			return false;
		} else {
			System.out.println("!!!!");
			items.add(i);
			return true;
		}
	}

	//Adds the Routine object to the set of Routines. 
	@Override
	public void createRoutine(String name, String descript) {
		// TODO Auto-generated method stub
		RoutineClass routine = new RoutineClass ();
		routine.setName(name);
		routine.setDescription(descript);
		routines.add(routine);
	}

	//Adds an Item implementation to the selected Routine (it`s name of the Routine and the Item are being provided as a parameter).
	//This method is responsible for checking of the size of the Item list (it must be 3 or less) of the Routine 
	//and verification that all the Items are the instances of different classes - Serum, Exfoliator, Cleanser.
	@Override
	public int addItemToRoutine(Item i, String routeName) {
		// TODO Auto-generated method stub
		List <Item> newItems = new LinkedList<>();
		for (Routine r : routines) {
			if (r.getName().equals(routeName)) 
			{
				System.out.println("size:" + r.getItems().size());
				
				//if the size of the set of Items is 0, no class check is required, any Item may be added
				if (r.getItems().size()==0) 
				{
					newItems.add(i);
					((RoutineClass) r).setItems(newItems); 
					System.out.println("item added");
					return 1;
				
				//if the size of Items is already 3 or more, no Items can be added. 
				} else if (r.getItems().size()>2) {
					System.out.println("no more items allowed");
					return 0;
					
				} else {
					//if the size of Item List of the indicated Routine is 1 or 2, calling the helper method
					//"checkItemsInRoutine", to make sure that there is no instance of the same class in the list.
					if (checkItemsInRoutine(r.getItems(), i)==false) 
						{
						//If there is no objects of the same class in the list, to add the provided Item to the list
							newItems.addAll(r.getItems());
							newItems.add(i);
							((RoutineClass) r).setItems(newItems); 
							System.out.println("item added");
							return 1;
						} else
							System.out.println("you alredy have such product");
							return 2;
					
				}
				
			}
	
		}
		//If the Routine with the provided name has not been found in the set
		return 4;
		
	}

	//Selects the Items with the specified component, adds them to a new set and returns it.
	@Override
	public Set<Item> getItemsWithComponent(String component) 
	{
		// TODO Auto-generated method stub
		Set <Item> foundItems = new HashSet<>();
		items.forEach(i -> {
			if (i.getComponents().containsKey(component)) {
				foundItems.add(i);
			}
		});
		return foundItems;
	}

	//Selects the Routines with the specified target, adds them to a new set and returns it.
	@Override
	public Set<Routine> getRoutinesWithTarget(String target) {
		// TODO Auto-generated method stub
		Set<Routine> temp = new HashSet<>(routines.size());
		routines.forEach(r -> {
			
			//Calls the private helper method to check if any Item in the Routine has the specified target, if so, adds 
			//the Routine to the new set
			if(containsTarget(r, target)== true) {
				temp.add(r);
				System.out.println("added");
			}
		});
		return temp;
	}
	
	//Private helper method to be used by addItemToRoutine method
	private boolean checkItemsInRoutine (List<Item> items, Item item) {
		
		for (Item i : items) {
			if (i.getClass().equals(item.getClass())) {
				return true;
			}
		}
		return false;
		
	}
	
	//Private helper method to be used by getRoutinesWithTarget method. 
	//Checks if any Item in the Routine has the specified target.
	private boolean containsTarget (Routine r, String target) {
		for (Item i : r.getItems()) {
			if (i.getTarget().equals(target)) {
				System.out.println("routine found: "+ r.getName());
				return true;
			}
		}
		return false;
		
	}

	

}
