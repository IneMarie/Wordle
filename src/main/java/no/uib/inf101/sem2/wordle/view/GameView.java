package no.uib.inf101.sem2.wordle.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import no.uib.inf101.sem2.wordle.controller.WordleController;
import no.uib.inf101.sem2.wordle.model.CorrectWord;
import no.uib.inf101.sem2.wordle.model.LetterStatus;
import no.uib.inf101.sem2.wordle.model.WordleModel;

public class GameView extends JPanel{
  private WordleModel model;
  private ColorTheme colorTheme;
  private LetterRow[] letterRows;

  // private int wordLength = model.getWordLength();
  private int wordLength = 5;
  private String correctLetters = "";

  public GameView(WordleModel model, WordleController controller){
    int width = 400;
    int height = 380;
    this.setPreferredSize(new Dimension(width, height));
    this.model = model;
    this.colorTheme = new DefaultColorTheme();
    this.setBackground(getBackground());
    
    int rows = model.getMaxRows();
    int cols = wordLength;

    // Oppretter game rutenettet med gridlayout
    this.setLayout(new GridLayout(rows, cols, 5, 5));
    this.letterRows = new LetterRow[rows];
    for (int i = 0; i < rows; i++){
      LetterRow letterRow = new LetterRow(wordLength, colorTheme);
      letterRows[i] = letterRow;
      letterRow.addLettersToPanel(this);
    }
  }
  
  // Oppdaterer labels (bokstavene) på den nåværende raden
  public void updateCurrentRowLabels(){
    String playerLetters = model.getPlayerLetters();
    LetterRow letterRow = getCurrentLetterRow();

    if (letterRow != null){
      // Dersom raden eksiterer, settes teksten til spillerens inputs
      letterRow.setText(playerLetters, null);
    }
  }

  // Oppdaterer radene som er fullt inn
  public void updateRow(int row){
    ArrayList<String> previousWords = model.getPlayerWords();
    LetterRow letterRow = getLetterRow(row); // Henter ut raden

    if (row < previousWords.size()){ 
      String previousWord = previousWords.get(row);
      CorrectWord correctWord = model.getCorrectWord(); 
      LetterStatus[] lettersStatus = correctWord.getLetterStatus(previousWord);
      // Sjekker hvilke av bokstavene fra sist ord som var riktige
      correctLetters += correctWord.getCorrectLetters(previousWord);  
      letterRow.setText(previousWord, lettersStatus);
    } else { // Dersom rowen ikke er "brukt" enda blir den resetet
      letterRow.setText("", null);
    }
  }

  public void updatePreviousRows(){
    correctLetters = "";
    for(int i = 0; i < model.getMaxRows(); i++){
      updateRow(i);
    }
  }

  LetterRow getLetterRow(int row){
    return letterRows[row];
  }

  LetterRow getCurrentLetterRow(){
    int letterRow = model.getPlayerWordRowCount(); //Antall rader spiller har spilt
    if (letterRow < model.getMaxRows()){
      return getLetterRow(letterRow);
    } else {
      return null;
    }
  }

  // Sjekker om bokstaven er rett
  public boolean isLetterCorrect(char c){
    return(correctLetters.indexOf(c) >= 0);
  }

  // Oppdaterer rader
  public void updateLetterGrid() {
    updatePreviousRows();
    updateCurrentRowLabels();
  }
}
