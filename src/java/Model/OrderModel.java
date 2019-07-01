/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author hung
 */
public class OrderModel {
    private int id;
   
    private int totalCost;
   
    private boolean status;
   
    private boolean deleted;
    
    private String createAt;
    
    private String updateAt;
    
    private int createBy;
 
    private int updateBy;
    
    private int userId;

    public OrderModel() {
    }

    public OrderModel(int id, int totalCost, boolean status, boolean deleted, String createAt, String updateAt, int createBy, int updateBy, int userId) {
        this.id = id;
        this.totalCost = totalCost;
        this.status = status;
        this.deleted = deleted;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.userId = userId;
    }

    public OrderModel(int totalCost, boolean status, boolean deleted, String createAt, String updateAt, int createBy, int updateBy, int userId) {
        this.totalCost = totalCost;
        this.status = status;
        this.deleted = deleted;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
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

    public int getCreateBy() {
        return createBy;
    }

    public void setCreateBy(int createBy) {
        this.createBy = createBy;
    }

    public int getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(int updateBy) {
        this.updateBy = updateBy;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    
}
