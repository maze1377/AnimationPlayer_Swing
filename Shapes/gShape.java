package Shapes;

import Effects.gEffect;

import java.awt.*;
import java.lang.reflect.Field;
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
    private double scale=1;
    private double delta=0;
    private int BorderSize=1;

    //
    private long id;

    public double getScale() {
        return scale;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }

    public double getDelta() {
        return delta;
    }

    public void setDelta(double delta) {
        this.delta = delta;
    }

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

    public ArrayList<gEffect> getgEffectArrayList() {
        return gEffectArrayList;
    }

    public void PlayLoop(int currentFrame) {
        for (gEffect x : gEffectArrayList) {
            if (x.getStart() <= currentFrame && x.getEndTime() >= currentFrame) {
                x.play();
            } else if (x.getEndTime() < currentFrame) {
                x.stop();
                //this.removeEffect(x);//todo ??
            }
        }
    }

    public abstract String GetString();

    public abstract List<Field> getNeededField();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof gShape)) return false;
        gShape gShape = (gShape) o;
        return getId() == gShape.getId();
    }

    @Override
    public String toString() {
        String name = this.getClass().getName();
        name = name.substring(name.lastIndexOf('.') + 2, name.length());
        return name;
    }

    public String getDetail() {
        String detail = "<html>Shape Type:" + toString() + "<br>Effect Count:"
                + String.valueOf(getgEffectArrayList().size()) + "</html>";
        return detail;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public int getBorderSize() {
        return BorderSize;
    }

    public void setBorderSize(int borderSize) {
        BorderSize = borderSize;
    }
}
