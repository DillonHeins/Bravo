/**
 * Created by User on 2016/03/18.
 */
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import org.junit.Test;


import java.util.Date;

public class Tester {

    @Test
    public void testNotAuthorizedException() {
        PublicationsMock unauhtorizedRequest =new PublicationsMock();
        try {

            unauhtorizedRequest.changePublicationState(new ChangePublicationStateRequestMock(unauhtorizedRequest, new PersonMock("Tonia"), new PublicationStateMock("Bad coding", new Date(), new Date(),"Published"), new PublicationMock("Late night coding and its detrimental effects"),"Late night coding and its detrimental effects"));
        } catch (Publications.NotAuthorizedException e) {
            e.printStackTrace();
        } catch (Publications.NoSuchPublicationException e) {
            e.printStackTrace();
        } catch (Publications.AlreadyPublishedException e) {
            e.printStackTrace();
        } catch (Publications.PublicationWithTitleExistsForAuthorsException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testAlreadyPublishedException() {

        PublicationsMock alreadyPublsihedRequest =new PublicationsMock();
        try {

            alreadyPublsihedRequest.changePublicationState(new ChangePublicationStateRequestMock(alreadyPublsihedRequest, new PersonMock("Dr Solms"), new PublicationStateMock("Bad coding", new Date(), new Date(),"Published"), new PublicationMock("Late night coding and its detrimental effects"),"Late night coding and its detrimental effects:Let them sleep"));
        } catch (Publications.NotAuthorizedException e) {
            e.printStackTrace();
        } catch (Publications.NoSuchPublicationException e) {
            e.printStackTrace();
        } catch (Publications.AlreadyPublishedException e) {

            e.printStackTrace();
        } catch (Publications.PublicationWithTitleExistsForAuthorsException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testNoSuchPublication() {

        PublicationsMock noSuchRequest =new PublicationsMock();
        try {

            noSuchRequest .changePublicationState(new ChangePublicationStateRequestMock(noSuchRequest, new PersonMock("Dr Solms"), new PublicationStateMock("Bad coding", new Date(), new Date(),"Published"), new PublicationMock("Coding under the sea with Spongebob"), "Coding under the sea with Spongebob"));
        } catch (Publications.NotAuthorizedException e) {
            e.printStackTrace();
        } catch (Publications.NoSuchPublicationException e) {
            e.printStackTrace();
        } catch (Publications.AlreadyPublishedException e) {

            e.printStackTrace();
        } catch (Publications.PublicationWithTitleExistsForAuthorsException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testPublicationWithTitleExistsForAuthorsException() {

        PublicationsMock alreadyNamedRequest =new PublicationsMock();
        try {

            alreadyNamedRequest .changePublicationState(new ChangePublicationStateRequestMock(alreadyNamedRequest, new PersonMock("Dr Solms"), new PublicationStateMock("Bad coding", new Date(), new Date(),"Published"), new PublicationMock("Implentation concerns of leftist D-heaps"), "Wifi in IT building: A cost analysis"));
        } catch (Publications.NotAuthorizedException e) {
            e.printStackTrace();
        } catch (Publications.NoSuchPublicationException e) {
            e.printStackTrace();
        } catch (Publications.AlreadyPublishedException e) {

            e.printStackTrace();
        } catch (Publications.PublicationWithTitleExistsForAuthorsException e) {
            e.printStackTrace();
        }
    }
     @Test
    public void testSuccess() {

        PublicationsMock correctRequest =new PublicationsMock();
        try {

            correctRequest .changePublicationState(new ChangePublicationStateRequestMock(correctRequest, new PersonMock("Dr Solms"), new PublicationStateMock("Needed a better name", new Date(), new Date(),"Published"), new PublicationMock("Implentation concerns of leftist D-heaps"), "Implentation concerns of leftist D-heaps a better version"));
        } catch (Publications.NotAuthorizedException e) {
            e.printStackTrace();
        } catch (Publications.NoSuchPublicationException e) {
            e.printStackTrace();
        } catch (Publications.AlreadyPublishedException e) {

            e.printStackTrace();
        } catch (Publications.PublicationWithTitleExistsForAuthorsException e) {
            e.printStackTrace();
        }
    }







}
