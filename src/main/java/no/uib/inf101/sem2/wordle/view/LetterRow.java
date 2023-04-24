package no.uib.inf101.sem2.wordle.view;

import javax.swing.JPanel;

import no.uib.inf101.sem2.wordle.model.LetterStatus;

public class LetterRow {
  private LetterLabel[] letterLabels;
  
  public LetterRow(int wordLength, ColorTheme colorTheme){
    this.letterLabels = new LetterLabel[wordLength];
    
    // Oppretter alle ruter på en rad som viser en bokstav hver
    for (int i = 0; i < wordLength; i++){
      letterLabels[i] = new LetterLabel(colorTheme);
    }
  }

  // Setter status på en enkelt rute
  public void setLetterAndStatus(int col, char c, LetterStatus status){
    letterLabels[col].setLetterAndStatus(c, status);
    //System.out.println(status + " " + col);
  }

  // Legger til alle bokstavene i raden til viewet
  public void addLettersToPanel(JPanel panel){
    for (int i = 0; i < letterLabels.length; i++){
      panel.add(letterLabels[i]);
    }
  }

  // Setter teksten og statusen for alle bokstavene på raden
  public void setText(String playerLetters, LetterStatus[] letterStatuses){
    for (int i = 0; i < letterLabels.length; i++){ 
      char c; 
      if (playerLetters.length() > i){ // Hvis teksten er lang nok til å inneholde denne pos.
        c = playerLetters.charAt(i); // henter ut tegnet på pos
      } else {
        c = ' '; // Space hvis brukerne ikke har skrevet ut bokstaven
      }
      LetterStatus letterStatus = LetterStatus.LETTER_EMPTY; // Default
      if (letterStatuses != null){
        letterStatus = letterStatuses[i]; // Status er satt, bruk denne
      }
      setLetterAndStatus(i, c, letterStatus);
    }
  }
}
