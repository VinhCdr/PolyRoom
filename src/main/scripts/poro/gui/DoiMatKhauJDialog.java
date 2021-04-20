package poro.gui;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import poro.module.db.DatabaseManager;
import poro.module.db.data.TaiKhoan;
import poro.gui.exception.ToViewException;
import poro.module.Encrypter;

/**
 *
 * @author ASUS, vinh
 */
public class DoiMatKhauJDialog extends javax.swing.JDialog {
	private static final long serialVersionUID = 1L;

	public DoiMatKhauJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txtTaiKhoan = new javax.swing.JTextField();
        txtPassMoi1 = new javax.swing.JPasswordField();
        txtPassCu = new javax.swing.JPasswordField();
        txtPassMoi2 = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnMatKhau = new javax.swing.JButton();
        hinh = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Đổi mật khẩu");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tài khoản");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        txtTaiKhoan.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        getContentPane().add(txtTaiKhoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 280, -1));

        txtPassMoi1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        getContentPane().add(txtPassMoi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 280, -1));

        txtPassCu.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        getContentPane().add(txtPassCu, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 280, -1));

        txtPassMoi2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        getContentPane().add(txtPassMoi2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 280, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nhập mật khẩu cũ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nhập mật khẩu mới");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Xác nhận lại mật khẩu");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, -1, -1));

        btnMatKhau.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        btnMatKhau.setText("Đổi mật khẩu");
        btnMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatKhauActionPerformed(evt);
            }
        });
        getContentPane().add(btnMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 140, -1));

        hinh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/br1.jpg"))); // NOI18N
        getContentPane().add(hinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 250));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatKhauActionPerformed
        try {
            doiMatKhau();
            JOptionPane.showMessageDialog(this, "Đổi mật khẩu thành công !");
            this.dispose();
        } catch (ToViewException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnMatKhauActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMatKhau;
    private javax.swing.JLabel hinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField txtPassCu;
    private javax.swing.JPasswordField txtPassMoi1;
    private javax.swing.JPasswordField txtPassMoi2;
    private javax.swing.JTextField txtTaiKhoan;
    // End of variables declaration//GEN-END:variables

    private TaiKhoan taiKhoanQuen;

    /**
     * Sử dụng khi đổi mật khẩu mà không cần nhập lại pass cũ (quên mk)
     * Khi thực hiện đổi mật khẩu sẽ đổi mật khẩu của tài khoản này.
     * @param taiKhoan Tài khoản gốc
     */
    public void setTaiKhoanDMK(TaiKhoan taiKhoan) {
        this.taiKhoanQuen = taiKhoan;
        txtTaiKhoan.setEnabled(false);
        txtPassCu.setEnabled(false);
        txtTaiKhoan.setText(taiKhoan.getIdTaiKhoan());
        txtPassCu.setText(taiKhoan.getMatKhau());
    }

    /**
     * Đặt vào tài khoản gốc trước khi thực hiện đổi mật khẩu (sẽ đổi mật khẩu của tài khoản này).
     * Vì phải nhập lại mật khẩu cũ, nên dữ liệu tài khoản sẽ được select trong csdl
     * @param taiKhoan Username
     */
    public void setTaiKhoan(String taiKhoan) {
        txtTaiKhoan.setEnabled(false);
        txtTaiKhoan.setText(taiKhoan);
    }
    
    /**
     * Thực hiện việc đổi mật khẩu, tự động chọn chế độ, dựa trên 
     * @throws ToViewException
     */
    private void doiMatKhau() throws ToViewException {
        if (taiKhoanQuen == null) {
            doiMatKhauBt();
        } else {
            doiMatKhauQuen();
        }
    }

    /**
     * Thực hiện đổi mật khẩu (chế độ bình thường / cần nhập lại pass)
     * @throws ToViewException Lỗi khi from trống, đủ kiểu
     */
    private void doiMatKhauBt() throws ToViewException {
        String passOld = String.valueOf(txtPassCu.getPassword());
        String passOldMd5 = Encrypter.toMD5(passOld);
        doiMatKhau(passOldMd5);
    }

    /**
     * Thực hiện đổi mật khẩu (chế độ quên mật khẩu / không cần nhập pass cũ)
     * @throws ToViewException Lỗi khi from trống, đủ kiểu
     */
    private void doiMatKhauQuen() throws ToViewException {
        String passOld = String.valueOf(txtPassCu.getPassword());
        doiMatKhau(passOld);
    }

    /**
     * Thực hiện đổi mật khẩu dựa trên dữ liệu trên form
     * @param passCuMd5 Mật khẩu cũ (đã mã hóa)
     * @throws ToViewException
     */
    private void doiMatKhau(String passCuMd5) throws ToViewException {
        String user = txtTaiKhoan.getText().trim();
        String passOld = passCuMd5;
        String passNew1 = String.valueOf(txtPassMoi1.getPassword()).trim();
        String passNew2 = String.valueOf(txtPassMoi2.getPassword()).trim();

        if (!passNew1.equalsIgnoreCase(passNew2)) {
            throw new ToViewException("Mật khẩu mới không khớp nhau");
        }

        String passNewMd5 = Encrypter.toMD5(passNew2);

        TaiKhoan tk = new TaiKhoan();
        tk.setIdTaiKhoan(user);
        tk.setMatKhau(passOld);

        ArrayList<TaiKhoan> tkList = DatabaseManager.executeQuery(tk, TaiKhoan.EXECUTE_SELECT_BY_USER_OR_EMAIL_AND_PASS);
        if (tkList.size() <= 0) {
            throw new ToViewException("Tài khoản hoặc mật khẩu củ không đúng");
        }
        tk = tkList.get(0);
        tk.setMatKhau(passNewMd5);

        DatabaseManager.executeUpdate(tk, TaiKhoan.EXECUTE_UPDATE_BY_ID);
    }
}
