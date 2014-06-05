/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.uad.tot.travel;

import id.ac.uad.tot.travel.dao.TripTypeDao;
import id.ac.uad.tot.travel.dao.impl.TripTypeDaoImpl;
import id.ac.uad.tot.travel.database.DatabaseConnection;
import id.ac.uad.tot.travel.domain.TripType;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jasoet
 */
public class MainTest {

    public static void main(String[] args) {
        try {
            DatabaseConnection dbConnection = DatabaseConnection.getInstance();

            TripTypeDao tripTypeDao = new TripTypeDaoImpl(dbConnection.getConnection());

            List<TripType> tripTypes = tripTypeDao.findByName("u");

            for (TripType tt : tripTypes) {
                System.out.println(tt);
            }
//
//            TripType ntt = new TripType();
//            ntt.setId(27);
//            ntt.setName("Plesir");
//            ntt.setDescription("Jalan jalan sore");
//            ntt.setLastUpdated(new Date());
//
//            tripTypeDao.save(ntt);
//
//            tripTypes = tripTypeDao.findAll();
//            System.out.println("AFTER INSERT ================= ");
//            for (TripType tt : tripTypes) {
//                System.out.println(tt);
//            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
