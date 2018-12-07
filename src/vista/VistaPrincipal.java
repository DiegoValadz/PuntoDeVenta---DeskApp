package vista;

import vista.buttons.CustomButton;
import vista.paneles.CustomPanel;
import controlador.CloseListener;
import controlador.ButtonsNavListener;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import utilities.GetProductosThread;
import utilities.GetUsuariosThread;
import utilities.GetVendedoresThread;
import utilities.MyValidator;
import utilities.Utilities;

/**
 *
 * @author diego
 */
public class VistaPrincipal implements MyValidator{

    public JFrame ventana;
    private CustomTitleBar titleBar;
    public CustomPanel leftPanel, centerPanel;
    public JTabbedPane tp;
    public CustomButton btn1, btn2, btn3, btn4, btn5;
    private Icon imgBanner, imgVentas, imgProductos, imgEmpleados, imgAjustes;
    private Icon imgVentasX, imgProductosX, imgEmpleadosX, imgAjustesX;
    private Icon mini, exit;
    public JLabel banner, lpFondo, imgMini, imgExit;
    private ButtonsNavListener leftListener;
    private CloseListener closeListener;
    private String URL;
    

    public VistaPrincipal(String nombre) {
       
        //Login 
        Login login = new Login(this);
        //Frame
        ventana = new JFrame("Aplicación Ingeniería de Software");
        ventana.getContentPane().setLayout(null);
        Utilities.frameGlobal = ventana;
        
        //Paneles
        leftPanel = new CustomPanel(0, 0, 300, 1200, null);
        centerPanel = new CustomPanel(0, 0, 1500, 1200, null);
        tp = new JTabbedPane();
        titleBar = new CustomTitleBar();

        //Imagenes estaticas 
        URL = "C:\\Users\\diego\\Documents\\NetBeansProjects\\PuntoDeVenta\\src\\sources\\bannerdef.jpg";
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
        btn1 = new CustomButton(" Productos", imgProductos, imgProductosX);
        btn2 = new CustomButton("   Ventas   ", imgVentas, imgVentasX);
        btn3 = new CustomButton("  Usuarios ", imgEmpleados, imgEmpleadosX);
        btn4 = new CustomButton("   Ajustes    ", imgAjustes, imgAjustesX);

        //Listener
        leftListener = new ButtonsNavListener(this);
        closeListener = new CloseListener(this);
        addComponents();
        launchFrame();
    }

    public void addComponents() {
        //Panel Izquierda
        URL = "C:\\Users\\diego\\Documents\\NetBeansProjects\\PuntoDeVenta\\src\\sources\\drawer3.png";
        leftPanel.setImageBackground(URL);
        leftPanel.setBounds(0, 0, 300, 1200);
        //Panel centro
        URL = "C:\\Users\\diego\\Documents\\NetBeansProjects\\PuntoDeVenta\\src\\sources\\center_fondo2.jpg";
        centerPanel.setImageBackground(URL);
        centerPanel.setBounds(300, 0, 1500, 1200);
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
        btn2.addActionListener(leftListener);
        leftPanel.add(btn3);
        btn3.setBounds(0, 430, 300, 100);
        btn3.addActionListener(leftListener);
        leftPanel.add(btn4);
        btn4.setBounds(0, 540, 300, 100);
        btn4.addActionListener(leftListener);
        //Imagenes de Menu
        imgMini.setBounds(1230, 0, 25, 25);
        imgExit.addMouseListener(closeListener);

        imgExit.setBounds(1260, 0, 25, 25);
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
        ventana.setSize(1400, 1000);
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(false);
    }

    public static void main(String[] args) {
        GetUsuariosThread usersSvc = new GetUsuariosThread();
        GetProductosThread prodSvc = new GetProductosThread();
        GetVendedoresThread vendedoresSvc = new GetVendedoresThread();
        
        usersSvc.start();
        prodSvc.start();
        vendedoresSvc.start();

                
        new VistaPrincipal("App");
    }

    public void validarFunciones(String tipo) {
        System.out.println("Viene: "+tipo+"Tengo: "+Utilities.VEND);
        if(Utilities.usuarioActual.getTipo().equals(Utilities.VEND)){
            btn3.setEnabled(false);
        }
    }

}
