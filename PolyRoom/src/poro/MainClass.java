package poro;

import poro.gui.DangNhapJDialog;
import poro.module.mail.Mailer;

/**
 *
 * @author vinh
 */
public class MainClass {

    public static void main(String[] args) {
        Mailer mail = new Mailer("mvinhle@outlook.com", "Test nè", "ko thì thôi");
        mail.send();
    }

//    public static void main(String args[]) {
//        
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//            DangNhapJDialog dialog = new DangNhapJDialog(new javax.swing.JFrame(), true);
//            dialog.setVisible(true);
//            System.exit(0);
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
//            ex.printStackTrace();
//        }
//
//    }
}
