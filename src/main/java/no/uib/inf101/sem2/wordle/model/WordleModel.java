package no.uib.inf101.sem2.wordle.model;

import java.io.IOException;
import java.util.ArrayList;

import no.uib.inf101.sem2.wordle.controller.ControllableWordleModel;
import no.uib.inf101.sem2.wordle.model.word.WordDictionary;


public class WordleModel implements ControllableWordleModel {
  GameState gameState;
  int wordLength = 5; // Default er 5 bokstaver
  

  String playerLetters = "";
  ArrayList<String> playerWords = new ArrayList<String>();

  private WordDictionary wordDictionary;
  CorrectWord correctWord;

  public WordleModel(){
    // Initierer gameState til HOME_SCREEN
    //this.gameState = GameState.HOME_SCREEN;

    try {
      this.wordDictionary = new WordDictionary("ordliste/ordliste2022.txt", this.getWordLength());
      correctWord = new CorrectWord(wordDictionary);


      System.out.println("CorrectWord: " + correctWord);
      
      
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  @Override
  public void setWordLength(int length) {
    wordLength = length;
  }
  
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
    c = Character.toLowerCase(c);
    if (canAddLetter() && isValidLetter(c)){
      playerLetters += c;
      System.out.println("La inn " + c + ", ordet er nå: " + playerLetters);
    }
  }

  @Override
  public void removeLetter() {
    if (this.getPlayerLetters().length() > 0){
      playerLetters = playerLetters.substring(0, playerLetters.length()-1);
    }
  }

  @Override
  public void resetInput() {
    if (this.getPlayerLetters().length() > 0){
      playerLetters = "";
    }
  }

  public String getPlayerLetters(){
    return playerLetters;
  }

  // TODO - brukes ikke
  public boolean isPlayerWordValid(){
    String playerWord = this.getPlayerLetters();
      
    if (!this.canAddLetter()){ // Sjekker at alle bokstavene er fylt inn
      if (wordDictionary.isValidWord(playerWord)){
        System.out.println(playerWord);
        return true;
      } else {
        System.out.println("Ordet finnes ikke!");
        return false;
      }
    }
    return false;
  }


  public boolean isWordValidAndCorrect(){
    String playerWord = this.getPlayerLetters();

    if (wordDictionary.isValidWord(playerWord)){
      correctWord.getLetterStatus(playerWord);

      if (correctWord.isWordCorrect(playerWord)){
        return true;
      }
      
    }
    return false;
  }

  public void addPlayerWords(){
    playerWords.add(getPlayerLetters());
    System.out.println("La inn " +playerLetters);
  }


  public ArrayList<String> getPlayerWords(){
    return playerWords;
  }


  @Override
  public GameState getGameState() {
    return gameState;
  }

  public int getPlayerWordRowCount(){
    return playerWords.size();
  }

}
