package FileManager;

import Common.Date;
import Common.Setting;
import Common.gDefult;
import Effects.gEffectFactory;
import Shapes.gShape;
import Shapes.gShapeFactory;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class gReader {
    private static int id = 1;
    private ArrayList<String> lines = new ArrayList<>();
    private Map<String, String> shapeDeta = new HashMap<>();
    private int currentI = 4;//todo init from file!!

    public gReader(int currentI) {
        this.currentI = currentI;
        init();
        Loop();
    }

    ////
    public static void main(String[] args) {
        new gReader(4);
    }

    private void init() {
        Path path = Setting.CurrentPath;
        try {
            Scanner scanner = new Scanner(path);
            while (scanner.hasNext()) {
                lines.add(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        lines.add("");//add if not have end space file..
        shapeDeta = gDefult.GetDefultShapeMap();
        shapeDeta.put("id", String.valueOf(id++));
    }

    private void addShape() {
        while (true) {
            int index1 = lines.get(currentI).trim().indexOf(":");
            shapeDeta.put(lines.get(currentI).substring(0, index1).toLowerCase().trim(), lines.get(currentI).substring(index1 + 1).toLowerCase().trim());
            currentI++;
            if (lines.get(currentI).equalsIgnoreCase("effect") || lines.get(currentI).trim().equals("")) {
                break;
            }
        }
    }

    private void addEffect() {
        currentI++;
        shapeDeta.put("effectname", lines.get(currentI).toLowerCase().trim());
        currentI++;
        int index1 = lines.get(currentI).trim().indexOf(":");
        shapeDeta.put("effectstart", lines.get(currentI).substring(index1 + 1).toLowerCase().trim());
        currentI++;
        if (lines.get(currentI).contains("stop")) {//for efffect that have loop time!!
            index1 = lines.get(currentI).trim().indexOf(":");
            shapeDeta.put("effectstop", lines.get(currentI).substring(index1 + 1).toLowerCase().trim());
            currentI++;
        } else {//this effect just play in one fram..
            shapeDeta.put("effectstop", lines.get(currentI - 1).substring(index1 + 1).toLowerCase().trim());
        }
        while (true) {
            if (lines.get(currentI).equalsIgnoreCase("effect") || lines.get(currentI).trim().equals("")) {
                break;
            }
            index1 = lines.get(currentI).trim().indexOf(":");
            shapeDeta.put(lines.get(currentI).substring(0, index1).toLowerCase().trim(), lines.get(currentI).substring(index1 + 1).toLowerCase().trim());
            currentI++;

        }
    }

    private void Loop() {
        gShape node = null;
        while (currentI < lines.size()) {
            if (lines.get(currentI).trim().toLowerCase().contains("shape")) {
                addShape();
                node = gShapeFactory.MakeEffect(shapeDeta);
                addtoDeta(node);
            } else if (lines.get(currentI).trim().toLowerCase().equals("effect")) {
                addEffect();
                gEffectFactory.MakeEffect(shapeDeta);
            } else {
                node = null;
                shapeDeta = gDefult.GetDefultShapeMap();
                shapeDeta.put("id", String.valueOf(id++));
                currentI++;
            }
        }
    }

    private void addtoDeta(gShape node) {
        if (node != null) {
            Date.addgShape(node);
        } else {
            // throw new RuntimeException("bad file..!");
        }
    }
}
