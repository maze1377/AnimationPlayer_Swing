package Effects;

import Common.DataBase;
import EX.EffectNotFind;
import FileManager.gHandler;
import Shapes.gShape;

import java.nio.file.Paths;
import java.util.Map;

public class gEffectFactory {


    public static gEffect MakeEffect(Map<String, String> x) throws EffectNotFind {
        int startTime = Integer.parseInt(x.get("effectstart"));
        int endTime = Integer.parseInt(x.get("effectstop"));
        gEffect effect = null;
        gShape shape = DataBase.FindById(Integer.parseInt(x.get("id")));
        switch (x.get("effectname")) {
            case "hide":
                effect = new gHide(DataBase.FindById(Integer.parseInt(x.get("id"))), startTime, startTime);
                break;
            case "show":
                effect = new gShow(DataBase.FindById(Integer.parseInt(x.get("id"))), startTime, startTime);
                break;
            case "changecolor":
                effect = new gChangeColor(DataBase.FindById(Integer.parseInt(x.get("id"))), startTime, startTime, gHandler.getColor(x.get("effectcolor")));
                break;
            case "move":
                effect = new gMove(DataBase.FindById(Integer.parseInt(x.get("id"))), startTime, startTime, Integer.parseInt(x.get("x2")), Integer.parseInt(x.get("y2")));
                break;
            case "slowmove":
                effect = new gSlowMove(DataBase.FindById(Integer.parseInt(x.get("id"))), startTime, endTime, Integer.parseInt(x.get("x2")), Integer.parseInt(x.get("y2")));
                break;
            case "rotate":
                effect = new gRotate(DataBase.FindById(Integer.parseInt(x.get("id"))), startTime, endTime, Double.parseDouble(x.get("delta")));
                break;
            case "blink":
                effect = new gBlink(DataBase.FindById(Integer.parseInt(x.get("id"))), startTime, endTime);
                break;
            case "party":
                effect = new gParty(DataBase.FindById(Integer.parseInt(x.get("id"))), startTime, endTime);
                break;
            case "scale":
                effect = new gScale(DataBase.FindById(Integer.parseInt(x.get("id"))), startTime, endTime, Double.parseDouble(x.get("scale")));
                break;
            case "music":
                effect = new gMusic(DataBase.FindById(Integer.parseInt(x.get("id"))), startTime, endTime, Paths.get(x.get("path")));
                break;
            default:
                throw new EffectNotFind("effect not find!!");
        }
        shape.addgEffect(effect);
        return effect;
    }

    public static gEffect MakeEffect(Map<String, String> x, gShape node) throws EffectNotFind {
        int startTime = Integer.parseInt(x.get("effectstart"));
        int endTime = Integer.parseInt(x.get("effectstop"));
        gEffect effect = null;
        switch (x.get("effectname")) {
            case "hide":
                effect = new gHide(node, startTime, startTime);
                break;
            case "show":
                effect = new gShow(node, startTime, startTime);
                break;
            case "changecolor":
                effect = new gChangeColor(node, startTime, startTime, gHandler.getColor(x.get("effectcolor")));
                break;
            case "move":
                effect = new gMove(node, startTime, startTime, Integer.parseInt(x.get("x2")), Integer.parseInt(x.get("y2")));
                break;
            case "slowmove":
                effect = new gSlowMove(node, startTime, endTime, Integer.parseInt(x.get("x2")), Integer.parseInt(x.get("y2")));
                break;
            case "rotate":
                effect = new gRotate(node, startTime, endTime, Double.parseDouble(x.get("delta")));
                break;
            case "blink":
                effect = new gBlink(node, startTime, endTime);
                break;
            case "party":
                effect = new gParty(node, startTime, endTime);
                break;
            case "scale":
                effect = new gScale(node, startTime, endTime, Double.parseDouble(x.get("scale")));
                break;
            case "music":
                effect = new gMusic(node, startTime, endTime, Paths.get(x.get("path")));
                break;
            default:
                throw new EffectNotFind("effect not find!!");
        }
        node.addgEffect(effect);
        return effect;
    }
}
