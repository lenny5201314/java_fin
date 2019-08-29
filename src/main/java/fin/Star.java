package fin;

import processing.core.PApplet;

public class Star extends PApplet {
    int num = 1000;
    int width = 1900;
    int height = 1050;
    Ball[] ball = new Ball[num];
    float[] ax = new float[num];
    float[] ay = new float[num];
    boolean back = false;
    float magnetism = 10.0f; 
    float radius = 1; 
    float gspeed = 0.95f; 

    public void settings() {
        size(1920, 1080); //size(width, height)，設定視窗的長寬像素點的個數
        for (int i = 0; i < num; i++) {
            ball[i] = new Ball(random(width),random(height),0,0);
        }
    }

    public void draw() {
    	background_setting();

        for (int i = 0; i < num; i++) {
            float distance = dist( mouseX, mouseY, ball[i].get_x(), ball[i].get_y()); //找到兩點之間距離
            //加速度與距離吸引中心的距離的平方成反比。
            if (distance > 3) { //如果距離鼠標太遠
                ax[i] = magnetism * (mouseX - ball[i].get_x()) / (distance * distance);
                ay[i] = magnetism * (mouseY - ball[i].get_y()) / (distance * distance);
            }
            ball[i].acceleration_vx(ax[i]);//增加速度
            ball[i].acceleration_vy(ay[i]);
            ball[i].add_gspeed(gspeed);//重力
            ball[i].add_x_v();//新增加速度

            float speed = dist(0, 0, ball[i].get_vx(), ball[i].get_vy()); //從向量中找出速度
            float r = map(speed, 0, 5, 0, 255); //根據速度計算顏色
            float g = map(speed, 0, 5, 64, 255);
            float b = map(speed, 0, 5, 128, 255);
            fill(r, g, b, 32);
            ellipse(ball[i].get_x(), ball[i].get_y(), radius, radius);
        }
    }
    void background_setting() {
    	if (!back) {
            colorMode(HSB, 360, 255, 255);	//色相、飽和度、亮度的值
            background(0);					//background(color) 設定背景顏色，，0(黑色)至255(白色)
            noStroke();						//不畫出筆
            fill(0);						//填顏色，fill(red,green,blue,alpha);	alpha為透明度，0-255
            ellipseMode(RADIUS);			//ellipse(x,y,width,height)(3,3,5,5);		ellipse:畫圓或橢圓；		RADIUS適用上面長寬的一半，畫圓
            blendMode(ADD);					//BLEND（混合）- 对颜色进行线性插值，ADD（相加）- 对两个颜色进行相加的混合之后与白色取小
            back = true;
        }
    }
}