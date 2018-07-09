package Effects;

import Common.DataBase;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.HashMap;
import java.util.Map;

public class gRootEffect {
    private int depth = 0;
    private int direction = 0;
    private int choose = 7;
    private Color color = Color.red;

    public gRootEffect() {
        setRootEffects(DataBase.RootEffects);
    }

    private Map<Integer,Integer> RootEffects=new HashMap<>();

    public void setRootEffects(Map<Integer, Integer> rootEffects) {
        RootEffects = rootEffects;
    }

    public void setChoose(int choose) {
        this.choose = choose;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void paintComponent(Graphics g, JComponent x) {
        Graphics2D g2 = (Graphics2D) g;

        g.setColor(Color.BLACK);
        g.fillRect(0,0,x.getWidth(),x.getHeight());
        g.setColor(Color.red);
        g.drawRect(1, 1, x.getWidth()-1 , x.getHeight()-1);
        if (choose == 0){
            g.setColor(color);
            g.fillRect(0,0,x.getWidth(),x.getHeight());
        }
        else if (choose == 1)
            draw1(g2, 2, 2, x.getWidth() - 1, 2, x.getWidth() - 1, x.getHeight() - 1, 2, x.getHeight() - 1);
        else if (choose == 2)
            draw2(g2, 2, 2, x.getWidth() - 1, x.getHeight() - 1);
        else if (choose == 3)
            draw3(g2, x.getWidth() / 2, 2, 2, x.getHeight() - 2, x.getWidth() - 2, x.getHeight() - 2);
        else if (choose == 4)
            draw4(g2, x.getWidth() / 2, x.getHeight() / 2, 2);
        else if (choose == 5)
            draw5(g2, 10, 10, 700, 700);
        else if (choose == 6)
            draw6(g2, 250, 200, 200);
        else if (choose == 7)
            draw7(g2, 400, 350);
        else if (choose == 8)
            draw8(g2, 360, 650, 360, 480);
        else if (choose == 9)
            draw9(g2, 300, 350);
        else if (choose == 10)
            draw10(g2, 350, 350, 200);
        depth = 0;
    }

    private void draw1(Graphics2D g2, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        Polygon pp = new Polygon();
        pp.addPoint(x1, y1);
        pp.addPoint(x2, y2);
        pp.addPoint(x3, y3);
        pp.addPoint(x4, y4);

        g2.setColor(new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256)));
        g2.fillPolygon(pp);

        if (Math.abs(Math.sqrt(((x1 - x2) * (x1 - x2)) + ((y1 - y2) * (y1 - y2)))) > 5)
            draw1(g2, (x1 + x2) / 2, (y1 + y2) / 2, (x2 + x3) / 2, (y2 + y3) / 2, (x3 + x4) / 2, (y3 + y4) / 2, (x4 + x1) / 2, (y4 + y1) / 2);
    }

    private void draw4(Graphics2D g2, int x1, int y1, int lenght) {
        Polygon pp = new Polygon();
        pp.addPoint(x1, y1);
        Point newPoint = null;

        if (direction == 0)
            newPoint = new Point(x1 + lenght, y1);
        else if (direction == 1)
            newPoint = new Point(x1, y1 - lenght);
        else if (direction == 2)
            newPoint = new Point(x1 - lenght, y1);
        else if (direction == 3)
            newPoint = new Point(x1, y1 + lenght);

        pp.addPoint(newPoint.x, newPoint.y);
        g2.setColor(new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256)));
        //g2.setColor(Color.black);
        g2.drawPolygon(pp);

        direction = (direction + 1) % 4;
        lenght = (int) (lenght * 1.03) + 1;
        //lenght=lenght+1;

        if (lenght < 800)
            draw4(g2, newPoint.x, newPoint.y, lenght);
    }

    private void draw3(Graphics2D g2, int x1, int y1, int x2, int y2, int x3, int y3) {
        Polygon pp = new Polygon();
        pp.addPoint(x1, y1);
        pp.addPoint(x2, y2);
        pp.addPoint(x3, y3);

        g2.setColor(new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256)));
        g2.fillPolygon(pp);
        //g2.drawPolygon(pp);

        if (Math.abs(Math.sqrt(((x1 - x2) * (x1 - x2)) + ((y1 - y2) * (y1 - y2)))) > 5) {
            draw3(g2, x1, y1, (x1 + x3) / 2, (y1 + y3) / 2, (x1 + x2) / 2, (y1 + y2) / 2);
            draw3(g2, x2, y2, (x2 + x3) / 2, (y2 + y3) / 2, (x1 + x2) / 2, (y1 + y2) / 2);
            draw3(g2, x3, y3, (x1 + x3) / 2, (y1 + y3) / 2, (x3 + x2) / 2, (y3 + y2) / 2);
        }
    }

    private void draw2(Graphics2D g2, int x1, int y1, int w, int h) {

        g2.setColor(new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256)));
        g2.fillRect(x1, y1, w, h);

        depth++;
        if (depth < 30)
            draw2(g2, x1 + depth, y1 + depth, w - 2 * depth, h - 2 * depth);


    }

    private void draw6(Graphics2D g2, int x, int y, int w) {
          g2.setColor(new Color((int) (Math.random()*256), (int) (Math.random()*256), (int) (Math.random()*256)));
          double teta=(Math.random()*2);
          g2.rotate(teta, x, y);
        //g2.setColor(Color.red);
        g2.fillOval(x, y, w, w);

        if (w > 1) {
            draw6(g2, x - 5 * w / 12, y - 5 * w / 12, 5 * w / 12);
            draw6(g2, x + w, y - 5 * w / 12, 5 * w / 12);
            draw6(g2, x + w, y + w, 5 * w / 12);
            draw6(g2, x - 5 * w / 12, y + w, 5 * w / 12);
        }
        g2.rotate(-teta, x, y);

    }

    private void draw7(Graphics2D g2, int x, int y) {
        g2.setColor(new Color((int) (Math.random()*256), (int) (Math.random()*256), (int) (Math.random()*256)));
        double theta;

        // end points of latest line drawn
        Point lastPoint;
        Point newPoint;

        // center of current spiral
        Point center;

        // How many points to draw per circle
        double STEPS_PER_ROTATION = 7;

        // Amount to add to angle at each step
        double increment = 2 * Math.PI / STEPS_PER_ROTATION;

        // Use position of mouse press to determine center of spiral
        center = new Point(x, y);
        lastPoint = center;
        theta = increment;

        float i = 1;
        while (theta < 10 * Math.PI) {
            newPoint = new Point((int) (center.getX() + i * theta * Math.cos(theta)), (int) (center.getY() + i * theta * Math.sin(theta)));

            g2.drawLine(lastPoint.x, lastPoint.y, newPoint.x, newPoint.y);
            depth++;
            if (i > 5)
                depth += 3;

            //g2.fillOval(newPoint.x-depth/2, newPoint.y-depth/2, depth, depth);

            //draw1(g2, newPoint.x-depth/2, newPoint.y-depth/2, newPoint.x-depth/2, newPoint.y+depth/2, newPoint.x+depth/2,
            //		newPoint.y+depth/2, newPoint.x+depth/2, newPoint.y-depth/2);

            draw6(g2, newPoint.x - depth / 2, newPoint.y - depth / 2, depth);

            theta = theta + increment;
            lastPoint = newPoint;
            i = i * 1.08f;
        }
    }

    private void draw5(Graphics2D g2, int x1, int y1, int x2, int y2) {
        int w = Math.abs(x2 - x1);
        int h = Math.abs(y2 - y1);

        g2.setColor(new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256)));
        g2.fillRect(x1, y1, w, h);

        g2.setColor(new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256)));
        g2.fillOval(x1, y1, w / 2, h / 2);
        g2.fillOval(x1 + w / 2, y1, w / 2, h / 2);
        g2.fillOval(x1, y1 + h / 2, w / 2, h / 2);
        g2.fillOval(x1 + w / 2, y1 + h / 2, w / 2, h / 2);

        if (Math.abs(Math.sqrt(((x1 - x2) * (x1 - x2)) + ((y1 - y2) * (y1 - y2)))) > 15 && x1 < x2) {
            draw5(g2, x1 + w / 13, y1 + w / 13, x1 + w / 2 - w / 13, y1 + h / 2 - h / 13);
            draw5(g2, x1 + w / 2 + w / 13, y1 + w / 13, x2 - w / 13, y1 + h / 2 - h / 13);
            draw5(g2, x1 + w / 13, y1 + h / 2 + w / 13, x1 + w / 2 - w / 13, y2 - h / 13);
            draw5(g2, x1 + w / 2 + w / 13, y1 + w / 2 + w / 13, x2 - w / 13, y2 - h / 13);
        }
    }

    private void draw9(Graphics2D g2, int x, int y) {
        g2.setColor(new Color((int) (Math.random()*256), (int) (Math.random()*256), (int) (Math.random()*256)));
        double theta;

        Point lastPoint;
        Point newPoint = null;

        // center of current spiral
        Point center = new Point(x, y);

        // How many points to draw per circle
        double STEPS_PER_ROTATION = 30;

        // Amount to add to angle at each step
        double increment = 2 * Math.PI / STEPS_PER_ROTATION;

        lastPoint = center;
        theta = increment;

        float i = 1;
        for (int jj = 0; jj < 160; jj++) {
            /** make center at below statement to lastpoint for make the map like
             * 3d */
            newPoint = new Point((int) (center.getX() + i * theta * Math.cos(theta)), (int) (center.getY() + i * theta * Math.sin(theta)));

            g2.drawLine(lastPoint.x, lastPoint.y, newPoint.x, newPoint.y);

            //drawF8(g2, lastPoint.x, lastPoint.y, newPoint.x, newPoint.y);
            draw8(g2, lastPoint.x, lastPoint.y, newPoint.x, newPoint.y);

            theta = theta + increment;
            lastPoint = newPoint;
            i = i * 1.016f;
        }

    }

    private void draw8(Graphics2D g2, int x1, int y1, int x2, int y2) {
        int degree = (int) Math.toDegrees(Math.atan2((y2 - y1), (x2 - x1)));
        int w = (int) Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        int newX1, newY1, newX2, newY2, newX3, newY3, newX4, newY4;

        g2.setColor(new Color((int) (Math.random()*256), (int) (Math.random()*256), (int) (Math.random()*256)));
        g2.drawLine(x1, y1, x2, y2);


        g2.rotate(Math.toRadians(degree), x2, y2);
        g2.drawLine(x2, y2, x2 + (w) / 3, y2 - w / 2);
        g2.drawLine(x2, y2, x2 + (2 * w) / 3, y2 - w / 3);
        g2.drawLine(x2, y2, x2 + (w) / 3, y2 + w / 2);
        g2.drawLine(x2, y2, x2 + (2 * w) / 3, y2 + w / 3);


        g2.rotate(-Math.toRadians(degree), x2, y2);

        double[] pt = {0, 0};

        pt[0] = x2 + (w) / 3;
        pt[1] = y2 - w / 2;
        AffineTransform.getRotateInstance(Math.toRadians(degree), x2, y2).transform(pt, 0, pt, 0, 1);
        newX1 = (int) pt[0];
        newY1 = (int) pt[1];


        pt[0] = x2 + (2 * w) / 3;
        pt[1] = y2 - w / 3;
        AffineTransform.getRotateInstance(Math.toRadians(degree), x2, y2).transform(pt, 0, pt, 0, 1);
        newX2 = (int) pt[0];
        newY2 = (int) pt[1];


        pt[0] = x2 + (2 * w) / 3;
        pt[1] = y2 + w / 3;
        AffineTransform.getRotateInstance(Math.toRadians(degree), x2, y2).transform(pt, 0, pt, 0, 1);
        newX3 = (int) pt[0];
        newY3 = (int) pt[1];

        pt[0] = x2 + (w) / 3;
        pt[1] = y2 + w / 2;
        AffineTransform.getRotateInstance(Math.toRadians(degree), x2, y2).transform(pt, 0, pt, 0, 1);
        newX4 = (int) pt[0];
        newY4 = (int) pt[1];


        if (w > 20) {
            draw8(g2, x2, y2, newX1, newY1);
            draw8(g2, x2, y2, newX2, newY2);
            draw8(g2, x2, y2, newX3, newY3);
            draw8(g2, x2, y2, newX4, newY4);
        }

    }

    private void draw10(Graphics2D g2, int x1, int y1, int length) {
        g2.setColor(new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256)));

        g2.drawLine(x1 - length, y1, x1 + length, y1);
        g2.drawLine(x1 - length, y1 - length, x1 - length, y1 + length);
        g2.drawLine(x1 + length, y1 - length, x1 + length, y1 + length);

        if (length > 15) {
            draw10(g2, x1 - length, y1 - length, length / 2);
            draw10(g2, x1 - length, y1 + length, length / 2);
            draw10(g2, x1 + length, y1 - length, length / 2);
            draw10(g2, x1 + length, y1 + length, length / 2);
        }
    }

    public void PlayLoop(int currentFtp){
        for (Integer x:RootEffects.keySet()){
            if (x==currentFtp){
                choose=RootEffects.get(x);
            }
        }
    }

}
