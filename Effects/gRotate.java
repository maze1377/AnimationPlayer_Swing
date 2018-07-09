package Effects;

import Shapes.gShape;

public class gRotate extends gChangeable {
    public gRotate(gShape node, int starttime, int endtime) {
        super(node, starttime, endtime);
    }

    public gRotate()
    {
        super(null,0,0);
    }

    @Override
    public void init() {

    }

    @Override
    public void play() {
        super.play();
        //todo..
    }

    @Override
    public void stop() {

    }

    @Override
    public String GetString() {
        return null;
    }
}
