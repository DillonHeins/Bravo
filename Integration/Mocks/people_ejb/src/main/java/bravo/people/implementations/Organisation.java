/**
 *    @author Bravo Team
 * @version 1.0 This file defines the Organization Class for the Researcher
 * Support System (RSS).
 */
package bravo.people.implementations;

import bravo.people.interfaces.OrganisationInterface;
import javax.persistence.Embeddable;

@Embeddable
public class Organisation implements OrganisationInterface {

    private String organisationName;
    //String ID;

    /**
     * Default Constructor with dummy data
     */
    public Organisation() {
    }

    /**
     * Constructor creates a Organisation object
     *
     * @param organisation_name Name of the organisation
     */
    public Organisation(String organisation_name) {
        organisationName = organisation_name;
    }

    /**
     * Setter
     *
     * @param name Name of the Orgnisation
     */
    public void setName(String name) {
        this.organisationName = name;
    }

    /**
     * Getter
     *
     * @return name of the Organisation
     */
    public String getName() {
        return organisationName;
    }
}
