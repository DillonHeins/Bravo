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
@Table(name = "publicationdetails")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Publicationdetails.findAll", query = "SELECT p FROM Publicationdetails p"),
    @NamedQuery(name = "Publicationdetails.findById", query = "SELECT p FROM Publicationdetails p WHERE p.id = :id"),
    @NamedQuery(name = "Publicationdetails.findByTitle", query = "SELECT p FROM Publicationdetails p WHERE p.title = :title"),
    @NamedQuery(name = "Publicationdetails.findByEnvisagedpublicationdate", query = "SELECT p FROM Publicationdetails p WHERE p.envisagedpublicationdate = :envisagedpublicationdate")})
public class Publicationdetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "envisagedpublicationdate")
    @Temporal(TemporalType.DATE)
    private Date envisagedpublicationdate;

    public Publicationdetails() {
    }

    public Publicationdetails(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getEnvisagedpublicationdate() {
        return envisagedpublicationdate;
    }

    public void setEnvisagedpublicationdate(Date envisagedpublicationdate) {
        this.envisagedpublicationdate = envisagedpublicationdate;
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
        if (!(object instanceof Publicationdetails)) {
            return false;
        }
        Publicationdetails other = (Publicationdetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Publicationdetails[ id=" + id + " ]";
    }
    
}
