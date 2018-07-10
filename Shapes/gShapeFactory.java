package Shapes;

import EX.ShapeNotFind;
import FileManager.gHandler;

import java.util.Map;

public class gShapeFactory {
    public static gShape MakeEffect(Map<String, String> x) throws ShapeNotFind {
        gShape temp;
        switch (x.get("shape")) {
            case "circle":
                temp=
                        new gCircle(gHandler.getColor(x.get("bordercolor")), Integer.parseInt(x.get("r")), Integer.parseInt(x.get("dashtype")),
                                Integer.parseInt(x.get("x1")), Integer.parseInt(x.get("y1")), Boolean.valueOf(x.get("isfilled")), gHandler.getColor(x.get("backcolor")),
                                Integer.parseInt(x.get("id")));
                break;
            case "text":
            case "label":
                temp= new gLabel(Integer.parseInt(x.get("x1")), Integer.parseInt(x.get("y1")), gHandler.getColor(x.get("bordercolor")),
                        Integer.parseInt(x.get("height")), Integer.parseInt(x.get("width")), Integer.parseInt(x.get("dashtype")),
                        x.get("text"), gHandler.getFont(x), Integer.parseInt(x.get("id")),gHandler.getColor(x.get("fontcolor")));
                break;
            case "line":
                temp= new gLine(gHandler.getColor(x.get("bordercolor")),
                        Integer.parseInt(x.get("dashtype")), Integer.parseInt(x.get("x1")), Integer.parseInt(x.get("y1")), Integer.parseInt(x.get("x2")),
                        Integer.parseInt(x.get("y2")), Integer.parseInt(x.get("id")));
                break;
            case "oval":
                temp= new gOval(gHandler.getColor(x.get("bordercolor")), Integer.parseInt(x.get("r1")), Integer.parseInt(x.get("r2")), Integer.parseInt(x.get("dashtype")),
                        Integer.parseInt(x.get("x1")), Integer.parseInt(x.get("y1")), Boolean.valueOf(x.get("isfilled")), gHandler.getColor(x.get("backcolor")),
                        Integer.parseInt(x.get("id")));
                break;
            case "rect":
                temp= new gRect(gHandler.getColor(x.get("bordercolor")), Integer.parseInt(x.get("height")), Integer.parseInt(x.get("width")), Integer.parseInt(x.get("dashtype")),
                        Integer.parseInt(x.get("x1")), Integer.parseInt(x.get("y1")), Integer.parseInt(x.get("x2")),
                        Integer.parseInt(x.get("y2")), Boolean.valueOf(x.get("isfilled")), gHandler.getColor(x.get("backcolor")),
                        Integer.parseInt(x.get("id")));
                break;
            case "square":
                temp= new gSquare(gHandler.getColor(x.get("bordercolor")), Integer.parseInt(x.get("length")), Integer.parseInt(x.get("dashtype")),
                        Integer.parseInt(x.get("x1")), Integer.parseInt(x.get("y1")), Boolean.valueOf(x.get("isfilled")), gHandler.getColor(x.get("backcolor")),
                        Integer.parseInt(x.get("id")));
                break;
            default:
                throw new ShapeNotFind("shape not find!!");
        }
        temp.setBorderSize(Integer.parseInt(x.get("bordersize")));//todo creat new construct for add bordersize method...
        return temp;
    }

}
