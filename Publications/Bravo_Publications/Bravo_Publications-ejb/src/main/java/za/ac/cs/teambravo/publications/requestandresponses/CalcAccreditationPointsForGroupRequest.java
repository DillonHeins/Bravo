/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cs.teambravo.publications.requestandresponses;

import za.ac.cs.teambravo.publications.base.Period;
import za.ac.cs.teambravo.publications.base.PublicationConfidenceLevel;

/**
 *
 * @author Hlengekile
 */
public class CalcAccreditationPointsForGroupRequest implements PublicationRequest
{
    private String groupName;
    
    private Period timePeriod;
    
    private PublicationConfidenceLevel pubConfidence;

    public CalcAccreditationPointsForGroupRequest() 
    {
    }

    public CalcAccreditationPointsForGroupRequest(String groupName, PublicationConfidenceLevel pubConfidence) 
    {
        this.groupName = groupName;
        this.pubConfidence = pubConfidence;
    }
    
    public CalcAccreditationPointsForGroupRequest(String groupName, Period timePeriod, PublicationConfidenceLevel pubConfidence)
    {
        this.groupName = groupName;
        this.timePeriod = timePeriod;
        this.pubConfidence = pubConfidence;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Period getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(Period timePeriod) {
        this.timePeriod = timePeriod;
    }

    public PublicationConfidenceLevel getPubConfidence() {
        return pubConfidence;
    }

    public void setPubConfidence(PublicationConfidenceLevel pubConfidence) {
        this.pubConfidence = pubConfidence;
    }
    
}
