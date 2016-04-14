/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author moses
 */
@Entity
@Table(name = "publicationdetailstoperson")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Publicationdetailstoperson.findAll", query = "SELECT p FROM Publicationdetailstoperson p"),
    @NamedQuery(name = "Publicationdetailstoperson.findById", query = "SELECT p FROM Publicationdetailstoperson p WHERE p.id = :id"),
    @NamedQuery(name = "Publicationdetailstoperson.findByPublicationdetails", query = "SELECT p FROM Publicationdetailstoperson p WHERE p.publicationdetails = :publicationdetails"),
    @NamedQuery(name = "Publicationdetailstoperson.findByPerson", query = "SELECT p FROM Publicationdetailstoperson p WHERE p.person = :person")})
public class Publicationdetailstoperson implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "publicationdetails")
    private Integer publicationdetails;
    @Column(name = "person")
    private Integer person;

    public Publicationdetailstoperson() {
    }

    public Publicationdetailstoperson(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPublicationdetails() {
        return publicationdetails;
    }

    public void setPublicationdetails(Integer publicationdetails) {
        this.publicationdetails = publicationdetails;
    }

    public Integer getPerson() {
        return person;
    }

    public void setPerson(Integer person) {
        this.person = person;
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
        if (!(object instanceof Publicationdetailstoperson)) {
            return false;
        }
        Publicationdetailstoperson other = (Publicationdetailstoperson) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Publicationdetailstoperson[ id=" + id + " ]";
    }
    
}
