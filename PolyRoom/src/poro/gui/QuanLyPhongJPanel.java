/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poro.gui;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import poro.module.CalendarManager;
import poro.module.db.DatabaseManager;
import poro.module.db.data.Phong;

/**
 *
 * @author ASUS
 */
public class QuanLyPhongJPanel extends javax.swing.JPanel {

    /**
     * Creates new form QuanLyPhongJPanel
     */
    public QuanLyPhongJPanel() {
        initComponents();
        loadTblPhong();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabs = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        cboLau = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTenPhong = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtMaPhong = new javax.swing.JTextField();
        chkChoPhep = new javax.swing.JCheckBox();
        btnMoi = new javax.swing.JButton();
        btnSuaPhong = new javax.swing.JButton();
        btnXoaPhong = new javax.swing.JButton();
        btnThemPhong = new javax.swing.JButton();
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
        txtCa = new javax.swing.JTextField();
        btnTimPhong = new javax.swing.JButton();
        btnTraPhong = new javax.swing.JButton();
        btnMuonPhong = new javax.swing.JButton();
        txtCa1 = new javax.swing.JTextField();

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quản lý phòng", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP));

        cboLau.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4" }));

        jLabel4.setText("Tầng lầu");

        jLabel3.setText("Tên phòng");

        jLabel2.setText("Mã phòng");

        chkChoPhep.setText("Cho phép mượn");
        chkChoPhep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkChoPhepActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(txtTenPhong)
                            .addComponent(cboLau, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(chkChoPhep))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtMaPhong)
                                .addContainerGap())))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnThemPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSuaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoaPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnMoi, btnSuaPhong, btnThemPhong, btnXoaPhong});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboLau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkChoPhep))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMoi)
                    .addComponent(btnThemPhong)
                    .addComponent(btnSuaPhong)
                    .addComponent(btnXoaPhong))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnMoi, btnSuaPhong, btnThemPhong, btnXoaPhong});

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cboLau, chkChoPhep, txtMaPhong, txtTenPhong});

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quản lý mượn", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP));

        jLabel13.setText("Lý do");

        jLabel11.setText("Email Sinh viên");

        jLabel12.setText("Sinh viên");

        rtxtKetThuc.setEditable(false);
        rtxtKetThuc.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setText("Thời gian trả dự kiến");

        rtxtBatDau.setEditable(false);
        rtxtBatDau.setBackground(new java.awt.Color(255, 255, 255));
        rtxtBatDau.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rtxtBatDauFocusGained(evt);
            }
        });
        rtxtBatDau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rtxtBatDauMouseClicked(evt);
            }
        });

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
                    .addComponent(jLabel13)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnXemChiTiet)
                        .addGap(18, 18, 18)
                        .addComponent(btnHuyMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
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
            .addGroup(jPanel1Layout.createSequentialGroup()
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
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
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

        btnTimPhong.setText("Tìm phòng trống");

        btnTraPhong.setText("Trả phòng");

        btnMuonPhong.setText("Mượn phòng");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtCa, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtCa1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTimPhong)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 199, Short.MAX_VALUE)
                        .addComponent(btnTraPhong)
                        .addGap(18, 18, 18)
                        .addComponent(btnMuonPhong)))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnMuonPhong, btnTraPhong});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtCa, txtCa1});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimPhong)
                    .addComponent(btnTraPhong)
                    .addComponent(btnMuonPhong)
                    .addComponent(txtCa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tabs.addTab("Danh sách", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabs)
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

    private void chkChoPhepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkChoPhepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkChoPhepActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        // TODO add your handling code here:
        lamMoi();
        setEnabled(false);
    }//GEN-LAST:event_btnMoiActionPerformed

    private void btnThemPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemPhongActionPerformed
        // TODO add your handling code here:
        try {
            them();
            loadTblPhong();
            JOptionPane.showMessageDialog(this, "Thêm thành công");
        } catch (ToViewException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnThemPhongActionPerformed

    private void btnSuaPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaPhongActionPerformed
        // TODO add your handling code here:
        try {
            sua();
            loadTblPhong();
            JOptionPane.showMessageDialog(this, "Thêm thành công");
        } catch (ToViewException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnSuaPhongActionPerformed

    private void btnXoaPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaPhongActionPerformed
        // TODO add your handling code here:
        try {
            xoa();
            loadTblPhong();
            JOptionPane.showMessageDialog(this, "Thêm thành công");
        } catch (ToViewException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnXoaPhongActionPerformed

    private void tblPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhongMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() != 2) {
            return;
        }
        selectTable();
    }//GEN-LAST:event_tblPhongMouseClicked

    private void rtxtBatDauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rtxtBatDauMouseClicked
        chonTG.setDateOrigin(CalendarManager.getNow());
        chonTG.setVisible(true);
        chonTG.resetForm();
        rtxtBatDau.setText(chonTG.getResult());
    }//GEN-LAST:event_rtxtBatDauMouseClicked

    private void rtxtBatDauFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rtxtBatDauFocusGained
        rtxtBatDau.setSelectionStart(0);
        rtxtBatDau.setSelectionEnd(rtxtBatDau.getText().length());
        if (rtxtBatDau.getText() == null || rtxtBatDau.getText().trim().isEmpty()) {
            return;
        }
    }//GEN-LAST:event_rtxtBatDauFocusGained

    private void rcboNguoiMuonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rcboNguoiMuonItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_rcboNguoiMuonItemStateChanged

    private void btnXemChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemChiTietActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXemChiTietActionPerformed

    private void btnHuyMuonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyMuonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHuyMuonActionPerformed


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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> rcboNguoiMuon;
    private javax.swing.JTextField rtxtBatDau;
    private javax.swing.JTextField rtxtEmailSinhVien;
    private javax.swing.JTextField rtxtKetThuc;
    private javax.swing.JTextField rtxtLyDo;
    private javax.swing.JTextField rtxtSinhVien;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblPhong;
    private javax.swing.JTextField txtCa;
    private javax.swing.JTextField txtCa1;
    private javax.swing.JTextField txtMaPhong;
    private javax.swing.JTextField txtTenPhong;
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
    }

    private void loadTblPhong() {
        DefaultTableModel dtm = (DefaultTableModel) tblPhong.getModel();
        dtm.setRowCount(0);
        ArrayList<Phong> dsPhong = DatabaseManager.executeQuery(new Phong(), Phong.EXECUTE_SELECT_ALL);
        dsPhong.forEach(phong -> {
            dtm.addRow(new Object[]{phong.getIdSoTang(), phong.getIdPhong(), phong.getTenPhong(), phong.isChoMuon() ? "Có" : "-", phong.isDangTrong() ? "Có" : "-", phong.getLuotDat()});
        });
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

    private Phong getModel() {
        Phong model = new Phong();
        String smaphg = txtMaPhong.getText().trim();
        int maphg = Integer.parseInt(smaphg);
        String ssotang = String.valueOf(cboLau.getSelectedItem());
        int sotang = Integer.parseInt(ssotang);
        model.setIdSoTang(sotang);
        model.setIdPhong(maphg);
        model.setTenPhong(txtTenPhong.getText().trim());
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
        Phong ph = new Phong();
        ph.setIdPhong(idPhong);
        ph.setIdSoTang(idTang);
        ArrayList<Phong> dsPhong = DatabaseManager.executeQuery(ph, Phong.EXECUTE_SELECT_BY_ID);
        if (dsPhong.isEmpty()) {
            return;
        }

        setForm(dsPhong.get(0));
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
        //code by Ngọc
    }

    public void sua() throws ToViewException{
        //code by Ngọc
    }

    public void xoa() throws ToViewException {
        //code by Ngọc
    }

    
    
}
