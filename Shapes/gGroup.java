package Shapes;

import Effects.gEffect;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class gGroup extends gShape {
    private List<gShape> shapes;

    public gGroup() {
        super(-1,-1, Color.white, -1, -1, -1, -1);
    }
    public gGroup( long id,List<gShape> shapes) {
        super(-1,-1, Color.white, -1, -1, -1, id);
    }
    public gGroup( long id) {
        this(id,new ArrayList<gShape>());
    }
    @Override
    public void Draw(Graphics g) {
        for (gShape x:shapes){
            x.Draw(g);
        }
    }

    public List<gShape> getShapes() {
        return shapes;
    }

    @Override
    public void PlayLoop(int currentFrame) {
        super.PlayLoop(currentFrame);
        for (gShape x:shapes){
            x.PlayLoop(currentFrame);
        }
    }

    public void addgShape(gShape x){
        shapes.add(x);
    }
    public void setbounds(){
        int minx=5000,maxx=0,miny=5000,maxy=0;
        for (gShape x:shapes){
            if (x.getX1()>maxx){
                maxx=x.getX1();
            }else if (x.getX1()<minx){
                minx=x.getX1();
            }
            if (x.getY1()>maxy){
                maxy=x.getY1();
            }else  if (x.getY1()<miny){
                miny=x.getY1();
            }
        }
        setX1(minx);
        setY1(miny);
        setWidth(maxx-minx);
        setHeight(maxy-miny);
    }

    public void setShapes(List<gShape> shapes) {
        this.shapes = shapes;
    }
}
