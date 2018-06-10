package Game;

import Common.Date;
import Common.Setting;
import Shapes.gShape;

import javax.swing.*;
import java.awt.*;

public class gMain extends JFrame {
    private static int speed = 20;//todo az file bekhone...
    private static int currentFtp = 0;//todo az file bekhone...

    public gMain() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, Setting.width, Setting.height);
        this.setTitle("Test");
        this.setLayout(new FlowLayout());
        //
        this.add(new DrawPanel());
        //main loop:
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

                    float secondsElapsed = (currentTime - previousTime) / 1e9f;
                    previousTime = currentTime;
                    secondsElapsedSinceLastFpsUpdate += secondsElapsed;
                    if (secondsElapsedSinceLastFpsUpdate >= 0.000001) {//todo update time with fram...!(timesh kharabe)
                        currentFtp++;
                        Update(currentFtp);
                        secondsElapsedSinceLastFpsUpdate = 0;
                    }
                }
            }
        });
        loop.setPriority(Thread.MAX_PRIORITY);
        loop.start();
        //end Loop
        setVisible(true);
    }

    private void Update(int currentFtp) {
        System.out.println(System.currentTimeMillis()+"///\\\\"+currentFtp+"done!");
        for (gShape x : Date.getgShapeArrayList()) {
            x.PlayLoop(currentFtp);
        }
    }

}
