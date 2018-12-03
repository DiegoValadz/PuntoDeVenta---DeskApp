/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.paneles;

import controlador.ButtonsProductosListener;
import controlador.ButtonsUsuariosListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import utilities.Utilities;
import vista.buttons.CustomButton;

/**
 *
 * @author diego
 */
public class UsuariosPanel extends CustomPanel {

    private JLabel lbBuscar;
    private JTextField buscarCampo;
    public CustomButton btnBuscar, btnAgregar, btnEditar, btnEliminar, btnActua;
    private Icon updateIcon, updatexIcon;
    private JLabel updatelb, updatexlb;
    private JPanel headBar;
    public JTable tabla;
    public DefaultTableModel modelo;
    private ButtonsUsuariosListener bul;
    private JScrollPane scrollPane;
    private JScrollBar scrollBar;
    private String URL;

    public UsuariosPanel(int x, int y, int widthP, int heigthP, LayoutManager lm) {
        super(x, y, widthP, heigthP, lm);
        setBounds(300, 0, 1500, 1200);
        //Icons
        URL = "C:\\Users\\diego\\Documents\\NetBeansProjects\\PuntoDeVenta\\src\\sources\\update.png";
        updateIcon = new ImageIcon(URL);
        URL = "C:\\Users\\diego\\Documents\\NetBeansProjects\\PuntoDeVenta\\src\\sources\\updatex.png";
        updatexIcon = new ImageIcon(URL);
        //Labels
        updatelb = new JLabel(updateIcon);
        updatexlb = new JLabel(updatexIcon);
        lbBuscar = new JLabel("   Introduzca el usuario que desea buscar  ");
        lbBuscar.setForeground(Color.gray);
        lbBuscar.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 25));
        lbBuscar.setBounds(5, 10, 640, 30);
        //TextFiels
        buscarCampo = new JTextField(30);
        buscarCampo.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
        buscarCampo.setBounds(25, 40, 870, 30);
        //Listeners
        bul = new ButtonsUsuariosListener(this);
        //Buttons
        btnBuscar = new CustomButton("Buscar");
        btnBuscar.setFont(new Font("Tw Cen MT", Font.ITALIC, 25));
        btnBuscar.setBounds(925, 40, 120, 30);
        btnAgregar = new CustomButton("Agregar");
        btnAgregar.setFont(new Font("Tw Cen MT", Font.ITALIC, 25));
        btnAgregar.setBounds(925, 200, 120, 30);
        btnAgregar.addActionListener(bul);

        btnEditar = new CustomButton("Editar");
        btnEditar.setFont(new Font("Tw Cen MT", Font.ITALIC, 25));
        btnEditar.setBounds(925, 250, 120, 30);
        btnEditar.addActionListener(bul);

        btnEliminar = new CustomButton("Eliminar");
        btnEliminar.setFont(new Font("Tw Cen MT", Font.ITALIC, 25));
        btnEliminar.setBounds(925, 300, 120, 30);
        btnEliminar.addActionListener(bul);

        btnActua = new CustomButton("", updateIcon, updatexIcon);
        btnActua.setFont(new Font("Tw Cen MT", Font.ITALIC, 25));
        btnActua.setBounds(940, 820, 80, 80);
        btnActua.addActionListener(bul);

        //Table
        tabla = new JTable();
        modelo = (DefaultTableModel) tabla.getModel();

        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Usuario");
        modelo.addColumn("Tipo");
        modelo.addColumn("Direccion");
        modelo.addColumn("Ciudad");
        modelo.addColumn("Estado");
        modelo.addColumn("CP");
        modelo.addColumn("Telefono");
        modelo.addColumn("E-mail");

        TableColumnModel tm = tabla.getColumnModel();
        tm.getColumn(9).setPreferredWidth(250);
        Utilities.setUpTableData(this);
       tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        scrollPane = new JScrollPane(tabla, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(25, 100, 870, 800);

        add(lbBuscar);
        add(buscarCampo);
        add(btnBuscar);
        add(btnAgregar);
        add(btnEditar);
        add(btnActua);
        add(btnEliminar);
        add(scrollPane);

        URL = "C:\\Users\\diego\\Documents\\NetBeansProjects\\PuntoDeVenta\\src\\sources\\center_fondo.jpg";
        setImageBackground(URL);

    }

   
}
