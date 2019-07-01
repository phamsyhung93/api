/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Model.CourseModel;
import Model.OrderModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import dao.CoureImpl;
import dao.OrderImpl;
import entities.Orders;
import entities.TblCourse;
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
@Path(value = "/course")
public class CourseService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path(value = "/getAllCourse")
    public String getAllUser() {
        try {
            List<TblCourse> listCourse = new CoureImpl().getAllCourse();
            ObjectMapper mapper = new ObjectMapper();
            String data = mapper.writeValueAsString(listCourse);
            return data;
        } catch (JsonProcessingException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path(value = "/insertCourse")
    public String insertCourse(TblCourse course){
        try {
            boolean addCourse = new CoureImpl().addCourse(course);
            ObjectMapper mapper = new ObjectMapper();
            String data = mapper.writeValueAsString(addCourse);
            return data;
        } catch (JsonProcessingException ex) {
            Logger.getLogger(CourseService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path(value = "/getCourseByCourseId/{id}")
    public String getCourseByCourseId(@PathParam("id")int id) {
        TblCourse c = new CoureImpl().getCourses(id);
        CourseModel cm = new CourseModel(c.getId(),c.getName(),
                c.getDescription(),c.getCoursePrice(),c.getDeleted(),c.getCreateAt(),c.getUpdateAt(),
                c.getStartDate(),c.getEndDate()
                ,c.getCreateBy(),c.getUpdateBy());
        Gson son = new Gson();
        String data = son.toJson(cm);
        return data;
    }
}
