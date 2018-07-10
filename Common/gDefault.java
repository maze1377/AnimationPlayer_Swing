package Common;

import java.util.HashMap;
import java.util.Map;

public class gDefault {
    public static Map<String, String> GetDefultShapeMap() {
        Map<String, String> shapeDeta = new HashMap<>();
        shapeDeta.put("r", "50");
        shapeDeta.put("r1", "50");
        shapeDeta.put("r2", "100");
        shapeDeta.put("x", "77");
        shapeDeta.put("y", "77");
        shapeDeta.put("isfilled", "true");
        shapeDeta.put("dashtype", "1");
        shapeDeta.put("length", "77");
        shapeDeta.put("height", "77");
        shapeDeta.put("width", "77");
        shapeDeta.put("border", "0.5");
        shapeDeta.put("bordersize", "1");
        shapeDeta.put("backcolor", "255, 0, 0");
        shapeDeta.put("bordercolor", "0, 0, 255");
        shapeDeta.put("x1", "77");
        shapeDeta.put("y1", "77");
        shapeDeta.put("x2", "177");
        shapeDeta.put("y2", "177");
        shapeDeta.put("fontname", "177");
        shapeDeta.put("font", "177");//?
        shapeDeta.put("fontsize", "16");
        shapeDeta.put("text", "Just for test..!");
        shapeDeta.put("effectname", "show");
        shapeDeta.put("effectstart", "1");
        shapeDeta.put("effectend", "1");
        shapeDeta.put("id", "-1");//have to init in filereader..!
        return shapeDeta;
    }
}
