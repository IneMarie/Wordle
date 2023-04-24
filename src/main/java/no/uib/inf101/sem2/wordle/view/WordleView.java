package no.uib.inf101.sem2.wordle.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

import no.uib.inf101.sem2.wordle.controller.WordleController;
import no.uib.inf101.sem2.wordle.model.WordleModel;

public class WordleView extends JPanel {
  private WordleModel model;
  private ColorTheme colorTheme;
  private HomeScreen homeScreen;
  private HeaderView headerView;
  private GameView gameView;
  private KeyboardView keyboardView;
  private WordleController controller;
  private BorderViewLeft BorderViewLeft;
  private BorderViewRight BorderViewRight;
  
  public WordleView(WordleModel model) {
    this.setFocusable(true);

    controller = new WordleController(this, model);
    headerView = new HeaderView(model, controller);
    homeScreen = new HomeScreen(model, controller);
    gameView = new GameView(model, controller);
    keyboardView = new KeyboardView(model, controller, gameView);
    BorderViewLeft = new BorderViewLeft();
    BorderViewRight = new BorderViewRight();

    int width = 400;
    int height = 500;
    this.setPreferredSize(new Dimension(width, height));
    this.colorTheme = new DefaultColorTheme();
   // TODO this.homeScreen = new HomeScreen(model);

 
    Color backgroundColor = colorTheme.getBackgroundColor();
    this.setBackground(backgroundColor);
    this.setLayout(new BorderLayout());
    this.add(headerView, BorderLayout.PAGE_START);
    this.add(gameView, BorderLayout.CENTER);
    this.add(keyboardView, BorderLayout.PAGE_END);
    this.add(BorderViewLeft, BorderLayout.LINE_START);
    this.add(BorderViewRight, BorderLayout.LINE_END);
 
  }

  public void updateLetterGrid(){
    gameView.updateLetterGrid();
    keyboardView.updateKeyboard();
  }
}
