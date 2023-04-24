package no.uib.inf101.sem2.wordle.view;

import java.awt.Color;
import java.awt.Font;

public class DefaultColorTheme implements ColorTheme{
  
  @Override
  public Color getBackgroundColor() {
    return Color.WHITE;
  }
  
  @Override
  public Color getTransparentOverlayColor() {
    Color color;
    color = new Color(0, 0, 0, 128);
    return color;
  }
  
  @Override
  public Color getTextColor() {
    return Color.DARK_GRAY;
  }

  @Override
  public Font getTitleFont() {
    Font font = new Font("Neue Helvetica", Font.BOLD, 20);
    return font;
  }

  @Override
  public Font getDefaultFont() {
    Font font = new Font("Neue Helvetica", Font.PLAIN, 16);
    return font;
  }

  @Override
  public Color getOutlineColor() {
    return Color.LIGHT_GRAY;
  }

  @Override
  public Color getColorCorrect() {
    return Color.green;
  }

  @Override
  public Color getColorExists() {
    return Color.orange;
  }

  @Override
  public Color getColorWrong() {
    return Color.gray;
  }
  
}
