/**
 * 
 */
package domain;

import java.util.List;

/**
 * @author Olga
 * This is a template for the Routine concrete class, representing 
 * the regular set of cosmetic products being assigned by aestetist to clients. 
 * It contains methods to get name and descriprion (Strings) and a List of products.
 *  
 */

public interface Routine {
	
	public String getName();
	
	public String getDescription();
	
	//Here we are getting the list of objects implementing the Item interface, which represent 
	//different products should be included to the cosmetic routine.
	public List<Item> getItems();

}
