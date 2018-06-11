package FileManager;

import Common.Setting;
import Common.gDefult;
import Shapes.gShapeFactory;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class gReader {
    private ArrayList<String> lines = new ArrayList<>();
    private Map<String, String> shapeDeta = new HashMap<>();
    private int currentI = 4;//todo init from file!!
    private static int id=1;

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
        shapeDeta = gDefult.GetDefultShapeMap();
    }

    private void addShape() {
        while (true) {
            int index1 = lines.get(currentI).trim().indexOf(":");
            if (lines.get(currentI).trim().substring(0, index1).toLowerCase().equalsIgnoreCase("shape")) {
                shapeDeta.put(lines.get(currentI).substring(0, index1).toLowerCase().trim(), lines.get(currentI).substring(index1 + 1).toLowerCase().trim());
            }
            currentI++;
            if (lines.get(currentI).equalsIgnoreCase("effect") || lines.get(currentI).trim().equals(""))
                break;
        }
    }

    private void addEffect()
    {
        while (true) {
            int index1 = lines.get(currentI).trim().indexOf(":");
            if (lines.get(currentI).trim().substring(0, index1).toLowerCase().equalsIgnoreCase("shape")) {
                //todo init!!?
            }
            currentI++;
            if (lines.get(currentI).equalsIgnoreCase("effect") || lines.get(currentI).trim().equals(""))
                break;
        }

    }

    private void Loop() {
        while (currentI < lines.size()) {
            shapeDeta.put("id",String.valueOf(id++));
            if (lines.get(currentI).trim().toLowerCase().equals("shape")) {
                addShape();
                gShapeFactory.MakeEffect(shapeDeta);
            } else if (lines.get(currentI).trim().toLowerCase().equals("effect")) {
                addEffect();
            } else {

                shapeDeta = gDefult.GetDefultShapeMap();
            }
            currentI++;
        }
    }
}
