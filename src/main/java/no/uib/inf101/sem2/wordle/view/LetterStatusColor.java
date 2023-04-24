package no.uib.inf101.sem2.wordle.view;

import java.awt.Color;

import no.uib.inf101.sem2.wordle.model.LetterStatus;

public class LetterStatusColor {

  // Brukes for å "oversette" status til farge
  public static Color getColor(LetterStatus status, ColorTheme colorTheme){
    if (status ==  LetterStatus.LETTER_EMPTY){
      return colorTheme.getBackgroundColor();
    } else if (status ==  LetterStatus.LETTER_WRONG) {
      return colorTheme.getColorWrong();
    } else if (status ==  LetterStatus.LETTER_EXISTS) {
      return colorTheme.getColorExists();
    } else if (status ==  LetterStatus.LETTER_CORRECT) {
      return colorTheme.getColorCorrect();
    }
    return null;
  }
}
