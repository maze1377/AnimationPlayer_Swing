package Shapes;

import FileManager.gHandler;

import java.util.Map;

public class gShapeFactory {
    public static gShape MakeEffect(Map<String, String> x) {
        switch (x.get("shape")) {
            case "circle":
                return
                        new gCircle(gHandler.getColor(x.get("bordercolor")), Integer.parseInt(x.get("r")), Integer.parseInt(x.get("dashtype")),
                                Integer.parseInt(x.get("x1")), Integer.parseInt(x.get("y1")), Integer.parseInt(x.get("x2")),
                                Integer.parseInt(x.get("y2")), Boolean.getBoolean(x.get("isfilled")), gHandler.getColor(x.get("backcolor")),
                                Integer.parseInt(x.get("id")));
            case "text":
            case "label":
                return new gLabel(Integer.parseInt(x.get("x1")), Integer.parseInt(x.get("y1")), gHandler.getColor(x.get("bordercolor")),
                        Integer.parseInt(x.get("height")), Integer.parseInt(x.get("width")), Integer.parseInt(x.get("dashtype")),
                        x.get("text"), gHandler.getFont(x), Integer.parseInt(x.get("id")));
            case "line":
                return new gLine(gHandler.getColor(x.get("bordercolor")), Integer.parseInt(x.get("height")), Integer.parseInt(x.get("width")),
                        Integer.parseInt(x.get("dashtype")), Integer.parseInt(x.get("x1")), Integer.parseInt(x.get("y1")), Integer.parseInt(x.get("x2")),
                        Integer.parseInt(x.get("y2")), Integer.parseInt(x.get("id")));
            case "oval":
                return new gOval(gHandler.getColor(x.get("bordercolor")), Integer.parseInt(x.get("r1")), Integer.parseInt(x.get("r2")), Integer.parseInt(x.get("dashtype")),
                        Integer.parseInt(x.get("x1")), Integer.parseInt(x.get("y1")), Integer.parseInt(x.get("x2")),
                        Integer.parseInt(x.get("y2")), Boolean.getBoolean(x.get("isfilled")), gHandler.getColor(x.get("backcolor")),
                        Integer.parseInt(x.get("id")));
            case "rect":
                return new gRect(gHandler.getColor(x.get("bordercolor")), Integer.parseInt(x.get("height")), Integer.parseInt(x.get("width")), Integer.parseInt(x.get("dashtype")),
                        Integer.parseInt(x.get("x1")), Integer.parseInt(x.get("y1")), Integer.parseInt(x.get("x2")),
                        Integer.parseInt(x.get("y2")), Boolean.getBoolean(x.get("isfilled")), gHandler.getColor(x.get("backcolor")),
                        Integer.parseInt(x.get("id")));
            case "Square":
                return new gSquare(gHandler.getColor(x.get("bordercolor")), Integer.parseInt(x.get("height")), Integer.parseInt(x.get("dashtype")),
                        Integer.parseInt(x.get("x1")), Integer.parseInt(x.get("y1")), Integer.parseInt(x.get("x2")),
                        Integer.parseInt(x.get("y2")), Boolean.getBoolean(x.get("isfilled")), gHandler.getColor(x.get("backcolor")),
                        Integer.parseInt(x.get("id")));//square not have weight!!

            default:
                throw new RuntimeException("shape not find!!");
        }

    }

}
