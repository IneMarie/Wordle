package no.uib.inf101.sem2.wordle.controller;

import no.uib.inf101.sem2.wordle.model.GameState;

public interface ControllableWordleModel {
    
/**
 * Brukes for å finne ut om spillet er ACTIVE_GAME eller GAME_OVER
 * @return statusen på gameState
 */
  GameState getGameState();
  

/**
 * Brukes for å finne ut hvor langt ordet er
 * @return lengden på ordet
 */
  int getWordLength();

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
 * Henter ut alle 
 * 
 */
  String getPlayerLetters();

}
