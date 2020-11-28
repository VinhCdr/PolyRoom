package poro.model;

import java.util.ArrayList;
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
        TaiKhoan tk = new TaiKhoan();
        ArrayList<TaiKhoan> tk2 = tk.<TaiKhoan>select(TaiKhoan.SELECT_USER_OR_EMAIL_AND_PASS);
        for (TaiKhoan tkk : tk2) {
            System.out.println(tkk.getTen());
        }
    }
    
}
