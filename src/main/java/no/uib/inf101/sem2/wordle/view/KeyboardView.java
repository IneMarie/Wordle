package no.uib.inf101.sem2.wordle.view;

import javax.swing.JPanel;

import no.uib.inf101.sem2.wordle.controller.WordleController;
import no.uib.inf101.sem2.wordle.model.LetterStatus;
import no.uib.inf101.sem2.wordle.model.WordleModel;

import java.awt.Dimension;

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
    
    // Tastaturet har 3 rader
    String[] row1 = {"q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "å"};
    String[] row2 = {"a", "s", "d", "f", "g", "h", "j", "k", "l", "ø", "æ"};
    String[] row3 = {"z", "x", "c", "v", "b", "n", "m"};
    
    // Initaliseres slik at den har nok plass til alle verdier
    keys = new KeyboardButton[row1.length + row2.length + row3.length];
    
    createKeyRow(row1); // Lager rad 1
    createKeyRow(row2); // Lager rad 2
    this.add(new KeyboardEnter(colorTheme, controller)); // Lager "enter"
    createKeyRow(row3); // Lager rad 3
    this.add(new KeyboardBackspace(colorTheme, controller)); // Lager "backspace"
  }
  
  // brukes for å lage tastatur knapper
  public void createAndAddKey(String letter){
    keys[index] = new KeyboardButton(letter.charAt(0), colorTheme, controller);
    this.add(keys[index]);
    index++;
  }
  
  // Lager rad med tastatur knapper
  public void createKeyRow(String[] row){
    for (String letter : row) {
      createAndAddKey(letter);
    }
  }
  
  // Oppdaterer tastatur slik at farger vises i henhold til en bokstavs status
  public void updateKeyboard(){
    for (KeyboardButton key : keys){
      char c = key.getButtonLetter();
      //System.out.println(c + " " + model.isLetterUsed(c));
      if (model.isLetterUsed(c)){
        if (model.getCorrectWord().containsLetter(c)){
          if (gameView.isLetterCorrect(c)) { // Bokstav har korrekt posisjon = grønn
            key.setStatus(LetterStatus.LETTER_CORRECT);
          } else { // Bokstav finnes i ordet = oransj
            key.setStatus(LetterStatus.LETTER_EXISTS);
          }
        } else { // Bokstav finnes ikke i ordet = mørke grå
          key.setStatus(LetterStatus.LETTER_WRONG);
        }
      } else {
        key.setStatus(LetterStatus.LETTER_EMPTY);
      }
    }
  }
}
