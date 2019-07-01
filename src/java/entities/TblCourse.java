/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "tbl_course")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblCourse.findAll", query = "SELECT t FROM TblCourse t"),
    @NamedQuery(name = "TblCourse.findById", query = "SELECT t FROM TblCourse t WHERE t.id = :id"),
    @NamedQuery(name = "TblCourse.findByName", query = "SELECT t FROM TblCourse t WHERE t.name = :name"),
    @NamedQuery(name = "TblCourse.findByDescription", query = "SELECT t FROM TblCourse t WHERE t.description = :description"),
    @NamedQuery(name = "TblCourse.findByCoursePrice", query = "SELECT t FROM TblCourse t WHERE t.coursePrice = :coursePrice"),
    @NamedQuery(name = "TblCourse.findByDeleted", query = "SELECT t FROM TblCourse t WHERE t.deleted = :deleted"),
    @NamedQuery(name = "TblCourse.findByCreateAt", query = "SELECT t FROM TblCourse t WHERE t.createAt = :createAt"),
    @NamedQuery(name = "TblCourse.findByUpdateAt", query = "SELECT t FROM TblCourse t WHERE t.updateAt = :updateAt"),
    @NamedQuery(name = "TblCourse.findByStartDate", query = "SELECT t FROM TblCourse t WHERE t.startDate = :startDate"),
    @NamedQuery(name = "TblCourse.findByEndDate", query = "SELECT t FROM TblCourse t WHERE t.endDate = :endDate"),
    @NamedQuery(name = "TblCourse.findByCreateBy", query = "SELECT t FROM TblCourse t WHERE t.createBy = :createBy"),
    @NamedQuery(name = "TblCourse.findByUpdateBy", query = "SELECT t FROM TblCourse t WHERE t.updateBy = :updateBy")})
public class TblCourse implements Serializable {
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
    @Column(name = "course_price")
    private Integer coursePrice;
    @Column(name = "deleted")
    private Boolean deleted;
    @Size(max = 12)
    @Column(name = "create_at")
    private String createAt;
    @Size(max = 12)
    @Column(name = "update_at")
    private String updateAt;
    @Size(max = 12)
    @Column(name = "start_date")
    private String startDate;
    @Size(max = 12)
    @Column(name = "end_date")
    private String endDate;
    @Column(name = "create_by")
    private Integer createBy;
    @Column(name = "update_by")
    private Integer updateBy;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseId")
    private Collection<OrderDetail> orderDetailCollection;
    @OneToMany(mappedBy = "courseId")
    private Collection<TblSubject> tblSubjectCollection;

    public TblCourse() {
    }

    public TblCourse(Integer id) {
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

    public Integer getCoursePrice() {
        return coursePrice;
    }

    public void setCoursePrice(Integer coursePrice) {
        this.coursePrice = coursePrice;
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
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
    public Collection<OrderDetail> getOrderDetailCollection() {
        return orderDetailCollection;
    }

    public void setOrderDetailCollection(Collection<OrderDetail> orderDetailCollection) {
        this.orderDetailCollection = orderDetailCollection;
    }

    @XmlTransient
    public Collection<TblSubject> getTblSubjectCollection() {
        return tblSubjectCollection;
    }

    public void setTblSubjectCollection(Collection<TblSubject> tblSubjectCollection) {
        this.tblSubjectCollection = tblSubjectCollection;
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
        if (!(object instanceof TblCourse)) {
            return false;
        }
        TblCourse other = (TblCourse) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblCourse[ id=" + id + " ]";
    }
    
}
