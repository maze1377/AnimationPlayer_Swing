package FileManager;

import Effects.gEffect;

import java.util.ArrayList;
import java.util.List;

public class gFrame {
    private List<gEffect> NowEffect=new ArrayList<>();
    private final long FrameId;

    public gFrame(long frameId) {
        FrameId = frameId;
    }
    public void addgEffect(gEffect x){
        NowEffect.add(x);
    }
    public void RemoveEffect(gEffect x){
        NowEffect.remove(x);
    }

}
