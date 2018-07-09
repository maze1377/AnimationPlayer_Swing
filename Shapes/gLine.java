package Shapes;

import Effects.gEffect;
import FileManager.gHandler;

import java.awt.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class gLine extends g2Shape {

    public gLine(Color bordercolor, int dashtype, int x1, int y1, int x2, int y2,long id) {
        super(bordercolor, 0, 0, dashtype, x1, y1, x2, y2,id);
    }
    public gLine(Color bordercolor,int height,int width, int dashtype, int x1, int y1, int x2, int y2,long id) {
        super(bordercolor, height, width, dashtype, x1, y1, x2, y2,id);
    }
    public gLine()
    {
        super(Color.black,0,0,1,0,0,0,0,0);
    }
    public void Draw(Graphics g) {
        g.setColor(this.getBordercolor());
        g.drawLine(getX1(), getY1(), getX2(), getY2());
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
        StringBuilder temp=new StringBuilder( "Shape: label \n"+
                "x1 : " +this.getX1()+"\n"+
                "y1 : " +this.getY1()+"\n"+
                "x2 : " +this.getX2()+"\n"+
                "y2 : " +this.getY2()+"\n"+
                "bordercolor  : " + gHandler.convertoColor(this.getBordercolor())+"\n");
        for (gEffect x:this.getgEffectArrayList()){
            temp.append("effect \n");
            temp.append(x.GetString());
        }
        return temp.toString();
    }
}
