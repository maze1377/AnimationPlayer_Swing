package Shapes;

import java.awt.*;

public abstract class gRectShape extends g2Shape {//done!
    private Boolean isFilled;
    private Color backcolor;

    public gRectShape(Color bordercolor, int height, int width, int dashtype, int x1, int y1, int x2, int y2, Boolean isFilled, Color backcolor,long id) {
        super(bordercolor, height, width, dashtype, x1, y1, x2, y2,id);
        setIsFilled(isFilled);
        setBackcolor(backcolor);
    }

    public abstract void Draw(Graphics g);

    public Boolean getIsFilled() {
        return isFilled;
    }

    public void setIsFilled(Boolean isFilled) {
        this.isFilled = isFilled;
    }

    public Color getBackcolor() {
        return backcolor;
    }

    public void setBackcolor(Color backcolor) {
        this.backcolor = backcolor;
    }


}
