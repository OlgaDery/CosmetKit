/**
 * 
 */
package domain;

import java.util.List;

/**
 * @author Olga
 *
 */
public interface Routine {
	
	public String getName();
	
	public String getDescription();
	
	public List<Item> getItems();

}
