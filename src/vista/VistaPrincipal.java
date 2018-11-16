package vista;

import controlador.CloseListener;
import controlador.ButtonsListener;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author diego
 */
public class VistaPrincipal {

    public JFrame ventana;
    private CustomTitleBar titleBar;
    public CustomPanel leftPanel, centerPanel;
    public CustomButton btn1, btn2, btn3, btn4, btn5;
    private Icon imgBanner, imgVentas, imgProductos, imgEmpleados, imgAjustes;
    private Icon imgVentasX, imgProductosX, imgEmpleadosX, imgAjustesX;
    private Icon mini, exit;
    public JLabel banner, lpFondo, imgMini, imgExit;
    private ButtonsListener leftListener;
    private CloseListener closeListener;
    private String URL;

    public VistaPrincipal(String nombre) {
        //Login 
        Login login = new Login(this);        
        //Frame
        ventana = new JFrame("Aplicación Ingeniería de Software");
        ventana.getContentPane().setLayout(null);
        //Paneles
        leftPanel = new CustomPanel(0, 0, 300, 900, null);
        centerPanel = new CustomPanel(0, 0, 1300, 900, null);
        titleBar = new CustomTitleBar();
        URL = "C:\\Users\\diego\\Documents\\NetBeansProjects\\PuntoDeVenta\\src\\sources\\fondolp.jpg";
        centerPanel.setImageBackground(URL);
        //Imagenes estaticas 
        URL = "C:\\Users\\diego\\Documents\\NetBeansProjects\\PuntoDeVenta\\src\\sources\\banner.jpg";
        imgBanner = new ImageIcon(URL);
        URL = "C:\\Users\\diego\\Documents\\NetBeansProjects\\PuntoDeVenta\\src\\sources\\prod_img.png";
        imgProductos = new ImageIcon(URL);
        URL = "C:\\Users\\diego\\Documents\\NetBeansProjects\\PuntoDeVenta\\src\\sources\\ventas_img.png";
        imgVentas = new ImageIcon(URL);
        URL = "C:\\Users\\diego\\Documents\\NetBeansProjects\\PuntoDeVenta\\src\\sources\\emp_img.png";
        imgEmpleados = new ImageIcon(URL);
        URL = "C:\\Users\\diego\\Documents\\NetBeansProjects\\PuntoDeVenta\\src\\sources\\set_img.png";
        imgAjustes = new ImageIcon(URL);
        URL = "C:\\Users\\diego\\Documents\\NetBeansProjects\\PuntoDeVenta\\src\\sources\\mini.png";
        mini = new ImageIcon(URL);
        URL = "C:\\Users\\diego\\Documents\\NetBeansProjects\\PuntoDeVenta\\src\\sources\\exit.png";
        exit = new ImageIcon(URL);
        //Imagenes Rollover 
        URL = "C:\\Users\\diego\\Documents\\NetBeansProjects\\PuntoDeVenta\\src\\sources\\prod_imgx.png";
        imgProductosX = new ImageIcon(URL);
        URL = "C:\\Users\\diego\\Documents\\NetBeansProjects\\PuntoDeVenta\\src\\sources\\ventas_imgx.png";
        imgVentasX = new ImageIcon(URL);
        URL = "C:\\Users\\diego\\Documents\\NetBeansProjects\\PuntoDeVenta\\src\\sources\\emp_imgx.png";
        imgEmpleadosX = new ImageIcon(URL);
        URL = "C:\\Users\\diego\\Documents\\NetBeansProjects\\PuntoDeVenta\\src\\sources\\set_imgx.png";
        imgAjustesX = new ImageIcon(URL);
        //Labels
        banner = new JLabel(imgBanner);
        imgMini = new JLabel(mini);
        imgExit = new JLabel(exit);

        //Botones
        btn1 = new CustomButton(" Productos", imgProductos,imgProductosX);
        btn2 = new CustomButton("   Ventas   ", imgVentas,imgVentasX);
        btn3 = new CustomButton("Empleados", imgEmpleados,imgEmpleadosX);
        btn4 = new CustomButton("   Ajustes    ", imgAjustes,imgAjustesX);
        
        //Listener
        leftListener = new ButtonsListener(this);
        closeListener = new CloseListener(this);

        addComponents();
        launchFrame();
    }

    public void addComponents() {      
        //Panel Izquierda
        URL = "C:\\Users\\diego\\Documents\\NetBeansProjects\\PuntoDeVenta\\src\\sources\\lpfondo2.png";
        leftPanel.setImageBackground(URL);
        leftPanel.setBounds(0, 0, 300, 900);
        //Panel centro
        centerPanel.setBounds(300, 0, 1000, 900);
        //centerPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        //Banner
        leftPanel.add(banner);
        banner.setBounds(0, 0, 300, 180);
        //Botones     
        btn1.addActionListener(leftListener);
        leftPanel.add(btn1);
        btn1.setBounds(0, 210, 300, 100);
        leftPanel.add(btn2);
        btn2.setBounds(0, 320, 300, 100);
        leftPanel.add(btn3);
        btn3.setBounds(0, 430, 300, 100);
        leftPanel.add(btn4);
        btn4.setBounds(0, 540, 300, 100);
        //Imagenes de Menu
        imgMini.setBounds(1230, 0, 25,25);    
        imgExit.addMouseListener(closeListener);
             
        imgExit.setBounds(1260, 0, 25,25);
        //ventana.add(imgMini);
        //ventana.add(imgExit);
        //ventana.add(titleBar);
        ventana.add(centerPanel);
        ventana.add(leftPanel);

    }

    public void launchFrame() {
        //ventana.setUndecorated(true);
        URL = "C:\\Users\\diego\\Documents\\NetBeansProjects\\PuntoDeVenta\\src\\sources\\iconframe.png";
        Image retValue = Toolkit.getDefaultToolkit().createImage(URL);
        ventana.setIconImage(retValue);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(1300, 900);
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(false);
    }
    
    public static void main(String[] args) {
        new VistaPrincipal("App");
    }

  
}