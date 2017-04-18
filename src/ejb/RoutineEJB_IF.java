/**
 * 
 */
package ejb;

import java.util.Set;

import domain.Item;
import domain.Routine;

/**
 * @author Olga
 *
 */
public interface RoutineEJB_IF 
{
		
		//stores all the approved pois during the app lifecycle
		public Set <?extends Routine> getRoutines();
		
		public Set <?extends Item> getItems();
		
		public boolean createSerum (Item i);
		
		public boolean createCleanser (Item i);
		
		public boolean createExfoliator (Item i);
		
		public void createRoutine (String name, String descript);
		
		public int addItemToRoutine (Item i, String routeName);
		
		public Set <Item> getItemsWithComponent (String component);
		
		public Set <Routine> getRoutinesWithTarget (String target);
		

}
