package Effects;

import Effects.audioplayer.AudioPlayer2;
import Shapes.gShape;

import java.nio.file.Path;

public class gMusic extends gChangeable {
    private Path source;
    private AudioPlayer2 player;

    public gMusic(gShape node, int starttime, int endtime, Path source) {
        super(node, starttime, endtime);
        this.setSource(source);
    }

    @Override
    public void init() {
        player = new AudioPlayer2();
        player.play(source.toString());
    }

    @Override
    public void play() {
        super.play();
    }

    @Override
    public void stop() {
        player.Stop();
    }

    @Override
    public String GetString() {
        return "slowmove \n" +
                "start :" + this.getStart() + "\n" +
                "stop :" + this.getEndTime() + "\n" +
                "Path : " + this.getSource().toString() + "\n";
    }

    public Path getSource() {
        return source;
    }

    public void setSource(Path source) {
        this.source = source;
    }
}
