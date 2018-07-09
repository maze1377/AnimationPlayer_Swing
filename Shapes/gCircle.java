package Shapes;

import Effects.gEffect;
import FileManager.gHandler;
import java.awt.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import java.awt.*;

public class gCircle extends gOval {
    public gCircle(Color bordercolor, int r, int dashtype, int x1, int y1, Boolean isFilled, Color backcolor,long id) {
        super(bordercolor, r, r, dashtype, x1, y1, x1, y1, isFilled, backcolor,id);
    }
    public gCircle(Color bordercolor, int r, int dashtype, int x1, int y1,int x2,int y2, Boolean isFilled, Color backcolor,long id) {
        super(bordercolor, r, r, dashtype, x1, y1, x2, y2, isFilled, backcolor,id);
    }
    public gCircle()
    {
        super(Color.black,0,0,1,0,0,0,0,false,Color.white,0);
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }

    @Override
    public void setHeight(int height) {
        super.setWidth(height);
        super.setHeight(height);
    }

    @Override
    public List<Field> getNeededField() {
        ArrayList<Field> fields=new ArrayList<>();
        try {
            fields.add(gShape.class.getDeclaredField("x1"));
            fields.add(gShape.class.getDeclaredField("y1"));
            fields.add(gShape.class.getDeclaredField("width"));
        }catch (NoSuchFieldException e)
        {
            e.printStackTrace();
        }
        return fields;
    }

    @Override
    public String GetString() {
        StringBuilder temp=new StringBuilder( "Shape: circle \n"+
                "r : "+this.getHeight()+"\n"+
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
