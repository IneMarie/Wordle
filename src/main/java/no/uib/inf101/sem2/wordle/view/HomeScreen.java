package no.uib.inf101.sem2.wordle.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;

import javax.swing.JButton;
import javax.swing.JPanel;

import no.uib.inf101.sem2.wordle.model.WordleModel;

public class HomeScreen extends JPanel{
  int recWidth;
  private ColorTheme colorTheme;
  private WordleModel model;
  
  public HomeScreen(WordleModel model){
    this.setFocusable(true);
    // g2.setColor(colorTheme.getTextColor());
    // g2.setFont(colorTheme.getDefaultFont());
    
    int width = 400;
    int height = 500;
    this.setPreferredSize(new Dimension(width, height));
    this.colorTheme = new DefaultColorTheme();
    this.model = model;
    this.setBackground(Color.blue);
    
    recWidth = width / 4;
    
    createButton(4, 130, colorTheme);
    createButton(5, 190, colorTheme);
    createButton(6, 250, colorTheme);
    createButton(7, 310, colorTheme);
    createButton(8, 370, colorTheme);
    
    
    // model.setWordLength();
    
  }
  
  private JButton createButton(int wordLength, int y, ColorTheme colorTheme){
    String text = (wordLength + " bokstaver");
    JButton b = new JButton(text);  
    b.setFont(colorTheme.getDefaultFont());
    b.setBounds(140, y, 120, 40);  
    this.add(b);  
    this.setLayout(null);  
    this.setVisible(true);
    
    // Kan trykke på knappene
    b.addActionListener((e) -> {
      model.setWordLength(wordLength);
      System.out.println(text);
    });
    return b;
  }
  
}
