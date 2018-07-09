package Shapes;

import Effects.gEffect;
import FileManager.gHandler;

import java.awt.Color;
import java.awt.Graphics;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


public class gRect extends gRectShape {//done!

	public gRect(Color bordercolor, int height, int width, int dashtype, int x1, int y1, int x2, int y2, Boolean isFilled, Color backcolor,long id) {
		super(bordercolor, height, width, dashtype, x1, y1, x2, y2, isFilled, backcolor,id);
	}
	public gRect()
	{
		super(Color.black,0,0,1,0,0,0,0,false,Color.white,0);

	}

	public void Draw(Graphics g)
	{
		g.setColor(this.getBordercolor());
		if (getIsFilled())
		{
			g.setColor(getBackcolor());
			g.fillRect(getX1(), getY1(), getWidth(), getHeight());
			
			g.setColor(getBordercolor());
			g.drawRect(getX1(), getY1(), getWidth(), getHeight());
		}
		else
			g.drawRect(getX1(), getY1(), getWidth(), getHeight());
		
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
				"Height : "+this.getHeight()+"\n"+
				"Width : "+this.getWidth()+"\n"+
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
