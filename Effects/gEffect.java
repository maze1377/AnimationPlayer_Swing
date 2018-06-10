package Effects;

import Shapes.gShape;

import java.util.Objects;

public abstract class gEffect {
    private gShape node;
    private int starttime;
    private int endtime;

    public gEffect(gShape node, int starttime, int endtime) {
        this.node = node;
        this.starttime = starttime;
        this.endtime = endtime;
    }

    public int getStart() {
        return starttime;
    }

    public void setStart(int start) {
        this.starttime = start;
    }

    public int getEndtime() {
        return endtime;
    }

    public void setEndtime(int endtime) {
        this.endtime = endtime;
    }

    public gShape getNode() {
        return node;
    }

    public void setNode(gShape node) {
        this.node = node;
    }
    public abstract void play();
    public abstract void stop();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof gEffect)) return false;
        gEffect gEffect = (gEffect) o;
        return starttime == gEffect.starttime &&
                getEndtime() == gEffect.getEndtime() &&
                Objects.equals(getNode(), gEffect.getNode());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getNode(), starttime, getEndtime());
    }
}
