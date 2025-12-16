/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author PCXX
 */
public class TestConexion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if(Conexion.getConexion()!=null)
        {
            System.out.println("Conectado....");
        }else{
            System.out.println("ERROR en la Conexion");
        }
    }
    
}
