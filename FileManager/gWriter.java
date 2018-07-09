package FileManager;

import Common.DataBase;
import Common.Setting;
import Shapes.gShape;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.Formatter;

public class gWriter {
    private Path Destination;
    private Formatter writer;
    public gWriter(Path destination) {
        Destination = destination;
        try {
            writer=new Formatter(Destination.toFile());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void WriteAll(){
        writer.format("frames: %d\n",Setting.TotalFrame);
        writer.format("speed: %d fps\n",Setting.speed);
        writer.format("Items: %d\n",DataBase.getgShapeArrayList().size());
        for (Integer x:DataBase.RootEffects.keySet()){
            writer.format("mode: %d\n",DataBase.RootEffects.get(x));
            writer.format("start: %d\n",x);
        }
        for (gShape x:DataBase.getgShapeArrayList()) {
            writer.format("\n");
            writer.format("%s",x.GetString());
            writer.format("\n");
        }
        writer.format("\n\n");
        writer.flush();
    }
}
