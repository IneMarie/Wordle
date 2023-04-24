package no.uib.inf101.sem2.wordle.view;

import javax.swing.JButton;
import javax.swing.JPanel;

import no.uib.inf101.sem2.wordle.controller.WordleController;
import no.uib.inf101.sem2.wordle.model.LetterStatus;
import no.uib.inf101.sem2.wordle.model.WordleModel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KeyboardView extends JPanel{
  int recWidth;
  private ColorTheme colorTheme;
  private KeyboardButton[] keys;
  private WordleModel model;
  private WordleController controller;
  private GameView gameView;
  int index = 0;
  
  public KeyboardView(WordleModel model, WordleController controller, GameView gameView){
    this.setFocusable(true);
    
    int width = 400;
    int height = 120;
    this.setPreferredSize(new Dimension(width, height));
    this.colorTheme = new DefaultColorTheme();
    this.model = model;
    this.gameView = gameView;
    this.controller = controller;
    
    String[] row1 = {"q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "å"};
    String[] row2 = {"a", "s", "d", "f", "g", "h", "j", "k", "l", "ø", "æ"};
    String[] row3 = {"z", "x", "c", "v", "b", "n", "m"};
    
    
    keys = new KeyboardButton[row1.length + row2.length + row3.length];
    
    createKeyRow(row1);
    createKeyRow(row2);
    this.add(new KeyboardEnter(colorTheme, controller));
    createKeyRow(row3);
    this.add(new KeyboardBackspace(colorTheme, controller));
  }
  
  public void createAndAddKey(String letter){
    keys[index] = new KeyboardButton(letter.charAt(0), colorTheme, controller);
    this.add(keys[index]);
    index++;
  }
  
  public void createKeyRow(String[] row){
    for (String letter : row) {
      createAndAddKey(letter);
    }
  }
  
  public void updateKeyboard(){
    for (KeyboardButton key : keys){
      char c = key.getButtonLetter();
      //System.out.println(c + " " + model.isLetterUsed(c));
      if (model.isLetterUsed(c)){
        if (model.getCorrectWord().containsLetter(c)){
          if (gameView.isLetterCorrect(c)) {
            key.setStatus(LetterStatus.LETTER_CORRECT);
          } else {
            key.setStatus(LetterStatus.LETTER_EXISTS);
          }
        } else {
          key.setStatus(LetterStatus.LETTER_WRONG);
        }
      } else {
        key.setStatus(LetterStatus.LETTER_EMPTY);
      }
    }
  }
  
}
