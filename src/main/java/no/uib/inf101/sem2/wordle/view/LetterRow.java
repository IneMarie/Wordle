package no.uib.inf101.sem2.wordle.view;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class LetterRow {
  private LetterLabel[] letterLabels;
  
  public LetterRow(int wordLength, ColorTheme colorTheme){
    this.letterLabels = new LetterLabel[wordLength];
    
    for (int i = 0; i < wordLength; i++){
      letterLabels[i] = new LetterLabel(colorTheme);
    }

  }

  public void addLettersToPanel(JPanel panel){
    for (int i = 0; i < letterLabels.length; i++){
      panel.add(letterLabels[i]);
    }
  }
}
