/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.RoleImpl;
import dao.TypeImpl;
import entities.TblRole;
import entities.TblfileType;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author hung
 */
@Path(value = "/type")
public class TypeService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path(value = "/getAllType")
    public String getAllType() {
        try {
            List<TblfileType> listType = new TypeImpl().getAllType();
            ObjectMapper mapper = new ObjectMapper();
            String data = mapper.writeValueAsString(listType);
            return data;
        } catch (JsonProcessingException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
}
