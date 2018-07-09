package Effects;

import Common.DataBase;
import FileManager.gHandler;
import Shapes.gShape;

import java.util.Map;

public class gEffectFactory {
    //map haveto have effectname

    public static gEffect MakeEffect(Map<String, String> x) {
        int startTime = Integer.parseInt(x.get("effectstart"));
        int endTime = Integer.parseInt(x.get("effectstop"));
        switch (x.get("effectname")) {
            case "hide":
                return new gHide(DataBase.FindById(Integer.parseInt(x.get("id"))), startTime, startTime);
            case "show":
                return new gShow(DataBase.FindById(Integer.parseInt(x.get("id"))), startTime, startTime);
            case "changecolor":
                return new gChangeColor(DataBase.FindById(Integer.parseInt(x.get("id"))), startTime, startTime, gHandler.getColor(x.get("effectcolor")));
            case "move":
                return new gMove(DataBase.FindById(Integer.parseInt(x.get("id"))), startTime, startTime, Integer.parseInt(x.get("x2")), Integer.parseInt(x.get("y2")));
            case "slowmove":
                return new gSlowMove(DataBase.FindById(Integer.parseInt(x.get("id"))), startTime, endTime, Integer.parseInt(x.get("x2")), Integer.parseInt(x.get("y2")));
            case "rotate":
                return new gRotate(DataBase.FindById(Integer.parseInt(x.get("id"))), startTime, endTime);
            case "blink":
                return new gBlink(DataBase.FindById(Integer.parseInt(x.get("id"))), startTime, endTime);
            default:
                throw new RuntimeException("effect not find!!");
        }
    }
    public static gEffect MakeEffect(Map<String, String> x, gShape node) {
        int startTime = Integer.parseInt(x.get("effectstart"));
        int endTime = Integer.parseInt(x.get("effectstop"));
        switch (x.get("effectname")) {
            case "hide":
                return new gHide(node, startTime, startTime);
            case "show":
                return new gShow(node, startTime, startTime);
            case "changecolor":
                //return new gChangeColor(node, startTime, startTime, x.get("effectcolor"));//todo how cast string to color...!
            case "move":
                return new gMove(node, startTime, startTime, Integer.parseInt(x.get("x2")), Integer.parseInt(x.get("y2")));
            case "slowmove":
                return new gSlowMove(node, startTime, endTime, Integer.parseInt(x.get("x2")), Integer.parseInt(x.get("y2")));
            case "rotate":
                return new gRotate(node, startTime, endTime);
            case "blink":
                return new gBlink(node, startTime, endTime);
            default:
                throw new RuntimeException("effect not find!!");
        }
    }
}
