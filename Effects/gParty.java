package Effects;

import Shapes.gRectShape;
import Shapes.gShape;

import java.awt.*;

public class gParty extends gChangeable {
    public gParty(gShape node, int starttime, int endtime) {
        super(node, starttime, endtime);
    }

    @Override
    public void init() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void play() {
        super.play();
        this.getNode().setBordercolor(new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256)));
        if (this.getNode() instanceof gRectShape){
            gRectShape x=(gRectShape) this.getNode();
            x.setBackcolor(new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256)));
        }
    }

    @Override
    public String GetString() {
        return "Party \n"+
                "start :"+this.getStart() +"\n" +
                "stop :" +this.getEndTime()+"\n";
    }
}
