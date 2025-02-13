package no.uib.inf101.sem2.wordle.view;

import java.awt.Color;
import java.awt.Font;

public interface ColorTheme {
/**
 * (PS! denne fargen kan ikke være gjennomsiktig -- men den kan være null,
 *  dersom du ønsker å benytte standard bakgrunnsfarge fra Java)
 *
 * @return Background color
 */
  Color getBackgroundColor();

/**
 * Fargen som skal brukes i outlinen til tastaturet og de tomme "blokkene"
 *
 * @return Outline color
 */
  Color getOutlineColor();

/**
 * Brukes for å hente fargen til korrekte bokstaver
 * @return Farge til rett bokstav
 */
  Color getColorCorrect();

/**
 * Brukes for å hente fargen til bokstaver på feil plass
 * @return Farge til eksiterende bokstav
 */
  Color getColorExists();


/**
 * Brukes for å hente fargen til feil bokstaver
 * @return Farge til feil bokstav
 */
Color getColorWrong();

/**
 * Brukes for å hente en gjennomsiktig farge som kan brukes i feks gameover screens
 * 
 * @return Color med gjennomsiktig farge
 */
  Color getTransparentOverlayColor();


/**
 * Brukes for å hente en farge som brukes i tekst / string elementer
 * 
 * @return Fargen til teksten
 */
  Color getTextColor();

/**
 * Henter fonten som brukes i tittelen
 * 
 * @return Font til tittelen
 */
  Font getTitleFont();

/**
 * Henter ut font til all tekst utenom tittel
 * 
 * @return Font til tekst
 */
  Font getDefaultFont();
}
