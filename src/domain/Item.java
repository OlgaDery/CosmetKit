/**
 * 
 */
package domain;

import java.util.Map;

/**
 * @author Olga
 * This is a template for all the cosmetic products. Contains getters for all the common fields.
 */
public interface Item 
{
	//Name of the product
	public String getName();
	
	//Target to be treated by the product. In a production environment, all the values would be stored in the DB.
	//Here, they can be found in ComponentsAndTargets class.
	public String getTarget();
	
	//For the convenience, every target has an digital index associated with it 
	//(in out case, it is the same as the index of the element in the array in the ComponentsAndTargets class).
	public int getTargetIndex();
	
	//To get the map, where key is the name of the component, and the value - the percent in the product 
	public Map <String, Long> getComponents() throws NullPointerException;

}
