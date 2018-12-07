/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.paneles;
import controlador.ButtonAjustesListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import vista.VistaPrincipal;
import vista.buttons.CustomButton;
/**
 *
 * @author diego
 */
public class AjustesPanel extends CustomPanel{
    
    private JLabel lbTipo,lbNombre,lbTitulo,lbUsuario,lbEmail,lbImagen,lbTelefono;
    private JLabel lbTipoRes,lbNombreRes,lbUsuarioRes,lbEmailRes,lbTelefonoRes; 
    public CustomButton btnCerrar;
    private Icon updateIcon, updatexIcon;
    private JLabel updatelb, updatexlb;
    private String URL;
    private ButtonAjustesListener bal;

    public AjustesPanel(int x, int y, int widthP, int heigthP, LayoutManager lm,VistaPrincipal vp) {
        super(x, y, widthP, heigthP, lm);
        setBounds(300, 0, 1500, 1200);
       //Listeners
       bal = new ButtonAjustesListener(vp);
        //Icons
        URL = "C:\\Users\\diego\\Documents\\NetBeansProjects\\PuntoDeVenta\\src\\sources\\update.png";
        updateIcon = new ImageIcon(URL);
        URL = "C:\\Users\\diego\\Documents\\NetBeansProjects\\PuntoDeVenta\\src\\sources\\updatex.png";
        updatexIcon = new ImageIcon(URL);
        //Labels
        updatelb = new JLabel(updateIcon);
        updatexlb = new JLabel(updatexIcon);
        lbTipo = new JLabel("   Tipo:  ");
        lbTipo.setForeground(Color.gray);
        lbTipo.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
        lbTipo.setBounds(400, 160, 400, 30);
        
        updatelb = new JLabel(updateIcon);
        updatexlb = new JLabel(updatexIcon);
        lbTipoRes = new JLabel("   ResultadoTipo" );
        lbTipoRes.setForeground(Color.gray);
        lbTipoRes.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
        lbTipoRes.setBounds(510, 160, 400, 30);
        
        updatelb = new JLabel(updateIcon);
        updatexlb = new JLabel(updatexIcon);
        lbNombre = new JLabel("   Nombre:  ");
        lbNombre.setForeground(Color.gray);
        lbNombre.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
        lbNombre.setBounds(400, 200, 400, 30);
        
        updatelb = new JLabel(updateIcon);
        updatexlb = new JLabel(updatexIcon);
        lbNombreRes = new JLabel("   ResultadoNombre");
        lbNombreRes.setForeground(Color.gray);
        lbNombreRes.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
        lbNombreRes.setBounds(510, 200, 600, 30);
        
        updatelb = new JLabel(updateIcon);
        updatexlb = new JLabel(updatexIcon);
        lbTitulo = new JLabel("   Mi cuenta  ");
        lbTitulo.setForeground(Color.gray);
        lbTitulo.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 50));
        lbTitulo.setBounds(270, 50, 400, 60);
        
        updatelb = new JLabel(updateIcon);
        updatexlb = new JLabel(updatexIcon);
        lbUsuario = new JLabel("   Usuario:  ");
        lbUsuario.setForeground(Color.gray);
        lbUsuario.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
        lbUsuario.setBounds(400, 120, 400, 30);
        
        updatelb = new JLabel(updateIcon);
        updatexlb = new JLabel(updatexIcon);
        lbUsuarioRes = new JLabel("   ResultadoUsuario:  ");
        lbUsuarioRes.setForeground(Color.gray);
        lbUsuarioRes.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
        lbUsuarioRes.setBounds(510, 120, 200, 30);
        
        updatelb = new JLabel(updateIcon);
        updatexlb = new JLabel(updatexIcon);
        lbEmail = new JLabel("   Email:  ");
        lbEmail.setForeground(Color.gray);
        lbEmail.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
        lbEmail.setBounds(400, 240, 400, 30);
        
        updatelb = new JLabel(updateIcon);
        updatexlb = new JLabel(updatexIcon);
        lbEmailRes = new JLabel("   ResultadoEmail:  ");
        lbEmailRes.setForeground(Color.gray);
        lbEmailRes.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
        lbEmailRes.setBounds(510, 240, 200, 30);
        
        updatelb = new JLabel(updateIcon);
        updatexlb = new JLabel(updatexIcon);
        lbImagen = new JLabel("   imagenRuta:  ");
        lbImagen.setForeground(Color.gray);
        lbImagen.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
        lbImagen.setBounds(200, 120, 200, 200);
        lbImagen.setIcon(new ImageIcon("C:\\Users\\MTZ\\Desktop\\corel\\peliculas\\750903659191.jpg"));
        
        updatelb = new JLabel(updateIcon);
        updatexlb = new JLabel(updatexIcon);
        lbTelefono = new JLabel("   Telefono:  ");
        lbTelefono.setForeground(Color.gray);
        lbTelefono.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
        lbTelefono.setBounds(400, 280, 400, 30);
        
        updatelb = new JLabel(updateIcon);
        updatexlb = new JLabel(updatexIcon);
        lbTelefonoRes = new JLabel("   ResultadoTelefono:  ");
        lbTelefonoRes.setForeground(Color.gray);
        lbTelefonoRes.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
        lbTelefonoRes.setBounds(510, 280, 220, 30);

        //Button
        btnCerrar = new CustomButton("Cerrar Sesión");
        btnCerrar.setFont(new Font("Tw Cen MT", Font.ITALIC, 25));
        btnCerrar.setBounds(300, 380, 320, 30);
        btnCerrar.addActionListener(bal);
        


        add(lbTipo);
        add(lbTipoRes);
        add(lbNombre);
        add(lbNombreRes);
        add(lbTitulo);
        add(lbUsuario);
        add(lbUsuarioRes);
        add(lbEmail);
        add(lbEmailRes);
        add(lbImagen);
        add(lbTelefono);
        add(lbTelefonoRes);
        add(lbTipoRes);
        add(btnCerrar);
        
        URL = "C:\\Users\\diego\\Documents\\NetBeansProjects\\PuntoDeVenta\\src\\sources\\center_fondo.jpg";
        setImageBackground(URL);

    }
    /*
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.add(new AjustesPanel(0, 0, 1300, 1200, null));
        f.setVisible(true);
        f.setSize(1300, 1200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
    }*/

    
}