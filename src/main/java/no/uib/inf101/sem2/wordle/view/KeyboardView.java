package no.uib.inf101.sem2.wordle.view;

import javax.swing.JButton;
import javax.swing.JPanel;

import no.uib.inf101.sem2.wordle.controller.WordleController;
import no.uib.inf101.sem2.wordle.model.WordleModel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KeyboardView extends JPanel{
  int recWidth;
  private ColorTheme colorTheme;
  private JButton[] keys;
  private WordleModel model;
  private WordleController controller;
  
  public KeyboardView(WordleModel model, WordleController controller){
    this.setFocusable(true);
    
    int width = 400;
    int height = 120;
    this.setPreferredSize(new Dimension(width, height));
    this.colorTheme = new DefaultColorTheme();
    this.model = model;
    this.controller = controller;
    this.setBackground(Color.RED);
    
    String[] row1 = {"Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "Å"};
    String[] row2 = {"A", "S", "D", "F", "G", "H", "J", "K", "L", "Ø", "Æ"};
    String[] row3 = {"↵", "Z", "X", "C", "V", "B", "N", "M", "⌫"};
    int index = 0;
    
    keys = new JButton[row1.length + row2.length + row3.length];
    
    for (String letter : row1) {
      keys[index] = new JButton(letter);
      keys[index].setPreferredSize(new Dimension(30, 30));
      
      // Knappen kan klikkes
      keys[index].addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  
          //System.out.println(letter);
          char c = letter.charAt(0);   
          model.addLetter(c);
          System.out.println("TYPED:" + c);
        }  
      });
      
      this.add(keys[index]);
      index++;
    }
    
    // TODO forbedre koden, gjenbruk
    for (String letter : row2) {
      keys[index] = new JButton(letter);
      keys[index].setPreferredSize(new Dimension(30, 30));
      
      // Knappen kan klikkes
      keys[index].addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  
          //System.out.println(letter);
          char c = letter.charAt(0);   
          model.addLetter(c);
          System.out.println("TYPED:" + c);
        }  
      });
      
      this.add(keys[index]);
      index++;
    }
    
    for (int i = 0; i < row3.length; i++) {
      // Første og siste index i row3 har special characters
      if (i == 0 || i == row3.length - 1) {
        // Special characters er dobbel så lange som en vanlig knapp
        keys[index] = new JButton(row3[i]);
        keys[index].setPreferredSize(new Dimension(70, 35));
      } else {
        // Vanlig knapp
        keys[index] = new JButton(row3[i]);
        keys[index].setPreferredSize(new Dimension(30, 30));
      }
      
      // Legger på actionlistener
      keys[index].addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          JButton button = (JButton) e.getSource();

          String letter = button.getText();
          if (letter == "↵"){
            controller.checkInput();
          } else if (letter == "⌫") {
            model.removeLetter();
            System.out.println(model.getPlayerLetters());
          } else {
            char c = letter.charAt(0);
            model.addLetter(c);
            System.out.println("TYPED:" + c);
          }
        }
      });
      
      this.add(keys[index]);
      index++;
    }
    
  }
}
