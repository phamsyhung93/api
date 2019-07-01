/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tbl_subject")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblSubject.findAll", query = "SELECT t FROM TblSubject t"),
    @NamedQuery(name = "TblSubject.findById", query = "SELECT t FROM TblSubject t WHERE t.id = :id"),
    @NamedQuery(name = "TblSubject.findByName", query = "SELECT t FROM TblSubject t WHERE t.name = :name"),
    @NamedQuery(name = "TblSubject.findByDescription", query = "SELECT t FROM TblSubject t WHERE t.description = :description"),
    @NamedQuery(name = "TblSubject.findByDeleted", query = "SELECT t FROM TblSubject t WHERE t.deleted = :deleted"),
    @NamedQuery(name = "TblSubject.findByCreateAt", query = "SELECT t FROM TblSubject t WHERE t.createAt = :createAt"),
    @NamedQuery(name = "TblSubject.findByUpdateAt", query = "SELECT t FROM TblSubject t WHERE t.updateAt = :updateAt"),
    @NamedQuery(name = "TblSubject.findByCreateBy", query = "SELECT t FROM TblSubject t WHERE t.createBy = :createBy"),
    @NamedQuery(name = "TblSubject.findByUpdateBy", query = "SELECT t FROM TblSubject t WHERE t.updateBy = :updateBy")})
public class TblSubject implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 1073741823)
    @Column(name = "name")
    private String name;
    @Size(max = 1073741823)
    @Column(name = "description")
    private String description;
    @Column(name = "deleted")
    private Boolean deleted;
    @Size(max = 12)
    @Column(name = "create_at")
    private String createAt;
    @Size(max = 12)
    @Column(name = "update_at")
    private String updateAt;
    @Column(name = "create_by")
    private Integer createBy;
    @Column(name = "update_by")
    private Integer updateBy;
    @OneToMany(mappedBy = "subjectId")
    private Collection<TblLesson> tblLessonCollection;
    @JoinColumn(name = "courseId", referencedColumnName = "id")
    @ManyToOne
    private TblCourse courseId;

    public TblSubject() {
    }

    public TblSubject(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    @XmlTransient
    public Collection<TblLesson> getTblLessonCollection() {
        return tblLessonCollection;
    }

    public void setTblLessonCollection(Collection<TblLesson> tblLessonCollection) {
        this.tblLessonCollection = tblLessonCollection;
    }

    public TblCourse getCourseId() {
        return courseId;
    }

    public void setCourseId(TblCourse courseId) {
        this.courseId = courseId;
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
        if (!(object instanceof TblSubject)) {
            return false;
        }
        TblSubject other = (TblSubject) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblSubject[ id=" + id + " ]";
    }
    
}
