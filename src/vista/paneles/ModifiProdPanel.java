/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.paneles;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import vista.buttons.CustomButton;
import vista.VistaPrincipal;
import controlador.ButtonWinListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author diego
 */
public class ModifiProdPanel extends JPanel {

    private JLabel headlb, nombrelb, idlb, pventalb, pcompralb, exislb, desclb;
    public JTextField nombretxt, idtxt, pventatxt, pcompratxt, existxt;
    public JTextArea desctxt;
    public CustomButton prodbtn, cancel, prodbtn2;
    private ButtonWinListener bwl;
    public static final int ADD = 0;
    public static final int UPDATE = 1;
    public static int s;
    private String URL;

    public ModifiProdPanel(String msg) {
        setLayout(null);
        setBackground(new Color(224, 224, 224));

        //Labels
        Font font = new Font("Yu Gothic UI Semibold", Font.BOLD, 15);

        headlb = new JLabel(msg);
        headlb.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
        headlb.setForeground(Color.black);
        headlb.setBounds(20, 5, 400, 30);

        nombrelb = new JLabel("Nombre");
        nombrelb.setFont(font);
        nombrelb.setBounds(20, 35, 400, 30);

        idlb = new JLabel("ID");
        idlb.setFont(font);
        idlb.setBounds(20, 90, 400, 30);

        pcompralb = new JLabel("Precio Compra");
        pcompralb.setFont(font);
        pcompralb.setBounds(20, 150, 200, 30);

        pventalb = new JLabel("Precio Venta");
        pventalb.setFont(font);
        pventalb.setBounds(290, 150, 250, 30);

        exislb = new JLabel("Existencia");
        exislb.setFont(font);
        exislb.setBounds(20, 210, 250, 30);

        desclb = new JLabel("Descripción");
        desclb.setFont(font);
        desclb.setBounds(20, 270, 250, 30);

        //TextFields
        nombretxt = new JTextField(100);
        nombretxt.setBounds(20, 60, 400, 30);

        idtxt = new JTextField(100);
        idtxt.setBounds(20, 120, 200, 30);

        pcompratxt = new JTextField(100);
        pcompratxt.setBounds(20, 180, 200, 30);

        pventatxt = new JTextField(100);
        pventatxt.setBounds(290, 180, 200, 30);

        existxt = new JTextField(100);
        existxt.setBounds(20, 240, 200, 30);

        desctxt = new JTextArea(500, 150);
        desctxt.setBounds(20, 300, 500, 120);

        //Listeners
        bwl = new ButtonWinListener(this, s);
        //Buttons
        prodbtn = new CustomButton("Agregar");
        prodbtn.setBounds(20, 440, 120, 30);
        prodbtn.addActionListener(bwl);

        prodbtn2 = new CustomButton("Actualizar");
        prodbtn2.setBounds(20, 440, 120, 30);
        prodbtn2.addActionListener(bwl);

        if (s == ADD) {
            prodbtn2.setVisible(false);
            prodbtn.setVisible(true);

        }
        else if (s == UPDATE) {
            prodbtn.setVisible(false);
            prodbtn2.setVisible(true);

        }

        cancel = new CustomButton("Cancelar");
        cancel.setBounds(180, 440, 120, 30);

        add(headlb);
        add(nombrelb);
        add(nombretxt);
        add(idlb);
        add(idtxt);
        add(pventalb);
        add(pcompralb);
        add(pcompratxt);
        add(pventatxt);
        add(exislb);
        add(existxt);
        add(desclb);
        add(desctxt);
        add(prodbtn);
        add(cancel);
        add(prodbtn2);

    }

    public static void main(String[] args) {
        new VistaPrincipal("");
    }

}
