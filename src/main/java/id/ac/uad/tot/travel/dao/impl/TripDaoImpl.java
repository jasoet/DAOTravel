/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.uad.tot.travel.dao.impl;

import id.ac.uad.tot.travel.dao.TripDao;
import id.ac.uad.tot.travel.domain.Person;
import id.ac.uad.tot.travel.domain.Trip;
import id.ac.uad.tot.travel.domain.TripType;
import id.ac.uad.tot.travel.util.Utils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jasoet
 */
public class TripDaoImpl implements TripDao {
    
    private Connection connection;

    public TripDaoImpl(Connection connection) {
        this.connection = connection;
    }
     
    @Override
    public List<Trip> findAll() throws SQLException{
        String sql = "SELECT t.tripid,t.depdate,t.depcity,t.destcity,t.lastupdated AS tripLastUpdated, "
                + " tt.triptypeid, tt.`name` AS tripTypeName, tt.description AS tripTypeDesc, tt.lastupdated as tripTypeLastUpdate, "
                + " p.personid,p.`name` AS personName, p.jobtitle, p.frequentflyer,p.lastupdated as personLastUpdate "
                + " FROM trip t  "
                + " INNER JOIN triptype tt ON (t.triptypeid = tt.triptypeid) "
                + " INNER JOIN person p ON (p.personid = t.personid)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        List<Trip> resultList = new ArrayList<Trip>();
        while(rs.next()){
            Person p = new Person();
            p.setId(rs.getInt("personid"));
            p.setJobTitle(rs.getString("jobtitle"));
            p.setFrequentFlyer(rs.getInt("frequentflyer"));
            p.setName(rs.getString("personName"));
            p.setLastUpdated(rs.getDate("personLastUpdate"));
            
            TripType tt = new TripType();
            tt.setId(rs.getInt("triptypeid"));
            tt.setDescription(rs.getString("tripTypeDesc"));
            tt.setName(rs.getString("tripTypeName"));
            tt.setLastUpdated(rs.getDate("tripTypeLastUpdate"));
        
            
            Trip result = new Trip();
            result.setPerson(p);
            result.setTripType(tt);
            result.setId(rs.getInt("tripId"));
            result.setDepDate(rs.getDate("depdate"));
            result.setDepCity(rs.getString("depcity"));
            result.setDestCity(rs.getString("destcity"));
            result.setLastUpdate(rs.getDate("tripLastUpdated"));
            
            resultList.add(result);
            
        }
        
        return resultList;
    }

    @Override
    public void save(Trip trip) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(int id, Trip trip) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Trip findById(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
