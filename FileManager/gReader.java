package FileManager;

import Common.DataBase;
import Common.Setting;
import Common.gDefult;
import Effects.gEffectFactory;
import Shapes.gGroup;
import Shapes.gShape;
import Shapes.gShapeFactory;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class gReader {
    private static int id = 1;
    private ArrayList<String> lines = new ArrayList<>();
    private Map<String, String> shapeDeta = new HashMap<>();
    private int currentI;//todo init from file!!

    public gReader(int currentI) {
        currentI = 0;
        init();
        readRoot();
        Loop();
    }

    private void readRoot() {
        int index1 = lines.get(currentI).trim().indexOf(":");
        if (index1 == -1) index1 = 0;
        Setting.TotalFrame = Integer.parseInt(lines.get(currentI).substring(index1 + 1).toLowerCase().trim());
        currentI++;
        Setting.setSpeed(Integer.parseInt(gHandler.getNumberInStinrg(lines.get(currentI))));
        currentI++;
        currentI++;//ignore item ..
        while (!lines.get(currentI).trim().equals("")) {
            try {
                DataBase.addRootEffect(Integer.parseInt(gHandler.getNumberInStinrg(lines.get(currentI + 1))), Integer.parseInt(gHandler.getNumberInStinrg(lines.get(currentI))));
                currentI += 2;
            } catch (NumberFormatException x) {
                break;
            }
        }
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
            if (index1 == -1) index1 = 0;
            shapeDeta.put(lines.get(currentI).substring(0, index1).toLowerCase().trim(), lines.get(currentI).substring(index1 + 1).toLowerCase().trim());
            currentI++;
            if (lines.get(currentI).toLowerCase().contains("effect") || lines.get(currentI).toLowerCase().contains("group") || lines.get(currentI).trim().equals("") || lines.get(currentI).trim().toLowerCase().contains("shape")) {
                break;
            }
        }
    }

    private void addEffect() {
        currentI++;
        shapeDeta.put("effectname", lines.get(currentI).toLowerCase().trim());
        currentI++;
        int index1 = lines.get(currentI).trim().indexOf(":");
        if (index1 == -1) index1 = 0;
        shapeDeta.put("effectstart", lines.get(currentI).substring(index1 + 1).toLowerCase().trim());
        currentI++;
        if (lines.get(currentI).contains("stop")) {//for efffect that have loop time!!
            index1 = lines.get(currentI).trim().indexOf(":");
            if (index1 == -1) index1 = 0;
            shapeDeta.put("effectstop", lines.get(currentI).substring(index1 + 1).toLowerCase().trim());
            currentI++;
        } else {//this effect just play in one fram..
            shapeDeta.put("effectstop", lines.get(currentI - 1).substring(index1 + 1).toLowerCase().trim());
        }
        while (true) {
            if (lines.get(currentI).toLowerCase().contains("effect") || lines.get(currentI).toLowerCase().contains("group") || lines.get(currentI).trim().equals("")) {
                break;
            }
            index1 = lines.get(currentI).trim().indexOf(":");
            if (index1 == -1) index1 = 0;
            shapeDeta.put(lines.get(currentI).substring(0, index1).toLowerCase().trim(), lines.get(currentI).substring(index1 + 1).toLowerCase().trim());
            currentI++;

        }
    }

    private void Loop() {
        gShape node = null;
        while (currentI < lines.size()) {
            try {
                if (lines.get(currentI).trim().toLowerCase().contains("group begin")) {
                    readgroup();
                } else if (lines.get(currentI).trim().toLowerCase().contains("shape")) {
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
            } catch (Exception x) {
                x.printStackTrace();
                while (currentI > lines.size() || !lines.get(currentI).trim().equals("")) {
                    currentI++;
                }
            }
        }
    }

    private void addtoDeta(gShape node) {
        if (node != null) {
            DataBase.addgShape(node);
        } else {
            throw new RuntimeException("bad file..!");
        }
    }

    private void readgroup() {
        currentI++;
        gGroup group = new gGroup(id);
        shapeDeta.put("id", String.valueOf(id++));
        gShape node = null;
        List<gShape> gShapeList = new ArrayList<>();
        while (!lines.get(currentI).trim().toLowerCase().contains("group end")) {
            if (lines.get(currentI).trim().toLowerCase().contains("group begin")) {
                readgroup();
            } else if (lines.get(currentI).trim().toLowerCase().contains("shape")) {
                addShape();
                node = gShapeFactory.MakeEffect(shapeDeta);
                addtoDeta(node);
                gShapeList.add(node);
            } else if (lines.get(currentI).trim().toLowerCase().equals("effect")) {
                addEffect();
                gEffectFactory.MakeEffect(shapeDeta);
            } else if (lines.get(currentI).trim().toLowerCase().equals("group effect")) {
                addEffect();
                gEffectFactory.MakeEffect(shapeDeta, group);
            } else {
                node = null;
                shapeDeta = gDefult.GetDefultShapeMap();
                shapeDeta.put("id", String.valueOf(id++));
                currentI++;
            }
        }

        group.setShapes(gShapeList);
        for (gShape x : group.getShapes()) {
            DataBase.removeShape(x);
        }
        group.setbounds();
        DataBase.addgShape(group);
    }
}
