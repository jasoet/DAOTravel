/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.uad.tot.travel.dao;

import id.ac.uad.tot.travel.domain.TripType;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author jasoet
 */
public interface TripTypeDao {

    public void save(TripType triptype) throws SQLException;

    public void update(int id, TripType triptype) throws SQLException;

    public void delete(int id) throws SQLException;

    public TripType findById(int id) throws SQLException;

    public List<TripType> findAll() throws SQLException;

    public List<TripType> findByName(String name) throws SQLException;
}
