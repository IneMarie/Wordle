package no.uib.inf101.sem2.wordle.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.geom.Line2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseAdapter;
import java.awt.geom.Rectangle2D;
import java.util.Objects;

import javax.swing.JButton;
import javax.swing.JPanel;

import no.uib.inf101.sem2.wordle.grid.CellPosition;
import no.uib.inf101.sem2.wordle.grid.CellPositionToPixelConverter;
import no.uib.inf101.sem2.wordle.grid.GridDimension;
import no.uib.inf101.sem2.wordle.model.GameState;
import no.uib.inf101.sem2.wordle.model.WordleModel;

public class WordleView extends JPanel {
  private WordleModel model;
  private ColorTheme colorTheme;
  private HomeScreen homeScreen;
  
  public WordleView() {
    this.setFocusable(true);

    
    
    int width = 400;
    int height = 500;
    this.setPreferredSize(new Dimension(width, height));
    this.colorTheme = new DefaultColorTheme();
    this.homeScreen = new HomeScreen();

 
    Color backgroundColor = colorTheme.getBackgroundColor();
    this.setBackground(backgroundColor);
    this.setLayout(new GridLayout(1, 1));
    // this.add(homeScreen); // FJern linja 
  }
  
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    
    drawHeader(g2);
    /*if (model.getGameState() == GameState.HOME_SCREEN){
      System.out.println("ETST");
    } */
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


  
  private void drawGrid(Graphics2D g2){
   
  }


  private void drawKeyboard(Graphics2D g2){
   //11x3
  }
}
