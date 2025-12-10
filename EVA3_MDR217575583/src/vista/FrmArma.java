/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorArma;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Arma;

/**
 *
 * @author PCXX
 */
public class FrmArma extends JFrame {
    
    private JLabel lblTituloDatos;
    private JLabel lblNombre;
    private JLabel lblPrecision;
    
    private JTextField txtNombre;
    private JTextField txtPrecision;
    
    private JButton btnAgregar;
    private JButton btnLimpiar;
    private JButton btnVerRegistros;
    
    private JTable tblArmas;
    private DefaultTableModel modeloTabla;
    
    private ControladorArma controlador;
    
    public FrmArma() {
        inicializarComponentes();
        controlador = new ControladorArma();
        cargarTabla();
    }
    
    private void inicializarComponentes() {
        setTitle("EVALUACIÓN 3 - FORMA B");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750, 400);
        setLocationRelativeTo(null);
        setLayout(null); // diseño manual sencillo
        
        // Panel de datos de arma
        JPanel panelDatos = new JPanel();
        panelDatos.setLayout(null);
        panelDatos.setBounds(10, 10, 340, 330);
        add(panelDatos);
        
        lblTituloDatos = new JLabel("Datos de arma");
        lblTituloDatos.setBounds(10, 10, 200, 20);
        panelDatos.add(lblTituloDatos);
        
        lblNombre = new JLabel("NOMBRE:");
        lblNombre.setBounds(10, 50, 80, 20);
        panelDatos.add(lblNombre);
        
        txtNombre = new JTextField();
        txtNombre.setBounds(100, 50, 200, 25);
        panelDatos.add(txtNombre);
        
        lblPrecision = new JLabel("PRECISIÓN:");
        lblPrecision.setBounds(10, 90, 80, 20);
        panelDatos.add(lblPrecision);
        
        txtPrecision = new JTextField("0");
        txtPrecision.setBounds(100, 90, 80, 25);
        panelDatos.add(txtPrecision);
        
        btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(10, 140, 100, 30);
        panelDatos.add(btnAgregar);
        
        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(130, 140, 100, 30);
        panelDatos.add(btnLimpiar);
        
        // Panel de lista de armas
        JPanel panelLista = new JPanel();
        panelLista.setLayout(null);
        panelLista.setBounds(360, 10, 360, 330);
        add(panelLista);
        
        JLabel lblTituloLista = new JLabel("Armas disponibles");
        lblTituloLista.setBounds(10, 10, 200, 20);
        panelLista.add(lblTituloLista);
        
        btnVerRegistros = new JButton("Ver Registros");
        btnVerRegistros.setBounds(220, 10, 130, 25);
        panelLista.add(btnVerRegistros);
        
        // Tabla
        tblArmas = new JTable();
        modeloTabla = new DefaultTableModel(
                new Object[]{"ID", "NOMBRE", "PRECISIÓN"}, 0);
        tblArmas.setModel(modeloTabla);
        
        JScrollPane scroll = new JScrollPane(tblArmas);
        scroll.setBounds(10, 50, 340, 260);
        panelLista.add(scroll);
        
        // Eventos
        btnAgregar.addActionListener(e -> agregarArma());
        btnLimpiar.addActionListener(e -> limpiarCampos());
        btnVerRegistros.addActionListener(e -> cargarTabla());
    }
    
    private void agregarArma() {
        try {
            String nombre = txtNombre.getText().trim();
            double prec = Double.parseDouble(txtPrecision.getText().trim());
            
            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese el nombre del arma");
                return;
            }
            
            if (prec < 0 || prec > 1) {
                JOptionPane.showMessageDialog(this, "La precisión debe estar entre 0 y 1");
                return;
            }
            
            Arma a = new Arma(nombre, prec);
            
            if (controlador.agregar(a)) {
                JOptionPane.showMessageDialog(this, "Arma agregada correctamente");
                limpiarCampos();
                cargarTabla();
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo agregar el registro");
            }
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Precisión debe ser un número decimal (ej: 0.85)");
        }
    }
    
    private void limpiarCampos() {
        txtNombre.setText("");
        txtPrecision.setText("0");
        txtNombre.requestFocus();
    }
    
    private void cargarTabla() {
        modeloTabla.setRowCount(0); // limpia la tabla
        
        ArrayList<Arma> lista = controlador.listar();
        for (Arma a : lista) {
            Object[] fila = new Object[3];
            fila[0] = a.getId();
            fila[1] = a.getNombre();
            fila[2] = a.getPrecision();
            modeloTabla.addRow(fila);
        }
    }
}
