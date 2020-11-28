package poro.model;

import java.util.ArrayList;
import poro.model.entity.Dao;
import poro.model.entity.TaiKhoan;

/**
 *
 * @author vinh
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Dao tk = new TaiKhoan();
        ArrayList<TaiKhoan> tk2 = tk.<TaiKhoan>select();
        System.out.println(tk2.get(0).getTen());;
        
    }
    
}
