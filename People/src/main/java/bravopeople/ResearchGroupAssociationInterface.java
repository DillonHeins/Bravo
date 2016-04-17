package bravopeople;

import java.util.Date;

/**
 * <h1>Association interface with a research group</h1>
 * Object representing the relationship of a person class with a specific research
 * project.
 * @author Bravo Team
 * @version 1.0
 */
public interface ResearchGroupAssociationInterface
{
    /**
     * Sets the starting date for the Research Group Association.
     * @param startDate The date to be set.
     */
    public void setStartDate(Date startDate);

    /**
     * Gets the starting date for the Research Group Association.
     * @return The starting date.
     */
    public Date getStartDate();

    /**
     * Sets the ending date for the Research Group Association.
     * @param endDate The date to be set.
     */
    public void setEndDate(Date endDate);

    /**
     * Gets the ending date for the Research Group Association.
     * @return The ending date.
     */
    public Date getEndDate();

    /**
     * Sets the role the person plays in the group.
     * @param role The role to be played:
     *              - STUDENT (default)
     *              - COLLABORATOR
     *              - MEMBER
     *              - GROUPLEADER
     */
    public void setRole(String role);

    /**
     * Gets the role the person plays in the group.
     * @return The person's role.
     */
    public String getRole();

    /**
     * Sets which group the person is associated with.
     * @param group The group to be set.
     */
    public void setGroup(Group group);

    /**
     * Gets the group the person is associated with.
     * @return The associated group.
     */
    public Group getGroup();


}
