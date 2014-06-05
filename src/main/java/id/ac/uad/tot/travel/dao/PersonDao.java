/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.ac.uad.tot.travel.dao;

import id.ac.uad.tot.travel.domain.Person;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author jasoet
 */
public interface PersonDao {
    
    public void save(Person person) throws SQLException;
    public void update(int id,Person person) throws SQLException;
    public void delete(int id) throws SQLException;
    public Person findById(int id) throws SQLException;
    public List<Person> findAll() throws SQLException;
    public List<Person> findByName() throws SQLException;
    
}
