package fin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import processing.core.PApplet;
import processing.event.KeyEvent;
import processing.event.TouchEvent;

import java.awt.MouseInfo;
import processing.core.*;

public class Visualization extends PApplet {
    double width = 600;
    double di = 6;
    double thickX = width / 2;
    double thickY = width / 2;
    

    double rot;
    double rotSpeed = 0.00005;
    boolean rotating = true;

    double freq = 0.000005;

    double cont = 0;

    public void settings() {
        size(1920, 1080);
        
        
    }

    public void draw() {
        colorMode(HSB, 360, 255, 255);
        background(0);
        translate((float)(1024 / 2), (float)(width / 2 + 74));
        rotate(radians((float)rot));
    

        noStroke();

        for (float i = 0; i < 500; i += 0.5) {
            thickX = width / 2 - 100 + mouseX / 10 + 100 * sin((float) (millis() * freq * i));
            thickY = width / 2 - 100 - mouseY / 10 + 100 * sin((float) (millis() * freq * i));
            fill((float)(i * 3.5 / 5), (float)255, (float)255);
            ellipse((float)thickX * cos(i), (float)thickY * sin(i), (float)di, (float)di);
            if (rotating) {
                rot += rotSpeed;
            }
        }

        // Text out status
        resetMatrix();
        translate((float)width / 2 - 100, (float)width / 2 - 100);
        // text("freq = " + freq, 0, 0);
        // text("t =" + millis() + " ms",0,40);
        // text("angle = " + (int)rot + "°" ,0,20);
        resetMatrix();

    }

}