package Effects;

import Game.DrawPanel;
import Shapes.gShape;

public class gHide extends gEffect {//done
    public gHide(gShape node, int starttime, int endtime) {
        super(node, starttime, endtime);
    }

    @Override
    public void play() {
        DrawPanel.removeShape(getNode());
    }

    @Override
    public void stop() {}
}
