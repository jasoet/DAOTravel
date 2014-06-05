/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.uad.tot.travel.dao;

import id.ac.uad.tot.travel.domain.Trip;
import java.util.List;

/**
 *
 * @author jasoet
 */
public interface TripDao {

    public void save(Trip trip);

    public void update(int id, Trip trip);

    public void delete(int id);

    public Trip findById(int id);

    public List<Trip> findAll();
}
