/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import entities.TblLesson;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author hung
 */
public class CourseWareModel {
    
    private int id;
  
    private String name;
    
    private String link;
   
    private String description;
    
    private int type;
   
    private int status;
    
    private boolean deleted;
    
    private String createAt;
    
    private String updateAt;
   
    private Integer createBy;
   
    private int updateBy;
    private int lessonId;
    private String lessonName;

    public CourseWareModel() {
    }

    public CourseWareModel(int id, String name, String link, String description, int type, int status, boolean deleted, String createAt, String updateAt, Integer createBy, int updateBy, int lessonId, String lessonName) {
        this.id = id;
        this.name = name;
        this.link = link;
        this.description = description;
        this.type = type;
        this.status = status;
        this.deleted = deleted;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.lessonId = lessonId;
        this.lessonName = lessonName;
    }

    public CourseWareModel(String name, String link, String description, int type, int status, boolean deleted, String createAt, String updateAt, Integer createBy, int updateBy, int lessonId) {
        this.name = name;
        this.link = link;
        this.description = description;
        this.type = type;
        this.status = status;
        this.deleted = deleted;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.lessonId = lessonId;
    }

    public CourseWareModel(String name, String link, String description, int type, int status, boolean deleted, String createAt, String updateAt, Integer createBy, int updateBy, int lessonId, String lessonName) {
        this.name = name;
        this.link = link;
        this.description = description;
        this.type = type;
        this.status = status;
        this.deleted = deleted;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.lessonId = lessonId;
        this.lessonName = lessonName;
    }

    public CourseWareModel(int id, String name, String link, String description, int type, int status, boolean deleted, String createAt, String updateAt, Integer createBy, int updateBy, int lessonId) {
        this.id = id;
        this.name = name;
        this.link = link;
        this.description = description;
        this.type = type;
        this.status = status;
        this.deleted = deleted;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.lessonId = lessonId;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
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

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public int getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(int updateBy) {
        this.updateBy = updateBy;
    }

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }
    
    
}
