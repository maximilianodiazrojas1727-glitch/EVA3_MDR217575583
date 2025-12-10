/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author PCXX
 */
public class Conexion {
    
    private static final String URL = "jdbc:mysql://localhost:3306/academia_guardianes";
    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection getConexion() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("conectado");
        } catch (Exception e) {
            System.out.println("error de conexion: " + e.getMessage());
        }
        return con;
    }
    
}
