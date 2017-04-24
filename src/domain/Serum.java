/**
 * 
 */
package domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Olga
 * Class Serum implements Item interface. It contains the inherited methods 
 * and one specific for the class.
 */
public class Serum implements Item {
	
	private String name;
	private String target;
	private Map<String, Long> components;
	private boolean beforeSleep;
	
	
//this constructor initialize the necessary fields
	public Serum(String name, String target) {
		super();
		this.name = name;
		this.target = target;
		this.beforeSleep = false;
	}
	
	//the empty constructor may be important for some JavaEE functionality as Java Beans
	public Serum () {
		
	}

	/* (non-Javadoc)
	 * @see domain.Item#getName()
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	/* (non-Javadoc)
	 * @see domain.Item#getTarget()
	 */
	@Override
	public String getTarget() {
		// TODO Auto-generated method stub
		return target;
	}
	
	/* (non-Javadoc)
	 * @see domain.Item#getComponents()
	 */
	@Override
	public Map<String, Long> getComponents() 
	{
		// TODO Auto-generated method stub
		try {
			//this is for testing if the map is NULL and NullPointerException is thrown 
			components.size();
			return components;
		} catch (Exception e) {
			//to prevent NullPointerException in any client class manipulating with the object
			return new HashMap <String, Long>();
		}
	}
	
	/* (non-Javadoc)
	 * @see domain.Item#getTargetIndex()
	 */
	@Override
	public int getTargetIndex() 
	{
		// to get the index associated to the target
		int Index = Arrays.asList(ComponentsAndTargets.targets).indexOf(this.target);
		return Index;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public void setComponents(Map<String, Long> components) {
		this.components = components;
	}
	
	public boolean isBeforeSleep() {
		return beforeSleep;
	}

	public void setBeforeSleep(boolean beforeSleep) {
		this.beforeSleep = beforeSleep;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (beforeSleep ? 1231 : 1237);
		result = prime * result + ((components == null) ? 0 : components.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((target == null) ? 0 : target.hashCode());
		return result;
	}

	@Override
	//overriding the Equals method to compare only the classes of objects and names
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Serum other = (Serum) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


}
