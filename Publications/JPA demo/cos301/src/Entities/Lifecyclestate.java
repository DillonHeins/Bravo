/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author moses
 */
@Entity
@Table(name = "lifecyclestate")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lifecyclestate.findAll", query = "SELECT l FROM Lifecyclestate l"),
    @NamedQuery(name = "Lifecyclestate.findById", query = "SELECT l FROM Lifecyclestate l WHERE l.id = :id"),
    @NamedQuery(name = "Lifecyclestate.findByState", query = "SELECT l FROM Lifecyclestate l WHERE l.state = :state"),
    @NamedQuery(name = "Lifecyclestate.findByPercentagecompleted", query = "SELECT l FROM Lifecyclestate l WHERE l.percentagecompleted = :percentagecompleted"),
    @NamedQuery(name = "Lifecyclestate.findByPublicationdate", query = "SELECT l FROM Lifecyclestate l WHERE l.publicationdate = :publicationdate"),
    @NamedQuery(name = "Lifecyclestate.findByBibtexentry", query = "SELECT l FROM Lifecyclestate l WHERE l.bibtexentry = :bibtexentry")})
public class Lifecyclestate implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "state")
    private String state;
    @Column(name = "percentagecompleted")
    private Integer percentagecompleted;
    @Column(name = "publicationdate")
    @Temporal(TemporalType.DATE)
    private Date publicationdate;
    @Column(name = "bibtexentry")
    private String bibtexentry;

    public Lifecyclestate() {
    }

    public Lifecyclestate(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getPercentagecompleted() {
        return percentagecompleted;
    }

    public void setPercentagecompleted(Integer percentagecompleted) {
        this.percentagecompleted = percentagecompleted;
    }

    public Date getPublicationdate() {
        return publicationdate;
    }

    public void setPublicationdate(Date publicationdate) {
        this.publicationdate = publicationdate;
    }

    public String getBibtexentry() {
        return bibtexentry;
    }

    public void setBibtexentry(String bibtexentry) {
        this.bibtexentry = bibtexentry;
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
        if (!(object instanceof Lifecyclestate)) {
            return false;
        }
        Lifecyclestate other = (Lifecyclestate) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Lifecyclestate[ id=" + id + " ]";
    }
    
}
