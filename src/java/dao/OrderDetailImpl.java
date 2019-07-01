/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Model.OrderDetailModel;
import entities.OrderDetail;
import entities.Orders;
import entities.TblCourse;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author hung
 */
public class OrderDetailImpl implements IOrderDetail{

    @Override
    public boolean addOrderDetail(OrderDetailModel odm) {
         Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            OrderDetail od = new OrderDetail();
            od.setId(odm.getId());
            TblCourse c = new CoureImpl().getCourses(odm.getCourseId());
            od.setCourseId(c);
            Orders o = new OrderImpl().getOrders(odm.getOrderId());
            od.setOrderId(o);
            session.beginTransaction();
            session.save(od);
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
    public List<OrderDetail> getAllOrderDetailByOrderId(int OrderId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            List list = session.createQuery("from OrderDetail where orderId.id = :id")
                    .setParameter("id", OrderId)
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
