package Effects;

import Shapes.gShape;

public abstract class gChangeable extends gEffect {
    boolean Firstplay=true;
    public gChangeable(gShape node, int starttime, int endtime) {
        super(node, starttime, endtime);
    }

    @Override
    public void play() {
        if (Firstplay){
            init();
            Firstplay=false;
        }
    }

    public abstract void init();
}
