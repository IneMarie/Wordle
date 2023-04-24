package no.uib.inf101.sem2.wordle.view;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.uib.inf101.sem2.wordle.controller.WordleController;
import no.uib.inf101.sem2.wordle.model.LetterStatus;


public class KeyboardButton extends JButton{
  protected ColorTheme colorTheme;
  protected char c;
  protected WordleController controller;

  public KeyboardButton(char c, ColorTheme colorTheme, WordleController controller){
    Color textColor = colorTheme.getTextColor();
    this.colorTheme = colorTheme;
    this.c = c;
    this.controller = controller;
    this.setOpaque(true);
    this.setBorderPainted(false);
    this.setMargin(new Insets(0, 0, 0, 0)); 
    this.setForeground(textColor);
    this.setText(Character.toString(c).toUpperCase());
    this.setPreferredSize(new Dimension(30, 30));

    setStatus(LetterStatus.LETTER_EMPTY);
    // Knappen kan klikkes
    this.addActionListener(new ActionListener(){  
      public void actionPerformed(ActionEvent e){  
        keyPressed(e);
      }
    });
  }

  public void keyPressed(ActionEvent e){  
    controller.addKey(c);

    //System.out.println("TYPED:" + c);
  }

  public void setStatus(LetterStatus status){
    Color color = LetterStatusColor.getColor(status, colorTheme);
    this.setBackground(color);
  }

  public char getButtonLetter() {
    return c;
  }  
}   
