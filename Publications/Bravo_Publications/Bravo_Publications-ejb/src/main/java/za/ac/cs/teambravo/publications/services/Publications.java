/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cs.teambravo.publications.services;

import javax.ejb.Remote;
import za.ac.cs.teambravo.publications.entities.PublicationStateEntity;
import za.ac.cs.teambravo.publications.entities.PublicationTypeEntity;
import za.ac.cs.teambravo.publications.exceptions.AlreadyPublishedException;
import za.ac.cs.teambravo.publications.exceptions.AuthorizationException;
import za.ac.cs.teambravo.publications.exceptions.EffectiveDateNotAfterEffectiveDateOfLastStateEntry;
import za.ac.cs.teambravo.publications.exceptions.InvalidRequest;
import za.ac.cs.teambravo.publications.exceptions.NoSuchPublicationException;
import za.ac.cs.teambravo.publications.exceptions.NotAuthorized;
import za.ac.cs.teambravo.publications.exceptions.PublicationWithTitleExistsForAuthors;
import za.ac.cs.teambravo.publications.requestandresponses.AddPublicationRequest;
import za.ac.cs.teambravo.publications.requestandresponses.AddPublicationResponse;
import za.ac.cs.teambravo.publications.requestandresponses.AddPublicationTypeRequest;
import za.ac.cs.teambravo.publications.requestandresponses.AddPublicationTypeResponse;
import za.ac.cs.teambravo.publications.requestandresponses.CalcAccreditationPointsForGroupRequest;
import za.ac.cs.teambravo.publications.requestandresponses.CalcAccreditationPointsForGroupResponse;
import za.ac.cs.teambravo.publications.requestandresponses.CalcAccreditationPointsForPersonRequest;
import za.ac.cs.teambravo.publications.requestandresponses.CalcAccreditationPointsForPersonResponse;
import za.ac.cs.teambravo.publications.requestandresponses.ChangePublicationStateRequest;
import za.ac.cs.teambravo.publications.requestandresponses.ChangePublicationStateResponse;
import za.ac.cs.teambravo.publications.requestandresponses.CreatePublicationRequest;
import za.ac.cs.teambravo.publications.requestandresponses.CreatePublicationResponse;
import za.ac.cs.teambravo.publications.requestandresponses.GetPublicationRequest;
import za.ac.cs.teambravo.publications.requestandresponses.GetPublicationResponse;
import za.ac.cs.teambravo.publications.requestandresponses.GetPublicationsForGroupRequest;
import za.ac.cs.teambravo.publications.requestandresponses.GetPublicationsForGroupResponse;
import za.ac.cs.teambravo.publications.requestandresponses.GetPublicationsForPersonRequest;
import za.ac.cs.teambravo.publications.requestandresponses.GetPublicationsForPersonResponse;
import za.ac.cs.teambravo.publications.requestandresponses.ModifyPublicationTypeRequest;
import za.ac.cs.teambravo.publications.requestandresponses.ModifyPublicationTypeResponse;


/**
 *
 * @author Jedd
 */
@Remote
public interface Publications {

    public AddPublicationResponse addPublication(AddPublicationRequest addPublicationRequest) throws NotAuthorized;

    /**
     * Accepts a GetPublicationRequest object to retrieve an existing publication, precondition check for addPublication to check whether a publication with that title
     already exists for the specified authors
     * @param GetPublicationRequest a request object passed to retrieve publication
     * @return GetPublicationResponse a response object that returns the publication requested
     * @see    Publication
     * @exception PublicationWithTitleExistsForAuthors trying to retrieve a publication with that same name and authors
     */
    public GetPublicationResponse getPublication(GetPublicationRequest getPublicationRequest) throws PublicationWithTitleExistsForAuthors;

    /**
     * Accepts a CreatePublicationRequest object to create a publication, post condition for addPublication
     * @param CreatePublicationRequest a request object passed to construct Publication
     * @return CreatePublicationResponse a response object that confirms Publication created
     * @see    Publication
     * @exception InvalidRequest request was improperly structured or invalid
     */
    public CreatePublicationResponse createPublication(CreatePublicationRequest createPublicationRequest) throws InvalidRequest;

    /**
     * Accepts a AddPublicationTypeRequest object to allow administrators to be able to add new publication types
     * @param AddPublicationTypeRequest a request object passed to add a new PublicationTypeEntity option
     * @return AddPublicationTypeResponse a response object that confirms PublicationTypeEntity ahs been added
     * @see    PublicationTypeEntity
     * @exception PublicationTypeExists the publication type is already an option
     * @exception  AuthorizationException user is not an administrator
     */
    public AddPublicationTypeResponse addPublicationType(AddPublicationTypeRequest addPublicationTypeRequest)throws AuthorizationException;

    /**
     * Accepts a ModifyPublicationTypeRequest object to allow the state of publication types to change at anytime
     * @param ModifyPublicationTypeRequest a request object passed to change a PublicationTypeEntity
     * @return ModifyPublicationTypeRequest a response object that confirms a PublicationTypeEntity has been changed
     * @see    PublicationTypeEntity
     * @exception EffectiveDateNotAfterEffectiveDateOfLastStateEntry the new effective Date is before previous effective date
     * @exception  AuthorizationException user is not an administrator
     */
    public ModifyPublicationTypeResponse modifyPublicationType(ModifyPublicationTypeRequest modifyPublicationTypeRequest)throws AuthorizationException,EffectiveDateNotAfterEffectiveDateOfLastStateEntry;

    /**
     * Accepts a GetPublicationsForPersonRequest object to return all publications for an author which either have been published, accepted or are
     envisaged to be published for a user within a specified time period
     * @param GetPublicationsForPersonRequest a request object passed to get all publications for an author
     * @return GetPublicationsForPersonRequest a response object that contains all publications from that author
     * @see    Publication
     */
    public GetPublicationsForPersonResponse getPublicationsForPerson( GetPublicationsForPersonRequest getPublicationsForPersonRequest);

    /**
     * Accepts a GetPublicationsForGroupRequest object. This service is similar to the getPublicationsForPerson service except that it returns all published,
     accepted or envisaged publications for a period for a group
     * @param GetPublicationsForGroupRequest a request object passed to get all publications for a group
     * @return GetPublicationsForGroupRequest a response object that contains all publications from that group
     * @see    Publication
     */
    public GetPublicationsForGroupResponse getPublicationsForGroup( GetPublicationsForGroupRequest getPublicationsForGroupRequest);

    /**
     * This service finds all publications published, accepted or envisaged to be published for a period by
     a person and sums up the accreditation points earned. The contribution from each individual paper
     is the accreditation points for the respective publication type divided by the number of authors on
     that paper.
     * @param CalcAccreditationPointsForPersonRequest a request object passed to get get all papers published for author
     * @return CalcAccreditationPointsForPersonResponse a response object that contains the total accredited score for author
     * @see    PublicationTypeEntity
     */
    public CalcAccreditationPointsForPersonResponse calcAccreditationPointsForPerson(CalcAccreditationPointsForPersonRequest calcAccreditationPointsForPersonRequest);

    /**
     * This service is similar to the calcAccreditationPointsForPerson service except that it accumulates
     the accreditation points for all persons who are part of that group.
     * @param CalcAccreditationPointsForGroupRequest a request object passed to get get all papers published for group
     * @return CalcAccreditationPointsForGroupResponse a response object that contains the total accredited score for group
     * @see    PublicationTypeEntity
     */
    public CalcAccreditationPointsForGroupResponse calcAccreditationPointsForGroup(CalcAccreditationPointsForGroupRequest calcAccreditationPointsForGroupRequest);


    /**
     * A publication has a sequence of state entries representing the state trace for that publication.
     Effectively it is an implementation of the memento pattern with each state entry being a memento
     capturing a snapshot of the state of the publication
     * @param ChangePublicationStateRequest a request object passed to change state of publication
     * @return ChangePublicationStateResponse a response object that confirms that new PublicationStateEntity has been added to publication
     * @see    PublicationStateEntity
     * @see    Publication
     * @exception NotAuthorized not an author of the publication
     * @exception NoSuchPublicationException specified publication could not be found
     * @exception AlreadyPublishedException the publication has already been published and thus cannot change state
     * @exception PublicationWithTitleExistsForAuthors I THINK THIS IS A MISTAKE
     */
    public ChangePublicationStateResponse changePublicationState(ChangePublicationStateRequest changePublicationStateRequest) throws NotAuthorized,NoSuchPublicationException,AlreadyPublishedException,PublicationWithTitleExistsForAuthors;


    
}
