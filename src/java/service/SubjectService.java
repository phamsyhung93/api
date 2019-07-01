/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Model.OrderModel;
import Model.SubjectModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.OrderImpl;
import dao.SubjectImpl;
import entities.Orders;
import entities.TblSubject;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author hung
 */
@Path(value = "/subject")
public class SubjectService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path(value = "/getAllSubjectByCourseId/{id}")
    public String getAllSubjectByCourseId(@PathParam("id")int id) {
        try {
            List<TblSubject> s = new SubjectImpl().getSubjectByCoureId(id);
            List<SubjectModel> suM = new ArrayList<>();
            for (TblSubject i : s) {
                SubjectModel sm = new SubjectModel();
                sm.setId(i.getId());
                sm.setCourseId(i.getCourseId().getId());
                sm.setCreateAt(i.getCreateAt());
                sm.setCreateBy(i.getCreateBy());
                sm.setDeleted(i.getDeleted());
                sm.setDescription(i.getDescription());
                sm.setName(i.getName());
                sm.setUpdateAt(i.getUpdateAt());
                sm.setUpdateBy(i.getUpdateBy());
                suM.add(sm);
            }
            ObjectMapper mapper = new ObjectMapper();
            String data = mapper.writeValueAsString(suM);
            return data;
        } catch (JsonProcessingException ex) {
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
}
