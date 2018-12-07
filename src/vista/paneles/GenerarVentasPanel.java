/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.paneles;

import com.toedter.calendar.JDateChooser;
import controlador.ButtonGVentaListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import service.UsuariosCliente;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import modelo.Producto;
import modelo.Usuario;
import modelo.Venta;
import vista.buttons.CustomButton;
import utilities.Utilities;

/**
 *
 * @author diego
 */
public class GenerarVentasPanel extends CustomPanel {

    public JLabel foliolb, fechalb, horalb, prodAgreglb, vendedorlb, productolb;
    public JLabel cantidadlb, cantidadmaxlb, prodAddlb, subtotallb, totallb, ivalb;
    public JLabel sucursallb;
    public JTextField foliotxt, fechatxt, horatxt, canttxt, sucursaltxt,vendedortxt;
    public JDateChooser dateChooser;
    public JComboBox vendedor, producto;
    public JScrollPane scrollPane;
    public JList productosJList;
    public ArrayList<Producto> prods;
    public ArrayList<Usuario> users;
    public Producto productoActual;
    public Usuario vendedorActual;
    public Venta venta;
    public CustomButton agregarbtn, quitarbtn, generarbtn, incbtn, decbtn;
    private ButtonGVentaListener bgvl;
    public String idVendedor="";

    public GenerarVentasPanel(int x, int y, int widthP, int heigthP, LayoutManager lm) {
        super(x, y, widthP, heigthP, lm);
        setBounds(300, 0, 1500, 1200);
        //Models
        venta = new Venta();
        //DateChooser
        dateChooser = new JDateChooser();
        dateChooser.setBounds(420, 40, 370, 30);
        dateChooser.getJCalendar().setTodayButtonVisible(true);
        //Listeners
        bgvl = new ButtonGVentaListener(this);
        //ComboBox
        vendedor = new JComboBox();
        vendedor.setBounds(20, 120, 370, 30);

        producto = new JComboBox();
        producto.setBounds(420, 120, 370, 30);
        // producto.addItemListener(gvcl);

        //Labels
        foliolb = new JLabel("Folio ");
        foliolb.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 25));
        foliolb.setBounds(20, 10, 140, 30);

        sucursallb = new JLabel("Sucursal ");
        sucursallb.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 25));
        sucursallb.setBounds(210, 10, 180, 30);

        fechalb = new JLabel("Fecha ");
        fechalb.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 25));
        fechalb.setBounds(420, 10, 140, 30);

        horalb = new JLabel("Hora ");
        horalb.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 25));
        horalb.setBounds(820, 10, 120, 30);

        vendedorlb = new JLabel("Vendedor ");
        vendedorlb.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 25));
        vendedorlb.setBounds(20, 90, 140, 30);

        productolb = new JLabel("Producto ");
        productolb.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 25));
        productolb.setBounds(420, 90, 140, 30);

        cantidadlb = new JLabel("Cantidad ");
        cantidadlb.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 25));
        cantidadlb.setBounds(820, 90, 120, 30);

        cantidadmaxlb = new JLabel("Max: ");
        cantidadmaxlb.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
        cantidadmaxlb.setBounds(820, 120, 370, 30);

        prodAddlb = new JLabel("Productos Agregados: ");
        prodAddlb.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 25));
        prodAddlb.setBounds(20, 160, 370, 30);

        ivalb = new JLabel("IVA: ");
        ivalb.setBounds(820, 200, 120, 30);

        subtotallb = new JLabel("Sub Total: ");
        subtotallb.setBounds(820, 220, 120, 30);

        totallb = new JLabel("Total: ");
        totallb.setBounds(820, 240, 120, 30);

        //TextFields
        foliotxt = new JTextField(30);
        foliotxt.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
        foliotxt.setBounds(20, 40, 160, 30);

        sucursaltxt = new JTextField(30);
        sucursaltxt.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
        sucursaltxt.setBounds(210, 40, 180, 30);

        horatxt = new JTextField(30);
        horatxt.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
        horatxt.setBounds(820, 40, 270, 30);

        canttxt = new JTextField(30);
        canttxt.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
        canttxt.setBounds(820, 160, 150, 30);
          
        vendedortxt = new JTextField(30);
        vendedortxt.setBounds(20, 120, 370, 30);

        //Buttons 
        incbtn = new CustomButton("+");
        incbtn.setBounds(980, 160, 45, 30);

        decbtn = new CustomButton("-");
        decbtn.setBounds(1035, 160, 45, 30);

        agregarbtn = new CustomButton("Agregar");
        agregarbtn.setBounds(980, 120, 100, 30);
        agregarbtn.addActionListener(bgvl);

        generarbtn = new CustomButton("Generar Venta");
        generarbtn.setBounds(820, 270, 260, 30);
        generarbtn.addActionListener(bgvl);

        quitarbtn = new CustomButton("Remover Producto");
        quitarbtn.setBounds(820, 820, 170, 30);

        //JList
        //Panel
        scrollPane = new JScrollPane(productosJList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(20, 200, 770, 650);
        fillComboBoxes();

        add(foliolb);
        add(foliotxt);
        add(fechalb);
        add(dateChooser);
        add(horalb);
        add(horatxt);
        add(vendedorlb);
       // add(vendedor);
       add(vendedortxt);
        add(productolb);
        add(producto);
        add(cantidadlb);
        add(canttxt);
        add(cantidadmaxlb);
        add(incbtn);
        add(decbtn);
        add(agregarbtn);
        add(prodAddlb);
        add(scrollPane);
        add(subtotallb);
        add(ivalb);
        add(totallb);
        add(generarbtn);
        add(quitarbtn);
        add(sucursallb);
        add(sucursaltxt);

    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.add(new GenerarVentasPanel(0, 0, 1300, 1200, null));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1400, 1000);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public void fillComboBoxes() {
        prods = new ArrayList<>();
        users = new ArrayList<>();

        users = Utilities.vendedores;
        prods = Utilities.productos;
        try {
            String[] data = new String[prods.size() + 1];
            for (int i = 0; i < prods.size(); i++) {
                data[i] = prods.get(i)._id;

            }
            producto = new JComboBox(data);
            producto.setBounds(420, 120, 370, 30);
            producto.setSelectedIndex(0);
            obtenerProductoActual(producto.getSelectedIndex());
            producto.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent ie) {
                    if (ie.getStateChange() == ItemEvent.SELECTED) {
                        remove(cantidadmaxlb);
                        obtenerProductoActual(producto.getSelectedIndex());
                        cantidadmaxlb = new JLabel("Max: " + String.valueOf(productoActual.getExistencia()));
                        cantidadmaxlb.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 15));
                        cantidadmaxlb.setBounds(820, 120, 370, 30);
                        add(cantidadmaxlb);
                        repaint();
                    }
                }
            });
        } catch (Exception e) {

        }

        try {
            String[] data2 = new String[users.size()];

            for (int i = 0; i < users.size(); i++) {
                data2[i] = users.get(i)._id;

            }

            vendedor = new JComboBox(data2);
            vendedor.setSelectedIndex(0);

            vendedor.setBounds(20, 120, 370, 30);
            
            vendedor.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent ie) {
                   if (ie.getStateChange() == ItemEvent.SELECTED) {
                     obtenerVendedorActual(vendedor.getSelectedIndex());
                    }
                }

              
            });

        } catch (Exception e) {

        }

    }

    public void fillJList() {

        String[] data = new String[venta.getProductosList().size()];
        System.out.println(venta.getProductosList().size());
        for (int i = 0; i < venta.getProductosList().size(); i++) {
            data[i] = ("ID: " + venta.getProductosList().get(i)._id
                    + " /tNombre: " + venta.getProductosList().get(i).getNombre()
                    + " /tPrecio Unitario: " + venta.getProductosList().get(i).getPrecioVenta());
        }
        productosJList = new JList(data);
        remove(scrollPane);
        scrollPane = new JScrollPane(productosJList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(20, 200, 770, 650);
        add(scrollPane);

        repaint();
    }

    public void updateSell() {

        remove(subtotallb);
        remove(ivalb);
        remove(totallb);

        ivalb = new JLabel("IVA: " + venta.getIva());
        ivalb.setBounds(820, 200, 120, 30);

        subtotallb = new JLabel("Sub Total: " + venta.getSubtotal());
        subtotallb.setBounds(820, 220, 120, 30);

        totallb = new JLabel("Total: " + venta.getTotal());
        totallb.setBounds(820, 240, 120, 30);

        add(subtotallb);
        add(ivalb);
        add(totallb);

    }

    public void obtenerProductoActual(int index) {
        //for (int i = 0; i < prods.size(); i++) {
        //if(id.equals(prods.get(i)._id)){
        if (index != -1) {
            productoActual = prods.get(index);
        }
    }
      public void obtenerVendedorActual(int selectedIndex) {
                
      if (selectedIndex != -1) {
            vendedorActual = users.get(selectedIndex);
        }
      }

}
