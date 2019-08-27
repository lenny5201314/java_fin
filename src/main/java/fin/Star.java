package fin;

import processing.core.PApplet;

public class Star extends PApplet {
    int num = 1000;
    int width = 1900;
    int height = 1050;
    double[] vx = new double[num];
    double[] vy = new double[num];
    double[] x = new double[num];
    double[] y = new double[num];
    double[] ax = new double[num];
    double[] ay = new double[num];
    boolean back = false;
    double magnetism = 10.0; 
    double radius = 1; 
    double gspeed = 0.95f; 

    public void settings() {
        // 
        size(1920, 1080);
        for (int i = 0; i < num; i++) {
            x[i] = random(width);
            y[i] = random(height);
            vx[i] = 0;
            vy[i] = 0;
            ax[i] = 0;
            ay[i] = 0;
        }
        //background(0);
    }

    public void draw() {
        if (!back) {
            colorMode(HSB, 360, 255, 255);
            background(0);
            noStroke();
            fill(0);
            ellipseMode(RADIUS);
            blendMode(ADD);
            back = true;
        }

        

        for (int i = 0; i < num; i++) {
            double distance = dist((float) mouseX, (float) mouseY, (float) x[i], (float) y[i]); //找到兩點之間距離
            //加速度與距離吸引中心的距離的平方成反比。
            if (distance > 3) { //如果距離鼠標太遠
                ax[i] = magnetism * (mouseX - x[i]) / (distance * distance);
                ay[i] = magnetism * (mouseY - y[i]) / (distance * distance);
            }
            vx[i] += ax[i]; //增加速度vx
            vy[i] += ay[i]; 
            vx[i] = vx[i] * gspeed;
            vy[i] = vy[i] * gspeed;
            x[i] += vx[i]; //前vy。
            y[i] += vy[i]; 

            float speed = dist(0, 0, (float) vx[i], (float) vy[i]); //從向量中找出速度
            double r = map(speed, 0, 5, 0, 255); //根據速度計算顏色
            double g = map(speed, 0, 5, 64, 255);
            double b = map(speed, 0, 5, 128, 255);
            fill((float) r, (float) g, (float) b, 32);
            ellipse((float) x[i], (float) y[i], (float) radius, (float) radius);
        }
    }
    
}