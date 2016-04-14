import java.util.Date;

/**
 * @author Jedd Shneier.
 *Mock object for Person interface to be used in testing
 */
public class PersonMock implements Person {

    String firstName;
    String surname;
    String emailAdress;
    String groupName;
    String researchGroupAssociationType;
    Date researchGroupAssociationStartDate;
    Date researchGroupAssociationEndDate;
    String organizationName;
    Date researchCategoryAssociationEffectiveDate;
    String researchCategory;
    Date researchCategoryStateEffectiveDate;
    Double researchCategoryStateResearchOutputTarget;

    public String getResearchGroupAssociationType() {
        return researchGroupAssociationType;
    }

    public void setResearchGroupAssociationType(String researchGroupAssociationType) {
        this.researchGroupAssociationType = researchGroupAssociationType;
    }

    public Date getResearchCategoryStateEffectiveDate() {
        return researchCategoryStateEffectiveDate;
    }

    public void setResearchCategoryStateEffectiveDate(Date researchCategoryStateEffectiveDate) {
        this.researchCategoryStateEffectiveDate = researchCategoryStateEffectiveDate;
    }

    public Double getResearchCategoryStateResearchOutputTarget() {
        return researchCategoryStateResearchOutputTarget;
    }

    public void setResearchCategoryStateResearchOutputTarget(Double researchCategoryStateResearchOutputTarget) {
        this.researchCategoryStateResearchOutputTarget = researchCategoryStateResearchOutputTarget;
    }

    public Date getResearchCategoryAssociationEffectiveDate() {
        return researchCategoryAssociationEffectiveDate;
    }

    public void setResearchCategoryAssociationEffectiveDate(Date researchCategoryAssociationEffectiveDate) {
        this.researchCategoryAssociationEffectiveDate = researchCategoryAssociationEffectiveDate;
    }

    public String getResearchCategory() {
        return researchCategory;
    }

    public void setResearchCategory(String researchCategory) {
        this.researchCategory = researchCategory;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public Date getResearchGroupAssociationEndDate() {
        return researchGroupAssociationEndDate;
    }

    public void setResearchGroupAssociationEndDate(Date researchGroupAssociationEndDate) {
        this.researchGroupAssociationEndDate = researchGroupAssociationEndDate;
    }

    public Date getResearchGroupAssociationStartDate() {
        return researchGroupAssociationStartDate;
    }

    public void setResearchGroupAssociationStartDate(Date researchGroupAssociationStartDate) {
        this.researchGroupAssociationStartDate = researchGroupAssociationStartDate;
    }

    public String getGroupName() {

        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }


    public String getFirstName() {
        return this.firstName;
    }


    public String getSurname() {
        return surname;
    }


    public void setFirstName(String name) {
        firstName=name;
    }


    public void setSurname(String name) {
        this.surname=name;
    }
}
