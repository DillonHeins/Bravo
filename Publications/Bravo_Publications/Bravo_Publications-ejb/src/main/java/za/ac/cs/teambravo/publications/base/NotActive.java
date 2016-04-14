package za.ac.cs.teambravo.publications.base;



public class NotActive extends PublicationTypeState
{

    public String getDeactivationReason() {
        return deactivationReason;
    }

    public void setDeactivationReason(String deactivationReason) {
        this.deactivationReason = deactivationReason;
    }

	private String deactivationReason;

}