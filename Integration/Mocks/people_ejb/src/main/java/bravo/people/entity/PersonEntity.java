package bravo.people.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import bravo.people.implementations.Person;
import javax.persistence.Embedded;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.OneToOne;

/**
 *
 * @author Dillon
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "getPerson",
        query = "SELECT p.person FROM PersonEntity p WHERE p.person.staffNumber = '14035538'"),
    @NamedQuery(name="getID",
              query="SELECT p.id FROM PersonEntity p WHERE p.person.firstName = 'Hank'")
})
public class PersonEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Embedded
    Person person;
    
//    private String firstName;
//    private String surname;
//    private String staffNumber;

    public PersonEntity() {
        
    }
    
    public PersonEntity(Person person) {
        this.person = person;
//        this.firstName = firstName;
//        this.surname = surname;
//        this.staffNumber = staffNumber;
    }
    
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getSurname() {
//        return surname;
//    }
//
//    public void setSurname(String surname) {
//        this.surname = surname;
//    }
//
//    public String getStaffNumber() {
//        return staffNumber;
//    }
//
//    public void setStaffNumber(String staffNumber) {
//        this.staffNumber = staffNumber;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonEntity)) {
            return false;
        }
        PersonEntity other = (PersonEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bravo.people.entity.PersonEntity[ id=" + id + " ]";
    }
    
}
