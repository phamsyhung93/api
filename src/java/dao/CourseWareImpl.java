/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.TblCourseware;
import entities.TblUser;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author hung
 */
public class CourseWareImpl implements ICourseWare{

    @Override
    public List<TblCourseware> getAllCourseWareByLessionId(int lessonId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            List<TblCourseware> list = session.createQuery("from TblCourseware where lessonId.id= :id")
                    .setParameter("id", lessonId)
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
