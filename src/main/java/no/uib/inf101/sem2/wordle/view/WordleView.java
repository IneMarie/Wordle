package no.uib.inf101.sem2.wordle.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseAdapter;
import java.awt.geom.Rectangle2D;
import java.util.Objects;

import javax.swing.JPanel;

import no.uib.inf101.sem2.wordle.grid.CellPosition;
import no.uib.inf101.sem2.wordle.grid.CellPositionToPixelConverter;
import no.uib.inf101.sem2.wordle.grid.GridDimension;
import no.uib.inf101.sem2.wordle.model.GameState;
import no.uib.inf101.sem2.wordle.model.WordleModel;

public class WordleView extends JPanel {
  private WordleModel model;
  private ColorTheme colorTheme;
  
  public WordleView() {
    this.setFocusable(true);
    
    
    int width = 400;
    int height = 500;
    this.setPreferredSize(new Dimension(width, height));
    this.colorTheme = new DefaultColorTheme();
    
    
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
    // if (model.getGameState() == GameState.HOME_SCREEN){
      drawHomeScreen(g2);
    // }
    drawGrid(g2);
  }
  
  private void drawHeader(Graphics2D g2){
    // Tittelen
    g2.setColor(colorTheme.getTextColor());
    g2.setFont(colorTheme.getTitleFont());
    Rectangle2D recTitle = new Rectangle2D.Double(100, 0, getWidth() / 2, 50);
    Inf101Graphics.drawCenteredString(g2, "WORDLE PÅ NORSK!", recTitle);
    
    // Linje under tittel
    g2.setColor(colorTheme.getOutlineColor());
    g2.drawLine(0, 50, getWidth(), 50);
    
    // Meny knapp
    // ≡
    
  }

  private void drawHomeScreen(Graphics2D g2){
    g2.setColor(colorTheme.getTextColor());
    g2.setFont(colorTheme.getDefaultFont());

    double recWidth = getWidth() / 4;

    // 4 bokstaver
    Rectangle2D rec4 = new Rectangle2D.Double(150, 130, recWidth, 40);
    g2.draw(rec4);
    Inf101Graphics.drawCenteredString(g2, "4 bokstaver", rec4);

    // 5 bokstaver
    Rectangle2D rec5 = new Rectangle2D.Double(150, 190, recWidth, 40);
    g2.draw(rec5);
    Inf101Graphics.drawCenteredString(g2, "5 bokstaver", rec5);

    // 6 bokstaver
    Rectangle2D rec6 = new Rectangle2D.Double(150, 250, recWidth, 40);
    g2.draw(rec6);
    Inf101Graphics.drawCenteredString(g2, "6 bokstaver", rec6);
    
    // 7 bokstaver
    Rectangle2D rec7 = new Rectangle2D.Double(150, 310, recWidth, 40);
    g2.draw(rec7);
    Inf101Graphics.drawCenteredString(g2, "7 bokstaver", rec7);

    // 8 bokstaver
    Rectangle2D rec8 = new Rectangle2D.Double(150, 370, recWidth,40);
    g2.draw(rec8);
    Inf101Graphics.drawCenteredString(g2, "8 bokstaver", rec8);

    // model.setWordLength();

  }

  
  
  
  
  private void drawGrid(Graphics2D g2){
   
  }


  private void drawKeyboard(Graphics2D g2){
   //11x3
  }
}
