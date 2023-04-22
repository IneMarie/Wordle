package no.uib.inf101.sem2.wordle.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import no.uib.inf101.sem2.wordle.model.WordleModel;

public class GameView extends JPanel{
    private WordleModel model;

    // private int wordLength = model.getWordLength();
    private int wordLength = 5;

    public GameView(WordleModel model){
        int width = 400;
        int height = 500;
        this.setPreferredSize(new Dimension(width, height));
        this.model = model;
        this.setBackground(Color.GREEN);


        // game grid
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(6, wordLength, 5, 10));
        p.add(new JLabel(""));
    }
}
