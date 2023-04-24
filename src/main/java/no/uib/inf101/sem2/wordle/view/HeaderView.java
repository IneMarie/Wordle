package no.uib.inf101.sem2.wordle.view;

import javax.swing.JButton;
import javax.swing.JPanel;

import no.uib.inf101.sem2.wordle.controller.WordleController;
import no.uib.inf101.sem2.wordle.model.WordleModel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class HeaderView extends JPanel{
  private WordleModel model;
  private WordleController controller;
  private ColorTheme colorTheme;

  
  public HeaderView(WordleModel model, WordleController controller){
    int width = 400;
    int height = 60;
    this.setPreferredSize(new Dimension(width, height));
    this.colorTheme = new DefaultColorTheme();
    this.model = model;
    this.controller = controller;
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    drawHeader(g2);
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
    
    // TODO Meny knapp 
    JButton b = new JButton("≡");
    b.setBounds(10, 10, 30, 30);  
    //this.add(b);  
    this.setLayout(null);  
    this.setVisible(true);
    
    // Kan trykke på knappene
    b.addActionListener((e) -> {
      // TODO HOMESCREEEEN
      System.out.println("TILBAKE TIL HOMESCREEN");
    });
  }
}
