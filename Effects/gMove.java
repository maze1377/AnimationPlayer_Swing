package Effects;

import Shapes.gShape;

public class gMove extends gEffect {
    private int x2;
    private int y2;

    public gMove(gShape node, int starttime, int endtime, int x2, int y2) {
        super(node, starttime, endtime);
        setX2(x2);
        setY2(y2);
    }

    @Override
    public void play() {
    this.getNode().setX1(getX2());
    this.getNode().setY1(getY2());
    }

    @Override
    public void stop() { }

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
}
