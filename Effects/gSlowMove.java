package Effects;

import Shapes.gShape;

public class gSlowMove extends gChangeable {
    private int x2;
    private int y2;
    private int delta;

    public gSlowMove(gShape node, int starttime, int endtime, int x2, int y2) {
        super(node, starttime, endtime);
        setX2(x2);
        setY2(y2);
    }

    @Override
    public void run() {
        super.run();
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public int getDelta() {
        return delta;
    }

    public void setDelta(int delta) {
        this.delta = delta;
    }
}
