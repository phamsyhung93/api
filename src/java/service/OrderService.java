/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Model.OrderModel;
import Model.UserModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import dao.CoureImpl;
import dao.OrderImpl;
import dao.UserDaoImpl;
import entities.Orders;
import entities.TblCourse;
import entities.TblUser;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author hung
 */
@Path(value = "/order")
public class OrderService {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path(value = "/insertOrder")
    public String insertOrder(OrderModel o){
        try {
            boolean addOrder = new OrderImpl().addOrder(o);
            ObjectMapper mapper = new ObjectMapper();
            String data = mapper.writeValueAsString(addOrder);
            return data;
        } catch (JsonProcessingException ex) {
            Logger.getLogger(CourseService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path(value = "/getAllOrderByUserId/{id}")
    public String getAllOrderByUserId(@PathParam("id")int id) {
        try {
            List<Orders> o = new OrderImpl().getAllOrderByUserId(id);
            List<OrderModel> or = new ArrayList<>();
            for (Orders i : o) {
                OrderModel orM = new OrderModel();
                orM.setId(i.getId());
                orM.setCreateAt(i.getCreateAt());
                orM.setCreateBy(i.getCreateBy());
                orM.setDeleted(i.getDeleted());
                orM.setStatus(i.getStatus());
                orM.setTotalCost(i.getTotalCost());
                orM.setUpdateAt(i.getUpdateAt());
                orM.setUpdateBy(i.getUpdateBy());
                orM.setUserId(i.getUserId().getId());
                or.add(orM);
            }
            ObjectMapper mapper = new ObjectMapper();
            String data = mapper.writeValueAsString(or);
            return data;
        } catch (JsonProcessingException ex) {
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path(value = "/getOrderByOrderId/{id}")
    public String getOrderByOrderId(@PathParam("id")int id) {
        Orders o = new OrderImpl().getOrders(id);
        OrderModel or = new OrderModel(o.getId(),o.getTotalCost(),o.getStatus(),o.getDeleted(),o.getCreateAt(),o.getUpdateAt(),
                o.getCreateBy(),o.getUpdateBy(),o.getUserId().getId());
        Gson son = new Gson();
        String data = son.toJson(or);
        return data;
    }
}
