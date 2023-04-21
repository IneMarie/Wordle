package no.uib.inf101.sem2.wordle.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

import no.uib.inf101.sem2.wordle.model.GameState;
import no.uib.inf101.sem2.wordle.model.WordleModel;

public class WordleView extends JPanel {
    // private WordleModel model;
    private ColorTheme colorTheme;

    public WordleView() {
        this.setFocusable(true);

        // Frivillig (fiks senere)
        int width = 400;
        int height = 500;
        this.setPreferredSize(new Dimension(width, height));
        this.colorTheme = new DefaultColorTheme();

        // Variabler

        this.colorTheme = new DefaultColorTheme();

        // Setter bakgrunnsfargen
        Color backgroundColor = colorTheme.getBackgroundColor();
        this.setBackground(backgroundColor);
   
    }

    @Override
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;

      drawHeader(g2);
      
      /* if (model.getGameState() == GameState.HOME_SCREEN){

      } */

      Rectangle2D rectangle = new Rectangle2D.Double(50, 50, getWidth() - 100, getHeight() - 100);
      Inf101Graphics.drawCenteredString(g2, "Bruk tastatur foreløpig, og se svar i terminalen", rectangle);
    }

    private void drawHeader(Graphics2D g2){
      // Tittelen
      g2.setColor(colorTheme.getTextColor());
      g2.setFont(colorTheme.getTitleFont());
      Rectangle2D recTitle = new Rectangle2D.Double(100, 000, getWidth() / 2, 50);
      Inf101Graphics.drawCenteredString(g2, "WORDLE PÅ NORSK!", recTitle);

      // Linje under tittel
      g2.setColor(colorTheme.getOutlineColor());
      g2.drawLine(0, 50, getWidth(), 50);

      // Meny knapp
      // ≡

    }
}
