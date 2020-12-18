package poro.gui;

import java.awt.Color;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import poro.module.CalendarManager;
import poro.module.Session;

/**
 *
 * @author Ngọc, vinh
 */
public class QLMainJFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainJFrame
     */
    public QLMainJFrame() {
        initComponents();

        init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        toolbar = new javax.swing.JToolBar();
        btnDangNhap = new javax.swing.JButton();
        btnDoiMatKhau = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        sptSauTaiKhoan = new javax.swing.JToolBar.Separator();
        btnQuanLyTaiKhoan = new javax.swing.JButton();
        btnQuanLyPhong = new javax.swing.JButton();
        btnMuonPhong = new javax.swing.JButton();
        sptSauPhong = new javax.swing.JToolBar.Separator();
        btnThongKe = new javax.swing.JButton();
        tabContent = new javax.swing.JTabbedPane();
        pnlChanTrang = new javax.swing.JPanel();
        lblNow = new javax.swing.JLabel();
        btnDongTab = new javax.swing.JButton();
        btnResetTab = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        mnubar = new javax.swing.JMenuBar();
        mnuTaiKhoan = new javax.swing.JMenu();
        mniQLTaiKhoan = new javax.swing.JMenuItem();
        mniXemTaiKhoan = new javax.swing.JMenuItem();
        sptMnuSauQLTaiKhoan = new javax.swing.JPopupMenu.Separator();
        mniDangNhap = new javax.swing.JMenuItem();
        mniDoiMatKhau = new javax.swing.JMenuItem();
        mniDangXuat = new javax.swing.JMenuItem();
        sptMnuSauTaiKhoan = new javax.swing.JPopupMenu.Separator();
        mniThoat = new javax.swing.JMenuItem();
        mnuPhong = new javax.swing.JMenu();
        mniQLPhong = new javax.swing.JMenuItem();
        mniXemPhong = new javax.swing.JMenuItem();
        mniMuonPhong = new javax.swing.JMenuItem();
        mnuThongKe = new javax.swing.JMenu();
        mniThongKePhong = new javax.swing.JMenuItem();
        mniThongKeGv = new javax.swing.JMenuItem();
        mniThongKeAll = new javax.swing.JMenuItem();
        mnuGioiThieu = new javax.swing.JMenu();
        mniChungToi = new javax.swing.JMenuItem();
        mniHuongDan = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PolyRoom - Quản Lí Phòng Học");
        setBackground(new java.awt.Color(204, 204, 204));

        toolbar.setBackground(new java.awt.Color(204, 204, 204));
        toolbar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        toolbar.setFloatable(false);
        toolbar.setToolTipText("");
        toolbar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        toolbar.setEnabled(false);
        toolbar.setMargin(new java.awt.Insets(5, 5, 5, 5));

        btnDangNhap.setBackground(new java.awt.Color(204, 204, 204));
        btnDangNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Login.png"))); // NOI18N
        btnDangNhap.setText("Đăng nhập");
        btnDangNhap.setFocusable(false);
        btnDangNhap.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDangNhap.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });
        toolbar.add(btnDangNhap);

        btnDoiMatKhau.setBackground(new java.awt.Color(204, 204, 204));
        btnDoiMatKhau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Refresh.png"))); // NOI18N
        btnDoiMatKhau.setText("Đổi mật khẩu");
        btnDoiMatKhau.setFocusable(false);
        btnDoiMatKhau.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDoiMatKhau.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDoiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiMatKhauActionPerformed(evt);
            }
        });
        toolbar.add(btnDoiMatKhau);

        btnThoat.setBackground(new java.awt.Color(204, 204, 204));
        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Delete.png"))); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.setFocusable(false);
        btnThoat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnThoat.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });
        toolbar.add(btnThoat);
        toolbar.add(sptSauTaiKhoan);

        btnQuanLyTaiKhoan.setBackground(new java.awt.Color(204, 204, 204));
        btnQuanLyTaiKhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Conference.png"))); // NOI18N
        btnQuanLyTaiKhoan.setText("Quản lý tài khoản ");
        btnQuanLyTaiKhoan.setFocusable(false);
        btnQuanLyTaiKhoan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnQuanLyTaiKhoan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnQuanLyTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLyTaiKhoanActionPerformed(evt);
            }
        });
        toolbar.add(btnQuanLyTaiKhoan);

        btnQuanLyPhong.setBackground(new java.awt.Color(204, 204, 204));
        btnQuanLyPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Company.png"))); // NOI18N
        btnQuanLyPhong.setText("Quản lý phòng");
        btnQuanLyPhong.setFocusable(false);
        btnQuanLyPhong.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnQuanLyPhong.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnQuanLyPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLyPhongActionPerformed(evt);
            }
        });
        toolbar.add(btnQuanLyPhong);

        btnMuonPhong.setBackground(new java.awt.Color(204, 204, 204));
        btnMuonPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Key.png"))); // NOI18N
        btnMuonPhong.setText("Mượn phòng");
        btnMuonPhong.setFocusable(false);
        btnMuonPhong.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMuonPhong.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMuonPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMuonPhongActionPerformed(evt);
            }
        });
        toolbar.add(btnMuonPhong);
        toolbar.add(sptSauPhong);

        btnThongKe.setBackground(new java.awt.Color(204, 204, 204));
        btnThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Lists.png"))); // NOI18N
        btnThongKe.setText("Thống kê");
        btnThongKe.setFocusable(false);
        btnThongKe.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnThongKe.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });
        toolbar.add(btnThongKe);

        getContentPane().add(toolbar, java.awt.BorderLayout.PAGE_START);

        tabContent.setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().add(tabContent, java.awt.BorderLayout.CENTER);

        pnlChanTrang.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.darkShadow"));
        pnlChanTrang.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblNow.setBackground(new java.awt.Color(0, 0, 0));
        lblNow.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lblNow.setForeground(new java.awt.Color(255, 255, 255));
        lblNow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Date.png"))); // NOI18N
        lblNow.setText("22/12/2020 - 20:02:59");
        lblNow.setToolTipText("Theo giờ hệ thống trên laptop");

        btnDongTab.setBackground(new java.awt.Color(0, 0, 0));
        btnDongTab.setText("Đóng tab");
        btnDongTab.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnDongTab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDongTabActionPerformed(evt);
            }
        });

        btnResetTab.setBackground(new java.awt.Color(0, 0, 0));
        btnResetTab.setText("Reset tab");
        btnResetTab.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnResetTab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetTabActionPerformed(evt);
            }
        });

        btnHome.setBackground(new java.awt.Color(0, 0, 0));
        btnHome.setText("Trang chủ");
        btnHome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlChanTrangLayout = new javax.swing.GroupLayout(pnlChanTrang);
        pnlChanTrang.setLayout(pnlChanTrangLayout);
        pnlChanTrangLayout.setHorizontalGroup(
            pnlChanTrangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChanTrangLayout.createSequentialGroup()
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnResetTab)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDongTab)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 590, Short.MAX_VALUE)
                .addComponent(lblNow, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlChanTrangLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnDongTab, btnHome, btnResetTab});

        pnlChanTrangLayout.setVerticalGroup(
            pnlChanTrangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChanTrangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblNow)
                .addComponent(btnDongTab)
                .addComponent(btnResetTab)
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlChanTrangLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnDongTab, btnHome, btnResetTab});

        getContentPane().add(pnlChanTrang, java.awt.BorderLayout.PAGE_END);

        mnuTaiKhoan.setText("Tài khoản");

        mniQLTaiKhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Conference.png"))); // NOI18N
        mniQLTaiKhoan.setText("Quản lí tài khoản");
        mniQLTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniQLTaiKhoanActionPerformed(evt);
            }
        });
        mnuTaiKhoan.add(mniQLTaiKhoan);

        mniXemTaiKhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Clien list.png"))); // NOI18N
        mniXemTaiKhoan.setText("Xem tài khoản");
        mniXemTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniXemTaiKhoanActionPerformed(evt);
            }
        });
        mnuTaiKhoan.add(mniXemTaiKhoan);
        mnuTaiKhoan.add(sptMnuSauQLTaiKhoan);

        mniDangNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Login.png"))); // NOI18N
        mniDangNhap.setText("Đăng nhập");
        mniDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDangNhapActionPerformed(evt);
            }
        });
        mnuTaiKhoan.add(mniDangNhap);

        mniDoiMatKhau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Refresh.png"))); // NOI18N
        mniDoiMatKhau.setText("Đổi mật khẩu");
        mniDoiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDoiMatKhauActionPerformed(evt);
            }
        });
        mnuTaiKhoan.add(mniDoiMatKhau);

        mniDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Exit.png"))); // NOI18N
        mniDangXuat.setText("Đăng xuất");
        mniDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDangXuatActionPerformed(evt);
            }
        });
        mnuTaiKhoan.add(mniDangXuat);
        mnuTaiKhoan.add(sptMnuSauTaiKhoan);

        mniThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Delete.png"))); // NOI18N
        mniThoat.setText("Thoát");
        mniThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniThoatActionPerformed(evt);
            }
        });
        mnuTaiKhoan.add(mniThoat);

        mnubar.add(mnuTaiKhoan);

        mnuPhong.setText("Phòng");

        mniQLPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Company.png"))); // NOI18N
        mniQLPhong.setText("Quản lí phòng");
        mniQLPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniQLPhongActionPerformed(evt);
            }
        });
        mnuPhong.add(mniQLPhong);

        mniXemPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/List.png"))); // NOI18N
        mniXemPhong.setText("Xem phòng");
        mniXemPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniXemPhongActionPerformed(evt);
            }
        });
        mnuPhong.add(mniXemPhong);

        mniMuonPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Key.png"))); // NOI18N
        mniMuonPhong.setText("Mượn phòng");
        mniMuonPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniMuonPhongActionPerformed(evt);
            }
        });
        mnuPhong.add(mniMuonPhong);

        mnubar.add(mnuPhong);

        mnuThongKe.setText("Thống kê");

        mniThongKePhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Lists.png"))); // NOI18N
        mniThongKePhong.setText("Thống kê phòng");
        mniThongKePhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniThongKePhongActionPerformed(evt);
            }
        });
        mnuThongKe.add(mniThongKePhong);

        mniThongKeGv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Lists.png"))); // NOI18N
        mniThongKeGv.setText("Thống kê giảng viên");
        mniThongKeGv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniThongKeGvActionPerformed(evt);
            }
        });
        mnuThongKe.add(mniThongKeGv);

        mniThongKeAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Statistics.png"))); // NOI18N
        mniThongKeAll.setText("Thống kê tất cả");
        mniThongKeAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniThongKeAllActionPerformed(evt);
            }
        });
        mnuThongKe.add(mniThongKeAll);

        mnubar.add(mnuThongKe);

        mnuGioiThieu.setText("Giới thiệu");

        mniChungToi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/User group.png"))); // NOI18N
        mniChungToi.setText("Về chúng tôi");
        mniChungToi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniChungToiActionPerformed(evt);
            }
        });
        mnuGioiThieu.add(mniChungToi);

        mniHuongDan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Help.png"))); // NOI18N
        mniHuongDan.setText("Hướng dẫn");
        mniHuongDan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniHuongDanActionPerformed(evt);
            }
        });
        mnuGioiThieu.add(mniHuongDan);

        mnubar.add(mnuGioiThieu);

        setJMenuBar(mnubar);

        setSize(new java.awt.Dimension(1040, 610));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mniQLTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniQLTaiKhoanActionPerformed
        try {
            showQLTaiKhoan(0);
        } catch (ToViewException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_mniQLTaiKhoanActionPerformed

    private void mniXemTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniXemTaiKhoanActionPerformed
        try {
            showQLTaiKhoan(1);
        } catch (ToViewException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_mniXemTaiKhoanActionPerformed

    private void mniDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDangNhapActionPerformed
        showDangNhap();
    }//GEN-LAST:event_mniDangNhapActionPerformed

    private void mniDoiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDoiMatKhauActionPerformed
        try {
            showDoiMatKhau();
        } catch (ToViewException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_mniDoiMatKhauActionPerformed

    private void mniDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDangXuatActionPerformed
        showDangXuat();
    }//GEN-LAST:event_mniDangXuatActionPerformed

    private void mniThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniThoatActionPerformed
        this.dispose();
    }//GEN-LAST:event_mniThoatActionPerformed

    private void mniQLPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniQLPhongActionPerformed
        try {
            showQLPhong(0);
        } catch (ToViewException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_mniQLPhongActionPerformed

    private void mniXemPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniXemPhongActionPerformed
        try {
            showQLPhong(1);
        } catch (ToViewException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_mniXemPhongActionPerformed

    private void mniMuonPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniMuonPhongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mniMuonPhongActionPerformed

    private void mniThongKePhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniThongKePhongActionPerformed
        try {
            showThongKe(0);
        } catch (ToViewException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_mniThongKePhongActionPerformed

    private void mniThongKeGvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniThongKeGvActionPerformed
        try {
            showThongKe(1);
        } catch (ToViewException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_mniThongKeGvActionPerformed

    private void mniThongKeAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniThongKeAllActionPerformed
        try {
            showThongKe(2);
        } catch (ToViewException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_mniThongKeAllActionPerformed

    private void mniChungToiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniChungToiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mniChungToiActionPerformed

    private void mniHuongDanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniHuongDanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mniHuongDanActionPerformed

    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
        showDangNhap();
    }//GEN-LAST:event_btnDangNhapActionPerformed

    private void btnDoiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiMatKhauActionPerformed
        try {
            showDoiMatKhau();
        } catch (ToViewException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnDoiMatKhauActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnQuanLyTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLyTaiKhoanActionPerformed
        try {
            showQLTaiKhoan(0);
        } catch (ToViewException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnQuanLyTaiKhoanActionPerformed

    private void btnQuanLyPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLyPhongActionPerformed
        try {
            showQLPhong(0);
        } catch (ToViewException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnQuanLyPhongActionPerformed

    private void btnMuonPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMuonPhongActionPerformed
        try {
            showMuonPhong();
        } catch (ToViewException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnMuonPhongActionPerformed

    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed
        try {
            showThongKe(0);
        } catch (ToViewException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnThongKeActionPerformed

    private void btnDongTabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongTabActionPerformed
        closeTab();
    }//GEN-LAST:event_btnDongTabActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        toHome();
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnResetTabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetTabActionPerformed
        resetTabs();
    }//GEN-LAST:event_btnResetTabActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
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
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLMainJFrame().setVisible(true);
            }
        });
    }

    @Override
    public void dispose() {
        int i = JOptionPane.showConfirmDialog(this, "Bạn có muốn thoát khỏi phần mềm ?", "Thoát", JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.YES_OPTION) {
            Session.exit();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangNhap;
    private javax.swing.JButton btnDoiMatKhau;
    private javax.swing.JButton btnDongTab;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnMuonPhong;
    private javax.swing.JButton btnQuanLyPhong;
    private javax.swing.JButton btnQuanLyTaiKhoan;
    private javax.swing.JButton btnResetTab;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnThongKe;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblNow;
    private javax.swing.JMenuItem mniChungToi;
    private javax.swing.JMenuItem mniDangNhap;
    private javax.swing.JMenuItem mniDangXuat;
    private javax.swing.JMenuItem mniDoiMatKhau;
    private javax.swing.JMenuItem mniHuongDan;
    private javax.swing.JMenuItem mniMuonPhong;
    private javax.swing.JMenuItem mniQLPhong;
    private javax.swing.JMenuItem mniQLTaiKhoan;
    private javax.swing.JMenuItem mniThoat;
    private javax.swing.JMenuItem mniThongKeAll;
    private javax.swing.JMenuItem mniThongKeGv;
    private javax.swing.JMenuItem mniThongKePhong;
    private javax.swing.JMenuItem mniXemPhong;
    private javax.swing.JMenuItem mniXemTaiKhoan;
    private javax.swing.JMenu mnuGioiThieu;
    private javax.swing.JMenu mnuPhong;
    private javax.swing.JMenu mnuTaiKhoan;
    private javax.swing.JMenu mnuThongKe;
    private javax.swing.JMenuBar mnubar;
    private javax.swing.JPanel pnlChanTrang;
    private javax.swing.JPopupMenu.Separator sptMnuSauQLTaiKhoan;
    private javax.swing.JPopupMenu.Separator sptMnuSauTaiKhoan;
    private javax.swing.JToolBar.Separator sptSauPhong;
    private javax.swing.JToolBar.Separator sptSauTaiKhoan;
    private javax.swing.JTabbedPane tabContent;
    private javax.swing.JToolBar toolbar;
    // End of variables declaration//GEN-END:variables

    private NMXemPhongJPanel tab_NMXemPhongJPanel;
    private QuanLyPhongJPanel tab_QuanLyPhongJPanel;
    private QuanLyTaiKhoanJPanel tab_QuanLyTaiKhoanJPanel;
    private ThongKeJPanel tab_ThongKeJPanel;
    private TrangChuJPanel tab_TrangChuJPanel;

    private void init() {
        tab_NMXemPhongJPanel = new NMXemPhongJPanel();
        tab_QuanLyPhongJPanel = new QuanLyPhongJPanel();
        tab_QuanLyTaiKhoanJPanel = new QuanLyTaiKhoanJPanel();
        tab_ThongKeJPanel = new ThongKeJPanel();
        tab_TrangChuJPanel = new TrangChuJPanel();

        resetTabs();
        loadingDongHo();
    }

    /**
     * Chuyển đổi giao diện cho người mượn hoặc quản lý
     *
     * @param chucVu Chức vụ sẽ hiện (true là quản lý)
     */
    public void setGiaoDien(boolean chucVu) {
        mniQLTaiKhoan.setVisible(chucVu);
        mniXemTaiKhoan.setVisible(chucVu);
        mniXemPhong.setVisible(chucVu);
        mniXemPhong.setVisible(chucVu);
        mniQLPhong.setVisible(chucVu);
        mnuThongKe.setVisible(chucVu);
        btnQuanLyPhong.setVisible(chucVu);
        btnQuanLyTaiKhoan.setVisible(chucVu);
        btnThongKe.setVisible(chucVu);
        sptMnuSauQLTaiKhoan.setVisible(chucVu);
        sptSauPhong.setVisible(chucVu);
        btnMuonPhong.setVisible(!chucVu);
        mniMuonPhong.setVisible(!chucVu);
    }

    /**
     * Thêm một tab vào màn hình chính
     *
     * @param title Tiêu đề của panel
     * @param panel Panel sẽ thêm vào màn hình chính
     */
    private void addTab(String title, JPanel panel) {
        JScrollPane jb = new JScrollPane();
        jb.setBorder(null);
        jb.setViewportView(panel);
        jb.setBorder(BorderFactory.createEtchedBorder(Color.BLACK, null));
        tabContent.addTab(title, jb);
        tabContent.setSelectedIndex(tabContent.getTabCount() - 1);
        // vòng for xóa tab trùng title trước đó
        // i < count - 1 vì tab cuối cùng là tab hiện tại
        for (int i = 0; i < tabContent.getTabCount() - 1; i++) {
            if (tabContent.getTitleAt(i).equals(title)) {
                tabContent.removeTabAt(i);
            }
        }
    }

    /**
     * Set panel vào tabs và setTab của lớp {@link QuanLyTaiKhoanJPanel}
     *
     * @see QuanLyTaiKhoanJPanel
     */
    private void showQLTaiKhoan(int i) throws ToViewException {
        checkDangNhap();
        addTab("Tài khoản", tab_QuanLyTaiKhoanJPanel);
        tab_QuanLyTaiKhoanJPanel.setTab(i);
    }

    private void showQLPhong(int i) throws ToViewException {
        checkDangNhap();
        addTab("Phòng", tab_QuanLyPhongJPanel);
        tab_QuanLyPhongJPanel.setTab(i);
    }

    private void showThongKe(int i) throws ToViewException {
        checkDangNhap();
        addTab("Thống kê", tab_ThongKeJPanel);
        tab_ThongKeJPanel.setTab(i);
    }

    private void showMuonPhong() throws ToViewException {
        checkDangNhap();
        addTab("Mượn phòng", tab_NMXemPhongJPanel);
    }

    private void showDangXuat() {
        Session.logoff();
        File file = new File("asset/save.dat");
        file.delete();
        showDangNhap();
    }

    private void showDangNhap() {
        resetTabs();
        new DangNhapJDialog(this, true).setVisible(true);
        if (Session.isLogin()) {
            setGiaoDien(Session.USER.isPhanQuyen());
        } else {
            this.dispose();
        }
    }

    private void showDoiMatKhau() throws ToViewException {
        checkDangNhap();
        DoiMatKhauJDialog dmk = new DoiMatKhauJDialog(this, true);
        dmk.setTaiKhoan(Session.USER.getIdTaiKhoan());
        dmk.setVisible(true);

    }

    private void checkDangNhap() throws ToViewException {
        if (!Session.isLogin()) {
            resetTabs();
            throw new ToViewException("Vui lòng đăng nhập để sử dụng phần mềm!");
        }
        setGiaoDien(Session.USER.isPhanQuyen());
    }

    private void resetTabs() {
        tabContent.removeAll();
        addTab("Trang chủ", tab_TrangChuJPanel);
    }

    private void toHome() {
        addTab("Trang chủ", tab_TrangChuJPanel);
    }

    private void closeTab() {
        if (tabContent.getTabCount() == 0) {
            return;
        }
        tabContent.removeTabAt(tabContent.getSelectedIndex());
    }

    private void loadingDongHo() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        lblNow.setText(CalendarManager.getString(CalendarManager.getNow(), CalendarManager.DATE_HOUR_FULL_FORMAT));
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException ex) {
                    System.out.println(ex);
                }
            }
        });
        t.start();
    }

}
