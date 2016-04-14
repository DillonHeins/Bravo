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
@Table(name = "publicationtypestate")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Publicationtypestate.findAll", query = "SELECT p FROM Publicationtypestate p"),
    @NamedQuery(name = "Publicationtypestate.findById", query = "SELECT p FROM Publicationtypestate p WHERE p.id = :id"),
    @NamedQuery(name = "Publicationtypestate.findByState", query = "SELECT p FROM Publicationtypestate p WHERE p.state = :state"),
    @NamedQuery(name = "Publicationtypestate.findByEffectivedate", query = "SELECT p FROM Publicationtypestate p WHERE p.effectivedate = :effectivedate"),
    @NamedQuery(name = "Publicationtypestate.findByAccredationpoints", query = "SELECT p FROM Publicationtypestate p WHERE p.accredationpoints = :accredationpoints"),
    @NamedQuery(name = "Publicationtypestate.findByDeactivationreason", query = "SELECT p FROM Publicationtypestate p WHERE p.deactivationreason = :deactivationreason")})
public class Publicationtypestate implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "state")
    private String state;
    @Column(name = "effectivedate")
    @Temporal(TemporalType.DATE)
    private Date effectivedate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "accredationpoints")
    private Float accredationpoints;
    @Column(name = "deactivationreason")
    private String deactivationreason;

    public Publicationtypestate() {
    }

    public Publicationtypestate(Integer id) {
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

    public Date getEffectivedate() {
        return effectivedate;
    }

    public void setEffectivedate(Date effectivedate) {
        this.effectivedate = effectivedate;
    }

    public Float getAccredationpoints() {
        return accredationpoints;
    }

    public void setAccredationpoints(Float accredationpoints) {
        this.accredationpoints = accredationpoints;
    }

    public String getDeactivationreason() {
        return deactivationreason;
    }

    public void setDeactivationreason(String deactivationreason) {
        this.deactivationreason = deactivationreason;
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
        if (!(object instanceof Publicationtypestate)) {
            return false;
        }
        Publicationtypestate other = (Publicationtypestate) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Publicationtypestate[ id=" + id + " ]";
    }
    
}
