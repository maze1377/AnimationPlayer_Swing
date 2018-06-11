package Game;


import Common.Setting;
import Shapes.gShape;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DrawPanel extends JComponent {
    private static List<gShape> shapes = new ArrayList<gShape>();

    public DrawPanel() {
        super();
//        setOpaque(true);
//        setBackground(Color.green);//??
        setPreferredSize(new Dimension(Setting.width, Setting.height));
    }

    public static void addShape(gShape x) {
        shapes.add(x);
    }

    public static void removeShape(gShape x) {
        shapes.remove(x);
    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        Graphics2D g2 = (Graphics2D) g;
        gInitialize(g);
        for (gShape x : shapes) {
            x.Draw(g);
        }

    }

    private void gInitialize(Graphics g) {
        g.setColor(new Color(0, 0, 0));
        g.fillRect(1, 1, getWidth() - 2, getHeight() - 2);

        g.setColor(Color.red);
        g.drawRect(1, 1, getWidth() - 2, getHeight() - 2);
    }
}
