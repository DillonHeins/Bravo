package bravopeople;

import java.util.ArrayList;

/**
 * Created by matthew on 2016/03/26.
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
    public void setEntities(ArrayList<Entity> entities);

    /**
     * Adds an entity relationship to the group.
     * @param entity The entity to be added.
     */
    public void addEntity(Entity entity);

    /**
     * Gets the entities related to the group.
     * @return An ArrayList of all the entities.
     */
    public ArrayList<Entity> getEntities();
}
