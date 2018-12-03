/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.paneles;

import controlador.ButtonWinProdListener;
import controlador.ButtonWinUserListener;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import vista.VistaPrincipal;
import vista.buttons.CustomButton;
import javax.swing.JPanel;
import utilities.Utilities;

/**
 *
 * @author diego
 */
public class ModifiUserPanel extends JPanel {

    private JLabel headlb, nombrelb, idlb, usuariolb, passlb, tipolb, direcclb;
    private JLabel ciudadlb, estadolb, cplb, tellb, emaillb;
    public JTextField nombretxt, idtxt, usuariotxt, passtxt, direcctxt;
    public JTextField ciudadtxt, estadotxt, cptxt, teltxt, emailtxt;
    private String[] tipos = {Utilities.ADMIN, Utilities.VEND, Utilities.CLIENT};
    public JComboBox tiposList;
    private ButtonWinUserListener bwul;
    public CustomButton userbtn, cancel, userbtn2;
    public static final int ADD = 0;
    public static final int UPDATE = 1;
    public static int s;
    private String URL;

    public ModifiUserPanel(String msg) {

        setLayout(null);
        setBackground(new Color(224, 224, 224));
        //ComoBox
        tiposList = new JComboBox(tipos);
        tiposList.setBounds(500, 180, 170, 30);
        //Labels
        Font font = new Font("Yu Gothic UI Semibold", Font.BOLD, 15);

        headlb = new JLabel(msg);
        headlb.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
        headlb.setForeground(Color.black);
        headlb.setBounds(20, 5, 400, 30);

        nombrelb = new JLabel("Nombre");
        nombrelb.setFont(font);
        nombrelb.setBounds(20, 90, 400, 30);

        idlb = new JLabel("ID");
        idlb.setFont(font);
        idlb.setBounds(20, 35, 400, 30);

        usuariolb = new JLabel("Usuario");
        usuariolb.setFont(font);
        usuariolb.setBounds(20, 150, 200, 30);

        passlb = new JLabel("Contraseña");
        passlb.setFont(font);
        passlb.setBounds(260, 150, 250, 30);

        tipolb = new JLabel("Tipo");
        tipolb.setFont(font);
        tipolb.setBounds(500, 150, 200, 30);

        direcclb = new JLabel("Dirección");
        direcclb.setFont(font);
        direcclb.setBounds(20, 210, 250, 30);

        ciudadlb = new JLabel("Ciudad");
        ciudadlb.setFont(font);
        ciudadlb.setBounds(500, 210, 200, 30);

        estadolb = new JLabel("Estado");
        estadolb.setFont(font);
        estadolb.setBounds(20, 270, 200, 30);

        cplb = new JLabel("Código Postal");
        cplb.setFont(font);
        cplb.setBounds(260, 270, 250, 30);

        tellb = new JLabel("Telefono");
        tellb.setFont(font);
        tellb.setBounds(500, 270, 200, 30);

        emaillb = new JLabel("E-Mail");
        emaillb.setFont(font);
        emaillb.setBounds(20, 330, 400, 30);

        //TextFields
        nombretxt = new JTextField(100);
        nombretxt.setBounds(20, 120, 400, 30);

        idtxt = new JTextField(100);
        idtxt.setBounds(20, 60, 400, 30);

        usuariotxt = new JTextField(100);
        usuariotxt.setBounds(20, 180, 200, 30);

        passtxt = new JTextField(100);
        passtxt.setBounds(260, 180, 200, 30);

        direcctxt = new JTextField(100);
        direcctxt.setBounds(20, 240, 450, 30);

        ciudadtxt = new JTextField(100);
        ciudadtxt.setBounds(500, 240, 170, 30);

        estadotxt = new JTextField(100);
        estadotxt.setBounds(20, 300, 200, 30);

        cptxt = new JTextField(100);
        cptxt.setBounds(260, 300, 200, 30);

        teltxt = new JTextField(100);
        teltxt.setBounds(500, 300, 170, 30);

        emailtxt = new JTextField(100);
        emailtxt.setBounds(20, 360, 400, 30);

        //Listeners
        bwul = new ButtonWinUserListener(this);
        //Buttons
        userbtn = new CustomButton("Agregar");
        userbtn.setBounds(20, 440, 120, 30);
        userbtn.addActionListener(bwul);

        userbtn2 = new CustomButton("Actualizar");
        userbtn2.setBounds(20, 440, 120, 30);
        userbtn2.addActionListener(bwul);

        if (s == ADD) {
            userbtn2.setVisible(false);
            userbtn.setVisible(true);

        } else if (s == UPDATE) {
            userbtn.setVisible(false);
            userbtn2.setVisible(true);

        }

        cancel = new CustomButton("Cancelar");
        cancel.setBounds(180, 440, 120, 30);

        add(headlb);
        add(nombrelb);
        add(nombretxt);
        add(idlb);
        add(idtxt);
        add(usuariolb);
        add(usuariotxt);
        add(passlb);
        add(passtxt);
        add(tipolb);
        add(tiposList);
        add(direcclb);
        add(direcctxt);
        add(userbtn);
        add(cancel);
        add(ciudadlb);
        add(userbtn2);
        add(ciudadtxt);
        add(estadolb);
        add(cplb);
        add(tellb);
        add(estadotxt);
        add(cptxt);
        add(teltxt);
        add(emaillb);
        add(emailtxt);

    }

}
