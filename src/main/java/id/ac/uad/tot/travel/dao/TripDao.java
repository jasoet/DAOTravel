/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.uad.tot.travel.dao;

import id.ac.uad.tot.travel.domain.Trip;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author jasoet
 */
public interface TripDao {

    public void save(Trip trip) throws SQLException;

    public void update(int id, Trip trip) throws SQLException;

    public void delete(int id) throws SQLException;

    public Trip findById(int id) throws SQLException;

    public List<Trip> findAll() throws SQLException;
}
