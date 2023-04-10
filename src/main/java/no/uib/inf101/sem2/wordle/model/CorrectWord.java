package no.uib.inf101.sem2.wordle.model;

import java.util.Arrays;
import java.util.Dictionary;
import java.util.Random;

import no.uib.inf101.sem2.wordle.model.word.WordDictionary;

public class CorrectWord {
  String correctWord;
  
  // Henter ut fasiten og lagrer den
  public CorrectWord(WordDictionary wordDictionary){
    correctWord = wordDictionary.getRandomWord();
  }

  public boolean isWordCorrect(String playerWord){
    return (correctWord.equals(playerWord));
  }

  // Sjekker om spillerens inntastet ord er korrekt
  public boolean isPlayerLetterCorrect(char c, int pos){
    return (correctWord.charAt(pos) == c);
  }

  public String toString(){
    return correctWord;
  }

  public LetterStatus[] getLetterStatus(String playerWord){
    int playerWordLen = playerWord.length();
    LetterStatus[] status = new LetterStatus[playerWordLen];

    String remainingLettersInCorrectWord = "";

    for (int i = 0; i < playerWordLen; i++){
      char playerLetter = playerWord.charAt(i);

      if (isPlayerLetterCorrect(playerLetter, i)){
        status[i] = LetterStatus.LETTER_CORRECT;
      }
      else {
        status[i] = LetterStatus.LETTER_WRONG;
        remainingLettersInCorrectWord += correctWord.charAt(i);
      }
    }

    // Sjekker om bokstaver er på feil plass
    for (int i = 0; i < playerWordLen; i++){
      char playerLetter = playerWord.charAt(i);

      if (status[i] != LetterStatus.LETTER_CORRECT){
        if (remainingLettersInCorrectWord.contains(Character.toString(playerLetter))) {
          // fant bokstav på feil posisjon
          status[i] = LetterStatus.LETTER_EXISTS;
          // vi må fjerne bokstaven fra remaining
          int pos = remainingLettersInCorrectWord.indexOf(playerLetter);
          String remainingBefore = remainingLettersInCorrectWord.substring(0, pos);
          String remainingAfter = remainingLettersInCorrectWord.substring(pos + 1);
          remainingLettersInCorrectWord = remainingBefore + remainingAfter;
        }
      }
    }
    System.out.println(Arrays.toString(status));
    return status;
  }

}
