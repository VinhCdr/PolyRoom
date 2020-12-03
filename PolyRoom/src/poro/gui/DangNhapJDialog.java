package poro.gui;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import poro.dao.DatabaseManager;
import poro.dao.data.TaiKhoan;
import poro.module.Encrypter;
import poro.module.FileManager;
import poro.module.Session;

/**
 *
 * @author Cô Ngọc
 */
public class DangNhapJDialog extends javax.swing.JDialog {

    /**
     * Creates new form DangNhap
     */
    public DangNhapJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        quenMatKhauJDialog = new QuenMatKhauJDialog(parent, true);

        loadTaiKhoan();
    }

    private QuenMatKhauJDialog quenMatKhauJDialog;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chkNhoMatKhau = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        btnQuenMatKhau = new javax.swing.JButton();
        btnDangNhap = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtTaiKhoan = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        hinh = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Đăng nhập");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        chkNhoMatKhau.setBackground(new java.awt.Color(255, 255, 255));
        chkNhoMatKhau.setForeground(new java.awt.Color(255, 255, 255));
        chkNhoMatKhau.setText("Nhớ mật khẩu?");
        chkNhoMatKhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                chkNhoMatKhauMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                chkNhoMatKhauMouseExited(evt);
            }
        });
        getContentPane().add(chkNhoMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 130, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Mật khẩu");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 100, 30));

        btnQuenMatKhau.setText("Quên mật khẩu");
        btnQuenMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuenMatKhauActionPerformed(evt);
            }
        });
        getContentPane().add(btnQuenMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 290, 150, 40));

        btnDangNhap.setText("Đăng nhập");
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });
        getContentPane().add(btnDangNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 150, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tài khoản");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 110, 40));
        getContentPane().add(txtTaiKhoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 540, 40));
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 540, 40));

        hinh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/br1.jpg"))); // NOI18N
        getContentPane().add(hinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 370));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void chkNhoMatKhauMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkNhoMatKhauMouseEntered
        // TODO add your handling code here:
        chkNhoMatKhau.setText("<html><u>Nhớ mật khẩu?</u></html>");
        chkNhoMatKhau.setForeground(Color.yellow);
    }//GEN-LAST:event_chkNhoMatKhauMouseEntered

    private void chkNhoMatKhauMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkNhoMatKhauMouseExited
        // TODO add your handling code here:
        chkNhoMatKhau.setText("Nhớ mật khẩu?");
        chkNhoMatKhau.setForeground(Color.white);
    }//GEN-LAST:event_chkNhoMatKhauMouseExited

    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
        try {
            nhoMatKhau();
            dangNhap();
        } catch (ToViewException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnDangNhapActionPerformed

    private void btnQuenMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuenMatKhauActionPerformed
        // TODO add your handling code here:
        quenMatKhauJDialog.setVisible(true);
    }//GEN-LAST:event_btnQuenMatKhauActionPerformed

    public static void main(String args[]) {

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangNhap;
    private javax.swing.JButton btnQuenMatKhau;
    private javax.swing.JCheckBox chkNhoMatKhau;
    private javax.swing.JLabel hinh;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtTaiKhoan;
    // End of variables declaration//GEN-END:variables

    TaiKhoan tkSave;

    private void loadTaiKhoan() {
        try {
            FileManager fm = new FileManager("asset/save.dat");
            tkSave = fm.<TaiKhoan>readObject();
            if (tkSave.getIdTaiKhoan() == null) {
                chkNhoMatKhau.setSelected(false);
            } else {
                chkNhoMatKhau.setSelected(true);
                txtTaiKhoan.setText(tkSave.getIdTaiKhoan());
                txtPassword.setText(tkSave.getMatKhau());
            }
        } catch (RuntimeException ex) {
            System.out.println(ex);
        }
    }

    private TaiKhoan getTaiKhoan() throws ToViewException {
        Encrypter encrypter = new Encrypter();

        String user = txtTaiKhoan.getText().trim();
        String password = String.valueOf(txtPassword.getPassword());

        if (user.isEmpty()) {
            throw new ToViewException("User không được để trống");
        }
        if (password.isEmpty()) {
            throw new ToViewException("Password không được để trống");
        }

        if (tkSave.getMatKhau() == null || !tkSave.getMatKhau().equals(password)) {
            password = encrypter.toMD5(password);
        }

        TaiKhoan tk = new TaiKhoan();
        tk.setIdTaiKhoan(user);
        tk.setEmail(user);
        tk.setMatKhau(password);
        return tk;
    }

    public void dangNhap() throws ToViewException {
        TaiKhoan tk = getTaiKhoan();
        ArrayList<TaiKhoan> tkList = DatabaseManager.executeQuery(tk, TaiKhoan.EXECUTE_SELECT_BY_USER_OR_EMAIL_AND_PASS);
        if (tkList.size() > 0) {
            Session.USER = tkList.get(0);
            this.dispose();
        } else {
            throw new ToViewException("Sai tài khoản hoặc mật khẩu!");
        }
    }

    private void nhoMatKhau() throws ToViewException {
        boolean isNhoMK = chkNhoMatKhau.isSelected();
        TaiKhoan tk;
        if (isNhoMK) {
            tk = getTaiKhoan();
        } else {
            tk = new TaiKhoan();
        }
        FileManager fm = new FileManager("asset/save.dat");
        fm.writeObject(tk);
    }

}
