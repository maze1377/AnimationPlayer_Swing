package Shapes;

import java.awt.*;

public class gCircle extends gOval {
    public gCircle(Color bordercolor, int r, int dashtype, int x1, int y1, int x2, int y2, Boolean isFilled, Color backcolor,long id) {
        super(bordercolor, r, r, dashtype, x1, y1, x2, y2, isFilled, backcolor,id);
    }
}