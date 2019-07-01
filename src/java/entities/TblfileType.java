/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author hung
 */
@Entity
@Table(name = "tbl_fileType")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblfileType.findAll", query = "SELECT t FROM TblfileType t"),
    @NamedQuery(name = "TblfileType.findById", query = "SELECT t FROM TblfileType t WHERE t.id = :id"),
    @NamedQuery(name = "TblfileType.findByTypeName", query = "SELECT t FROM TblfileType t WHERE t.typeName = :typeName")})
public class TblfileType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "typeName")
    private String typeName;
    @JsonIgnore
    @OneToMany(mappedBy = "type" ,fetch = FetchType.EAGER)
    private Collection<TblCourseware> tblCoursewareCollection;

    public TblfileType() {
    }

    public TblfileType(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @XmlTransient
    public Collection<TblCourseware> getTblCoursewareCollection() {
        return tblCoursewareCollection;
    }

    public void setTblCoursewareCollection(Collection<TblCourseware> tblCoursewareCollection) {
        this.tblCoursewareCollection = tblCoursewareCollection;
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
        if (!(object instanceof TblfileType)) {
            return false;
        }
        TblfileType other = (TblfileType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblfileType[ id=" + id + " ]";
    }
    
}
