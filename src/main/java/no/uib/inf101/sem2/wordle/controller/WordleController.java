package no.uib.inf101.sem2.wordle.controller;

import java.awt.event.KeyEvent;
import no.uib.inf101.sem2.wordle.model.CorrectWord;
import no.uib.inf101.sem2.wordle.model.WordleModel;
import no.uib.inf101.sem2.wordle.model.word.WordDictionary;
import no.uib.inf101.sem2.wordle.view.WordleView;

public class WordleController implements java.awt.event.KeyListener{
  private ControllableWordleModel model;
  private WordleView view;
  private WordDictionary wordDictionary;
  private CorrectWord correctWord;
  
  
  public WordleController(WordleView view, ControllableWordleModel model){
    this.view = view;
    this.model = model;
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
      checkInput();
    } 

    // Backspace = Sletter den siste bokstaven man skrev inn
    else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
        model.removeLetter();
        System.out.println(model.getPlayerLetters());
    }
  }

  public void checkInput(){
     if (!model.canAddLetter()){
      System.out.println("PlayerInputs:" + model.getPlayerLetters());
      if (model.isPlayerWordValid()){
        model.addPlayerWords();
        model.resetInput();
        if (model.isWordValidAndCorrect()){
          System.out.println("Ordet er korrekt :)");
          
        } else {
          System.out.println("Ordet er feil :(");
        }
      }
    } else {
      System.out.println("Mangler bokstaver");
    }
  }

  public void updateLetterGrid(){
    view.updateLetterGrid();
    
  }

  public void addKey(char c){
    model.addLetter(c);
    updateLetterGrid();
  }
  
  @Override
  public void keyReleased(KeyEvent e) {
  }

  public void removeLetter() {
    model.removeLetter();
  }
}
