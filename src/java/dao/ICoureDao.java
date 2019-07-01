/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Model.CourseModel;
import entities.TblCourse;
import java.util.List;

/**
 *
 * @author hung
 */
public interface ICoureDao {
    public List<TblCourse> getAllCourse();
    public boolean addCourse(TblCourse course);
    public TblCourse getCourses(int CourseId);
}
