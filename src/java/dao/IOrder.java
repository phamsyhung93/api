/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Model.OrderModel;
import entities.Orders;
import java.util.List;

/**
 *
 * @author hung
 */
public interface IOrder {
    public boolean addOrder(OrderModel o);
    public List<Orders> getAllOrderByUserId(int UserId);
    public Orders getOrders(int OrderId);
}
