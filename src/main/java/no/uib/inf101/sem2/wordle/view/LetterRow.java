package no.uib.inf101.sem2.wordle.view;

import javax.swing.JLabel;
import javax.swing.JPanel;

import no.uib.inf101.sem2.wordle.model.GameState;
import no.uib.inf101.sem2.wordle.model.LetterStatus;

public class LetterRow {
  private LetterLabel[] letterLabels;
  
  public LetterRow(int wordLength, ColorTheme colorTheme){
    this.letterLabels = new LetterLabel[wordLength];
    
    for (int i = 0; i < wordLength; i++){
      letterLabels[i] = new LetterLabel(colorTheme);
    }
  }

  public void setLetterAndStatus(int col, char c, LetterStatus status){
    letterLabels[col].setLetterAndStatus(c, status);
    //System.out.println(status + " " + col);
  }

  public void addLettersToPanel(JPanel panel){
    for (int i = 0; i < letterLabels.length; i++){
      panel.add(letterLabels[i]);
    }
  }

  public void setText(String playerLetters, LetterStatus[] letterStatuses){
    for (int i = 0; i < letterLabels.length; i++){
      char c;
      if (playerLetters.length() > i){
        c = playerLetters.charAt(i);
      } else {
        c = ' ';
      }
      LetterStatus letterStatus = LetterStatus.LETTER_EMPTY; // Default
      if (letterStatuses != null){
        letterStatus = letterStatuses[i];
      }
      
      setLetterAndStatus(i, c, letterStatus);
    }
  }
}
