package Effects;

import Shapes.gShape;

public class gChangeable extends gEffect implements Runnable {
    private Thread thread;
    public gChangeable(gShape node, int starttime, int endtime) {
        super(node, starttime, endtime);
    }

    @Override
    public final void play() {
        thread=new Thread(this);
        thread.start();
    }

    @Override
    public void stop() {
        thread.stop();
    }

    @Override
    public void run() {
        //todo por konamesh!!!
    }
}
