/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.TblRole;
import java.util.List;

/**
 *
 * @author hung
 */
public interface IRole {
    public List<TblRole> getAllRole();
}
