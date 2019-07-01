/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.TblLesson;
import java.util.List;

/**
 *
 * @author hung
 */
public interface ILesson {
    public List<TblLesson> getAllLessonBySubjectId(int SubjectId);
}
