package no.uib.inf101.sem2.wordle.model;

import no.uib.inf101.sem2.wordle.model.word.WordDictionary;

public class CorrectWord {
  String correctWord;
  
  // Henter ut fasiten og lagrer den
  public CorrectWord(WordDictionary wordDictionary){
    correctWord = wordDictionary.getRandomWord();
  }

  // Sjekker om playerordet er lik fasiten
  public boolean isWordCorrect(String playerWord){
    return (correctWord.equals(playerWord));
  }

  // Sjekker om bokstaven er i ordet
  public boolean containsLetter(char c){
    return (correctWord.indexOf(c) >= 0);
  } 

  // Sjekker om spillerens inntastet ord er korrekt
  public boolean isPlayerLetterCorrect(char c, int pos){
    return (correctWord.charAt(pos) == c);
  }

  public String toString(){
    return correctWord;
  }

  // Returnerer streng med de bokstavene som er helt riktige
  public String getCorrectLetters(String playerWord){
    int playerWordLen = playerWord.length();
    String correctLetters = "";

    for (int i = 0; i < playerWordLen; i++){
      char playerLetter = playerWord.charAt(i);

      if (isPlayerLetterCorrect(playerLetter, i)){
        correctLetters += playerLetter;
      }
    }
    return correctLetters;
  }

  // Setter statusen på bokstavene
  public LetterStatus[] getLetterStatus(String playerWord){
    int playerWordLen = playerWord.length();
    LetterStatus[] status = new LetterStatus[playerWordLen];

    // TODO - hint funksjon kan kanskje bruke denne?
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

        // Sjekker om bokstaven finnes i ordet
        if (remainingLettersInCorrectWord.contains(Character.toString(playerLetter))) {

          status[i] = LetterStatus.LETTER_EXISTS;

          // Fjerner første tilfelle av bokstaven fra remainingLettersInCorrectWord
          // Viktig dersom ordet har flere like bokstaver (Feks blass)
          int pos = remainingLettersInCorrectWord.indexOf(playerLetter);
          String remainingBefore = remainingLettersInCorrectWord.substring(0, pos);
          String remainingAfter = remainingLettersInCorrectWord.substring(pos + 1);
          remainingLettersInCorrectWord = remainingBefore + remainingAfter;
        }
      }
    }
   // System.out.println(playerWord +" "+ correctWord);
   // System.out.println(Arrays.toString(status));
    return status;
  }

}
