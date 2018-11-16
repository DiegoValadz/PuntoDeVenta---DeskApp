/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import vista.VistaPrincipal;

/**
 *
 * @author diego
 */
public class CloseListener extends MouseAdapter{
    
    private VistaPrincipal vp;

    public CloseListener(VistaPrincipal vp) {
        this.vp = vp;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.getSource()==vp.imgExit){
            System.exit(0);
        }
    }
    
}
