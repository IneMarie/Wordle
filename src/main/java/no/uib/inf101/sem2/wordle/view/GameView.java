package no.uib.inf101.sem2.wordle.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import no.uib.inf101.sem2.wordle.controller.WordleController;
import no.uib.inf101.sem2.wordle.model.WordleModel;

public class GameView extends JPanel{
  private WordleModel model;
  private ColorTheme colorTheme;

  // private int wordLength = model.getWordLength();
  private int wordLength = 5;
  
  public GameView(WordleModel model, WordleController controller){
    int width = 400;
    int height = 500;
    this.setPreferredSize(new Dimension(width, height));
    this.model = model;
    this.colorTheme = new DefaultColorTheme();
    this.setBackground(getBackground());
    
    int row = 6;
    int col = wordLength;
    Color color = colorTheme.getOutlineColor();
    
    // game grid
    this.setLayout(new GridLayout(row, col, 0, 5));
    for (int i = 0; i < row; i++){
      LetterRow letterRow = new LetterRow(wordLength, colorTheme);
      letterRow.addLettersToPanel(this);
    }
  }
}
