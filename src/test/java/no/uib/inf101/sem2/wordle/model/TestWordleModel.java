package no.uib.inf101.sem2.wordle.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class TestWordleModel {
  WordleModel model = new WordleModel();
  
  @Test
  public void testAddLetter() {
    model.addLetter('a');
    model.addLetter('b');
    assertEquals("ab", model.getPlayerLetters());
  }
  
  @Test
  public void testRemoveLetter() {
    model.addLetter('a');
    model.addLetter('b');
    model.removeLetter();
    assertEquals("a", model.getPlayerLetters());
  }
  
  @Test
  public void testResetInput() {
    model.addLetter('a');
    model.addLetter('b');
    model.resetInput();
    assertEquals("", model.getPlayerLetters());
  }
  
  @Test
  public void testIsValidLetter() {
    assertTrue(model.isValidLetter('a'));
    assertFalse(model.isValidLetter('1'));
  }
  
  @Test
  public void testCanAddLetter() {
    model.setWordLength(3);
    model.addLetter('a');
    model.addLetter('b');
    model.addLetter('c');
    assertFalse(model.canAddLetter());
  }
  
  @Test
  public void testIsWordValidAndCorrect() {
    model.setWordLength(5);
    model.addLetter('a');
    model.addLetter('p');
    model.addLetter('p');
  }

  @Test
  public void testAddPlayerWords() {
    model.setWordLength(4);
    model.addLetter('b');
    model.addLetter('e');
    model.addLetter('s');
    model.addLetter('t');
    model.addPlayerWords();
    ArrayList<String> expectedWords = new ArrayList<String>();
    expectedWords.add("best");
    assertEquals(expectedWords, model.getPlayerWords());
  }
}
