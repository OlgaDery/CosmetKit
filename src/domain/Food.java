/**
 * 
 */
package domain;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Olga
 * Data holder for food information
 */
@XmlRootElement
public class Food 
{
	String name;
	int calories;
	String servSize;
	
	public Food() 
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public Food(String name, int calories, String servSize) 
	{
		super();
		this.name = name;
		this.calories = calories;
		this.servSize = servSize;
	}

	@Override
	public String toString() {
		return "Food [name=" + name + ", calories=" + calories + ", servSize=" + servSize + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public String getServSize() {
		return servSize;
	}

	public void setServSize(String servSize) {
		this.servSize = servSize;
	}
	
	
	
	

}
