package poro.gui;

import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import poro.module.CalendarManager;

/**
 *
 * @author vinh
 */
public class ChonNgayGioJDialog extends javax.swing.JDialog {

    public ChonNgayGioJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        setView(VIEW_DATE_HOUR);
        try {
            loadCbo();
        } catch (Exception e) {
            System.out.println(e);
        }
        resetForm();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlNgay = new javax.swing.JPanel();
        cboNgay = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cboThang = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cboNam = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        pnlGio = new javax.swing.JPanel();
        cboGio = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cboPhut = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cboGiay = new javax.swing.JComboBox<>();
        btnXacNhan = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Chọn ngày giờ");
        setResizable(false);

        pnlNgay.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "Chọn ngày"));

        cboNgay.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        cboNgay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1" }));

        jLabel3.setText("Ngày");

        cboThang.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        cboThang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1" }));
        cboThang.setToolTipText("");
        cboThang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboThangItemStateChanged(evt);
            }
        });

        jLabel2.setText("Tháng");

        cboNam.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        cboNam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1" }));
        cboNam.setToolTipText("");
        cboNam.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboNamItemStateChanged(evt);
            }
        });

        jLabel1.setText("Năm");

        javax.swing.GroupLayout pnlNgayLayout = new javax.swing.GroupLayout(pnlNgay);
        pnlNgay.setLayout(pnlNgayLayout);
        pnlNgayLayout.setHorizontalGroup(
            pnlNgayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNgayLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlNgayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(cboNam, 0, 1, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnlNgayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(cboThang, 0, 1, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnlNgayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(cboNgay, 0, 1, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlNgayLayout.setVerticalGroup(
            pnlNgayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNgayLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlNgayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlNgayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlGio.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)), "Chọn giờ"));

        cboGio.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        cboGio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1" }));

        jLabel4.setText("Giờ");

        jLabel5.setText("Phút");

        cboPhut.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        cboPhut.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1" }));

        jLabel6.setText("Giây");

        cboGiay.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        cboGiay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1" }));

        javax.swing.GroupLayout pnlGioLayout = new javax.swing.GroupLayout(pnlGio);
        pnlGio.setLayout(pnlGioLayout);
        pnlGioLayout.setHorizontalGroup(
            pnlGioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(cboGio, 0, 1, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnlGioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(cboPhut, 0, 1, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnlGioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(cboGiay, 0, 1, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlGioLayout.setVerticalGroup(
            pnlGioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlGioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboGio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboPhut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboGiay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnXacNhan.setText("Xác nhận");
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });

        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 69, Short.MAX_VALUE)
                        .addComponent(btnXacNhan)
                        .addGap(18, 18, 18)
                        .addComponent(btnHuy)
                        .addGap(0, 69, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pnlGio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlNgay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnHuy, btnXacNhan});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlGio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXacNhan)
                    .addComponent(btnHuy))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cboNamItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboNamItemStateChanged
        try {
            if (!this.isVisible()) {
                return;
            }
            reloadCboNgay();
        } catch (ToViewException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_cboNamItemStateChanged

    private void cboThangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboThangItemStateChanged
        try {
            if (!this.isVisible()) {
                return;
            }
            reloadCboNgay();
        } catch (ToViewException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_cboThangItemStateChanged

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed
        try {
            loadResult();
            this.dispose();
        } catch (ToViewException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnXacNhanActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        result = "";
        this.dispose();
    }//GEN-LAST:event_btnHuyActionPerformed

    @Override
    public void pack() {
        super.pack();
        this.setSize(320, this.getHeight());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnXacNhan;
    private javax.swing.JComboBox<String> cboGiay;
    private javax.swing.JComboBox<String> cboGio;
    private javax.swing.JComboBox<String> cboNam;
    private javax.swing.JComboBox<String> cboNgay;
    private javax.swing.JComboBox<String> cboPhut;
    private javax.swing.JComboBox<String> cboThang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel pnlGio;
    private javax.swing.JPanel pnlNgay;
    // End of variables declaration//GEN-END:variables

    private Date dateOrigin = new Date();

    public static final int VIEW_DATE_HOUR = 0;
    public static final int VIEW_DATE = 1;
    public static final int VIEW_HOUR = 2;

    public void setView(int viewCode) {
        switch (viewCode) {
            case VIEW_DATE:
                pnlNgay.setVisible(true);
                pnlGio.setVisible(false);
                break;
            case VIEW_HOUR:
                pnlGio.setVisible(true);
                pnlNgay.setVisible(false);
                break;
            case VIEW_DATE_HOUR:
                pnlNgay.setVisible(true);
                pnlGio.setVisible(true);
                break;
            default:
                throw new RuntimeException("Không hổ trợ view có mã là: " + viewCode);
        }
        this.pack();
    }

    public void setDateOrigin(Date date) {
        this.dateOrigin = date;
        resetForm();
    }

    private void loadCbo() throws ToViewException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOrigin);

        setCbo(cboNam, calendar.get(Calendar.YEAR) - 50, calendar.get(Calendar.YEAR) + 50);
        setCbo(cboThang, 1, 12);
        setCbo(cboNgay, 1, getDayOfMonth());
        setCbo(cboGio, 0, 23);
        setCbo(cboPhut, 0, 59);
        setCbo(cboGiay, 0, 59);
    }

    public void resetForm() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOrigin);
        cboNam.setSelectedItem(calendar.get(Calendar.YEAR));
        cboThang.setSelectedItem(calendar.get(Calendar.MONTH) + 1);
        cboNgay.setSelectedItem(calendar.get(Calendar.DAY_OF_MONTH));
        cboGio.setSelectedItem(calendar.get(Calendar.HOUR_OF_DAY));
        cboPhut.setSelectedItem(calendar.get(Calendar.MINUTE));
        cboGiay.setSelectedIndex(0);
    }

    private void reloadCboNgay() throws ToViewException {
        int valueNgay = cboNgay.getSelectedIndex();
        setCbo(cboNgay, 1, getDayOfMonth());
        if (valueNgay < 0) {
            return;
        }
        if (valueNgay >= cboNgay.getItemCount()) {
            valueNgay = cboNgay.getItemCount() - 1;
        }
        cboNgay.setSelectedIndex(valueNgay);
    }

    private int getDayOfMonth() throws ToViewException {
        int nam = getCbo(cboNam);
        int thang = getCbo(cboThang);
        return CalendarManager.getDaysOf(nam, thang);
    }

    private void setCbo(JComboBox cboOrigin, int min, int max) {
        DefaultComboBoxModel dcm = (DefaultComboBoxModel) cboOrigin.getModel();
        dcm.removeAllElements();
        for (int i = min; i <= max; i++) {
            dcm.addElement(i);
        }
    }

    private int getCbo(JComboBox cboOrigin) throws ToViewException {
        String text = String.valueOf(cboOrigin.getSelectedItem());
        int value = 0;
        try {
            value = Integer.valueOf(text);
        } catch (NumberFormatException ex) {
            System.out.println(ex + "\n" + cboOrigin.getToolTipText());
            throw new ToViewException(text + "Không phải số nguyên");
        }

        return value;
    }

    private String result = "";

    private void loadResult() throws ToViewException {
        String date = String.format("%d/%2d/%2d",
                getCbo(cboNgay),
                getCbo(cboThang),
                getCbo(cboNam));
        String time = String.format("%2d:%2d:%2d",
                getCbo(cboGio),
                getCbo(cboPhut),
                getCbo(cboGiay));
        result = "";
        if (pnlNgay.isVisible()) {
            result += date;
        }
        if (pnlGio.isVisible()) {
            result += "x" + time;
        }
        this.result = result.replaceAll(" ", "0").replaceAll("x", " ");
    }

    public String getResult() {
        return result;
    }
}
