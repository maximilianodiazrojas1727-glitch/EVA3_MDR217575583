/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import db.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Arma;

/**
 *
 * @author PCXX
 */
public class ControladorArma {

    public boolean agregar(Arma newArma) {
        try {
            Connection con = Conexion.getConexion();

            // EN BD LA COLUMNA ES prec, NO precision
            String sql = "INSERT INTO arma(nombre, prec) VALUES(?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, newArma.getNombre());
            ps.setDouble(2, newArma.getPrecision());

            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("error al agregar: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<Arma> listar() {
        ArrayList<Arma> datos = new ArrayList<>();

        try {
            Connection con = Conexion.getConexion();

            
            String sql = "SELECT id, nombre, prec FROM arma";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Arma arma = new Arma(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getDouble("prec")  
                );
                datos.add(arma);
            }

        } catch (Exception e) {
            System.out.println("error al listar: " + e.getMessage());
        }

        return datos;
    }
}
