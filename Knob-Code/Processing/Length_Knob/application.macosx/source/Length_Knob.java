import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Length_Knob extends PApplet {

PFont f;
PFont fsm;

float l=0;
int fh=300;
boolean inchUnits=false;
public void setup() {
  // size(900, 600);
  size(displayWidth, displayHeight);

  // Create the font
  printArray(PFont.list());
  f = createFont("Helvetica-bold", fh);
  fsm = createFont("Helvetica-bold", fh*.1f);

  textFont(f);
}

public void draw() {
  background(10, 0, 30);
  fill(220, 200, 0);

  textAlign(CENTER);
  background(100);
  String unit;
  float displayLength;


  if (inchUnits) {
    fill(220, 200, 0);
    displayLength=l;
    if (abs(displayLength)>=100) {
      unit="m";
      displayLength=displayLength/100.0f;
    } else {
      unit="cm";
    }
  } 


  //inches
  else {
    fill(20, 200, 200);
    displayLength=l/2.54f;

    if (abs(displayLength)>=12) {
      unit="feet";
      displayLength=displayLength/12.0f;
    } else {
      unit="inches";
    }
  }

  textFont(fsm);
  text(unit, width*.75f, height*.5f+fh*.5f);
  textFont(f);
  text(nf(displayLength, 2, 2), width*.5f, height*.5f+fh*.33f);
}




public void keyPressed() {
  //  println(key);
  float nDetents=24;
  float diameter=2.4f;
  float circumference=diameter*PI;

  float distancePerDetent=circumference/nDetents;



  if (key == CODED) {
    if (keyCode == LEFT) {
      l+=distancePerDetent;
    } else  if (keyCode == RIGHT) {
      l-=distancePerDetent;
    }
  } else {

    if (key == 'i') {
      inchUnits=!inchUnits;
    } else if (key == 'r') {
      l=0;
    }
  }
}

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--full-screen", "--bgcolor=#666666", "--hide-stop", "Length_Knob" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
