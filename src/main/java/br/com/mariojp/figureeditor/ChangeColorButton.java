package br.com.mariojp.figureeditor;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;

public class ChangeColorButton  extends  JComponent implements ActionListener {

	public void changesColor( final Graphics g) {
		if(g.getColor() == Color.BLUE) {
			g.setColor(Color.MAGENTA);
		}else {
			g.setColor(Color.BLUE);
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		 System.out.println("o comando de mudar de cor FUNCIONA.");	
		
	}

}
