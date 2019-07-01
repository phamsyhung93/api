/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Model.OrderDetailModel;
import entities.OrderDetail;
import java.util.List;

/**
 *
 * @author hung
 */
public interface IOrderDetail {
    public boolean addOrderDetail(OrderDetailModel odm);
    public List<OrderDetail> getAllOrderDetailByOrderId(int OrderId);
}
