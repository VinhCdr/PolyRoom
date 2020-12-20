package poro.gui;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import poro.module.CalendarManager;
import poro.module.db.data.ThongTinMuonPhong;

/**
 *
 * @author Cô Ngọc, vinh
 */
public class ChiTietMuonJDialog extends javax.swing.JDialog {

    public ChiTietMuonJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cboLau = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtMaPhong = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTenPhong = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblList = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Chi tiết mượn phòng");

        jLabel1.setText("Tầng lầu");

        cboLau.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4" }));
        cboLau.setEnabled(false);

        jLabel2.setText("Mã phòng");

        txtMaPhong.setEditable(false);

        jLabel3.setText("Tên phòng");

        txtTenPhong.setEditable(false);

        tblList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã mượn", "Người mượn", "Chức vụ", "Lý do", "TG bắt đầu", "TG trả dự kiến"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 821, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboLau, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtTenPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 383, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboLau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListMouseClicked
        if (evt.getClickCount() != 2) {
            return;
        }
        this.dispose();
    }//GEN-LAST:event_tblListMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboLau;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblList;
    private javax.swing.JTextField txtMaPhong;
    private javax.swing.JTextField txtTenPhong;
    // End of variables declaration//GEN-END:variables

    public void loading(ArrayList<ThongTinMuonPhong> ttmps) {
        if (ttmps == null || ttmps.isEmpty()) {
            resetForm();
            return;
        }
        cboLau.getModel().setSelectedItem(ttmps.get(0).getPhong().getIdSoTang());
        txtMaPhong.setText(ttmps.get(0).getPhong().getIdPhong() + "");
        txtTenPhong.setText(ttmps.get(0).getPhong().getTenPhong());
        DefaultTableModel dtm = (DefaultTableModel) tblList.getModel();
        dtm.setRowCount(0);
        ttmps.forEach(tt -> {
            if (tt.getPhong().getLuotDat() >= 0 && tt.getMuonPhong() != null && tt.getMuonPhong().getTgTraThucTe() == null) {
                dtm.addRow(new Object[]{
                    tt.getMuonPhong().getIdMuonPhong(),
                    tt.getSinhVien() == null
                    ? tt.getTaiKhoan().getTen() + " (" + tt.getTaiKhoan().getIdTaiKhoan() + ")"
                    : tt.getSinhVien().getTenSV() + " (" + tt.getSinhVien().getIdSV() + ")",
                    tt.getSinhVien() == null ? tt.getTaiKhoan().isPhanQuyen() ? "Quản lý" : "Giảng viên"
                    : "Sinh viên",
                    tt.getMuonPhong().getLyDo(),
                    CalendarManager.getString(tt.getMuonPhong().getTgMuon(), CalendarManager.DATE_HOUR_FULL_FORMAT),
                    CalendarManager.getString(tt.getMuonPhong().getTgTra(), CalendarManager.DATE_HOUR_FULL_FORMAT)});
            }
        });
    }

    public void resetForm() {
        DefaultTableModel dtm = (DefaultTableModel) tblList.getModel();
        dtm.setRowCount(0);
        cboLau.getModel().setSelectedItem(0);
        txtMaPhong.setText("");
        txtTenPhong.setText("");
    }
    
    public int getRowSeleted() {
        return tblList.getSelectedRow();
    }
}
