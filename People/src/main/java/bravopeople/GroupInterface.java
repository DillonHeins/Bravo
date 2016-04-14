package bravo.people.interfaces;

import java.util.ArrayList;

/**
 * <h1>Group Interface</h1>
 * Interface for the Group Class.
 * @author Bravo Team
 * @version 1.0
 */
public interface GroupInterface
{
    /**
     * Sets the name of the group.
     * @param name The name to be set.
     */
    public void setName(String name);

    /**
     * Gets the name of the group.
     * @return The name of the group.
     */
    public String getName();

    /**
     * Sets the entities related to the group.
     * @param entities An ArrayList of all the entities.
     */
//    public void setEntities(ArrayList<Entity> entities);

    /**
     * Adds an entity relationship to the group.
     * @param entity The entity to be added.
     */
//    public void addEntity(Entity entity);

    /**
     * Gets the entities related to the group.
     * @return An ArrayList of all the entities.
     */
//    public ArrayList<Entity> getEntities();

    /**
     * Checks if the group is active or inactive
     * @return true if active (default), false if inactive.
     */
    public boolean isActive();

    /**
     * Sets the group to active (true)
     */
    public void activate();

    /**
     * Sets the group to inactive (false)
     */
    public void deactivate();
}
