/**
 * 
 */
package domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Olga
 *
 */
public class Exfoliator extends Cleanser {
	
	private String name;
	private String target;
	private Integer frequencyPerWeek;
	private Map<String, Long> components;
	
	

	public Exfoliator(String name, String target) {
		super();
		this.name = name;
		this.target = target;
		this.frequencyPerWeek = 3;
		
	}
	
	//empty constructor may be necessary 
	
	public Exfoliator () {
		
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
	public Map<String, Long> getComponents() {
		// TODO This method is to prevent the nullpointerexception 
		//throwing if the components have not been set yet
		try {
			components.size();
			return components;
		} catch (Exception e) {
			return new HashMap <String, Long>();
		}
	}
	
	@Override
	public int getTargetIndex() 
	{
		// TODO Auto-generated method stub
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
	
	public Integer getDaysPerWeek() {
		return frequencyPerWeek;
	}

	public void setDaysPerWeek(Integer daysPerWeek) {
		this.frequencyPerWeek = daysPerWeek;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((components == null) ? 0 : components.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((target == null) ? 0 : target.hashCode());
		return result;
	}

	@Override
	//to compare the serums we need only to compare the names and the classes
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exfoliator other = (Exfoliator) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


}
