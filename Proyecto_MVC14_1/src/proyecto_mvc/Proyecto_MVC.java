/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_mvc;

import java.awt.*;
import javax.swing.*;
import Vista.*;

public class Proyecto_MVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
        
            //CD_Ingreso_Prod cd=new CD_Ingreso_Prod(new JFrame(),true);
            //cd.setVisible(true);
            new Ventana_Principal().setVisible(true);
        });
    }
    
}
