package Shapes;

import Effects.gEffect;
import FileManager.gHandler;

import java.awt.*;

public class gSquare extends gRect {
    public gSquare(Color bordercolor, int length, int dashtype, int x1, int y1, int x2, int y2, Boolean isFilled, Color backcolor, long id) {
        super(bordercolor, length, length, dashtype, x1, y1, x2, y2, isFilled, backcolor, id);
    }

    public gSquare(Color bordercolor, int length, int dashtype, int x1, int y1, Boolean isFilled, Color backcolor, long id) {
        super(bordercolor, 0, 0, dashtype, x1, y1, 0, 0, isFilled, backcolor, id);
        setHeight(length);
        setWidth(length);
    }

    public gSquare() {
        super(Color.BLACK, 0, 0, 0, 0, 0, 0, 0, false, Color.white, 0);
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(getHeight());
    }

    @Override
    public String GetString() {
        StringBuilder temp = new StringBuilder("Shape: circle \n" +
                "length  : " + this.getHeight() + "\n" +
                "x1 : " + this.getX1() + "\n" +
                "y1 : " + this.getY1() + "\n" +
                "isfilled  : " + this.getIsFilled() + "\n" +
                "backcolor  : " + gHandler.convertoColor(this.getBackcolor()) + "\n" +
                "bordercolor  : " + gHandler.convertoColor(this.getBordercolor()) + "\n");
        for (gEffect x : this.getgEffectArrayList()) {
            temp.append("effect \n");
            temp.append(x.GetString());
        }
        return temp.toString();
    }

}
