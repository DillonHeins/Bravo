
package Beans;

import Main.AlreadyPublishedException;
import Main.AuthorizationException;
import Main.EffectiveDateNotAfterEffectiveDateOfLastStateEntry;
import Main.InvalidRequest;
import Main.NoSuchPublicationException;
import Main.NotAuthorized;
import Main.PublicationWithTitleExistsForAuthors;
import RequestsAndResponses.AddPublicationRequest;
import RequestsAndResponses.AddPublicationResponse;
import RequestsAndResponses.AddPublicationTypeRequest;
import RequestsAndResponses.AddPublicationTypeResponse;
import RequestsAndResponses.CalcAccreditationPointsForGroupRequest;
import RequestsAndResponses.CalcAccreditationPointsForGroupResponse;
import RequestsAndResponses.CalcAccreditationPointsForPersonRequest;
import RequestsAndResponses.CalcAccreditationPointsForPersonResponse;
import RequestsAndResponses.ChangePublicationStateRequest;
import RequestsAndResponses.ChangePublicationStateResponse;
import RequestsAndResponses.CreatePublicationRequest;
import RequestsAndResponses.CreatePublicationResponse;
import RequestsAndResponses.GetPublicationRequest;
import RequestsAndResponses.GetPublicationResponse;
import RequestsAndResponses.GetPublicationsForGroupRequest;
import RequestsAndResponses.GetPublicationsForGroupResponse;
import RequestsAndResponses.GetPublicationsForPersonRequest;
import RequestsAndResponses.GetPublicationsForPersonResponse;
import RequestsAndResponses.ModifyPublicationTypeRequest;
import RequestsAndResponses.ModifyPublicationTypeResponse;
import javax.ejb.Stateless;

/**
 *
 * @author Jedd
 */
@Stateless
public class PublicationsBean implements Publications {

    @Override
    public void businessMethod() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AddPublicationResponse addPublication(AddPublicationRequest addPublicationRequest) throws NotAuthorized {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GetPublicationResponse getPublication(GetPublicationRequest getPublicationRequest) throws PublicationWithTitleExistsForAuthors {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CreatePublicationResponse createPublication(CreatePublicationRequest createPublicationRequest) throws InvalidRequest {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AddPublicationTypeResponse addPublicationType(AddPublicationTypeRequest addPublicationTypeRequest) throws AuthorizationException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ModifyPublicationTypeResponse modifyPublicationType(ModifyPublicationTypeRequest modifyPublicationTypeRequest) throws AuthorizationException, EffectiveDateNotAfterEffectiveDateOfLastStateEntry {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GetPublicationsForPersonResponse getPublicationForPerson(GetPublicationsForPersonRequest getPublicationsForPersonRequest) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GetPublicationsForGroupResponse getPublicationForGroup(GetPublicationsForGroupRequest getPublicationsForGroupRequest) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CalcAccreditationPointsForPersonResponse calcAccreditationPointsForPerson(CalcAccreditationPointsForPersonRequest calcAccreditationPointsForPersonRequest) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CalcAccreditationPointsForGroupResponse calcAccreditationPointsForGroup(CalcAccreditationPointsForGroupRequest calcAccreditationPointsForGroupRequest) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ChangePublicationStateResponse changePublicationState(ChangePublicationStateRequest changePublicationStateRequest) throws NotAuthorized, NoSuchPublicationException, AlreadyPublishedException, PublicationWithTitleExistsForAuthors {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  

}
