/**
 * 
 */
package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Olga
 *
 */
public class RoutineClass implements Routine 
{
	private String name;
	private String description;
	private List <Item> items;
	
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
		// TODO Auto-generated method stub
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
