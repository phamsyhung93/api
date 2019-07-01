/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.TblSubject;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author hung
 */
public class SubjectImpl implements ISubjectDao{

    @Override
    public List<TblSubject> getSubjectByCoureId(int CoureId) {
         Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            List list = session.createQuery("from TblSubject where courseId.id = :id")
                    .setParameter("id", CoureId)
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
