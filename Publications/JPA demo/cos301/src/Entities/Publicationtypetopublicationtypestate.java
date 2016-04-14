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
@Table(name = "publicationtypetopublicationtypestate")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Publicationtypetopublicationtypestate.findAll", query = "SELECT p FROM Publicationtypetopublicationtypestate p"),
    @NamedQuery(name = "Publicationtypetopublicationtypestate.findById", query = "SELECT p FROM Publicationtypetopublicationtypestate p WHERE p.id = :id"),
    @NamedQuery(name = "Publicationtypetopublicationtypestate.findByPublicationtype", query = "SELECT p FROM Publicationtypetopublicationtypestate p WHERE p.publicationtype = :publicationtype"),
    @NamedQuery(name = "Publicationtypetopublicationtypestate.findByPublicationtypestate", query = "SELECT p FROM Publicationtypetopublicationtypestate p WHERE p.publicationtypestate = :publicationtypestate")})
public class Publicationtypetopublicationtypestate implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "publicationtype")
    private Integer publicationtype;
    @Column(name = "publicationtypestate")
    private Integer publicationtypestate;

    public Publicationtypetopublicationtypestate() {
    }

    public Publicationtypetopublicationtypestate(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPublicationtype() {
        return publicationtype;
    }

    public void setPublicationtype(Integer publicationtype) {
        this.publicationtype = publicationtype;
    }

    public Integer getPublicationtypestate() {
        return publicationtypestate;
    }

    public void setPublicationtypestate(Integer publicationtypestate) {
        this.publicationtypestate = publicationtypestate;
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
        if (!(object instanceof Publicationtypetopublicationtypestate)) {
            return false;
        }
        Publicationtypetopublicationtypestate other = (Publicationtypetopublicationtypestate) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Publicationtypetopublicationtypestate[ id=" + id + " ]";
    }
    
}
