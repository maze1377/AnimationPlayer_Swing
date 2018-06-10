package Shapes;

import java.awt.*;

public class gLine extends g2Shape {

    public gLine(Color bordercolor, int height, int width, int dashtype, int x1, int y1, int x2, int y2,long id) {
        super(bordercolor, height, width, dashtype, x1, y1, x2, y2,id);
    }

    public void Draw(Graphics g) {
        g.setColor(this.getBordercolor());
        g.drawLine(getX1(), getY1(), getX2(), getY2());
    }
}
