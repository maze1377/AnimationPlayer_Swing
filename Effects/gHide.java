package Effects;

import Game.DrawPanel;
import Shapes.gShape;

public class gHide extends gEffect {//done
    public gHide(gShape node, int starttime, int endtime) {
        super(node, starttime, endtime);
    }
    public gHide()
    {
        super(null,0,0);
    }
    @Override
    public void play() {
        DrawPanel.removeShape(getNode());
    }

    @Override
    public void stop() {}
    @Override
    public String GetString() {
        return "changecolor \n"+
                "start :"+this.getStart() +"\n";
    }
}
