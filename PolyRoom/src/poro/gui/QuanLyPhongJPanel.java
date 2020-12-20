package poro.gui;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import poro.module.CalendarManager;
import poro.module.Session;
import poro.module.db.DatabaseManager;
import poro.module.db.data.MuonPhong;
import poro.module.db.data.Phong;
import poro.module.db.data.ThongTinMuonPhong;

/**
 *
 * @author ASUS
 */
public class QuanLyPhongJPanel extends javax.swing.JPanel {

    public QuanLyPhongJPanel() {
        initComponents();
        loadTblPhong();
        setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabs = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnMoi = new javax.swing.JButton();
        btnSuaPhong = new javax.swing.JButton();
        btnXoaPhong = new javax.swing.JButton();
        btnThemPhong = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        txtTenPhong = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cboLau = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        chkChoPhep = new javax.swing.JCheckBox();
        txtMaPhong = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        rtxtSinhVien = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        rtxtEmailSinhVien = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        rtxtLyDo = new javax.swing.JTextField();
        rtxtKetThuc = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        rtxtBatDau = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        rcboNguoiMuon = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        btnXemChiTiet = new javax.swing.JButton();
        btnHuyMuon = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPhong = new javax.swing.JTable();
        txtTimStart = new javax.swing.JTextField();
        btnTimPhong = new javax.swing.JButton();
        btnTraPhong = new javax.swing.JButton();
        btnMuonPhong = new javax.swing.JButton();
        txtTimEnd = new javax.swing.JTextField();

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quản lý mượn", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        btnMoi.setText("Mới");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        btnSuaPhong.setText("Sửa phòng");
        btnSuaPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaPhongActionPerformed(evt);
            }
        });

        btnXoaPhong.setText("Xóa phòng");
        btnXoaPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaPhongActionPerformed(evt);
            }
        });

        btnThemPhong.setText("Thêm phòng");
        btnThemPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemPhongActionPerformed(evt);
            }
        });

        jLabel3.setText("Tên phòng");

        cboLau.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4" }));

        jLabel4.setText("Tầng lầu");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4)
            .addComponent(jLabel3)
            .addComponent(cboLau, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(txtTenPhong)
                .addGap(2, 2, 2))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboLau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cboLau, txtTenPhong});

        chkChoPhep.setText("Cho phép mượn");

        jLabel2.setText("Mã phòng");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtMaPhong)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(chkChoPhep))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(chkChoPhep))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {chkChoPhep, txtMaPhong});

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnThemPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnSuaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoaPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnMoi, btnSuaPhong, btnThemPhong, btnXoaPhong});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMoi)
                    .addComponent(btnThemPhong)
                    .addComponent(btnSuaPhong)
                    .addComponent(btnXoaPhong))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnMoi, btnSuaPhong, btnThemPhong, btnXoaPhong});

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quản lý mượn", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        rtxtSinhVien.setEditable(false);
        rtxtSinhVien.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setText("Lý do");

        rtxtEmailSinhVien.setEditable(false);
        rtxtEmailSinhVien.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setText("Email Sinh viên");

        jLabel12.setText("Sinh viên");

        rtxtLyDo.setEditable(false);
        rtxtLyDo.setBackground(new java.awt.Color(255, 255, 255));

        rtxtKetThuc.setEditable(false);
        rtxtKetThuc.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setText("Thời gian trả dự kiến");

        rtxtBatDau.setEditable(false);
        rtxtBatDau.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setText("Thời gian bắt đầu");

        rcboNguoiMuon.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rcboNguoiMuonItemStateChanged(evt);
            }
        });

        jLabel6.setText("Người mượn");

        btnXemChiTiet.setText("Xem chi tiết mượn");
        btnXemChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemChiTietActionPerformed(evt);
            }
        });

        btnHuyMuon.setText("Hủy mượn");
        btnHuyMuon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyMuonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rtxtSinhVien)
                    .addComponent(rtxtKetThuc)
                    .addComponent(rtxtBatDau)
                    .addComponent(rtxtEmailSinhVien)
                    .addComponent(rcboNguoiMuon, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rtxtLyDo)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnXemChiTiet)
                .addGap(18, 18, 18)
                .addComponent(btnHuyMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rcboNguoiMuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rtxtBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rtxtKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rtxtLyDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rtxtSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rtxtEmailSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHuyMuon)
                    .addComponent(btnXemChiTiet))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        tabs.addTab("Form nhập", jPanel1);

        tblPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã lầu", "Mã phòng", "Tên phòng", "Cho mượn", "Đang trống", "Lượt đặt"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhongMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPhong);

        txtTimStart.setEditable(false);
        txtTimStart.setBackground(new java.awt.Color(255, 255, 255));
        txtTimStart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTimStartMouseClicked(evt);
            }
        });

        btnTimPhong.setText("Tìm phòng trống");
        btnTimPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimPhongActionPerformed(evt);
            }
        });

        btnTraPhong.setText("Trả phòng");
        btnTraPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraPhongActionPerformed(evt);
            }
        });

        btnMuonPhong.setText("Mượn phòng");
        btnMuonPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMuonPhongActionPerformed(evt);
            }
        });

        txtTimEnd.setEditable(false);
        txtTimEnd.setBackground(new java.awt.Color(255, 255, 255));
        txtTimEnd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTimEndMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtTimStart, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTimEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTimPhong)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                        .addComponent(btnTraPhong)
                        .addGap(18, 18, 18)
                        .addComponent(btnMuonPhong)))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnMuonPhong, btnTraPhong});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtTimEnd, txtTimStart});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimPhong)
                    .addComponent(btnTraPhong)
                    .addComponent(btnMuonPhong)
                    .addComponent(txtTimEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tabs.addTab("Danh sách", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabs, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabs)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        lamMoi();
        setEnabled(false);
    }//GEN-LAST:event_btnMoiActionPerformed

    private void btnThemPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemPhongActionPerformed
        try {
            them();
            loadTblPhong();
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            lamMoi();
            setEnabled(false);
        } catch (ToViewException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnThemPhongActionPerformed

    private void btnSuaPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaPhongActionPerformed
        try {
            sua();
            loadTblPhong();
            JOptionPane.showMessageDialog(this, "Sửa thành công");
            lamMoi();
            setEnabled(false);
        } catch (ToViewException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnSuaPhongActionPerformed

    private void btnXoaPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaPhongActionPerformed
        try {
            String confirm = JOptionPane.showInputDialog(
                    this,
                    "Tất cả dữ liệu liên quan phòng \'"
                    + txtTenPhong.getText().trim()
                    + "\' sẽ bị xóa\nNhập CONFIRM và ấn xác nhận để tiếp tục xóa!"
            );
            if (null == confirm || !confirm.equals("CONFIRM")) {
                return;
            }
            xoa();
            loadTblPhong();
            JOptionPane.showMessageDialog(this, "Xóa thành công");
            lamMoi();
            setEnabled(false);
        } catch (ToViewException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }

    }//GEN-LAST:event_btnXoaPhongActionPerformed

    private void tblPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhongMouseClicked
        if (evt.getClickCount() != 2) {
            return;
        }
        selectTable();
    }//GEN-LAST:event_tblPhongMouseClicked

    private void rcboNguoiMuonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rcboNguoiMuonItemStateChanged
        setQLM(rcboNguoiMuon.getSelectedIndex());
    }//GEN-LAST:event_rcboNguoiMuonItemStateChanged

    private void btnXemChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemChiTietActionPerformed
        showChiTietMuon();
    }//GEN-LAST:event_btnXemChiTietActionPerformed

    private void btnHuyMuonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyMuonActionPerformed
        if (rcboNguoiMuon.getItemCount() == 0) {
            return;
        }
        try {
            int confirm = JOptionPane.showConfirmDialog(this, "Phần mềm sẽ trả phòng ngay lập tức cho đối tượng này", "Xác nhận hủy mượn", JOptionPane.YES_NO_OPTION);
            if (confirm != JOptionPane.YES_OPTION) {
                return;
            }
            huyMuon();
            selectTable();
            loadTblPhong();
            JOptionPane.showMessageDialog(this, "Hủy mượn thành công");
        } catch (ToViewException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnHuyMuonActionPerformed

    private void btnMuonPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMuonPhongActionPerformed
        MuonPhongJDialog m = new MuonPhongJDialog((JFrame) this.getRootPane().getParent(), true);
        int selected = tblPhong.getSelectedRow();
        
        if (selected == -1 || selected >= tblPhong.getRowCount()) {
            JOptionPane.showMessageDialog(this, "Chưa chọn phòng muốn mượn");
            return;
        }
        
        DefaultTableModel dtm = (DefaultTableModel) tblPhong.getModel();
        
        if (dtm.getValueAt(selected, 3).equals("-")) {
            JOptionPane.showMessageDialog(this, "Phòng không được phép mượn");
            return;
        }
        
        int soTang = (Integer) dtm.getValueAt(selected, 0);
        int idPhong = (Integer) dtm.getValueAt(selected, 1);
        m.loading(soTang, idPhong);
        m.setVisible(true);
        lamMoi();
        loadTblPhong();
    }//GEN-LAST:event_btnMuonPhongActionPerformed

    private void btnTraPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraPhongActionPerformed
        showDangMuon();
        loadTblPhong();
    }//GEN-LAST:event_btnTraPhongActionPerformed

    private void btnTimPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimPhongActionPerformed

        String sbatDau = txtTimStart.getText();
        String sketThuc = txtTimEnd.getText();
        Date batDau, ketThuc;

        try {
            if (sbatDau.isEmpty()) {
                throw new ToViewException("Chưa chọn thời gian mượn");
            }

            batDau = CalendarManager.getDateByString(sbatDau, CalendarManager.DATE_HOUR_FULL_FORMAT);

            if (batDau.before(CalendarManager.addTimes(CalendarManager.getNow(), -15L * 60 * 1000))) {
                throw new ToViewException("Lỗi thời gian bắt đầu trễ hơn 15 phút so với hiện tại");
            }

            if (sketThuc.isEmpty()) {
                throw new ToViewException("Chưa chọn thời gian trả phòng");
            }

            ketThuc = CalendarManager.getDateByString(sketThuc, CalendarManager.DATE_HOUR_FULL_FORMAT);

            if (batDau.after(ketThuc)) {
                throw new ToViewException("Lỗi thời gian kết thúc trước thời gian mượn");
            }
        } catch (ToViewException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            return;
        }

        //xử lý
        loadTblPhong();
        ArrayList<ThongTinMuonPhong> ttmpss;
        ThongTinMuonPhong ttmp = new ThongTinMuonPhong();
        ttmp.setTgBatDauF(batDau);
        ttmp.setTgKetThucF(ketThuc);

        ttmpss = DatabaseManager.executeQuery(ttmp, ThongTinMuonPhong.EXECUTE_SELECT_TIM_PHONG);
        if (ttmpss == null || ttmpss.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không có phòng trống trong thời gian này!");
            return;
        }
        DefaultTableModel dtm = (DefaultTableModel) tblPhong.getModel();
        ttmpss.forEach(tt -> {
            for (int i = 0; i < dtm.getRowCount(); i++) {
                boolean isLau = tt.getPhong().getIdSoTang() == (Integer) dtm.getValueAt(i, 0);
                boolean isPhong = tt.getPhong().getIdPhong() == (Integer) dtm.getValueAt(i, 1);
                if (isLau && isPhong) {
                    tblPhong.addRowSelectionInterval(i, i);
                }
            }
        });
    }//GEN-LAST:event_btnTimPhongActionPerformed

    private void txtTimStartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimStartMouseClicked
        setGioBatDau(txtTimStart);
    }//GEN-LAST:event_txtTimStartMouseClicked

    private void txtTimEndMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimEndMouseClicked
        setGioKetThuc(txtTimStart, txtTimEnd);
    }//GEN-LAST:event_txtTimEndMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuyMuon;
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnMuonPhong;
    private javax.swing.JButton btnSuaPhong;
    private javax.swing.JButton btnThemPhong;
    private javax.swing.JButton btnTimPhong;
    private javax.swing.JButton btnTraPhong;
    private javax.swing.JButton btnXemChiTiet;
    private javax.swing.JButton btnXoaPhong;
    private javax.swing.JComboBox<String> cboLau;
    private javax.swing.JCheckBox chkChoPhep;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> rcboNguoiMuon;
    private javax.swing.JTextField rtxtBatDau;
    private javax.swing.JTextField rtxtEmailSinhVien;
    private javax.swing.JTextField rtxtKetThuc;
    private javax.swing.JTextField rtxtLyDo;
    private javax.swing.JTextField rtxtSinhVien;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblPhong;
    private javax.swing.JTextField txtMaPhong;
    private javax.swing.JTextField txtTenPhong;
    private javax.swing.JTextField txtTimEnd;
    private javax.swing.JTextField txtTimStart;
    // End of variables declaration//GEN-END:variables

    ChonNgayGioJDialog chonTG = new ChonNgayGioJDialog((JFrame) this.getParent(), true);

    public void setTab(int i) {
        tabs.setSelectedIndex(i);
    }

    private void lamMoi() {
        txtTenPhong.setText("");
        txtMaPhong.setText("");
        rtxtLyDo.setText("");
        cboLau.setSelectedIndex(0);
        chkChoPhep.setSelected(false);
        setEditable(false);

        lamMoiR();
    }

    private void lamMoiR() {
        DefaultComboBoxModel dcm = (DefaultComboBoxModel) rcboNguoiMuon.getModel();
        dcm.removeAllElements();
        rtxtBatDau.setText("");
        rtxtKetThuc.setText("");
        rtxtLyDo.setText("");
        rtxtSinhVien.setText("");
        rtxtEmailSinhVien.setText("");
    }

    private void loadTblPhong() {
        DefaultTableModel dtm = (DefaultTableModel) tblPhong.getModel();
        dtm.setRowCount(0);
        ArrayList<Phong> dsPhong = DatabaseManager.executeQuery(new Phong(), Phong.EXECUTE_SELECT_ALL);
        dsPhong.forEach(phong -> {
            dtm.addRow(new Object[]{phong.getIdSoTang(), phong.getIdPhong(), phong.getTenPhong(), phong.isChoMuon() ? "Có" : "-", phong.isDangTrong() ? "Có" : "-", phong.getLuotDat()});
        });
        loadPhongDangMuon();
    }

    private void them() throws ToViewException {
        Phong phg = getModel();
        int i = DatabaseManager.executeUpdate(phg, Phong.EXECUTE_INSERT);
        if (i == 0) {
            ArrayList<Phong> dsPhong;
            dsPhong = DatabaseManager.executeQuery(phg, Phong.EXECUTE_SELECT_BY_ID);
            if (dsPhong.size() > 0) {
                throw new ToViewException("Phòng đã tồn tại");
            }
        }
    }

    private Phong getModel() throws ToViewException {
        Phong model = new Phong();
        String smaphg = txtMaPhong.getText().trim();
        String ssotang = String.valueOf(cboLau.getSelectedItem());
        String tenPh = txtTenPhong.getText().trim();

        if (smaphg.isEmpty()) {
            throw new ToViewException("Phòng không được để trống");
        }
        if (ssotang.isEmpty()) {
            throw new ToViewException("Số tầng không được để trống");
        }
        if (tenPh.isEmpty()) {
            throw new ToViewException("Tên phòng không được để trống");
        }

        model.setTenPhong(tenPh);
        int sotang = Integer.parseInt(ssotang);
        int maphg = Integer.parseInt(smaphg);

        model.setIdSoTang(sotang);
        model.setIdPhong(maphg);

        model.setChoMuon(chkChoPhep.isSelected());
        return model;
    }

    private void selectTable() {
        int rowSelected = tblPhong.getSelectedRow();
        if (rowSelected < 0) {
            return;
        }
        DefaultTableModel dtm = (DefaultTableModel) tblPhong.getModel();
        Integer idTang = (Integer) dtm.getValueAt(rowSelected, 0);
        Integer idPhong = (Integer) dtm.getValueAt(rowSelected, 1);

        setQLMuon(idTang, idPhong);

        if (ttmps.isEmpty()) {
            return;
        }

        setForm(ttmps.get(0).getPhong());
        setEditable(true);
        tabs.setSelectedIndex(0);
    }

    private void setForm(Phong phong) {
        cboLau.getModel().setSelectedItem(phong.getIdSoTang());
        txtMaPhong.setText(phong.getIdPhong() + "");
        txtTenPhong.setText(phong.getTenPhong());
        chkChoPhep.getModel().setSelected(phong.isChoMuon());
    }

    public void setEditable(boolean selected) {
        cboLau.setEnabled(!selected);
        txtMaPhong.setEditable(!selected);
        btnThemPhong.setEnabled(!selected);
        btnSuaPhong.setEnabled(selected);
        btnXoaPhong.setEnabled(selected);
        btnXemChiTiet.setEnabled(selected);
        btnHuyMuon.setEnabled(selected);
    }

    public void sua() throws ToViewException {
        Phong phog = getModel();
        int i = DatabaseManager.executeUpdate(phog, Phong.EXECUTE_UPDATE_BY_ID);
        if (i == 0) {
            throw new ToViewException("Sửa phòng thất bại");
        }
    }

    public void xoa() throws ToViewException {
        Phong phog = getModel();
        DatabaseManager.executeUpdate(phog, Phong.EXECUTE_DELETE_BY_ID);
    }

    private ArrayList<ThongTinMuonPhong> ttmps = new ArrayList<>();
    private ArrayList<QLMuon> qlms = new ArrayList<>();

    private void setQLMuon(int soTang, int idPhong) {
        ThongTinMuonPhong ttmp = new ThongTinMuonPhong();
        ttmp.setSoTang(soTang);
        ttmp.setIdPhong(idPhong);
        ttmps = DatabaseManager.executeQuery(ttmp, ThongTinMuonPhong.EXECUTE_SELECT_BY_ID_PHONG);
        qlms.clear();
        if (ttmps == null || ttmps.isEmpty()) {
            return;
        }
        ttmps.forEach(tt -> {
            if (tt.getPhong().getLuotDat() >= 0 && tt.getMuonPhong() != null && tt.getMuonPhong().getTgTraThucTe() == null) {
                QLMuon qlm = new QLMuon();
                qlm.idMuon = tt.getMuonPhong().getIdMuonPhong();
                qlm.emailSinhVien = tt.getSinhVien() != null ? tt.getSinhVien().getEmail() : "";
                qlm.lyDo = tt.getMuonPhong().getLyDo();
                qlm.sinhVien = tt.getSinhVien() != null ? tt.getSinhVien().getTenSV() + " (" + tt.getSinhVien().getIdSV() + ")" : "";
                qlm.tenNguoiMuon = tt.getTaiKhoan().getTen() + " (" + tt.getTaiKhoan().getIdTaiKhoan() + ")";
                qlm.tgBatDau = CalendarManager.getString(tt.getMuonPhong().getTgMuon(), CalendarManager.DATE_HOUR_FULL_FORMAT);
                qlm.tgKetThuc = CalendarManager.getString(tt.getMuonPhong().getTgTra(), CalendarManager.DATE_HOUR_FULL_FORMAT);
                qlms.add(qlm);
            }
        });
        DefaultComboBoxModel dcm = (DefaultComboBoxModel) rcboNguoiMuon.getModel();
        dcm.removeAllElements();
        for (QLMuon qlm : qlms) {
            dcm.addElement(qlm);
        }
        setQLM(0);
    }

    private void setQLM(int index) {
        if (index < 0 || index >= qlms.size()) {
            lamMoiR();
            return;
        }
        QLMuon qlm = qlms.get(index);
        rcboNguoiMuon.getModel().setSelectedItem(qlm);
        rtxtBatDau.setText(qlm.tgBatDau);
        rtxtKetThuc.setText(qlm.tgKetThuc);
        rtxtLyDo.setText(qlm.lyDo);
        rtxtSinhVien.setText(qlm.sinhVien);
        rtxtEmailSinhVien.setText(qlm.emailSinhVien);
    }

    private void showChiTietMuon() {
        ChiTietMuonJDialog dialog = new ChiTietMuonJDialog((JFrame) this.getRootPane().getParent(), true);
        dialog.loading(ttmps);
        dialog.setVisible(true);
        int seleted = dialog.getRowSeleted();
        if (seleted == -1 || seleted >= rcboNguoiMuon.getItemCount()) {
            setQLMuon((Integer) cboLau.getSelectedItem(), Integer.parseInt(txtMaPhong.getText()));
        } else {
            setQLM(seleted);
        }
    }

    private void huyMuon() throws ToViewException {
        QLMuon muon = (QLMuon) rcboNguoiMuon.getSelectedItem();
        MuonPhong mp = new MuonPhong();
        mp.setIdMuonPhong(muon.idMuon);

        ArrayList<MuonPhong> mps = DatabaseManager.executeQuery(mp, MuonPhong.EXECUTE_SELECT_BY_ID);
        if (mps == null && mps.isEmpty()) {
            throw new ToViewException("Không có phiếu mượn định hủy");
        }
        mp = mps.get(0);
        if (CalendarManager.getNow().before(mp.getTgMuon())) {
            mp.setTgTraThucTe(mp.getTgMuon());
        } else {
            mp.setTgTraThucTe(CalendarManager.getNow());
        }
        int ok = DatabaseManager.executeUpdate(mp, MuonPhong.EXECUTE_UPDATE_BY_ID);
        if (ok == 0) {
            throw new ToViewException("Hủy mượn phòng thất bại");
        }
        setQLMuon(mp.getSoTang(), mp.getIdPhong());
    }

    private ArrayList<ThongTinMuonPhong> ttPhongDangMuons = new ArrayList<>();

    private void loadPhongDangMuon() {
        if (!Session.isLogin()) {
            btnTraPhong.setEnabled(false);
            return;
        }

        ThongTinMuonPhong ttmp = new ThongTinMuonPhong();
        ttmp.setIdTaiKhoanMuon(Session.USER.getIdTaiKhoan());
        ttPhongDangMuons = DatabaseManager.executeQuery(ttmp, ThongTinMuonPhong.EXECUTE_SELECT_BY_ID_TAI_KHOAN);

        if (ttPhongDangMuons == null || ttPhongDangMuons.isEmpty()) {
            btnTraPhong.setEnabled(false);
        } else {
            btnTraPhong.setEnabled(true);
        }
    }

    private void showDangMuon() {
        if (ttPhongDangMuons == null || ttPhongDangMuons.isEmpty()) {
            btnTraPhong.setEnabled(false);
            return;
        } else {
            btnTraPhong.setEnabled(true);
        }
        TraPhongJDialog traPhongJDialog = new TraPhongJDialog((JFrame) this.getRootPane().getParent(), true, ttPhongDangMuons);
        traPhongJDialog.setVisible(true);
    }

    private void setGioBatDau(JTextField txtBatDau) {
        ChonNgayGioJDialog cngjd = new ChonNgayGioJDialog((JFrame) this.getRootPane().getParent(), true);

        Date dateOrigin = CalendarManager.getNow();
        if (!txtBatDau.getText().isEmpty()) {
            dateOrigin = CalendarManager.getDateByString(txtBatDau.getText(), CalendarManager.DATE_HOUR_FULL_FORMAT);
        }

        cngjd.setDateOrigin(dateOrigin);
        cngjd.setVisible(true);
        txtBatDau.setText(cngjd.getResult());
    }

    private void setGioKetThuc(JTextField txtBatDau, JTextField txtKetThuc) {
        ChonNgayGioJDialog cngjd = new ChonNgayGioJDialog((JFrame) this.getRootPane().getParent(), true);

        Date dateOrigin = CalendarManager.getNow();

        if (!txtKetThuc.getText().isEmpty()) {
            dateOrigin = CalendarManager.getDateByString(txtKetThuc.getText(), CalendarManager.DATE_HOUR_FULL_FORMAT);
        } else {
            if (!txtBatDau.getText().isEmpty()) {
                Date first = CalendarManager.getDateByString(txtBatDau.getText(), CalendarManager.DATE_HOUR_FULL_FORMAT);
                dateOrigin = CalendarManager.addTimes(first, 1000L * 60 * 60 * 2);
            }
        }

        cngjd.setDateOrigin(dateOrigin);
        cngjd.setVisible(true);
        txtKetThuc.setText(cngjd.getResult());
    }

    private class QLMuon {

        int idMuon;
        String tenNguoiMuon;
        String tgBatDau;
        String tgKetThuc;
        String lyDo;
        String sinhVien = "";
        String emailSinhVien = "";

        @Override
        public String toString() {
            return tenNguoiMuon;
        }
    }

}
