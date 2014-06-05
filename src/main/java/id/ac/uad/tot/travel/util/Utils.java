/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.ac.uad.tot.travel.util;

/**
 *
 * @author jasoet
 */
public class Utils {
    public static java.sql.Date convert(java.util.Date dateOri){
        return new java.sql.Date(dateOri.getTime());
    }
}
