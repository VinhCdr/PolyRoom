package poro;

import poro.gui.DangNhapJDialog;

/**
 *
 * @author vinh
 */
public class MainClass {

    public static void main(String[] args) {
        show();
    }
    
    
    public static void show() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            DangNhapJDialog dialog = new DangNhapJDialog(new javax.swing.JFrame(), true);
            dialog.setVisible(true);
            System.exit(0);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
    }
    
}
