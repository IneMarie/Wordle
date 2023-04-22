package no.uib.inf101.sem2.wordle.view;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;

public class KeyboardView extends JPanel{
  int recWidth;
  private ColorTheme colorTheme;
  private JButton[] keys;
  
  public KeyboardView(/* Graphics2D g2, ColorTheme colorTheme*/){
    this.setFocusable(true);
    
    int width = 400;
    int height = 500;
    this.setPreferredSize(new Dimension(width, height));
    this.colorTheme = new DefaultColorTheme();
    this.setBackground(Color.RED);
    
    String[] row1 = {"Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "Å"};
    String[] row2 = {"A", "S", "D", "F", "G", "H", "J", "K", "L", "Ø", "Æ"};
    String[] row3 = {"↵", "Z", "X", "C", "V", "B", "N", "M", "⌫"};
    int index = 0;
    
    keys = new JButton[row1.length + row2.length + row3.length];
    
    for (String label : row1) {
      keys[index] = new JButton(label);
      keys[index].setPreferredSize(new Dimension(30, 30));
      this.add(keys[index]);
      index++;
    }
    
    for (String label : row2) {
      keys[index] = new JButton(label);
      keys[index].setPreferredSize(new Dimension(30, 30));
      this.add(keys[index]);
      index++;
    }
    
    for (int i = 0; i < row3.length; i++) {
      // Første og siste index i row3 har special characters
      if (i == 0 || i == row3.length - 1) {
        // Special characters er dobbel så lange som en vanlig knapp
        keys[index] = new JButton(row3[i]);
        keys[index].setPreferredSize(new Dimension(60, 30));
      } else {
        // Vanlig knapp
        keys[index] = new JButton(row3[i]);
        keys[index].setPreferredSize(new Dimension(30, 30));
      }
      this.add(keys[index]);
      index++;
    }
  }
}
