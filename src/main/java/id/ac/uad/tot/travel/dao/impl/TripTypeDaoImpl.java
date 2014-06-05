/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.uad.tot.travel.dao.impl;

import id.ac.uad.tot.travel.dao.TripTypeDao;
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
public class TripTypeDaoImpl implements TripTypeDao {

    private Connection connection;

    public TripTypeDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(TripType triptype) throws SQLException {
        String sql = "INSERT INTO triptype (triptypeid,`name`,description,lastupdated) VALUES (?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,triptype.getId());
        ps.setString(2, triptype.getName());
        ps.setString(3, triptype.getDescription());
        ps.setDate(4, Utils.convert(triptype.getLastUpdated()));
        ps.executeUpdate();
    }

    @Override
    public void update(int id, TripType triptype) throws SQLException {
        String sql = "UPDATE triptype SET `name`=?, description=?, lastupdated=? WHERE triptypeid=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, triptype.getName());
        ps.setString(2, triptype.getDescription());
        ps.setDate(3, Utils.convert(triptype.getLastUpdated()));
        ps.setInt(4, id);
        ps.executeUpdate();
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM triptype WHERE triptypeid=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public TripType findById(int id) throws SQLException {
        String sql = "SELECT t.triptypeid AS id, t.`name`,t.description,t.lastupdated as lastUpdated FROM triptype t WHERE t.triptypeid=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        TripType result = null;
        if (rs.next()) {
            result = new TripType();
            result.setId(rs.getInt("id"));
            result.setName(rs.getString("name"));
            result.setDescription(rs.getString("description"));
            result.setLastUpdated(rs.getDate("lastUpdate"));
        }

        return result;
    }

    @Override
    public List<TripType> findAll() throws SQLException {
        String sql = "SELECT t.triptypeid AS id,t.`name`,t.description,t.lastupdated as lastUpdated FROM triptype t";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        List<TripType> resultList = new ArrayList<TripType>();
        while (rs.next()) {
            TripType result = new TripType();
            result.setId(rs.getInt("id"));
            result.setName(rs.getString("name"));
            result.setDescription(rs.getString("description"));
            result.setLastUpdated(rs.getDate("lastUpdated"));
            resultList.add(result);
        }

        return resultList;
    }

    @Override
    public List<TripType> findByName() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
