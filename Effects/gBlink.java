package Effects;

import Shapes.gShape;

public class gBlink extends gChangeable {
    boolean swHide=false;
    public gBlink(gShape node, int starttime, int endtime) {
        super(node, starttime, endtime);
    }

    @Override
    public void run() {
        super.run();
        //todo..
    }
}
