/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Model.CourseWareModel;
import Model.UserModel;
import com.google.gson.Gson;
import dao.CourseWareImpl;
import dao.UserDaoImpl;
import entities.TblCourseware;
import entities.TblUser;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author hung
 */
@Path(value = "/courseware")
public class CourseWareService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path(value = "/getCourseWare/{Lessonid}")
    public String getCourseWare(@PathParam("Lessonid")int LessonId) {
        List<TblCourseware> list = new CourseWareImpl().getAllCourseWareByLessionId(LessonId);
        List<CourseWareModel> lst = new ArrayList<>();
        for (TblCourseware i : list) {
            CourseWareModel cwm = new CourseWareModel();
            cwm.setId(i.getId());
            cwm.setName(i.getName());
            cwm.setCreateAt(i.getCreateAt());
            cwm.setCreateBy(i.getCreateBy());
            cwm.setDeleted(i.getDeleted());
            cwm.setDescription(i.getDescription());
            cwm.setLessonId(i.getLessonId().getId());
            cwm.setLessonName(i.getLessonId().getName());
            cwm.setLink(i.getLink());
            cwm.setStatus(i.getStatus());
            cwm.setType(i.getType().getId());
            cwm.setUpdateAt(i.getUpdateAt());
            cwm.setUpdateBy(i.getUpdateBy());
            lst.add((cwm));
        }
        Gson son = new Gson();
        String data = son.toJson(lst);
        return data;
    }
}
