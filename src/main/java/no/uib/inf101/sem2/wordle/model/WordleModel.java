package no.uib.inf101.sem2.wordle.model;

import no.uib.inf101.sem2.wordle.controller.ControllableWordleModel;
import no.uib.inf101.sem2.wordle.view.ViewableWordleModel;

public class WordleModel implements ViewableWordleModel, ControllableWordleModel {
  
  int wordLength = 5; // Default er 5 bokstaver
  String playerLetters = "";
  
  @Override
  public int getWordLength() {
    return wordLength;
  }
  
  // Sjekker om det er plass
  public boolean canAddLetter() {
    if (playerLetters.length() == getWordLength()){
      return false;
    } else {
      return true;
    }
  }

  // Sjekker om det er gyldig bokstav
  private boolean isValidLetter(char c){
    String validLetters = "abcdefghijklmnopqrstuvwxyzæøå";

    if (validLetters.contains(Character.toString(c))){
      return true;
    } else {
      return false;
    }
  }

  @Override
  public void addLetter(char c) {
    if (canAddLetter() && isValidLetter(c)){
      playerLetters += c;
    }
  }

  @Override
  public void removeLetter() {
    playerLetters = playerLetters.substring(0, playerLetters.length()-1);
    
  }

  public String getPlayerLetters(){
    return playerLetters;
  }


  @Override
  public GameState getGameState() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getGameState'");
  }

  
}
