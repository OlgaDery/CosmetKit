/**
 * 
 */
package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Olga
 *This class implements Routine interface. It contains the inherited methods, fields, returning by
 *these methods, and setters for the fields.
 */
public class RoutineClass implements Routine 
{
	private String name;
	private String description;
	
	//This list must contain only 3 Items, which are instances of 3 classes (Serum, Cleanser and Exfoliator),
	//implementing Item interface. The size and the content of a list is being controlled by the methods
	//within the client classes responsible for business logic, like EJBs.
	
	private List <Item> items;

	//empty constructor
	public RoutineClass () {
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return description;
	}

	@Override
	public List<Item> getItems() 
	{
		// Calling components.size() to test if the map is null. If so, the new list is being
		//instantiated in the CATCH block. It will prevent the nullpointerexception 
		//throwing within any client class using the instance of this class.
		try {
			items.size();
			return items;
		} catch (Exception e) {
			return new ArrayList <Item>(3);
		}
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

}
