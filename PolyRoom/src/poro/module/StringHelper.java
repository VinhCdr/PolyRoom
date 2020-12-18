package poro.module;

import java.util.Random;

/**
 *
 * @author ASUS
 */
public class StringHelper {
    
    /**
     * Sinh ra một số ngẫu nhiên có n kí tự
     * 
     * @param range Số kí tự
     * @return một chuỗi gồm các số ngẫu nhiên
     */
    public static String random(int range) {
        Random ran = new Random();
        String result = "";
        for(int i =0; i<range; i++){
            result+=ran.nextInt(10);
        }
        return result;
    }
}
