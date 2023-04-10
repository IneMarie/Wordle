package no.uib.inf101.sem2.wordle.controller;

import java.awt.event.KeyEvent;
import java.io.IOException;

import no.uib.inf101.sem2.wordle.model.CorrectWord;
import no.uib.inf101.sem2.wordle.model.word.WordDictionary;
import no.uib.inf101.sem2.wordle.view.WordleView;

public class WordleController implements java.awt.event.KeyListener{
  private ControllableWordleModel model;
  private WordleView view;
  private WordDictionary wordDictionary;
  private CorrectWord correctWord;
  
  
  public WordleController(WordleView view, ControllableWordleModel model){
    this.model = model;
    this.view = view;
    
    view.addKeyListener(this);
    
  }
  
  @Override
  public void keyTyped(KeyEvent e) {
    char playerLetter = e.getKeyChar();
    playerLetter = Character.toLowerCase(playerLetter);
    
    model.addLetter(playerLetter);
    System.out.println("TYPED:" + playerLetter);
    
  }
  
  
  @Override
  public void keyPressed(KeyEvent e) {
    // Enter = ordet lagres, og sjekkes mot fasiten
    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
      System.out.println("PlayerInputs:" + model.getPlayerLetters());
      model.isWordValidAndCorrect();
    } 
    // Backspace = Sletter den siste bokstaven man skrev inn
    else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
        model.removeLetter();
        System.out.println(model.getPlayerLetters());
    }
  }
  
  @Override
  public void keyReleased(KeyEvent e) {
  }
}
