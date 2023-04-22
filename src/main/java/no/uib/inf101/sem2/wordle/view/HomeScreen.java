package no.uib.inf101.sem2.wordle.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;

import javax.swing.JButton;
import javax.swing.JPanel;

public class HomeScreen extends JPanel{
  int recWidth;
  private ColorTheme colorTheme;
  
  public HomeScreen(/* Graphics2D g2 ColorTheme colorTheme*/){
    this.setFocusable(true);
    // g2.setColor(colorTheme.getTextColor());
    // g2.setFont(colorTheme.getDefaultFont());
    
    int width = 400;
    int height = 500;
    this.setPreferredSize(new Dimension(width, height));
    this.colorTheme = new DefaultColorTheme();
    this.setBackground(Color.blue);
    
    recWidth = width / 4;
    
    createButton("4 bokstaver", 130, colorTheme);
    createButton("5 bokstaver", 190, colorTheme);
    createButton("6 bokstaver", 250, colorTheme);
    createButton("7 bokstaver", 310, colorTheme);
    createButton("8 bokstaver", 370, colorTheme);
    
    
    // model.setWordLength();
    
  }
  
  private JButton createButton(String text, int y, ColorTheme colorTheme){
    JButton b = new JButton(text);  
    b.setFont(colorTheme.getDefaultFont());
    b.setBounds(140, y, 120, 40);  
    this.add(b);  
    //this.setSize(recWidth,40);  
    this.setLayout(null);  
    this.setVisible(true);
    b.addActionListener(null);
    return b;
  }
}
