package no.uib.inf101.sem2.wordle.controller;

import no.uib.inf101.sem2.wordle.model.GameState;

public interface ControllableWordleModel {

/**
 * Brukes for å finne ut hvor langt ordet er
 * @return lengden på ordet
 */
  int getWordLength();

/**
 * Setter lengden på ordet
 * 
 */
  void setWordLength(int length);

/**
 * Sjekker om det er plass til flere bokstaver
 * @return true eller false, dersom det er plass eller ikke
 */
  boolean canAddLetter();

/**
 * Legger til bokstaver til userInput strengen
 * 
 */
  void addLetter(char c);

/**
 * Fjerner den siste bokstaven
 * 
 */
  void removeLetter();

/**
 * Fjerner alle tidligere inputs, slik at man starter med en tom string
 * 
 */
  void resetInput();

/**
 * Henter ut alle bokstavene spilleren har skrevet
 * 
 */
  String getPlayerLetters();

/**
 * Sjekker om spillerens input resulterer i et ekte ord
 * 
 */
  boolean isPlayerWordValid();

/**
 * Sjekker om ordene er gyldige og i korrekt plassering
 * @return bool
 */
boolean isWordValidAndCorrect();

/**
 * Legger til ferdig player input 
 * 
 */
void addPlayerWords();


/**
 * Brukes for å finne ut hvilken status spillet er i
 * @return statusen på gameState
 */
GameState getGameState();
  


/**
 * Brukes for å sette status på spillet
 */
void setGameState(GameState gameOver);

/**
 * Brukes for å starte nytt spill
 */
void restartGame();

}
