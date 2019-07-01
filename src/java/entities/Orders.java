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
@Table(name = "orders")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o"),
    @NamedQuery(name = "Orders.findById", query = "SELECT o FROM Orders o WHERE o.id = :id"),
    @NamedQuery(name = "Orders.findByTotalCost", query = "SELECT o FROM Orders o WHERE o.totalCost = :totalCost"),
    @NamedQuery(name = "Orders.findByStatus", query = "SELECT o FROM Orders o WHERE o.status = :status"),
    @NamedQuery(name = "Orders.findByDeleted", query = "SELECT o FROM Orders o WHERE o.deleted = :deleted"),
    @NamedQuery(name = "Orders.findByCreateAt", query = "SELECT o FROM Orders o WHERE o.createAt = :createAt"),
    @NamedQuery(name = "Orders.findByUpdateAt", query = "SELECT o FROM Orders o WHERE o.updateAt = :updateAt"),
    @NamedQuery(name = "Orders.findByCreateBy", query = "SELECT o FROM Orders o WHERE o.createBy = :createBy"),
    @NamedQuery(name = "Orders.findByUpdateBy", query = "SELECT o FROM Orders o WHERE o.updateBy = :updateBy")})
public class Orders implements Serializable {
    private static final long serialVersionUID = 1L;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "total_cost")
    private Integer totalCost;
    @Column(name = "status")
    private Boolean status;
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
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private TblUser userId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderId")
    private Collection<OrderDetail> orderDetailCollection;

    public Orders() {
    }

    public Orders(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Integer totalCost) {
        this.totalCost = totalCost;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
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

    public TblUser getUserId() {
        return userId;
    }

    public void setUserId(TblUser userId) {
        this.userId = userId;
    }

    @XmlTransient
    public Collection<OrderDetail> getOrderDetailCollection() {
        return orderDetailCollection;
    }

    public void setOrderDetailCollection(Collection<OrderDetail> orderDetailCollection) {
        this.orderDetailCollection = orderDetailCollection;
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
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Orders[ id=" + id + " ]";
    }
    
}
