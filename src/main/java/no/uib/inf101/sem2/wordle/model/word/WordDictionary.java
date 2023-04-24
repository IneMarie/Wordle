package no.uib.inf101.sem2.wordle.model.word;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class WordDictionary implements WordDictionaryInterface {
  ArrayList<String> validWords;
  
  public WordDictionary(String fileName, int wordLength) throws IOException {
    File file = new File(fileName);
    BufferedReader reader = new BufferedReader(
    new FileReader(file, StandardCharsets.UTF_8)
    );
    List<String> lines = reader.lines().toList();
    reader.close();
    
    // Ny ordliste som kun inneholder ord med ønsket lengde
    validWords = new ArrayList<String>();
    for (String line : lines) {
      if (line.length() == wordLength){
        validWords.add(line);
      }
    }
  }
  
  @Override
  public String getRandomWord(){
    Random random = new Random();
    String randomWord = validWords.get(random.nextInt(validWords.size()));
    return randomWord;
  }
  
  // Sjekker om ordet finnes
  public boolean isValidWord(String guessedWord) {
    if (validWords.contains(guessedWord.toLowerCase())){
      return true;
    } else {
      return false;
    }
  }
}