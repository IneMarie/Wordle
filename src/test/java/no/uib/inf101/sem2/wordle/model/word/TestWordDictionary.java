package no.uib.inf101.sem2.wordle.model.word;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.IOException;

import org.junit.jupiter.api.Test;


public class TestWordDictionary {
    
    @Test
    public void testIsValidWord() throws IOException {
        WordDictionary dictionary = new WordDictionary("ordliste/ordliste2022.txt", 5);
        String randomWord = dictionary.getRandomWord();


        assertTrue(dictionary.isValidWord(randomWord));
        assertTrue(dictionary.isValidWord("Kjøre"));
        assertTrue(dictionary.isValidWord("KjØrE"));
        
        assertFalse(dictionary.isValidWord("aaaaa")); // Ikke et ord
        assertFalse(dictionary.isValidWord("Universitet")); // For langt
        assertFalse(dictionary.isValidWord("test")); // For kort
    }
}
