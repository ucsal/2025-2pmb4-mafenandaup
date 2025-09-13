package br.com.mariojp.figureeditor;

import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {}

            JFrame frame = new JFrame("Figure Editor — Clique para inserir figuras");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            DrawingPanel panel = new DrawingPanel();

            JButton colorBtn = new JButton("Mudar de Cor");
            JButton savePng = new JButton("Salvar PNG");
            JButton undoBtn = new JButton("Desfazer");
            
            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new FlowLayout()); 
            buttonPanel.setBackground(Color.decode("#f3aac0"));
            buttonPanel.add(colorBtn);
            buttonPanel.add(savePng);
            buttonPanel.add(undoBtn);
   
            colorBtn.setBackground(Color.yellow);
            colorBtn.setForeground(Color.BLACK);
            colorBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            colorBtn.setPreferredSize(new Dimension(100, 30));
            
            colorBtn.addActionListener(e -> {
                panel.setCorAlterada(colorBtn); 
            });
          
            savePng.setPreferredSize(new Dimension(100, 30));
            savePng.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            savePng.setBackground(Color.cyan);
            savePng.setForeground(Color.BLACK);
            
       
            undoBtn.setPreferredSize(new Dimension(100, 30));
            undoBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            undoBtn.setBackground(Color.pink);
            undoBtn.setForeground(Color.BLACK);
            
            
            
            frame.setLayout(new BorderLayout());
            frame.add(panel, BorderLayout.CENTER);
            frame.add(buttonPanel, BorderLayout.SOUTH);
            frame.setSize(900, 600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
