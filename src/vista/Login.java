/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import vista.buttons.CustomButton;
import vista.paneles.CustomPanel;
import controlador.LoginListener;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author diego
 */
public class Login {

    public JFrame ventana;
    private CustomPanel panel;
    private String URL;
    private JLabel lbImgUser, lbUser, lbPass;
    private Icon user;
    public JTextField userTxt;
    public JPasswordField passTxt;
    public CustomButton aceptar;
    private Font font;
    public ButtonGroup btnGroup;
    public JRadioButton adminOp, vendeOp;
    private LoginListener loginListener;

    public Login(VistaPrincipal vp) {
        //Frame
        ventana = new JFrame("Login");
        //Panel
        panel = new CustomPanel(0, 0, 600, 400, null);
        URL = "C:\\Users\\diego\\Documents\\NetBeansProjects\\PuntoDeVenta\\src\\sources\\fondo_login.jpg";
        panel.setImageBackground(URL);
        //Imagenes
        URL = "C:\\Users\\diego\\Documents\\NetBeansProjects\\PuntoDeVenta\\src\\sources\\user.jpg";
        user = new ImageIcon(URL);
        //Labels
        font = new Font("Nirmala UI", Font.PLAIN, 30);
        lbImgUser = new JLabel(user);
        lbUser = new JLabel("Usuario");
        lbPass = new JLabel("Contraseña");
        lbUser.setFont(font);
        lbUser.setForeground(Color.white);
        lbPass.setFont(font);
        lbPass.setForeground(Color.white);
        //TextFields
        userTxt = new JTextField();
        passTxt = new JPasswordField();
        //Buttons
        aceptar = new CustomButton("Aceptar");
        //RadioButtons
        adminOp = new JRadioButton("Administrador", true);
        adminOp.setSelected(true);
        vendeOp = new JRadioButton("Vendedor", false);
        btnGroup = new ButtonGroup();
        //Listeners
        loginListener = new LoginListener(this,vp);

        addComponents();
        launchFrame();
    }

    private void addComponents() {
        font = new Font("Nirmala UI", Font.PLAIN, 20);
        //Label de Imagen
        lbImgUser.setBounds(30, 30, 120, 120);
        //Label de Usuario
        lbUser.setBounds(180, 30, 150, 30);
        lbPass.setBounds(180, 120, 150, 30);
        //TextUsuario
        userTxt.setBounds(180, 70, 350, 30);
        userTxt.setOpaque(false);
        userTxt.setFont(font);
        userTxt.setForeground(Color.white);
        //TextContraseña
        passTxt.setBounds(180, 160, 350, 30);
        passTxt.setOpaque(false);
        passTxt.setFont(font);
        //Buttons
        font = new Font("Nirmala UI", Font.PLAIN, 30);
        aceptar.setFont(font);
        aceptar.setBackground(new Color(224, 224, 224));
        aceptar.setBounds(180, 230, 350, 40);
        aceptar.addActionListener(loginListener);
        //RadioButtons
        btnGroup.add(adminOp);
        btnGroup.add(vendeOp);
        adminOp.setBounds(200, 300, 120, 30);
        adminOp.setOpaque(false);
        adminOp.setFocusPainted(false);
        vendeOp.setBounds(400, 300, 100, 30);
        vendeOp.setOpaque(false);
        vendeOp.setFocusPainted(false);

        panel.add(adminOp);
        panel.add(vendeOp);
        panel.add(aceptar);
        panel.add(passTxt);
        panel.add(userTxt);
        panel.add(lbPass);
        panel.add(lbUser);
        panel.add(lbImgUser);
        ventana.add(panel);
    }

    public void launchFrame() {
        ventana.setUndecorated(true);
        ventana.setSize(600, 350);
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }

  

}
