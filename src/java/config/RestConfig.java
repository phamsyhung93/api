/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import service.CourseService;
import service.CourseWareService;
import service.LessonService;
import service.OrderDetailService;
import service.OrderService;
import service.RoleService;
import service.SubjectService;
import service.TypeService;
import service.UserService;


/**
 *
 * @author hung
 */
@ApplicationPath("/rest")
public class RestConfig extends Application{

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resource = new HashSet<>();
        addResource(resource);
        return resource;
    }
    
    private void addResource(Set<Class<?>> resource){
          resource.add(UserService.class);
          resource.add(RoleService.class);
          resource.add(CourseService.class);
          resource.add(CourseWareService.class);
          resource.add(OrderService.class);
          resource.add(OrderDetailService.class);
          resource.add(SubjectService.class);
          resource.add(LessonService.class);
          resource.add(TypeService.class);
    }
}
