/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Model.OrderDetailModel;
import Model.OrderModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.OrderDetailImpl;
import dao.OrderImpl;
import entities.OrderDetail;
import entities.Orders;
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
@Path(value = "/orderdetail")
public class OrderDetailService {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path(value = "/insertOrderDetail")
    public String insertOrderDetail(OrderDetailModel o){
        try {
            boolean addOrderDetail = new OrderDetailImpl().addOrderDetail(o);
            ObjectMapper mapper = new ObjectMapper();
            String data = mapper.writeValueAsString(addOrderDetail);
            return data;
        } catch (JsonProcessingException ex) {
            Logger.getLogger(CourseService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path(value = "/getAllOrderDetailByOrderId/{id}")
    public String getAllOrderDetailByOrderId(@PathParam("id")int id) {
        try {
            List<OrderDetail> o = new OrderDetailImpl().getAllOrderDetailByOrderId(id);
            List<OrderDetailModel> odm = new ArrayList<>();
            for (OrderDetail i : o) {
                OrderDetailModel orM = new OrderDetailModel();
                orM.setId(i.getId());
                orM.setCourseId(i.getCourseId().getId());
                orM.setCourseName(i.getCourseId().getName());
                orM.setCoursePrice(i.getCourseId().getCoursePrice());
                orM.setOrderId(i.getOrderId().getId());
                odm.add(orM);
            }
            ObjectMapper mapper = new ObjectMapper();
            String data = mapper.writeValueAsString(odm);
            return data;
        } catch (JsonProcessingException ex) {
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
}
