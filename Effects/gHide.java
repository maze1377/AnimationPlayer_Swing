package Effects;

import Shapes.gShape;

public class gHide extends gEffect {
    public gHide(gShape node, int starttime, int endtime) {
        super(node, starttime, endtime);
    }

    @Override
    public void play() {
        //todo remove node from list
    }

    @Override
    public void stop() {}
}
