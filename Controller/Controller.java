package Controller;

import Common.getClass;
import Common.DataBase;
import Shapes.gShape;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Controller {

    //private DataBase dataBase=DataBase;
    private getClass getShapeClass=new getClass();
    public List<Class> getObjects()
    {
        List<Class> objects=getShapeClass.getGShapeList();
        return objects;
    }
    public List<Class> getEffects()
    {
        List<Class> effects=getShapeClass.getGEffectList();
        return effects;
    }
    public void addShape(gShape shape)
    {
        DataBase.addgShape(shape);
    }
    public void removeShape(gShape shape)
    {
        DataBase.removeShape(shape);
    }
    public void play()
    {
        //Todo startAnim
    }
    public void stop()
    {
        //Todo stopAnim
    }
    public void loadFromFile(File file) {
        //Todo loadFile
    }
    public void saveToFile(File file) {
        //ToDO saveFile
    }
    public void exit(){
        System.exit(1);
    }

}
