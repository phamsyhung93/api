/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Model.UserModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import dao.UserDaoImpl;
import entities.TblUser;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@Path(value = "/user")
public class UserService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path(value = "/getAllUser")
    public String getAllUser() {
        try {
            List<TblUser> listUser = new UserDaoImpl().getAllUser();
            List<UserModel> lstUser = new ArrayList<>();
            for (TblUser u : listUser) {
                UserModel um = new UserModel();
                um.setBirthday(u.getBirthday());
                um.setCreateAt(u.getCreateAt());
                um.setCreateBy(u.getCreateBy());
                um.setDisplayName(u.getDisplayName());
                um.setEmail(u.getEmail());
                um.setFirstName(u.getFirstName());
                um.setId(u.getId());
                um.setLastName(u.getLastName());
                um.setPassword(u.getPassword());
                um.setPhone(u.getPhone());
                um.setRoleId(u.getRoleId().getId());
                um.setSex(u.getSex());
                um.setStatus(u.getStatus());
                um.setUpdateAt(u.getUpdateAt());
                um.setUpdateBy(u.getUpdateBy());
                um.setUsername(u.getUsername());
                lstUser.add(um);
            }

            ObjectMapper mapper = new ObjectMapper();
            String data = mapper.writeValueAsString(lstUser);
            return data;
        } catch (JsonProcessingException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path(value = "/getUser/{username}/{password}")
    public String getUser(@PathParam("username")String username,@PathParam("password")String password) {
        TblUser u = new UserDaoImpl().getUser(username, password);
        UserModel um = new UserModel();
        um.setBirthday(u.getBirthday());
        um.setCreateAt(u.getCreateAt());
        um.setCreateBy(u.getCreateBy());
        um.setDisplayName(u.getDisplayName());
        um.setEmail(u.getEmail());
        um.setFirstName(u.getFirstName());
        um.setId(u.getId());
        um.setLastName(u.getLastName());
        um.setPassword(u.getPassword());
        um.setPhone(u.getPhone());
        um.setRoleId(u.getRoleId().getId());
        um.setSex(u.getSex());
        um.setStatus(u.getStatus());
        um.setUpdateAt(u.getUpdateAt());
        um.setUpdateBy(u.getUpdateBy());
        um.setUsername(u.getUsername());
        Gson son = new Gson();
        String data = son.toJson(um);
        return data;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path(value = "/getUserByUserId/{id}")
    public String getUser(@PathParam("id")int id) {
        TblUser u = new UserDaoImpl().getUserByUserId(id);
        UserModel um = new UserModel();
        um.setBirthday(u.getBirthday());
        um.setCreateAt(u.getCreateAt());
        um.setCreateBy(u.getCreateBy());
        um.setDisplayName(u.getDisplayName());
        um.setEmail(u.getEmail());
        um.setFirstName(u.getFirstName());
        um.setId(u.getId());
        um.setLastName(u.getLastName());
        um.setPassword(u.getPassword());
        um.setPhone(u.getPhone());
        um.setRoleId(u.getRoleId().getId());
        um.setSex(u.getSex());
        um.setStatus(u.getStatus());
        um.setUpdateAt(u.getUpdateAt());
        um.setUpdateBy(u.getUpdateBy());
        um.setUsername(u.getUsername());
        Gson son = new Gson();
        String data = son.toJson(um);
        return data;
    }
}
