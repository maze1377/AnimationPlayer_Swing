package Effects;

import FileManager.gHandler;
import Shapes.gRectShape;
import Shapes.gShape;

import java.awt.*;

public class gChangeColor extends gEffect {
    private Color color;

    public gChangeColor(gShape node, int starttime, int endtime, Color color) {
        super(node, starttime, endtime);
        setColor(color);
    }

    public gChangeColor()
    {
        super(null,0,0);
        setColor(new Color(0,0,0));
    }

    @Override
    public void play() {
        if (getNode() instanceof gRectShape){
            gRectShape node=(gRectShape) this.getNode();
            node.setBackcolor(color);
        }else {
          //throw new RuntimeException("can't play this effect for this node:"+this.getNode().getId());//todo!
        }
    }

    @Override
    public void stop() {}

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String GetString() {
        return "blink \n"+
                "start :"+this.getStart() +"\n" +
                "stop :" +this.getEndtime()+"\n"+
                "effectcolor :"+ gHandler.convertoColor(this.getColor())+"\n";

    }
}
