package poro.gui;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import poro.dao.DatabaseManager;
import poro.dao.data.TaiKhoan;
import poro.module.Encrypter;
import poro.module.FileManager;

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

        FileManager fm = new FileManager("asset/save.dat");
        tkSave = fm.<TaiKhoan>readObject();
        if (tkSave.getIdTaiKhoan() == null) {
            chkNhoMatKhau.setSelected(false);
        } else {
            chkNhoMatKhau.setSelected(true);
            txtTaiKhoan.setText(tkSave.getIdTaiKhoan());
            txtPassword.setText(tkSave.getMatKhau());
        }
    }

    TaiKhoan tkSave;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        chkNhoMatKhau = new javax.swing.JCheckBox();
        btnQuenMatKhau = new javax.swing.JButton();
        btnDangNhap = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        txtTaiKhoan = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Đăng nhập");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        chkNhoMatKhau.setText("Nhớ mật khẩu?");
        chkNhoMatKhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                chkNhoMatKhauMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                chkNhoMatKhauMouseExited(evt);
            }
        });

        btnQuenMatKhau.setText("Quên mật khẩu");

        btnDangNhap.setText("Đăng nhập");
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/lock.jpg"))); // NOI18N
        jLabel4.setOpaque(true);

        jLabel3.setText("Mật khẩu");

        jLabel2.setText("Tài khoản");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnDangNhap)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnQuenMatKhau))
                    .addComponent(txtTaiKhoan)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(chkNhoMatKhau)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnDangNhap, btnQuenMatKhau});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(chkNhoMatKhau)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDangNhap)
                            .addComponent(btnQuenMatKhau)))
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, "card2");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void chkNhoMatKhauMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkNhoMatKhauMouseEntered
        // TODO add your handling code here:
        chkNhoMatKhau.setText("<html><u>Nhớ mật khẩu?</u></html>");
        chkNhoMatKhau.setForeground(Color.red);
    }//GEN-LAST:event_chkNhoMatKhauMouseEntered

    private void chkNhoMatKhauMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkNhoMatKhauMouseExited
        // TODO add your handling code here:
        chkNhoMatKhau.setText("Nhớ mật khẩu?");
        chkNhoMatKhau.setForeground(Color.black);
    }//GEN-LAST:event_chkNhoMatKhauMouseExited

    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
        try {
            nhoMatKhau();
            dangNhap();
        } catch (RuntimeException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnDangNhapActionPerformed

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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtTaiKhoan;
    // End of variables declaration//GEN-END:variables

    private TaiKhoan getTaiKhoan() {
        Encrypter encrypter = new Encrypter();

        String user = txtTaiKhoan.getText().trim();
        String password = String.valueOf(txtPassword.getPassword());

        if (user.isEmpty()) {
            throw new RuntimeException("User không được để trống");
        }
        if (password.isEmpty()) {
            throw new RuntimeException("Password không được để trống");
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

    public void dangNhap() {
        TaiKhoan tk = getTaiKhoan();
        ArrayList<TaiKhoan> tkList = DatabaseManager.executeQuery(tk, TaiKhoan.EXECUTE_SELECT_BY_USER_OR_EMAIL_AND_PASS);
        if (tkList.size() > 0) {
            JOptionPane.showMessageDialog(this, "Đăng nhập thành công!");
        } else {
            throw new RuntimeException("Sai tài khoản hoặc mật khẩu!");
        }
    }

    private void nhoMatKhau() {
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
