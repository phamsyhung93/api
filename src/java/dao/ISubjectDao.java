/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.TblSubject;
import java.util.List;

/**
 *
 * @author hung
 */
public interface ISubjectDao {
    public List<TblSubject> getSubjectByCoureId(int CoureId);
    
}
