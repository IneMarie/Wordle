package no.uib.inf101.sem2.wordle.model.word;

public interface WordDictionaryInterface {
/**
 * Henter ut ett tilfeldig ord fra en liste
 * 
 * @return Ett tilfeldig ord
 */
  String getRandomWord();
  

/**
 * Sjekker om et inntastet ord fra spilleren faktisk eksisterer
 * 
 * @param guessedWord Ord som spilleren skriver inn
 * @return True dersom ordet finnes i ordlista, False ellers
 */
  boolean isValidWord(String guessedWord);
}
