package no.uib.inf101.sem2;

import java.io.IOException;

import javax.swing.JFrame;

import no.uib.inf101.sem2.wordle.model.word.WordDictionary;
import no.uib.inf101.sem2.wordle.view.SampleView;

public class Main {
  public static void main(String[] args) {
    createFrame();

    try {
      WordDictionary dictionary = new WordDictionary("ordliste/nsf2022.txt", 5);
      String randomWord = dictionary.getRandomWord();
      System.out.println(randomWord);


    } catch (IOException e) {
      e.printStackTrace();
    }
    


  }

  private static JFrame createFrame (){
    SampleView view = new SampleView();
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("INF101 sem2 - Wordle");
    frame.setContentPane(view);
    frame.pack();
    frame.setVisible(true);

    return frame;
  }
}


