package no.uib.inf101.sem2.wordle.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import no.uib.inf101.sem2.wordle.model.LetterStatus;

public class LetterLabel extends JLabel{
  private ColorTheme colorTheme;

  public LetterLabel(ColorTheme colorTheme){
    Color borderColor = colorTheme.getOutlineColor();
    this.colorTheme = colorTheme;
    
    setLetterAndStatus(' ', LetterStatus.LETTER_EMPTY);
    this.setBorder(BorderFactory.createLineBorder(borderColor));

    Font font = colorTheme.getTitleFont();
    Color textColor = colorTheme.getTextColor();
    this.setFont(font);
    this.setForeground(textColor);
    
    this.setHorizontalAlignment(JLabel.CENTER);

    
  }

  public void setLetterAndStatus(char c, LetterStatus status){
    String text = Character.toString(c);
    this.setText(text);
    if (status ==  LetterStatus.LETTER_EMPTY){
      this.setBackground(colorTheme.getBackgroundColor());
    } else if (status ==  LetterStatus.LETTER_WRONG) {
      this.setBackground(colorTheme.getColorWrong());
    } else if (status ==  LetterStatus.LETTER_EXISTS) {
      this.setBackground(colorTheme.getColorExists());
    } else if (status ==  LetterStatus.LETTER_CORRECT) {
      this.setBackground(colorTheme.getColorCorrect());
    }
  }
}
