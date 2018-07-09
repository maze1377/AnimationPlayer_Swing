package Game;


import Common.Setting;
import Effects.gRootEffect;
import Shapes.gShape;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DrawPanel extends JComponent {
    private static List<gShape> shapes = new ArrayList<gShape>();
    private long lastupdate=1000;//for start first time!!
    private gRootEffect rootEffect;

    public gRootEffect getRootEffect() {
        return rootEffect;
    }

    public DrawPanel() {
        super();
        rootEffect=new gRootEffect();
        setOpaque(true);
        setPreferredSize(new Dimension(Setting.width, Setting.height));
    }

    public static synchronized void addShape(gShape x) {
        shapes.add(x);
    }

    public static synchronized void removeShape(gShape x) {
        shapes.remove(x);
    }

    @Override
    protected synchronized void paintComponent(Graphics g) {
        super.paintComponent(g);
        lastupdate++;
         if(lastupdate>Setting.getSpeed())//just for lower process!!
        {
            gInitialize(g);
            lastupdate=0;
        }
        for (gShape x : DrawPanel.shapes) {
            x.Draw(g);
        }
    }

    private void gInitialize(Graphics g) {
        rootEffect.paintComponent(g,this);
    }

}