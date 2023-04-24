package no.uib.inf101.sem2.wordle.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

import no.uib.inf101.sem2.wordle.controller.WordleController;
import no.uib.inf101.sem2.wordle.model.GameState;
import no.uib.inf101.sem2.wordle.model.WordleModel;

public class WordleView extends JPanel {
  private WordleModel model;
  private ColorTheme colorTheme;
  //private HomeScreen homeScreen;
  private HeaderView headerView;
  private GameView gameView;
  private KeyboardView keyboardView;
  private WordleController controller;
  private BorderViewLeft borderViewLeft;
  private BorderViewRight borderViewRight;
  private RetryView retryView;

  private JPanel bottomView;
  private CardLayout cardLayout;
  
  
  public WordleView(WordleModel model) {
    this.model = model;
    this.setFocusable(true);
    
    controller = new WordleController(this, model);
    headerView = new HeaderView(model, controller);
    //homeScreen = new HomeScreen(model, controller);
    gameView = new GameView(model, controller);
    keyboardView = new KeyboardView(model, controller, gameView);
    borderViewLeft = new BorderViewLeft();
    borderViewRight = new BorderViewRight();
    retryView = new RetryView(model, controller);

    int width = 400;
    int height = 500;
    this.setPreferredSize(new Dimension(width, height));
    this.colorTheme = new DefaultColorTheme();
   // TODO this.homeScreen = new HomeScreen(model);

    cardLayout = new CardLayout();
    bottomView = new JPanel(cardLayout);
    bottomView.add(keyboardView);
    bottomView.add(retryView);
    
    Color backgroundColor = colorTheme.getBackgroundColor();
    this.setBackground(backgroundColor);
    this.setLayout(new BorderLayout());
    this.add(headerView, BorderLayout.PAGE_START);
    this.add(gameView, BorderLayout.CENTER);
    this.add(bottomView, BorderLayout.PAGE_END);
    this.add(borderViewLeft, BorderLayout.LINE_START);
    this.add(borderViewRight, BorderLayout.LINE_END);
 
  }

  public void updateLetterGrid(){
    gameView.updateLetterGrid();
    keyboardView.updateKeyboard();
    updateBottomView();
  }

  public void updateBottomView(){
    GameState gameState = model.getGameState();
    if (gameState == GameState.GAME_OVER || gameState == GameState.GAME_WON){
      retryView.updateButton();
      cardLayout.last(bottomView);
    } else {
      cardLayout.first(bottomView);
    }
  }

  public LetterRow getCurrentLetterRow() {
    return gameView.getCurrentLetterRow();
  }
}
