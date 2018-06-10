package Common;

import Shapes.gShape;

import java.util.ArrayList;

public class Date {
    public static ArrayList<gShape> gShapeArrayList=new ArrayList<>();
    public static void addgShape(gShape x){
        gShapeArrayList.add(x);
    }
    public static void removeShape(gShape x){
        gShapeArrayList.remove(x);
    }

    public static ArrayList<gShape> getgShapeArrayList() {
        return gShapeArrayList;
    }
}
