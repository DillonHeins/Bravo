/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cs.teambravo.publications.requestandresponses;

import za.ac.cs.teambravo.publications.base.Period;
import za.ac.cs.teambravo.publications.base.Person;
import za.ac.cs.teambravo.publications.base.PublicationConfidenceLevel;

/**
 *
 * @author Hlengekile
 */
public class CalcAccreditationPointsForPersonRequest implements PublicationRequest
{
    private Person forWho;
    
    private Period timePeriod;
    
    private PublicationConfidenceLevel pubConfidence;

    public CalcAccreditationPointsForPersonRequest() 
    {
    }

    public CalcAccreditationPointsForPersonRequest(Person forWho, PublicationConfidenceLevel pubConfidence) 
    {
        this.forWho = forWho;
        this.pubConfidence = pubConfidence;
    }
    
    public CalcAccreditationPointsForPersonRequest(Person forWho, Period timePeriod, PublicationConfidenceLevel pubConfidence)
    {
        this.forWho = forWho;
        this.timePeriod = timePeriod;
        this.pubConfidence = pubConfidence;
    }

    public Person getForWho() {
        return forWho;
    }

    public void setForWho(Person forWho) {
        this.forWho = forWho;
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