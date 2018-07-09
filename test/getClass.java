package test;

import Effects.gEffect;
import Shapes.gShape;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class getClass {
    public List<Class<gShape>>  GetgShapeList(){
        List<Class<gShape>> gShapeList=new ArrayList<>();

        File[] files = new File("./src/Shapes").listFiles();
        ClassLoader classLoader = this.getClass().getClassLoader();
        for (File file : files) {
            if (file.isFile()) {
                try {
                    Class loadedMyClass = classLoader.loadClass("Shapes."+file.getName().substring(0,file.getName().indexOf(".")));
                    System.out.println("Loaded class name: " + loadedMyClass.getName());
                    gShapeList.add(loadedMyClass);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        //remove class
        try {
            gShapeList.remove(classLoader.loadClass("Shapes.g2Shape"));
            gShapeList.remove(classLoader.loadClass("Shapes.gRectShape"));
            gShapeList.remove(classLoader.loadClass("Shapes.gShape"));
            gShapeList.remove(classLoader.loadClass("Shapes.gShapeFactory"));
            gShapeList.remove(classLoader.loadClass("Shapes.gShapeFactory"));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //
        return gShapeList;
    }
    public List<Class<gEffect>>  GetgEffectList(){
        List<Class<gEffect>> gEffectList=new ArrayList<>();
        File[] files = new File("./src/Effects").listFiles();
        ClassLoader classLoader = this.getClass().getClassLoader();
        for (File file : files) {
            if (file.isFile()) {
                try {
                    Class loadedMyClass = classLoader.loadClass("Effects."+file.getName().substring(0,file.getName().indexOf(".")));
                    System.out.println("Loaded class name: " + loadedMyClass.getName());
                    gEffectList.add(loadedMyClass);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        //remove class
        try {
            gEffectList.remove(classLoader.loadClass("Effects.gEffect"));
            gEffectList.remove(classLoader.loadClass("Effects.gChangeable"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //
        return gEffectList;
    }

    public static void main(String[] args) {
        new getClass().GetgShapeList();
        new getClass().GetgEffectList();
    }
}
