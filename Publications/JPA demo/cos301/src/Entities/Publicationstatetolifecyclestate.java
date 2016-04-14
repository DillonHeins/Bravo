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
@Table(name = "publicationstatetolifecyclestate")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Publicationstatetolifecyclestate.findAll", query = "SELECT p FROM Publicationstatetolifecyclestate p"),
    @NamedQuery(name = "Publicationstatetolifecyclestate.findById", query = "SELECT p FROM Publicationstatetolifecyclestate p WHERE p.id = :id"),
    @NamedQuery(name = "Publicationstatetolifecyclestate.findByPublicationstate", query = "SELECT p FROM Publicationstatetolifecyclestate p WHERE p.publicationstate = :publicationstate"),
    @NamedQuery(name = "Publicationstatetolifecyclestate.findByLifecyclestate", query = "SELECT p FROM Publicationstatetolifecyclestate p WHERE p.lifecyclestate = :lifecyclestate")})
public class Publicationstatetolifecyclestate implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "publicationstate")
    private Integer publicationstate;
    @Column(name = "lifecyclestate")
    private Integer lifecyclestate;

    public Publicationstatetolifecyclestate() {
    }

    public Publicationstatetolifecyclestate(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPublicationstate() {
        return publicationstate;
    }

    public void setPublicationstate(Integer publicationstate) {
        this.publicationstate = publicationstate;
    }

    public Integer getLifecyclestate() {
        return lifecyclestate;
    }

    public void setLifecyclestate(Integer lifecyclestate) {
        this.lifecyclestate = lifecyclestate;
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
        if (!(object instanceof Publicationstatetolifecyclestate)) {
            return false;
        }
        Publicationstatetolifecyclestate other = (Publicationstatetolifecyclestate) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Publicationstatetolifecyclestate[ id=" + id + " ]";
    }
    
}
