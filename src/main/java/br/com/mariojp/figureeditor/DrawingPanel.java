
package br.com.mariojp.figureeditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

class DrawingPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private static final int DEFAULT_SIZE = 60;
    private final List<FiguraAlternavel> figura = new ArrayList<>(); //criei uma classe pra armazenar as propriedades que quero alterar a medida q coloco novas formas
    private final Color[] cores = {
            new Color(34,76,244), // cor original
            Color.MAGENTA,
            Color.GREEN,
            Color.ORANGE,
            Color.RED,
            Color.pink
        };
    private int colorListIndex =  0;
    private Point startDrag = null;
    private Color corOriginal = new Color(34,76,244);

    DrawingPanel() {
        

        setBackground(Color.WHITE);
        setOpaque(true);
        setDoubleBuffered(true);

        var mouse = new MouseAdapter() {
            @Override public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1 && startDrag == null) {
                    int size = Math.max(Math.min(DEFAULT_SIZE, DEFAULT_SIZE), 10);
                    Shape s =  new Ellipse2D.Double(e.getPoint().x, e.getPoint().y, size, size);
                    //return new Rectangle2D.Double(e.getPoint().x, e.getPoint().y, Math.max(DEFAULT_SIZE, 10), Math.max(DEFAULT_SIZE, 10));
                    figura.add(new FiguraAlternavel(s, cores[colorListIndex]));
                    repaint();
                }
            }
        };
        addMouseListener(mouse);        
        addMouseMotionListener(mouse);

    }

    void clear() {
    	figura.clear();
        repaint();
    }

    @Override protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for (FiguraAlternavel f : figura) {  // aqui tb esqueci de alterar as variáveis de cor, por isso tava preso em uma cor só 
            g2.setColor(f.cor);      
            g2.fill(f.shape);
            g2.setColor(new Color(0, 0, 0, 70));
            g2.setStroke(new BasicStroke(7f));
            g2.draw(f.shape);
        }


        g2.dispose();
    }

	public Color getCorOriginal() {
		return corOriginal;
	}
	
	public void setCorAlterada(JButton b) {
		colorListIndex = (colorListIndex + 1) % cores.length; //eu nem sabia que essa maneira de percorrer array existia. Teria me salvo mt tempo em estrutura de dados
	    b.setForeground(cores[colorListIndex]);
	    repaint(); 
	}
	
	public void UndoBolinhas() {
		figura.removeLast();
	}

}
