package no.uib.inf101.sem2.wordle.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import no.uib.inf101.sem2.wordle.controller.WordleController;
import no.uib.inf101.sem2.wordle.model.WordleModel;

public class GameView extends JPanel{
  private WordleModel model;
  private ColorTheme colorTheme;
  private LetterRow[] letterRows;

  // private int wordLength = model.getWordLength();
  private int wordLength = 5;

  public GameView(WordleModel model, WordleController controller){
    int width = 400;
    int height = 380;
    this.setPreferredSize(new Dimension(width, height));
    this.model = model;
    this.colorTheme = new DefaultColorTheme();
    this.setBackground(getBackground());
    
    int rows = 6;
    int cols = wordLength;

    // game grid
    this.setLayout(new GridLayout(rows, cols, 5, 5));
    this.letterRows = new LetterRow[rows];
    for (int i = 0; i < rows; i++){
      LetterRow letterRow = new LetterRow(wordLength, colorTheme);
      letterRows[i] = letterRow;
      letterRow.addLettersToPanel(this);
    }
  }
  
  void updateCurrentRowLabels(){
    String playerLetters = model.getPlayerLetters().toUpperCase();
    LetterRow letterRow = getCurrentLetterRow();

    letterRow.setText(playerLetters);

  }

  void updatePreviousRows(){
    ArrayList<String> previousWords = model.getPlayerWords();
    for(int i = 0; i < previousWords.size(); i++){
      String previousWord = previousWords.get(i);
      LetterRow letterRow = getLetterRow(i);

      letterRow.setText(previousWord);
    }
  }

  LetterRow getLetterRow(int row){
    return letterRows[row];
  }

  LetterRow getCurrentLetterRow(){
    return getLetterRow(model.getPlayerWordRowCount());
  }

  public void updateLetterGrid() {
    updateCurrentRowLabels();
    updatePreviousRows();
  }
}
