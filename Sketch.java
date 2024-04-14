/**
 * Description: draws patterns using methods
 * @author: EdricLai
*/

import processing.core.PApplet;
public class Sketch extends PApplet {
  /*
   * global variables
   * local variables do not have a data type prefix
   */
  int intR;
  int intG;
  int intB;
  int intRow;
  int intWidth = 1000;
  int intHeight = 540;
  float fltPosX;
  float fltPosY;
  float fltSize = intWidth / 80;
  float fltSpace = intWidth / 16;
  float fltSpace2 = 0;
  
  /**
   * initial settings
   * @author EdricLai
   */
  public void settings() {
    // screen size
    size(intWidth, intHeight);
  }
  
  /** 
   * initial setup
   * @author EdricLai
   */
  public void setup() {
    background(30, 35, 35);
    drawFigurePattern();
    drawHeartPattern();
  }

  /**
   * changes rgb
   * @param R value added to red
   * @param G value added to green
   * @param B value added to blue
   * @author EdricLai
  */
  private void changeRgb(int R, int G, int B) {
    intR += R;
    intG += G;
    intB += B;
  }

  /**
   * initializes rgb
   * @param R initialize red to value
   * @param G initialize blue to value
   * @param B initialize green to value
   * @author EdricLai
  */
  private void initRgb(int R, int G, int B) {
    intR = R;
    intG = G;
    intB = B;
  }

  /**
   * translates pattern
   * @return returns the translation
   * @param space the spacing between pattern objects
   * @param space2 the initial spacing of the entire pattern
   * @author EdricLai
  */
  private float shiftPattern(float space, float space2) {
    // increases space
    if (space2 == 0) {
      space2 = space;
    }
    // decreases space
    else {
      space2 = 0;
    }
    // returns result
    return space2;
  }

  /**
   * draws stick figure
   * @param posX x-coordinate of figure
   * @param posY y-coordinate of figure
   * @param size size of figure
   * @author EdricLai
  */
  private void drawFigure(float posX, float posY, float size) {
    // settings
    noFill();
    strokeWeight(size / 10f);
    stroke(intR, intG, intB);
    translate(posX, posY);

    // body
    ellipse(0, 0, size, size);
    line(0, size / 2f, 0, size * 1.5f);

    // hands
    line(0, size / 2f, - size, size * 1.5f);
    line(0, size / 2f, + size, size * 1.5f);

    // legs
    line(0, size * 1.5f, - size, size * 3f);
    line(0, size * 1.5f, + size, size * 3f);

    // resets position
    translate(-posX, -posY);
  }

  /**
   * draws heart
   * @param posX x-coordinate of heart
   * @param posY y-coordinate of heart
   * @param size size of heart
   * @author EdricLai
  */
  private void drawHeart(float posX, float posY, float size) {
    // settings
    noStroke();
    fill(intR, intG, intB);
    translate(posX, posY);

    // right side
    rotate(radians(40));
    ellipse(+ size / 3.5f, 0, size, size * 1.5f);

    // left side
    rotate(radians(280));
    ellipse(- size / 3.5f, 0, size, size * 1.5f);

    // resets position
    rotate(radians(40));
    translate(-posX, -posY);
  }

  /**
   * draws stick figure pattern
   * @author EdricLai
  */
  private void drawFigurePattern() {
    initRgb(255, 0, 0);
    // repeated vertically
    for (fltPosY = fltSpace; fltPosY <= intHeight - fltSpace; fltPosY += fltSpace) {  
      // color change dependent on rows
      if (intRow > 0 && intRow < 3) {
        changeRgb(0, 127, 0);
      }
      else if (intRow == 3) {
        initRgb(0, 255, 0);
      }
      else if (intRow > 3 && intRow < 7) {
        initRgb(intR, intB, 255);
        changeRgb(51, -85, 0);
      }
      // counts rows
      intRow += 1;

      // repeated horizontally
      for (fltPosX = fltSpace; fltPosX <= intWidth - fltSpace; fltPosX += fltSpace) {
        drawFigure(fltPosX, fltPosY, fltSize);
      }
    }
  }
  
  /**
   * draws heart pattern
   * @author EdricLai
  */
  private void drawHeartPattern() {
    initRgb(255, 0, 0);
    // repeated vertically
    for (fltPosY = fltSpace * 1.25f + fltSpace2; fltPosY <= intHeight - fltSpace; fltPosY += fltSpace) {
      fltSpace2 = shiftPattern(fltSpace, fltSpace2);

      // repeated horizontally
      for (fltPosX = fltSpace * 1.5f + fltSpace2; fltPosX <= intWidth - fltSpace; fltPosX += fltSpace * 2f) {
        drawHeart(fltPosX, fltPosY, fltSize);
      }
    }
  }
}