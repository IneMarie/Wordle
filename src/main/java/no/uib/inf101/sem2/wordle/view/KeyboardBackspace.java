package no.uib.inf101.sem2.wordle.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;

import no.uib.inf101.sem2.wordle.controller.WordleController;

public class KeyboardBackspace extends KeyboardButton{

  public KeyboardBackspace(ColorTheme colorTheme, WordleController controller) {
    super('⌫', colorTheme, controller);

    this.setPreferredSize(new Dimension(70, 35));
  
  }

  @Override
  public void keyPressed(ActionEvent e){  
    controller.removeLetter(); // Fjerner siste bokstav
    controller.updateLetterGrid(); // Oppdaterer ruter
  }  
}
