
package za.ac.cs.teambravo.publications.requestandresponses;

/**
 
 * @author Hlengekile
 */
public class CalcAccreditationPointsForPersonResponse implements PublicationResponse 
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
