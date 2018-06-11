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
    public static gShape FindById(int id){
        for (gShape x:gShapeArrayList){
            if (x.getId()==id){
                return x;
            }
        }
        throw new RuntimeException("not Find Shape!");
    }

}
