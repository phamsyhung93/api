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
public class OrderDetailModel {
    private int id;
    private int orderId;
    private int courseId;
    private String CourseName;
    private int CoursePrice;

    public OrderDetailModel() {
    }

    public OrderDetailModel(int id, int orderId, int courseId, String CourseName, int CoursePrice) {
        this.id = id;
        this.orderId = orderId;
        this.courseId = courseId;
        this.CourseName = CourseName;
        this.CoursePrice = CoursePrice;
    }

    public OrderDetailModel(int orderId, int courseId, String CourseName, int CoursePrice) {
        this.orderId = orderId;
        this.courseId = courseId;
        this.CourseName = CourseName;
        this.CoursePrice = CoursePrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String CourseName) {
        this.CourseName = CourseName;
    }

    public int getCoursePrice() {
        return CoursePrice;
    }

    public void setCoursePrice(int CoursePrice) {
        this.CoursePrice = CoursePrice;
    }
    
    
}
