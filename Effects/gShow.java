package Effects;

import Game.DrawPanel;
import Shapes.gShape;

public class gShow extends gEffect {
    public gShow(gShape node, int starttime, int endtime) {
        super(node, starttime, endtime);
    }

    @Override
    public void play() {
        DrawPanel.addShape(getNode());
    }

    @Override
    public void stop() {}
}
