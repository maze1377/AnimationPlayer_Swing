package Effects;

import Common.Date;

import java.util.Map;

public class gEffectFactory {
    //map haveto have effectname
    public static gEffect MakeEffect(Map<String, String> x) {
        int startTime = Integer.parseInt(x.get("effectstart"));
        int endTime = Integer.parseInt(x.get("effectend"));//note! all map haveto have endtime..!
        switch (x.get("effectname")) {
            case "hide":
                return new gHide(Date.FindById(Integer.parseInt(x.get("id"))), startTime, startTime);
            case "show":
                return new gShow(Date.FindById(Integer.parseInt(x.get("id"))), startTime, startTime);
            case "changecolor":
                //return new gChangeColor(Date.FindById(Integer.parseInt(x.get("id"))), startTime, startTime, x.get("effectcolor"));//todo how cast string to color...!
            case "move":
                return new gMove(Date.FindById(Integer.parseInt(x.get("id"))), startTime, startTime, Integer.parseInt(x.get("x2")), Integer.parseInt(x.get("y2")));
            case "slowmove":
                return new gSlowMove(Date.FindById(Integer.parseInt(x.get("id"))), startTime, startTime, Integer.parseInt(x.get("x2")), Integer.parseInt(x.get("y2")));
            case "rotate":
                return new gRotate(Date.FindById(Integer.parseInt(x.get("id"))), startTime, endTime);
            case "blink":
                return new gBlink(Date.FindById(Integer.parseInt(x.get("id"))), startTime, endTime);
            default:
                throw new RuntimeException("effect not find!!");
        }
    }
}
