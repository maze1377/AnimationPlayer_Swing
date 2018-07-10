package Common;

import Shapes.gShape;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataBase {
    public static ArrayList<gShape> gShapeArrayList = new ArrayList<>();
    public static ArrayList<gShape> basicGShapeArraylist = new ArrayList<>();
    public static Map<Integer, Integer> RootEffects = new HashMap<>();
    private static DataBase dataBase = new DataBase();
    private DataBase() {
    }

    public static DataBase getInstance() {
        return dataBase;
    }

    public static void addRootEffect(int starttime, int mode) {
        RootEffects.put(starttime, mode);
    }

    public static void addgShape(gShape x) {
        gShapeArrayList.add(x);
    }

    public static void removeShape(gShape x) {
        gShapeArrayList.remove(x);
    }

    public static void addBaseGShape(gShape x) {
        getBasegShapes().add(x);
    }

    public static void removeBaseGShape(gShape x) {
        getBasegShapes().remove(x);
    }

    public static ArrayList<gShape> getBasegShapes() {
        return basicGShapeArraylist;
    }


    public static ArrayList<gShape> getShapes() {
        return gShapeArrayList;
    }

    public static void clean() {
        getShapes().clear();
    }

    public static gShape FindById(int id) {
        for (gShape x : gShapeArrayList) {
            if (x.getId() == id) {
                return x;
            }
        }
        throw new RuntimeException("not Find Shape!");
    }

}
