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
    
    String[] row1 = {"Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "Å"};
    String[] row2 = {"A", "S", "D", "F", "G", "H", "J", "K", "L", "Ø", "Æ"};
    String[] row3 = {"↵", "Z", "X", "C", "V", "B", "N", "M", "⌫"};
    int index = 0;
    
    keys = new JButton[row1.length + row2.length + row3.length];
    
    for (String letter : row1) {
      row1And2Common(keys, letter, index);
    }
    
    for (String letter : row2) {
      row1And2Common(keys, letter, index);
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
            controller.updateLetterGrid();
          } else if (letter == "⌫") {
            model.removeLetter();
            controller.updateLetterGrid();
            System.out.println(model.getPlayerLetters());
          } else {
            actionPerformedCommon(letter);
          }
        }
      });
      this.add(keys[index]);
      index++;
    }
  }
  
  // Kode som er felles for alle rader
  public void actionPerformedCommon(String letter){
    char c = letter.charAt(0);
    model.addLetter(c);
    controller.updateLetterGrid();
    System.out.println("TYPED:" + c);
  }

  // Kode som kun er felles for rad 1 og 2
  public void row1And2Common(JButton[] keys, String letter, int index){
    keys[index] = new JButton(letter);
    keys[index].setPreferredSize(new Dimension(30, 30));
    
    // Knappen kan klikkes
    keys[index].addActionListener(new ActionListener(){  
      public void actionPerformed(ActionEvent e){  
        actionPerformedCommon(letter);
      }  
    });
    this.add(keys[index]);
    index++;
  }
}
