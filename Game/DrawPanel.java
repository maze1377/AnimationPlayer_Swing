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
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        gInitialize(g);
        for (gShape x : DrawPanel.shapes) {
            x.Draw(g);
        }
    }

    private void gInitialize(Graphics g) {
        g.setColor(new Color(0, 0, 255));
        g.fillRect(1, 1, getWidth() - 2, getHeight() - 2);

        g.setColor(Color.red);
        g.drawRect(1, 1, getWidth() - 2, getHeight() - 2);
    }
}
