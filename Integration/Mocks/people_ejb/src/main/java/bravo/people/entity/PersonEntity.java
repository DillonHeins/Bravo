package bravo.people.entity;

import bravo.people.implementations.Group;
import bravo.people.implementations.Organisation;
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
              query="SELECT p.id FROM PersonEntity p WHERE p.person.firstName = 'Thomas'")
})
public class PersonEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Embedded
    Person person;
    
    @Embedded
    Group group;
    
    @Embedded
    Organisation organisation;
    
    public PersonEntity() {
        
    }
    
    public PersonEntity(Person person, Group group) {
        this.person = person;
        this.group = group;
    }
    
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    
     public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

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
