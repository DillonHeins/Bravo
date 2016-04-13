
package za.ac.cs.teambravo.publications.requestandresponses;

/**
 *
 * @author Hlengekile
 */
public class CalcAccreditationPointsForGroupResponse implements PublicationResponse 
{
    private double sumAccreditationPoints;

    public double getSumAccreditationPoints() 
    {
        return sumAccreditationPoints;
    }

    public void setSumAccreditationPoints(double sumAccreditationPoints) 
    {
        this.sumAccreditationPoints = sumAccreditationPoints;
    }
    
    
}