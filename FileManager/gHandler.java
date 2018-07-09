package FileManager;

import java.awt.*;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Objects.requireNonNullElse;

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
        String poll[]= x.split(",");
        int r=Integer.parseInt(poll[0].trim()),g=Integer.parseInt(poll[1].trim()),b=Integer.parseInt(poll[2].trim());
        String hex = String.format("0X%02x%02x%02x", r, g, b);
        Color Result=requireNonNullElse(Color.decode(hex),Color.red);
        return Result;
    }
    public static String convertoColor(Color x){
        return x.getRed()+","+x.getGreen()+","+x.getBlue();
    }
    public static Font getFont(Map<String,String> x){
        //todo..!
        return new Font("Courier New", Font.ITALIC, 12);
    }
}
