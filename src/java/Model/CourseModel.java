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
public class CourseModel {
    private Integer id;
    private String name;
    private String description;
    private Integer coursePrice;
    private Boolean deleted;
    private String createAt;
    private String updateAt;
    private String startDate;
    private String endDate;
    private Integer createBy;
    private Integer updateBy;

    public CourseModel() {
    }

    public CourseModel(Integer id, String name, String description, Integer coursePrice, Boolean deleted, String createAt, String updateAt, String startDate, String endDate, Integer createBy, Integer updateBy) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.coursePrice = coursePrice;
        this.deleted = deleted;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.startDate = startDate;
        this.endDate = endDate;
        this.createBy = createBy;
        this.updateBy = updateBy;
    }

    
    
    public CourseModel(String name, String description, Integer coursePrice, Boolean deleted, String createAt, String updateAt, String startDate, String endDate, Integer createBy, Integer updateBy) {
        this.name = name;
        this.description = description;
        this.coursePrice = coursePrice;
        this.deleted = deleted;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.startDate = startDate;
        this.endDate = endDate;
        this.createBy = createBy;
        this.updateBy = updateBy;
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
    
    
}
