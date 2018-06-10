package Shapes;

import java.awt.Color;
import java.awt.Graphics;

public class gRect extends gRectShape {//done!

	public gRect(Color bordercolor, int height, int width, int dashtype, int x1, int y1, int x2, int y2, Boolean isFilled, Color backcolor,long id) {
		super(bordercolor, height, width, dashtype, x1, y1, x2, y2, isFilled, backcolor,id);
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
}
