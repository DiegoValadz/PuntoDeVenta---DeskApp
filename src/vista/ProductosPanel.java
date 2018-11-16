/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

/**
 *
 * @author diego
 */
public class ProductosPanel extends CustomPanel {

    private JLabel lbBuscar;
    private JTextField buscarCampo;
    private CustomButton btnBuscar, btnAgregar, btnEditar, btnEliminar;
    private JPanel headBar;
    private JTable tabla;
    private JScrollPane scrollPane;
    private JScrollBar scrollBar;
    private String URL;

    public ProductosPanel(int x, int y, int widthP, int heigthP, LayoutManager lm) {
        super(x, y, widthP, heigthP, lm);
        setBounds(300, 0, 1000, 900);
        //Labels
        lbBuscar = new JLabel("   Introduzca el nombre del producto que desea buscar  ");
        lbBuscar.setForeground(Color.gray);
        lbBuscar.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 25));
        lbBuscar.setBounds(5, 10, 640, 30);
        //TextFiels
        buscarCampo = new JTextField(30);
        buscarCampo.setBounds(25, 40, 640, 30);
        //Buttons
        btnBuscar = new CustomButton("Buscar");
        btnBuscar.setFont(new Font("Tw Cen MT", Font.ITALIC, 25));
        btnBuscar.setBounds(670, 40, 120, 30);
        btnAgregar = new CustomButton("Agregar");
        btnAgregar.setFont(new Font("Tw Cen MT", Font.ITALIC, 25));
        btnAgregar.setBounds(770, 200, 120, 30);

        btnEditar = new CustomButton("Editar");
        btnEditar.setFont(new Font("Tw Cen MT", Font.ITALIC, 25));
        btnEditar.setBounds(770, 250, 120, 30);

        btnEliminar = new CustomButton("Eliminar");
        btnEliminar.setFont(new Font("Tw Cen MT", Font.ITALIC, 25));
        btnEliminar.setBounds(770, 300, 120, 30);

        //Table
        tabla = new JTable();
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();

        modelo.addColumn("Nombre");
        modelo.addColumn("ID");
        modelo.addColumn("Precio Venta");
        modelo.addColumn("Precio Compra");
        modelo.addColumn("Existencia");
        modelo.addColumn("Descripción");
        
        
        TableColumnModel tm = tabla.getColumnModel();
        tm.getColumn(5).setPreferredWidth(300);
        
        scrollPane = new JScrollPane(tabla);
        scrollPane.setBounds(25, 100, 740, 700);

        add(lbBuscar);
        add(buscarCampo);
        add(btnBuscar);
        add(btnAgregar);
        add(btnEditar);
        add(btnEliminar);
        add(scrollPane);
        
        
        URL = "C:\\Users\\diego\\Documents\\NetBeansProjects\\PuntoDeVenta\\src\\sources\\center_fondo.jpg";
        setImageBackground(URL);

    }

}
