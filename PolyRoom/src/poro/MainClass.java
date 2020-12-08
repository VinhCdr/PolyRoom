package poro;

import poro.gui.DangNhapJDialog;
import poro.gui.QLMainJFrame;
import poro.module.Session;

/**
 *
 * @author vinh
 */
public class MainClass {

    static DangNhapJDialog dangNhapJDialog;
    static QLMainJFrame mainJFrame;

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QLMainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLMainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLMainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLMainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        mainJFrame = new QLMainJFrame();
        dangNhapJDialog = new DangNhapJDialog(mainJFrame, true);
        dangNhapJDialog.setVisible(true);
        if (Session.isLogin()) {
            mainJFrame.setVisible(true);
        } else {
            System.exit(0);
        }
    }

}
