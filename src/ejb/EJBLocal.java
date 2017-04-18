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
 *
 */
public class EJBLocal implements RoutineEJB_IF
{
	private Set<Routine> routines = new HashSet <Routine> ();
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

	@Override
	public boolean createSerum(Item i) 
	{
		// TODO Auto-generated method stub
		if (!i.getClass().equals(Serum.class)) 
		{
			return false;
		} else {
			items.add(i);
			return true;
		}
		
	}

	@Override
	public boolean createCleanser(Item i) {
		// TODO Auto-generated method stub
		if (!i.getClass().equals(Cleanser.class)) 
		{
			System.out.println("&&&&");
			return false;
		} else {
			items.add(i);
			return true;
		}
	}
	
	@Override
	public boolean createExfoliator(Item i) {
		// TODO Auto-generated method stub
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

	@Override
	public void createRoutine(String name, String descript) {
		// TODO Auto-generated method stub
		RoutineClass routine = new RoutineClass ();
		routine.setName(name);
		routine.setDescription(descript);
		routines.add(routine);
	}

	@Override
	public int addItemToRoutine(Item i, String routeName) {
		// TODO Auto-generated method stub
		List <Item> newItems = new LinkedList<>();
		for (Routine r : routines) {
			if (r.getName().equals(routeName)) 
			{
				System.out.println("size:" + r.getItems().size());
				
				if (r.getItems().size()==0) 
				{
					newItems.add(i);
					((RoutineClass) r).setItems(newItems); 
					System.out.println("item added");
					return 1;
					
				} else if (r.getItems().size()>2) {
					System.out.println("no more items allowed");
					return 0;
					
				} else {
					
					if (checkItemsInRoutine(r.getItems(), i)==false) 
						{
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
		return 4;
		
	}

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

	@Override
	public Set<Routine> getRoutinesWithTarget(String target) {
		// TODO Auto-generated method stub
		Set<Routine> temp = new HashSet<>(routines.size());
		routines.forEach(r -> {
			if(containsTarget(r, target)== true) {
				temp.add(r);
				System.out.println("added");
			}
		});
		return temp;
	}
	
	//private helper method to be used by addItemToRoutine method
	private boolean checkItemsInRoutine (List<Item> items, Item item) {
		
		for (Item i : items) {
			if (i.getClass().equals(item.getClass())) {
				return true;
			}
		}
		return false;
		
	}
	
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
