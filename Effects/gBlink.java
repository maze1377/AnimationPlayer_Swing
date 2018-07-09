package Effects;

import Game.DrawPanel;
import Shapes.gShape;

public class gBlink extends gChangeable {
    boolean swHide;
    public gBlink(gShape node, int starttime, int endtime) {
        super(node, starttime, endtime);
    }

    @Override
    public void init() {
        swHide=false;
    }

    @Override
    public void play() {
        super.play();
        if (swHide){
            DrawPanel.addShape(getNode());
            swHide=false;
        }else {
            DrawPanel.removeShape(getNode());
            swHide=true;
        }
    }

    @Override
    public void stop() {

    }
}
