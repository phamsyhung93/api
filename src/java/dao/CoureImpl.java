/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Model.CourseModel;
import entities.Orders;
import entities.TblCourse;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author hung
 */
public class CoureImpl implements ICoureDao{

    @Override
    public List<TblCourse> getAllCourse() {
       Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            List list = session.createQuery("from TblCourse ").list();
            session.getTransaction().commit();
            session.close();
            return list;
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
            return null;
        }
    }

    @Override
    public boolean addCourse(TblCourse course) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(course);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage()); 
            session.getTransaction().rollback();
            session.close();
        }
        return false;
    }

    @Override
    public TblCourse getCourses(int CourseId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            TblCourse o = (TblCourse) session.createQuery("from TblCourse where id = :id")
                    .setParameter("id", CourseId)
                    .uniqueResult();
            session.getTransaction().commit();
            session.close();
            return o;
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
            return null;
        }
    }
    
    
}
