package Effects;

import Shapes.gShape;

public class gScale extends gChangeable{
    private double scale;
    private double step;
    public gScale(gShape node, int starttime, int endtime,double scale) {
        super(node, starttime, endtime);
        setScale(scale);
    }

    public gScale() {
        super( null, 0, 0);
        setScale(0);
    }

    @Override
    public void play() {
        super.play();
        this.getNode().setScale(this.getNode().getScale()+this.step);
    }

    @Override
    public void init() {
        try {
            step=(this.scale -this.getNode().getScale())/(this.getEndTime()-this.getStart());
        }catch (Exception x){
            x.printStackTrace();
            step=(this.scale -this.getNode().getScale());
        }
    }

    @Override
    public void stop() {
        this.getNode().setScale(1);
    }

    @Override
    public String GetString() {
        return "scale \n"+
                "start :"+this.getStart() +"\n" +
                "stop :" +this.getEndTime()+"\n"+
                "scales : " + this.getScale() + "\n" ;
    }

    public double getScale() {
        return scale;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }
}
