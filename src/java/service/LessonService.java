/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Model.LessonModel;
import Model.SubjectModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.LessonImpl;
import dao.SubjectImpl;
import entities.TblLesson;
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
@Path(value = "/lesson")
public class LessonService {
     @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path(value = "/getAllLessonBySubjectId/{id}")
    public String getAllLessonBySubjectId(@PathParam("id")int id) {
        try {
            List<TblLesson> l = new LessonImpl().getAllLessonBySubjectId(id);
            List<LessonModel> lM = new ArrayList<>();
            for (TblLesson i : l) {
                LessonModel lesson = new LessonModel();
                lesson.setId(i.getId());
                lesson.setCreateAt(i.getCreateAt());
                lesson.setCreateBy(i.getCreateBy());
                lesson.setDeleted(i.getDeleted());
                lesson.setDescription(i.getDescription());
                lesson.setName(i.getName());
                lesson.setSubjectId(i.getSubjectId().getId());
                lesson.setUpdateAt(i.getUpdateAt());
                lesson.setUpdateBy(i.getUpdateBy());
                lM.add(lesson);
            }
            ObjectMapper mapper = new ObjectMapper();
            String data = mapper.writeValueAsString(lM);
            return data;
        } catch (JsonProcessingException ex) {
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
}
