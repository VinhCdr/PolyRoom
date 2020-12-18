package poro.module.db.data;

import java.util.ArrayList;
import poro.module.db.DatabaseManager;

/**
 *
 * @author vinh
 */
public class MuonPhongTest {

    public static void main(String[] args) {
        MuonPhong mp = new MuonPhong();
        mp.setSoTang(1);
        mp.setIdPhong(1);
        ArrayList<MuonPhong> mpList = DatabaseManager.executeQuery(mp, MuonPhong.EXECUTE_SELECT_BY_ID_PHONG);
        mpList.forEach(m -> {
            System.out.println(m.getIdMuonPhong()); 
        });
        
    }

}
