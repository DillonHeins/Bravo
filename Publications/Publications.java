/**
 * Created by u13133064 Jedd Shneier.
 * Interface for Publications
 * Maps the changePublicationState service contract to the interface
 */
public interface Publications {
   public ChangePublicationStateResponse changePublicationState(ChangePublicationStateRequest request) throws NotAuthorizedException,NoSuchPublicationException,AlreadyPublishedException,PublicationWithTitleExistsForAuthorsException;
   public Publication getPublication(String title);

    class NotAuthorizedException extends Exception {
        public NotAuthorizedException() {
            super("User was not authorized to change publication state");
        }
    }

    class NoSuchPublicationException extends Exception {
        public NoSuchPublicationException() {
            super("Could not find Publication to change");
        }
    }

    class AlreadyPublishedException extends Exception {
        public AlreadyPublishedException() {
            super("Can not change state of publication already published");
        }
    }


    class PublicationWithTitleExistsForAuthorsException extends Exception {
        public PublicationWithTitleExistsForAuthorsException() {
            super("Another publication as the same title and authors");
        }
    }
}
