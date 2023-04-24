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
    
    // default
    setLetterAndStatus(' ', LetterStatus.LETTER_EMPTY);
    this.setBorder(BorderFactory.createLineBorder(borderColor));

    Font font = colorTheme.getTitleFont();
    Color textColor = colorTheme.getTextColor();
    this.setOpaque(true);
    this.setFont(font);
    this.setForeground(textColor);
    this.setHorizontalAlignment(JLabel.CENTER);
  }

  // Farger rutene utifra hvilke status bokstavene har
  public void setLetterAndStatus(char c, LetterStatus status){
    String text = Character.toString(c).toUpperCase();
    this.setText(text);
    Color color = LetterStatusColor.getColor(status, colorTheme);
    this.setBackground(color);
  }
}
