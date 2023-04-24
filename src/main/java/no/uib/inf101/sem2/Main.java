package no.uib.inf101.sem2;

import javax.swing.JFrame;
import javax.swing.UIManager;

import no.uib.inf101.sem2.wordle.controller.WordleController;
import no.uib.inf101.sem2.wordle.model.WordleModel;
import no.uib.inf101.sem2.wordle.view.WordleView;

public class Main {
  public static void main(String[] args) {

    // Format for å gjøre det mulig å gi knappene farger
    try {
      UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
    } catch (Exception e) {
      e.printStackTrace();
    }
    createFrame();
  }
  
  private static JFrame createFrame (){
    WordleModel model = new WordleModel();
    
    WordleView view = new WordleView(model);
    
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("INF101 sem2 - Wordle");
    frame.setContentPane(view);
    
    frame.pack();
    frame.setVisible(true);
    
    return frame;
  }
}


