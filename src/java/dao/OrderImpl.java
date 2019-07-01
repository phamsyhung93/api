/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Model.OrderModel;
import entities.Orders;
import entities.TblUser;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author hung
 */
public class OrderImpl implements IOrder{

    @Override
    public boolean addOrder(OrderModel o) {
         Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Orders or = new Orders();
            or.setCreateAt(o.getCreateAt());
            or.setCreateBy(o.getCreateBy());
            or.setDeleted(o.isDeleted());
            or.setId(o.getId());
            or.setStatus(o.isStatus());
            or.setTotalCost(o.getTotalCost());
            or.setUpdateAt(o.getUpdateAt());
            or.setUpdateBy(o.getUpdateBy());
            TblUser user = new UserDaoImpl().getUserByUserId(o.getUserId());
            or.setUserId(user);
            session.beginTransaction();
            session.save(or);
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
    public List<Orders> getAllOrderByUserId(int UserId) {
     Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            List list = session.createQuery("from Orders where userId.id = :id")
                    .setParameter("id", UserId)
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

    @Override
    public Orders getOrders(int OrderId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Orders o = (Orders) session.createQuery("from Orders where id = :id")
                    .setParameter("id", OrderId)
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
