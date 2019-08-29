package fin;

import processing.core.PApplet;

public class Point extends PApplet{
	public void point_setting() {
	    int num = 1000;
	    int width = 1900;
	    int height = 1050;
	    float[] ax = new float[num];
	    float[] ay = new float[num];
	    Ball[] ball = new Ball[num];
	    
	    size(1920, 1080); //size(width, height)，設定視窗的長寬像素點的個數
        for (int i = 0; i < num; i++) {
            ball[i] = new Ball(random(width),random(height),0,0);
        }
	}
}
