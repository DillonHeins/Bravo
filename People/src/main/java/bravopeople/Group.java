package bravopeople;

import java.util.*;

/**
 * <h1>Group</h1>
 * The group class to which either a person or subgroups can belong to (Composite pattern).
 * @author Bravo Team
 * @version 1.0
 */
class Group implements GroupInterface {
	private String name;
	private ArrayList<Entity> entities;		// Composite Pattern

	/**
	 * Default constructor - Dummy object creation
	 */
	public Group() {
		this.name = "MockGroup";
		this.entities = new ArrayList<Entity>();
	}

	/**
	 * Creates a group object which may consist of sub groups or people.
	 * @param name Name of the group 
	 * @param entities Subgroups or people contain in the Group class
	 */
	public Group(String name, ArrayList<Entity> entities) {
		this.name = name;
		this.entities = entities;
	}

	/**
	 * Getter
	 * @return Group's name
	 */
	public String getName() { return name; }

	/**
	 * Getter
	 * @return Dynamically re-sizable ArrayList used to store subgroups or person objects 
	 */
	public ArrayList<Entity> getEntities() { return entities; }

	/**
	 * Setter
	 * @param name Group's name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public void addEntity(Entity entity)
	{
		
	}

	/**
	 * Setter
	 * @param entities Dynamically re-sizable ArrayList used to store subgroups or person objects 
	 */
	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}
}