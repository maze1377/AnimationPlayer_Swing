package Common;

import java.awt.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Setting {
    public static final int width=800;
    public static final int height=600;
    public static final Color backGround=new Color(0,0,0);
    public static int speed=20;
    public static int currentFtp=20;
    public static Path CurrentPath= Paths.get("");
    public static int getSpeed() {
        return speed;
    }

    public static void setSpeed(int speed) {
        Setting.speed = speed;
    }

    public static int getCurrentFtp() {
        return currentFtp;
    }

    public static void setCurrentFtp(int currentFtp) {
        Setting.currentFtp = currentFtp;
    }
}
