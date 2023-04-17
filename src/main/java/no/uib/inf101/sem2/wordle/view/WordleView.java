package no.uib.inf101.sem2.wordle.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

public class WordleView extends JPanel {
    //private ViewableTetrisModel model;
    //private ColorTheme colorTheme;

    public WordleView(/* viewable model */) {
        this.setFocusable(true);

        // Frivillig (fiks senere)
        int width = 300;
        int height = 400;
        this.setPreferredSize(new Dimension(width, height));

        // Variabler
        /*this.model = model;

        this.colorTheme = new DefaultColorTheme();*/

        // Setter bakgrunnsfargen
        // Color backgroundColor = colorTheme.getBackgroundColor();
        //this.setBackground(backgroundColor);
        this.setBackground(Color.LIGHT_GRAY);
    }

    @Override
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;

      Rectangle2D rectangle = new Rectangle2D.Double(50, 50, getWidth() - 100, getHeight() - 100);
      Inf101Graphics.drawCenteredString(g2, "Bruk tastatur foreløpig, og se svar i terminalen", rectangle);
    }
}
