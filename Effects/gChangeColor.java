package Effects;

import Shapes.gShape;

import java.awt.*;

public class gChangeColor extends gEffect {
    private Color color;

    public gChangeColor(gShape node, int starttime, int endtime, Color color) {
        super(node, starttime, endtime);
        setColor(color);
    }

    @Override
    public void play() {//todo cast baiad beshe!?
        this.getNode();
    }

    @Override
    public void stop() {}

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
