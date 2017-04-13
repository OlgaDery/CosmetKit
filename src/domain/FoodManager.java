/**
 * 
 */
package domain;

import java.util.Optional;

/**
 * @author Olga
 *
 */
public class FoodManager {
	/**
	 * 
	 */
	private static FoodList foodLst = new FoodList();
	
	static //initialize with some data
	{
		foodLst.add(new Food ("onion", 20, "2 slices"));
		foodLst.add(new Food ("beans", 60, "1 cup"));
		foodLst.add(new Food ("orange", 80, "1 whole"));
	}
	
	public FoodManager() {
		// TODO Auto-generated constructor stub
	}
	
	public static FoodList getFoods () {
		return foodLst;
		
	}
	
	public static Food findFood (String name) {
		final Optional <Food> foundFood = foodLst.stream()
				.filter(food -> food.getName().equalsIgnoreCase(name)).findFirst();
		return foundFood.orElse(null);
	}
	
	public static void add (Food food)
	{
		foodLst.add(food);
	}
	
	public static void delete (String name) 
	{ 
		Food f = findFood(name);
		foodLst.remove(f);
	}

}
