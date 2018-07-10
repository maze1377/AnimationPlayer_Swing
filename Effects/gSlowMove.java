package Effects;

import Shapes.gShape;

public class gSlowMove extends gChangeable {
    private int x2;
    private int y2;
    private double deltax;
    private double deltay;

    public gSlowMove(gShape node, int starttime, int endtime, int x2, int y2) {
        super(node, starttime, endtime);
        setX2(x2);
        setY2(y2);
    }

    public gSlowMove() {
        super(null, 0, 0);
        setX2(0);
        setY2(0);
    }

    @Override
    public void init() {
        try {
            deltay = (getY2() - getNode().getY1()) / (this.getEndTime() - this.getStart());
            deltax = (getX2() - getNode().getX1()) / (this.getEndTime() - this.getStart());
        } catch (Exception x) {
            x.printStackTrace();
            deltay = (getY2() - getNode().getY1());
            deltax = (getX2() - getNode().getX1());
        }
    }

    @Override
    public void play() {
        super.play();
        this.getNode().setX1((int) (getNode().getX1() + deltax));
        this.getNode().setY1((int) (getNode().getY1() + deltay));
    }

    @Override
    public void stop() {

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

    @Override
    public String GetString() {
        return "slowmove \n" +
                "start :" + this.getStart() + "\n" +
                "stop :" + this.getEndTime() + "\n" +
                "x2 : " + this.getX2() + "\n" +
                "y2 : " + this.getY2() + "\n";
    }
}
