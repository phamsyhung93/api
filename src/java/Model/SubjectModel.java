/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import entities.TblCourse;
import entities.TblLesson;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

/**
 *
 * @author hung
 */
public class SubjectModel {
    private int id;
    
    private String name;
    
    private String description;
   
    private boolean deleted;
    
    private String createAt;
   
    private String updateAt;
   
    private int createBy;
   
    private int updateBy;

    private int courseId;

    public SubjectModel() {
    }

    public SubjectModel(int id, String name, String description, boolean deleted, String createAt, String updateAt, int createBy, int updateBy, int courseId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.deleted = deleted;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.courseId = courseId;
    }

    public SubjectModel(String name, String description, boolean deleted, String createAt, String updateAt, int createBy, int updateBy, int courseId) {
        this.name = name;
        this.description = description;
        this.deleted = deleted;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.courseId = courseId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
    
    
}
