package Game;

import Common.DataBase;
import Common.Setting;
import FileManager.gReader;
import FileManager.gWriter;
import Shapes.gShape;

import javax.swing.*;
import java.awt.*;
import java.nio.file.Paths;

public class gMain extends JFrame {
    private int speed;
    private int currentFtp;
    private DrawPanel drawPanel;

    public gMain() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, Setting.width, Setting.height);
        this.setTitle("Test");
        this.setLayout(new FlowLayout());
        currentFtp = Setting.getCurrentFtp();
        speed = Setting.getSpeed();
        //
        new gReader(0);
        drawPanel = new DrawPanel();
        this.add(drawPanel);

        //main loop:
        MainLoop();
        //end Loop
        setVisible(true);
    }

    private void EndWork() {
        drawPanel = new DrawPanel();
        //todo karhaie marbote be paian root
        drawPanel.repaint();
    }

    private void Update(int currentFtp) {
        System.out.println(System.currentTimeMillis() + "///\\\\" + currentFtp + "done!");
        for (gShape x : DataBase.getgShapeArrayList()) {
            x.PlayLoop(currentFtp);
        }
        drawPanel.getRootEffect().PlayLoop(currentFtp);
        this.setTitle("currentFtp :"+currentFtp+",totalFtp:"+Setting.TotalFrame);
    }

    private void MainLoop() {
        init();
        Thread loop = new Thread(new Runnable() {
            private long previousTime = 0;
            private float secondsElapsedSinceLastFpsUpdate = 0f;

            @Override
            public void run() {
                while (true) {
                    long currentTime = System.currentTimeMillis();
                    if (previousTime == 0) {
                        previousTime = currentTime;
                    }

                    float secondsElapsed = (currentTime - previousTime) / 1e3f;
                    previousTime = currentTime;
                    secondsElapsedSinceLastFpsUpdate += secondsElapsed;
                    if (secondsElapsedSinceLastFpsUpdate >= 1.0 / Setting.getSpeed()) {//todo update time with fram...!(timesh kharabe)
                        currentFtp++;
                        Update(currentFtp);
                        drawPanel.repaint();
                        System.out.println();
                        secondsElapsedSinceLastFpsUpdate = 0;
                    }
                    if (currentFtp >= Setting.TotalFrame) {
                        EndWork();
                        return;
                    }
                }
            }
        });
        loop.setPriority(Thread.MAX_PRIORITY);
        loop.start();
    }

    private void init() {
        for (int i = 0; i <= currentFtp; i++) {
            Update(i);
        }
    }
}
