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
@Table(name = "tbl_user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblUser.findAll", query = "SELECT t FROM TblUser t"),
    @NamedQuery(name = "TblUser.findById", query = "SELECT t FROM TblUser t WHERE t.id = :id"),
    @NamedQuery(name = "TblUser.findByUsername", query = "SELECT t FROM TblUser t WHERE t.username = :username"),
    @NamedQuery(name = "TblUser.findByPassword", query = "SELECT t FROM TblUser t WHERE t.password = :password"),
    @NamedQuery(name = "TblUser.findByFirstName", query = "SELECT t FROM TblUser t WHERE t.firstName = :firstName"),
    @NamedQuery(name = "TblUser.findByLastName", query = "SELECT t FROM TblUser t WHERE t.lastName = :lastName"),
    @NamedQuery(name = "TblUser.findByDisplayName", query = "SELECT t FROM TblUser t WHERE t.displayName = :displayName"),
    @NamedQuery(name = "TblUser.findByEmail", query = "SELECT t FROM TblUser t WHERE t.email = :email"),
    @NamedQuery(name = "TblUser.findByBirthday", query = "SELECT t FROM TblUser t WHERE t.birthday = :birthday"),
    @NamedQuery(name = "TblUser.findByPhone", query = "SELECT t FROM TblUser t WHERE t.phone = :phone"),
    @NamedQuery(name = "TblUser.findBySex", query = "SELECT t FROM TblUser t WHERE t.sex = :sex"),
    @NamedQuery(name = "TblUser.findByStatus", query = "SELECT t FROM TblUser t WHERE t.status = :status"),
    @NamedQuery(name = "TblUser.findByCreateAt", query = "SELECT t FROM TblUser t WHERE t.createAt = :createAt"),
    @NamedQuery(name = "TblUser.findByUpdateAt", query = "SELECT t FROM TblUser t WHERE t.updateAt = :updateAt"),
    @NamedQuery(name = "TblUser.findByCreateBy", query = "SELECT t FROM TblUser t WHERE t.createBy = :createBy"),
    @NamedQuery(name = "TblUser.findByUpdateBy", query = "SELECT t FROM TblUser t WHERE t.updateBy = :updateBy")})
public class TblUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "last_name")
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "display_name")
    private String displayName;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "email")
    private String email;
    @Size(max = 12)
    @Column(name = "birthday")
    private String birthday;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 20)
    @Column(name = "phone")
    private String phone;
    @Column(name = "sex")
    private Short sex;
    @Column(name = "status")
    private Boolean status;
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
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    @ManyToOne
    private TblRole roleId;
    @OneToMany(mappedBy = "userId")
    private Collection<Orders> ordersCollection;

    public TblUser() {
    }

    public TblUser(Integer id) {
        this.id = id;
    }

    public TblUser(Integer id, String username, String password, String firstName, String lastName, String displayName) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.displayName = displayName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Short getSex() {
        return sex;
    }

    public void setSex(Short sex) {
        this.sex = sex;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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

    public TblRole getRoleId() {
        return roleId;
    }

    public void setRoleId(TblRole roleId) {
        this.roleId = roleId;
    }

    @XmlTransient
    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
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
        if (!(object instanceof TblUser)) {
            return false;
        }
        TblUser other = (TblUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TblUser[ id=" + id + " ]";
    }
    
}
