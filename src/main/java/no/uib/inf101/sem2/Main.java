package no.uib.inf101.sem2;

import javax.swing.JFrame;
import javax.swing.UIManager;

import no.uib.inf101.sem2.wordle.controller.WordleController;
import no.uib.inf101.sem2.wordle.model.WordleModel;
import no.uib.inf101.sem2.wordle.view.ColorTheme;
import no.uib.inf101.sem2.wordle.view.DefaultColorTheme;
import no.uib.inf101.sem2.wordle.view.GameView;
import no.uib.inf101.sem2.wordle.view.HeaderView;
import no.uib.inf101.sem2.wordle.view.HomeScreen;
import no.uib.inf101.sem2.wordle.view.KeyboardView;
import no.uib.inf101.sem2.wordle.view.RetryView;
import no.uib.inf101.sem2.wordle.view.WordleView;

public class Main {
  public static void main(String[] args) {
    try {
      UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
      
   } catch (Exception e) {
              e.printStackTrace();
   }
    createFrame();
    
  }
  
  private static JFrame createFrame (){
    WordleModel model = new WordleModel();

    // Forskjellige views
    WordleView view = new WordleView(model);
    WordleController controller = new WordleController(view, model); /* 
    HeaderView headerView = new HeaderView(model, controller);
    HomeScreen homeScreen = new HomeScreen(model, controller);
    GameView gameView = new GameView(model, controller);
    KeyboardView keyboardView = new KeyboardView(model, controller); */
    //RetryView retryView = new RetryView(model, controller);

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("INF101 sem2 - Wordle");
    frame.setContentPane(view);
    // frame.setContentPane(homeScreen);
    // frame.setContentPane(headerView);
    //frame.setContentPane(gameView);
    //frame.setContentPane(retryView);
    //frame.setContentPane(keyboardView);
    frame.pack();
    frame.setVisible(true);
    
    return frame;
  }
}


