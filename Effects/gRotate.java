package Effects;

import Shapes.gShape;

public class gRotate extends gChangeable {
    private double delta;
    private double step;
    public gRotate(gShape node, int starttime, int endtime,double delta) {
        super(node, starttime, endtime);
        setDelta(delta);
    }

    public gRotate()
    {
        super(null,0,0);
    }


    @Override
    public void play() {
        super.play();
        this.getNode().setDelta(this.getNode().getDelta()+this.step);
    }

    @Override
    public void init() {
        try {
            step=(this.delta-this.getNode().getDelta())/(this.getEndTime()-this.getStart());
        }catch (Exception e){
            e.printStackTrace();
            step=(this.delta-this.getNode().getDelta());
        }
    }

    @Override
    public void stop() {
        this.getNode().setDelta(0);
    }

    @Override
    public String GetString() {
        return "slowmove \n"+
                "start :"+this.getStart() +"\n" +
                "stop :" +this.getEndTime()+"\n"+
                "delta : " + this.getDetail() + "\n" ;
    }

    public double getDelta() {
        return delta;
    }

    public void setDelta(double delta) {
        this.delta = delta;
    }
}
