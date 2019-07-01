/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.TblfileType;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author hung
 */
public class TypeImpl implements IType{

    @Override
    public List<TblfileType> getAllType() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            List list = session.createQuery("from TblfileType ").list();
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
