package fin;

public class Ball{
    private float vx;
    private float vy;
    private float x;
    private float y;

    public Ball(float x, float y, float vx, float vy) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
    }

    public float get_x() {
        return x;
    }

    public float get_y() {
        return y;
    }

    public void set_x(float x) {
        this.x = x;
    }

    public void set_y(float y) {
        this.y = y;
    }

    public void acceleration_vx(float ax) {
        vx += ax;
    }

    public void acceleration_vy(float ay) {
        vy += ay;
    }

    public void add_gspeed(float gspeed) {
        vx *= gspeed;
        vy *= gspeed;
    }

    public float get_vx() {
        return vx;
    }

    public float get_vy() {
        return vy;
    }

    public void add_x_v() {
        this.x += this.vx;
        this.y += this.vy;
    }
}