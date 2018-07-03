package Shapes;

import Effects.gEffect;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class gShape {//done!
    private int x1;
    private int y1;
    private Color bordercolor;
    private int width;
    private int height;
    private int dashtype;
    //
    private long id;
    private ArrayList<gEffect> gEffectArrayList = new ArrayList<>();

    public gShape(int x1, int y1, Color bordercolor, int height, int width, int dashtype, long id) {
        setBordercolor(bordercolor);
        setDashtype(dashtype);
        setWidth(width);
        setHeight(height);
        setX1(x1);
        setY1(y1);
        setId(id);
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public abstract void Draw(Graphics g);

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getBordercolor() {
        return bordercolor;
    }

    public void setBordercolor(Color bordercolor) {
        this.bordercolor = bordercolor;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getDashtype() {
        return dashtype;
    }

    public void setDashtype(int dashtype) {
        this.dashtype = dashtype;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void addgEffect(gEffect x) {
        gEffectArrayList.add(x);
    }

    public void removeEffect(gEffect x) {
        gEffectArrayList.remove(x);
    }

    public void PlayLoop(int currentFrame) {
        for (gEffect x : gEffectArrayList) {
            if (x.getStart() <= currentFrame && x.getEndtime() >= currentFrame) {
                x.play();
            } else if (x.getEndtime() < currentFrame) {
                x.stop();
                //this.removeEffect(x);//todo ??
            }
        }
    }

    public abstract List<String> getNeededField();
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof gShape)) return false;
        gShape gShape = (gShape) o;
        return getId() == gShape.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

}
