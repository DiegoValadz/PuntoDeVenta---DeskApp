/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author diego
 */
public class CustomPanel extends JPanel {
 
	
	private Image background;
        private int x,y,widthP,heigthP;

    public CustomPanel(int x, int y, int widthP, int heigthP, LayoutManager lm) {
        super(lm);
        this.x = x;
        this.y = y;
        this.widthP = widthP;
        this.heigthP = heigthP;
    }
 
	public void paintComponent(Graphics g) {
  
		// Mandamos que pinte la imagen en el panel
		if (this.background != null) {
			g.drawImage(background, x, y, widthP, heigthP, this);
		}
 
		super.paintComponent(g);
	}
 
	// Metodo donde le pasaremos la dirección de la imagen a cargar.
	public void setImageBackground(String imagePath) {
		
		// Construimos la imagen y se la asignamos al atributo background.
		this.setOpaque(false);
		this.background = new ImageIcon(imagePath).getImage();
		repaint();
	}
 
}