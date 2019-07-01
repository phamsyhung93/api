/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.TblUser;
import java.util.List;

/**
 *
 * @author hung
 */
public interface IUserDao {
    public TblUser getUser(String username,String password);
    public List<TblUser> getAllUser();
    public TblUser getUserByUserId(int UserId);
}
