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

    private String name;
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
        name = organisation_name;
    }

    /**
     * Setter
     *
     * @param name Name of the Orgnisation
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter
     *
     * @return name of the Organisation
     */
    public String getName() {
        return name;
    }
}
