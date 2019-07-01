/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.TblUser;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author hung
 */
public class UserDaoImpl implements IUserDao{
    
    
    @Override
    public TblUser getUser(String username, String password) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            TblUser user = (TblUser) session.createQuery("from TblUser where username = :username and password =:password and status = true ")
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .uniqueResult();
            session.getTransaction().commit();
            session.close();
            return user;
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
            return null;
        }
    }
    
    
     @Override
    public List<TblUser> getAllUser() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            List list = session.createQuery("from TblUser where status = true").list();
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
    public TblUser getUserByUserId(int UserId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            TblUser user = (TblUser) session.createQuery("from TblUser where status = true and id = :id")
                    .setParameter("id", UserId)
                    .uniqueResult();
            session.getTransaction().commit();
            session.close();
            return user;
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.close();
            return null;
        }
    }
    

}

