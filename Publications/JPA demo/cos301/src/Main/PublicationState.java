package Main;



import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author moses
 */
public class PublicationState 
{

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public PublicationDetails getPublicationDetailsObject() {
        return publicationDetailsObject;
    }

    public void setPublicationDetailsObject(PublicationDetails publicationDetailsObject) {
        this.publicationDetailsObject = publicationDetailsObject;
    }

    public LifeCycleState getLifeCycleStateObject() {
        return lifeCycleStateObject;
    }

    public void setLifeCycleStateObject(LifeCycleState lifeCycleStateObject) {
        this.lifeCycleStateObject = lifeCycleStateObject;
    }

    public PublicationType getPublicationTypeObject() {
        return publicationTypeObject;
    }

    public void setPublicationTypeObject(PublicationType publicationTypeObject) {
        this.publicationTypeObject = publicationTypeObject;
    }

    public PublicationTarget getPublicationTargetObject() {
        return publicationTargetObject;
    }

    public void setPublicationTargetObject(PublicationTarget publicationTargetObject) {
        this.publicationTargetObject = publicationTargetObject;
    }
    private Date date;
    private String reason;
    private PublicationDetails publicationDetailsObject;
    private LifeCycleState lifeCycleStateObject;
    private PublicationType publicationTypeObject;
    private PublicationTarget publicationTargetObject;
    
}
