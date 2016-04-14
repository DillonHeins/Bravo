package bravo.people.implementations;

import bravo.people.interfaces.GroupInterface;
import java.util.*;
import javax.persistence.Embeddable;

/**
 * <h1>Group</h1>
 * The group class to which either a person or subgroups can belong to
 * (Composite pattern).
 *
 * @author Bravo Team
 * @version 1.0
 */
@Embeddable
public class Group implements GroupInterface {

    private String groupName;

    /**
     * Default constructor - Dummy object creation
     */
    public Group() {
    }

    public Group(String groupName) {
        this.groupName = groupName;
    }

    /**
     * Creates a group object which may consist of sub groups or people.
     *
     * @param name Name of the group
     * @param entities Subgroups or people contain in the Group class
     */
    /*public Group(String name, ArrayList<Entity> entities) {
		this.name = name;
//		this.entities = entities;
	}*/
    /**
     * Getter
     *
     * @return Group's name
     */
    public String getName() {
        return this.groupName;
    }

    /**
     * Getter
     *
     * @return Dynamically re-sizable ArrayList used to store subgroups or
     * person objects
     */
    /*public ArrayList<Entity> getEntities() { return entities; }*/
    /**
     * Setter
     *
     * @param name Group's name
     */
    public void setName(String name) {
        this.groupName = name;
    }

    /*public void addEntity(Entity entity)
	{
		this.entities.add(entity);
	}*/
    /**
     * Setter
     *
     * @param entities Dynamically re-sizable ArrayList used to store subgroups
     * or person objects
     */
    /*public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}*/
    /**
     * Checks if the group is active or inactive
     *
     * @return true if active (default), false if inactive.
     */
    public boolean isActive() {
        return true;
    }

    /**
     * Sets the group to active (true)
     */
    public void activate() {

    }

    /**
     * Sets the group to inactive (false)
     */
    public void deactivate() {

    }
}
