package Shapes;

import java.awt.*;

public class gSquare extends gRect {
    public gSquare(Color bordercolor, int height, int dashtype, int x1, int y1, int x2, int y2, Boolean isFilled, Color backcolor,long id) {
        super(bordercolor, height, height, dashtype, x1, y1, x2, y2, isFilled, backcolor,id);
    }
    public gSquare()
    {
        super(Color.BLACK,0, 0,0, 0, 0, 0, 0, false, Color.white,0);
    }
    @Override
    public void setHeight(int height) {
        super.setHeight(height);
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(getHeight());
    }
}
