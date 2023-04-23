package no.uib.inf101.sem2.wordle.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.geom.Line2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseAdapter;
import java.awt.geom.Rectangle2D;
import java.util.Objects;

import javax.swing.JButton;
import javax.swing.JPanel;

import no.uib.inf101.sem2.wordle.controller.WordleController;
import no.uib.inf101.sem2.wordle.model.GameState;
import no.uib.inf101.sem2.wordle.model.WordleModel;

public class WordleView extends JPanel {
  private WordleModel model;
  private ColorTheme colorTheme;
  private HomeScreen homeScreen;
  private HeaderView headerView;
  private GameView gameView;
  private KeyboardView keyboardView;
  private WordleController controller;
  
  public WordleView(WordleModel model) {
    this.setFocusable(true);

    controller = new WordleController(this, model);
    headerView = new HeaderView(model, controller);
    homeScreen = new HomeScreen(model, controller);
    gameView = new GameView(model, controller);
    keyboardView = new KeyboardView(model, controller);

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
    // this.add(homeScreen); // FJern linja 
  }
}
