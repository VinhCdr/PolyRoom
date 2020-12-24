package poro;

import javax.swing.UnsupportedLookAndFeelException;
import poro.gui.DangNhapJDialog;
import poro.gui.QLMainJFrame;
import poro.module.Session;
import poro.module.db.DatabaseRefresh;
import poro.module.web.WebStdManager;

/**
 *
 * @author vinh
 */
public class MainClass {

    public static void main(String[] args) {
        // <editor-fold defaultstate="collapsed" desc="Nạp giao diện windows">   
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
            System.out.println(ex);
        }
        // </editor-fold>
        
        // Tạo 2 màn hình
        QLMainJFrame mainJFrame = new QLMainJFrame();
        DangNhapJDialog dangNhapJDialog = new DangNhapJDialog(mainJFrame, true);
        DatabaseRefresh.refresh();
        WebStdManager.start();
        dangNhapJDialog.setVisible(true);
        
        // Chưa đăng nhập thì ko hiện main
        if (Session.isLogin()) {
            mainJFrame.setGiaoDien(Session.USER.isPhanQuyen());
            mainJFrame.setVisible(true);
        } else {
            System.exit(0);
        }
    }

}
