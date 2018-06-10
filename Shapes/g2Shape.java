package Shapes;

import java.awt.*;

public abstract class g2Shape extends gShape {
    private int x2;
    private int y2;

    public g2Shape(Color bordercolor, int height, int width, int dashtype, int x1, int y1, int x2, int y2, long id) {
        super(x1, y1, bordercolor, height, width, dashtype, id);
        setX2(x2);
        setY2(y2);
    }

    public g2Shape(Color bordercolor, int dashtype, int x1, int y1, int x2, int y2, long id) {
        this(bordercolor, Math.abs(y2 - y1), Math.abs(x2 - x1), dashtype, x1, y1, x2, y2, id);
    }

    public abstract void Draw(Graphics g);

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public int calWidth() {
        return Math.abs(getX2() - getX1());
    }

    public int calHeight() {
        return Math.abs(getY2() - getY1());
    }
}
