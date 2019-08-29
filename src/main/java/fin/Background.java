package fin;

import processing.core.PApplet;

public class Background{
	void background_setting(Star star) {
//	    boolean back = false;
    	if (!star.back) {
    		star.colorMode(star.HSB, 360, 255, 255);	//色相、飽和度、亮度的值
    		star.background(0);					//background(color) 設定背景顏色，，0(黑色)至255(白色)
    		star.noStroke();						//不畫出筆
    		star.fill(0);						//填顏色，fill(red,green,blue,alpha);	alpha為透明度，0-255
    		star.ellipseMode(star.RADIUS);			//ellipse(x,y,width,height)(3,3,5,5);		ellipse:畫圓或橢圓；		RADIUS適用上面長寬的一半，畫圓
    		star.blendMode(star.ADD);					//BLEND（混合）- 对颜色进行线性插值，ADD（相加）- 对两个颜色进行相加的混合之后与白色取小
    		star.back = true;
        }
    }
}
