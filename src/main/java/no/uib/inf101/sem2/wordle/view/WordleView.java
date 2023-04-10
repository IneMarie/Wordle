package no.uib.inf101.sem2.wordle.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class WordleView extends JPanel {
    //private ViewableTetrisModel model;
    //private ColorTheme colorTheme;

    public WordleView(/*ViewableTetrisModel model*/) {
        this.setFocusable(true);

        // Frivillig (fiks senere)
        int width = 300;
        int height = 400;
        this.setPreferredSize(new Dimension(width, height));

        // Variabler
        /*this.model = model;

        this.colorTheme = new DefaultColorTheme();*/

        // Setter bakgrunnsfargen
        // Color backgroundColor = colorTheme.getBackgroundColor();
        //this.setBackground(backgroundColor);
        this.setBackground(Color.LIGHT_GRAY);
    }
}
