package FileManager;

import Common.Date;
import Common.Setting;
import Effects.gEffect;
import Shapes.gShape;

import java.util.ArrayList;
import java.util.List;

public class gFrameManager {
    private static final List<gFrame> gFrameList = new ArrayList<>();
    private static final gFrameManager ourInstance = new gFrameManager();
    private static long NumberofEffect = 1;
    private static gFrame CurrnetFrame = new gFrame(NumberofEffect);

    private gFrameManager() {
    }

    public static gFrameManager getInstance() {
        return ourInstance;
    }

    public void NextFrame() {
        CurrnetFrame = new gFrame(++NumberofEffect);
    }

    public void addgEffect(gEffect x) {
        CurrnetFrame.addgEffect(x);
    }

    public void RemoveEffect(gEffect x) {
        CurrnetFrame.RemoveEffect(x);
    }

    public void InitFrame(){
        for (int i=0;i<Setting.TotalFrame;i++){
            for (gShape x : Date.getgShapeArrayList()) {
                x.PlayLoop(i);
            }
        }
    }
}
