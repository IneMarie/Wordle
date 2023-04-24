package no.uib.inf101.sem2.wordle.view;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import no.uib.inf101.sem2.wordle.controller.WordleController;
import no.uib.inf101.sem2.wordle.model.GameState;
import no.uib.inf101.sem2.wordle.model.WordleModel;

public class RetryView extends JPanel{
  private WordleModel model;
  private ColorTheme colorTheme;
  private WordleController controller;
  private JButton retryButton;

  public RetryView(WordleModel model, WordleController controller){
    this.model = model;
    this.colorTheme = new DefaultColorTheme();
    this.controller = controller;
    int width = 500;
    int height = 120;

    retryButton = new JButton("...");
    retryButton.setPreferredSize(new Dimension(400, 100));
    this.add(retryButton);
    retryButton.addActionListener(new ActionListener(){  
      public void actionPerformed(ActionEvent e){  
        controller.gameRestart();
      }
    });
    
    updateButton();

    this.setPreferredSize(new Dimension(width, height));
  }

  public void updateButton(){
    System.out.println("GameSTATE: " + model.getGameState());
    if (model.getGameState() == GameState.GAME_OVER){
      retryButton.setText("Forsøk oppbrukt, prøv igjen");
    } else if (model.getGameState() == GameState.GAME_WON){
      retryButton.setText("Du vant! Prøv igjen");
    }
  }
}
