/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hung
 */
@Entity
@Table(name = "tbl_courseware")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblCourseware.findAll", query = "SELECT t FROM TblCourseware t"),
    @NamedQuery(name = "TblCourseware.findById", query = "SELECT t FROM TblCourseware t WHERE t.id = :id"),
    @NamedQuery(name = "TblCourseware.findByName", query = "SELECT t FROM TblCourseware t WHERE t.name = :name"),
    @NamedQuery(name = "TblCourseware.findByDescription", query = "SELECT t FROM TblCourseware t WHERE t.description = :description"),
    @NamedQuery(name = "TblCourseware.findByStatus", query = "SELECT t FROM TblCourseware t WHERE t.status = :status"),
    @NamedQuery(name = "TblCourseware.findByDeleted", query = "SELECT t FROM TblCourseware t WHERE t.deleted = :deleted"),
    @NamedQuery(name = "TblCourseware.findByCreateAt", query = "SELECT t FROM TblCourseware t WHERE t.createAt = :createAt"),
    @NamedQuery(name = "TblCourseware.findByUpdateAt", query = "SELECT t FROM TblCourseware t WHERE t.updateAt = :updateAt"),
    @NamedQuery(name = "TblCourseware.findByCreateBy", query = "SELECT t FROM TblCourseware t WHERE t.createBy = :createBy"),
    @NamedQuery(name = "TblCourseware.findByUpdateBy", query = "SELECT t FROM TblCourseware t WHERE t.updateBy = :updateBy")})
public class TblCourseware implements Serializable {
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
    @Lob
    @Size(max = 2147483647)
    @Column(name = "link")
    private String link;
    @Size(max = 1073741823)
    @Column(name = "description")
    private String description;
    @Column(name = "status")
    private Integer status;
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
    @JoinColumn(name = "type", referencedColumnName = "id")
    @ManyToOne
    private TblfileType type;
    @JoinColumn(name = "lesson_id", referencedColumnName = "id")
    @ManyToOne
    private TblLesson lessonId;

    public TblCourseware() {
    }

    public TblCourseware(Integer id) {
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public TblfileType getType() {
        return type;
    }

    public void setType(TblfileType type) {
        this.type = type;
    }

    public TblLesson getLessonId() {
        return lessonId;
    }

    public void setLessonId(TblLesson lessonId) {
        this.lessonId = lessonId;
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
        if (!(object instanceof TblCourseware)) {
            return false;
        }
        TblCourseware other = (TblCourseware) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblCourseware[ id=" + id + " ]";
    }
    
}
