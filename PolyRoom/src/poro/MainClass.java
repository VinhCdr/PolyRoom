package poro;

import javax.swing.UnsupportedLookAndFeelException;
import poro.gui.DangNhapJDialog;
import poro.gui.QLMainJFrame;
import poro.module.Session;

/**
 *
 * @author vinh
 */
public class MainClass {

    public static void main(String[] args) {
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

        QLMainJFrame mainJFrame = new QLMainJFrame();
        DangNhapJDialog dangNhapJDialog = new DangNhapJDialog(mainJFrame, true);
        
        dangNhapJDialog.setVisible(true);
        if (Session.isLogin()) {
            mainJFrame.setVisible(true);
        } else {
            System.exit(0);
        }
    }

}
