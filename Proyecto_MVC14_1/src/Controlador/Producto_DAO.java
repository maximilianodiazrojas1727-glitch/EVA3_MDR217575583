/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Producto;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author PCXX
 */
public class Producto_DAO 
{
    public boolean agregarProducto(Producto p){
        String sql="INSERT INTO producto (nombre,descripcion,precio) VALUES (?,?,?)";
        
        try (Connection con=Conexion.getConexion();
                PreparedStatement ps=con.prepareStatement(sql))
        {
            ps.setString(1,p.getNom());
            ps.setString(2,p.getDesc());
            ps.setDouble(3,p.getPrecio());
            
            ps.executeUpdate();
            return true;
                        
        }catch (Exception e)
        {
            System.out.println("ERROR DAO al Agregar: "+e.getMessage());
            return false;
        }
    }
    
    public boolean eliminar(int id)
    {
        String sql="DELETE FROM producto WHERE id=?";
        
        try (Connection con=Conexion.getConexion();
            PreparedStatement ps=con.prepareStatement(sql))
        {
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
            
        }catch (Exception e){
            System.out.println("ERROR al Eliminar: "+e.getMessage());
            return false;
        }
               
    }
    
    public Producto buscarPorId(int id){
        String sql="SELECT * FROM producto WHERE id=?";
        Producto p=null;
        
        try (Connection con=Conexion.getConexion();
            PreparedStatement ps=con.prepareStatement(sql))
        {
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            
            if(rs.next()){
                p=new Producto(
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        (int)rs.getDouble("precio"));
            }
                   
        }catch(Exception e){
            System.out.println("ERROR en la busqueda: "+e.getMessage());
        }
        return p;
    }
    
    public ArrayList<Producto> listar() {
        
        ArrayList<Producto> lista=new ArrayList<>();
    
        String sql="SELECT * FROM producto";
        
        try (Connection con=Conexion.getConexion();
                PreparedStatement ps=con.prepareStatement(sql);
                ResultSet rs=ps.executeQuery())
        {
            while(rs.next())
            {
                lista.add(new Producto(
                rs.getString("nombre"),
                rs.getString("descripcion"),
                rs.getInt("precio")
                ));
            }
        }catch (Exception e)
        {
            System.out.println("ERROR: "+e.getMessage());
            
        }
        return lista;
    }
}
