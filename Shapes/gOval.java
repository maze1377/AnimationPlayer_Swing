package Shapes;

import Effects.gEffect;
import FileManager.gHandler;

import java.awt.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class gOval extends gRectShape {//done!
    public gOval(Color bordercolor, int height, int width, int dashtype, int x1, int y1, int x2, int y2, Boolean isFilled, Color backcolor,long id) {
        super(bordercolor, height, width, dashtype, x1, y1, x2, y2, isFilled, backcolor,id);
    }
    public gOval(Color bordercolor, int height, int width, int dashtype, int x1, int y1, Boolean isFilled, Color backcolor,long id) {
        super(bordercolor, height, width, dashtype, x1, y1, 0, 0, isFilled, backcolor,id);
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

    @Override
    public List<Field> getNeededField() {
        ArrayList<Field> fields=new ArrayList<>();
        try {
            fields.add(gShape.class.getDeclaredField("x1"));
            fields.add(gShape.class.getDeclaredField("y1"));
            fields.add(gShape.class.getDeclaredField("width"));
            fields.add(gShape.class.getDeclaredField("height"));
        }catch (NoSuchFieldException e)
        {
            e.printStackTrace();
        }
        return fields;

    }

    @Override
    public String GetString() {
        StringBuilder temp=new StringBuilder( "Shape: circle \n"+
                "r1 : "+this.getHeight()+"\n"+
                "r2 : "+this.getWidth()+"\n"+
                "x1 : " +this.getX1()+"\n"+
                "y1 : " +this.getY1()+"\n"+
                "isfilled  : " +this.getIsFilled()+"\n"+
                "backcolor  : " + gHandler.convertoColor(this.getBackcolor())+"\n"+
                "bordercolor  : " + gHandler.convertoColor(this.getBordercolor())+"\n");
        for (gEffect x:this.getgEffectArrayList()){
            temp.append("effect \n");
            temp.append(x.GetString());
        }
        return temp.toString();
    }
}
