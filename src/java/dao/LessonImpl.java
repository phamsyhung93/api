/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.TblLesson;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author hung
 */
public class LessonImpl implements ILesson{

    @Override
    public List<TblLesson> getAllLessonBySubjectId(int SubjectId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            List list = session.createQuery("from TblLesson where subjectId.id = :id")
                    .setParameter("id", SubjectId)
                    .list();
            session.getTransaction().commit();
            session.close();
            return list;
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
            return null;
        }
    }
    
}
