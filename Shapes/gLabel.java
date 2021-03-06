package Shapes;

import Effects.gEffect;
import FileManager.gHandler;

import java.awt.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class gLabel extends gShape {
    private String Text;
    private Font font;
    private Color fontcolor=Color.black;

    public gLabel(int x1, int y1, Color bordercolor, int height, int width, int dashtype, String text, Font font,long id,Color fontcolor) {
        super(x1, y1, bordercolor, height, width, dashtype,id);
        setText(text);
        setFont(font);
        setFontcolor(fontcolor);
    }


    public gLabel()
    {
        super(0,0,Color.black,0,0,1,0);
        Text="Test";
        font=new Font("Times New Roman",Font.TYPE1_FONT,34);
    }

    public void Draw(Graphics g) {
        Graphics2D y=(Graphics2D) g;
        y.scale(this.getScale(),this.getScale());
        y.rotate(this.getDelta());
        y.setColor(fontcolor);
        y.setStroke(new BasicStroke(this.getBorderSize()));
        y.setFont(font);
        y.drawString(getText(), getX1(), getY1());
        y.scale(1,1);
        y.rotate(-this.getDelta());
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
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
                "height  : "+this.getWidth()+"\n"+
                "height  : "+this.getHeight()+"\n"+
                "x1 : " +this.getX1()+"\n"+
                "y1 : " +this.getY1()+"\n"+
                "text : " + this.getText()+"\n"+
                "fontsize : " + this.getFont().getSize()+"\n"+
                "fontcolor : " + gHandler.convertoColor(this.getFontcolor())+"\n"+
                "bordercolor  : " + gHandler.convertoColor(this.getBordercolor())+"\n");
        for (gEffect x:this.getgEffectArrayList()){
            temp.append("effect \n");
            temp.append(x.GetString());
        }
        return temp.toString();
    }

    public Color getFontcolor() {
        return fontcolor;
    }

    public void setFontcolor(Color fontcolor) {
        this.fontcolor = fontcolor;
    }
}
