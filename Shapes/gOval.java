package Shapes;

import java.awt.*;

public class gOval extends gRectShape {//done!
    public gOval(Color bordercolor, int height, int width, int dashtype, int x1, int y1, int x2, int y2, Boolean isFilled, Color backcolor,long id) {
        super(bordercolor, height, width, dashtype, x1, y1, x2, y2, isFilled, backcolor,id);
    }
    public gOval()
    {
        super(Color.BLACK,0,0,0,0,0,0,0,false,Color.white,0);
    }
    public void Draw(Graphics g) {
        g.setColor(this.getBordercolor());
        if (getIsFilled()) {
            g.setColor(getBackcolor());
            g.fillOval(getX1(), getY1(), getWidth(), getHeight());

            g.setColor(getBordercolor());
            g.drawOval(getX1(), getY1(), getWidth(), getHeight());
        } else
            g.drawOval(getX1(), getY1(), getWidth(), getHeight());
    }
    @Override
    public void setWidth(int width) {
        super.setWidth(width);
    }

}
