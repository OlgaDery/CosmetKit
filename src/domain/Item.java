/**
 * 
 */
package domain;

import java.util.Map;

/**
 * @author Olga
 * This is a template for all the cosmetic products
 */
public interface Item 
{
	public String getName();
	
	public String getTarget();
	
	public int getTargetIndex();
	
	public Map <String, Long> getComponents();

}
