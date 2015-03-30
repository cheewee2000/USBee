PFont f;
PFont fsm;

float l=0;
int fh=300;
boolean inchUnits=false;
void setup() {
  // size(900, 600);
  size(displayWidth, displayHeight);

  // Create the font
  printArray(PFont.list());
  f = createFont("Helvetica-bold", fh);
  fsm = createFont("Helvetica-bold", fh*.1);

  textFont(f);
}

void draw() {
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
      displayLength=displayLength/100.0;
    } else {
      unit="cm";
    }
  } 


  //inches
  else {
    fill(20, 200, 200);
    displayLength=l/2.54;

    if (abs(displayLength)>=12) {
      unit="feet";
      displayLength=displayLength/12.0;
    } else {
      unit="inches";
    }
  }

  textFont(fsm);
  text(unit, width*.75, height*.5+fh*.5);
  textFont(f);
  text(nf(displayLength, 2, 2), width*.5, height*.5+fh*.33);
}




void keyPressed() {
  //  println(key);
  float nDetents=24;
  float diameter=2.4;
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

