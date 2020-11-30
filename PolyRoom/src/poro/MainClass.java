package poro;

import java.util.ArrayList;
import poro.dao.DatabaseManager;
import poro.dao.data.Phong;
import poro.module.Mailer;

/**
 *
 * @author vinh
 */
public class MainClass {

    public static void main(String[] args) {
        Phong phong = new Phong();
        ArrayList<Phong> lis = DatabaseManager.select(phong);
        lis.forEach((Phong p) -> {
            System.out.println(p.getTenPhong());
        });
        
    }
    
}
