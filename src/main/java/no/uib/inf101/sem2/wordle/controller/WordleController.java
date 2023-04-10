package no.uib.inf101.sem2.wordle.controller;

import java.awt.event.KeyEvent;
import java.io.IOException;

import no.uib.inf101.sem2.wordle.model.word.WordDictionary;
import no.uib.inf101.sem2.wordle.view.WordleView;

public class WordleController implements java.awt.event.KeyListener{
  private ControllableWordleModel model;
  private WordleView view;
  
  
  public WordleController(WordleView view, ControllableWordleModel model){
    this.model = model;
    this.view = view;
    
    
    try {
      WordDictionary dictionary = new WordDictionary("ordliste/ordliste2022.txt", model.getWordLength());
      String randomWord = dictionary.getRandomWord();
      System.out.println(randomWord);
      
      
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    view.addKeyListener(this);
    
  }
  
  @Override
  public void keyTyped(KeyEvent e) {
    char playerLetter = e.getKeyChar();
    playerLetter = Character.toLowerCase(playerLetter);
    
    model.addLetter(playerLetter);
    // System.out.println("TYPED: " + playerLetter);
    
  }
  
  @Override
  public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
      if (!model.canAddLetter()){ // Sjekker at alle bokstavene er fylt inn
        System.out.println(model.getPlayerLetters());
      }
    } else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
      if (model.getPlayerLetters().length() > 0){
        model.removeLetter();
        System.out.println(model.getPlayerLetters());
      }
    }
  }
  
  @Override
  public void keyReleased(KeyEvent e) {
  }
  
}
