package fin;

import processing.core.PApplet;

public class Star extends PApplet {
    int num = 1000;
    int width = 1900;
    int height = 1050;
    Ball[] ball = new Ball[num];
    double[] ax = new double[num];
    double[] ay = new double[num];
    boolean back = false;
    double magnetism = 10.0; 
    double radius = 1; 
    float gspeed = 0.95f; 

    public void settings() {
        // 
        size(1920, 1080);					//size(width, height)，設定視窗的長寬像素點的個數
        for (int i = 0; i < num; i++) {
            ball[i] = new Ball(random(width),random(height),0,0);
        }
    }

    public void draw() {
    	background_setting();

        for (int i = 0; i < num; i++) {
            double distance = dist((float) mouseX, (float) mouseY, ball[i].get_x(), ball[i].get_y()); //找到兩點之間距離
            //加速度與距離吸引中心的距離的平方成反比。
            if (distance > 3) { //如果距離鼠標太遠
                ax[i] = magnetism * (mouseX - ball[i].get_x()) / (distance * distance);
                ay[i] = magnetism * (mouseY - ball[i].get_y()) / (distance * distance);
            }
            ball[i].acceleration_vx((float)ax[i]);//增加速度
            ball[i].acceleration_vy((float)ay[i]);
            ball[i].add_gspeed(gspeed);//重力

            ball[i].add_x_v();//新增加速度

            float speed = dist(0, 0, ball[i].get_vx(), ball[i].get_vy()); //從向量中找出速度
            double r = map(speed, 0, 5, 0, 255); //根據速度計算顏色
            double g = map(speed, 0, 5, 64, 255);
            double b = map(speed, 0, 5, 128, 255);
            fill((float) r, (float) g, (float) b, 32);
            ellipse(ball[i].get_x(), ball[i].get_y(), (float) radius, (float) radius);
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