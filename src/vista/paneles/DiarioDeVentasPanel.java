package vista.paneles;

import com.toedter.calendar.JDateChooser;
import controlador.ButtonsDiarioDVListener;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import vista.buttons.CustomButton;

public class DiarioDeVentasPanel extends CustomPanel {

    private JLabel lbBuscar, lbBuscar2, lbBuscar3, lbBuscar4;
    public JDateChooser fecha1, fecha2;
    public JTextField buscartxt;
    public JRadioButton rbtnVendedor, rbtnSucursal, rbtnProducto;
    public CustomButton btnBuscar;
    private Icon updateIcon, updatexIcon, updateIcon2, updatexIcon2, updateIcon3, updatexIcon3, updateIcon4, updatexIcon4;
    private JLabel updatelb, updatexlb, updatelb2, updatexlb2, updatelb3, updatexlb3, updatelb4, updatexlb4;
    private JPanel headBar;
    public JTable tabla;
    public DefaultTableModel modelo;
    private JScrollPane scrollPane;
    private JScrollBar scrollBar;
    private String URL;
    private ButtonGroup gruop1;
    private ButtonsDiarioDVListener bddvl; 

    public DiarioDeVentasPanel(int x, int y, int widthP, int heigthP, LayoutManager lm) {
        super(x, y, widthP, heigthP, lm);
        setBounds(300, 0, 1500, 1200);
        //Listener
        bddvl = new ButtonsDiarioDVListener(this);
        //Icons
        URL = "C:\\Users\\diego\\Documents\\NetBeansProjects\\PuntoDeVenta\\src\\sources\\update.png";
        updateIcon = new ImageIcon(URL);
        URL = "C:\\Users\\diego\\Documents\\NetBeansProjects\\PuntoDeVenta\\src\\sources\\updatex.png";
        updatexIcon = new ImageIcon(URL);
        //Labels
        updatelb = new JLabel(updateIcon);
        updatexlb = new JLabel(updatexIcon);
        lbBuscar = new JLabel("   Desde:  ");
        lbBuscar.setForeground(Color.gray);
        lbBuscar.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
        lbBuscar.setBounds(2, 30, 400, 30);
        //Label hasta
        updatelb2 = new JLabel(updateIcon2);
        updatexlb2 = new JLabel(updatexIcon2);
        lbBuscar2 = new JLabel("   Hasta:  ");
        lbBuscar2.setForeground(Color.gray);
        lbBuscar2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
        lbBuscar2.setBounds(290, 30, 400, 30);
        //
        updatelb3 = new JLabel(updateIcon3);
        updatexlb3 = new JLabel(updatexIcon3);
        lbBuscar3 = new JLabel("   Seleccione el rango de fecha:  ");
        lbBuscar3.setForeground(Color.gray);
        lbBuscar3.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
        lbBuscar3.setBounds(2, 1, 400, 30);
        //
        updatelb4 = new JLabel(updateIcon4);
        updatexlb4 = new JLabel(updatexIcon4);
        lbBuscar4 = new JLabel("   Consultar por:  ");
        lbBuscar4.setForeground(Color.gray);
        lbBuscar4.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
        lbBuscar4.setBounds(2, 70, 400, 30);
        
        //TextFields
        buscartxt = new JTextField(30);
        buscartxt.setBounds(160, 70, 150, 30);
        
        
        
        //DataChooser

        fecha1 = new JDateChooser();
        fecha1.getJCalendar().setTodayButtonVisible(true);
        fecha1.setBounds(90, 35, 200, 30);

        fecha2 = new JDateChooser();
        fecha2.getJCalendar().setTodayButtonVisible(true);
        
        fecha2.setBounds(370, 35, 200, 30);
        //radioButton
        rbtnVendedor = new JRadioButton("Vendedor", true);
        rbtnVendedor.setBounds(20, 110, 100, 30);

        rbtnSucursal = new JRadioButton("Sucursal", false);
        rbtnSucursal.setSelected(false);
        rbtnSucursal.setBounds(220, 110, 100, 30);

        rbtnProducto = new JRadioButton("Producto", false);
        rbtnProducto.setSelected(false);
        rbtnProducto.setBounds(425, 110, 100, 30);
        //ButtonsGroup
        gruop1 = new ButtonGroup();
        gruop1.add(rbtnVendedor);
        gruop1.add(rbtnSucursal);
        gruop1.add(rbtnProducto);
        //Button
        btnBuscar = new CustomButton("Buscar");
        btnBuscar.setFont(new Font("Tw Cen MT", Font.ITALIC, 25));
        btnBuscar.setBounds(770, 100, 120, 30);
        btnBuscar.addActionListener(bddvl);

        //Table
        tabla = new JTable();
        modelo = (DefaultTableModel) tabla.getModel();

        modelo.addColumn("Folio");
        modelo.addColumn("Fecha");
        modelo.addColumn("Hora");
        modelo.addColumn("Sucursal");
        modelo.addColumn("Vendedor");
        modelo.addColumn("Id_producto");
        modelo.addColumn("Nombre");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Costo Unitario");
        modelo.addColumn("Subtotal");
        modelo.addColumn("Iva");
        modelo.addColumn("Total");

        TableColumnModel tm = tabla.getColumnModel();
        tm.getColumn(5).setPreferredWidth(300);
        tm.getColumn(1).setPreferredWidth(270);

        //Utilities.setUpTableData(this);
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        scrollPane = new JScrollPane(tabla, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(25, 150, 870, 700);

        add(lbBuscar);
        add(lbBuscar2);
        add(lbBuscar3);
        add(lbBuscar4);
        add(fecha1);
        add(fecha2);
        add(btnBuscar);
        add(rbtnVendedor);
        add(rbtnSucursal);
        add(rbtnProducto);
        add(scrollPane);
        add(buscartxt);

        URL = "C:\\Users\\diego\\Documents\\NetBeansProjects\\PuntoDeVenta\\src\\sources\\center_fondo.jpg";
        setImageBackground(URL);

    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.add(new DiarioDeVentasPanel(0, 0, 1300, 1200, null));
        f.setVisible(true);
        f.setSize(1300, 1200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
