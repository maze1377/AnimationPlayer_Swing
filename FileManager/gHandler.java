package FileManager;

import java.awt.*;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class gHandler {
    public static String getNumberInStinrg(String x) {
        Pattern p = Pattern.compile("-?[\\d]+");//"\\d+"  [\d\.]
        Matcher m = p.matcher(x);
        String temp = "";
        while (m.find()) {
            temp += m.group();
        }
        return temp;
    }
    public static long getNumberInLong(String x) {
       return Long.parseLong(getNumberInStinrg(x));
    }
    public static Color getColor(String x){
        //todo!
        return null;
    }
    public static Font getFont(Map<String,String> x){
        //todo..!
        return null;
    }
}
