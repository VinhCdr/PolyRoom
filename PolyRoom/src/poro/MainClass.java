/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poro;

import java.util.ArrayList;
import poro.dao.DatabaseManager;
import poro.dao.data.TaiKhoan;

/**
 *
 * @author vinh
 */
public class MainClass {

    public static void main(String[] args) {
        TaiKhoan taiKhoan;
        taiKhoan = new TaiKhoan("test3", "email3", "pass", false, "viz", "0123");
        DatabaseManager dm = new DatabaseManager();
        taiKhoan.setEmail("new 33333");
        dm.update(taiKhoan);
                
        dm.insert(taiKhoan);
        ArrayList<TaiKhoan> al = dm.select(taiKhoan);
        al.forEach(d -> {
            System.out.println(d.getEmail());
        });
    }
    
    
//    public static void main(String args[]) {
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//            DangNhap dialog = new DangNhap(new javax.swing.JFrame(), true);
//            dialog.setVisible(true);
//            System.exit(0);
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
//            ex.printStackTrace();
//        }
//
//    }

}
