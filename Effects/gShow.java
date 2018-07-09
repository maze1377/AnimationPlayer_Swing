package Effects;

import Game.DrawPanel;
import Shapes.gShape;

public class gShow extends gEffect {
    public gShow(gShape node, int starttime, int endtime) {
        super(node, starttime, endtime);
    }

    public gShow(){
        super(null,0,0);
    }

    @Override
    public void play() {
        DrawPanel.addShape(getNode());
    }

    @Override
    public void stop() {}

    @Override
    public String GetString() {
        return "show \n"+
                "start :"+this.getStart() +"\n";
    }
}
