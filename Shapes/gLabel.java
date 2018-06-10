package Shapes;

import java.awt.*;

public class gLabel extends gShape {
    private String Text;
    private Font font;

    public gLabel(int x1, int y1, Color bordercolor, int height, int width, int dashtype, String text, Font font,long id) {
        super(x1, y1, bordercolor, height, width, dashtype,id);
        setText(text);
        setFont(font);
    }

    public void Draw(Graphics g) {
        g.setColor(Color.white);
        g.setFont(font);
        g.drawString(getText(), getX1(), getY1());
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
}
