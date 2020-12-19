package poro.module.db.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import poro.module.db.DatabaseManager;
import poro.module.db.DbExecuteQuery;

/**
 *
 * @author vinh
 */
public class ThongTinMuonPhong implements DbExecuteQuery {

    private MuonPhong muonPhong;
    private TaiKhoan taiKhoan;
    private Phong phong;
    private SinhVien sinhVien;

    public ThongTinMuonPhong() {
        muonPhong = new MuonPhong();
        taiKhoan = new TaiKhoan();
        phong = new Phong();
        sinhVien = new SinhVien();
    }

    private int soTang, idPhong;

    public void setSoTang(int soTang) {
        this.soTang = soTang;
    }

    public void setIdPhong(int idPhong) {
        this.idPhong = idPhong;
    }

    public MuonPhong getMuonPhong() {
        return muonPhong;
    }

    public TaiKhoan getTaiKhoan() {
        return taiKhoan;
    }

    public Phong getPhong() {
        return phong;
    }

    public SinhVien getSinhVien() {
        return sinhVien;
    }

    public static final int EXECUTE_SELECT_BY_ID_PHONG = 1;

    @Override
    public ThongTinMuonPhong coverResultSet(ResultSet resultSet, int type) throws SQLException {
        ThongTinMuonPhong model = new ThongTinMuonPhong();
        model.taiKhoan = model.taiKhoan.coverResultSet(resultSet, TaiKhoan.EXECUTE_SELECT_ALL);
        model.phong = model.phong.coverResultSet(resultSet, Phong.EXECUTE_SELECT_ALL);
        model.muonPhong = model.muonPhong.coverResultSet(resultSet, MuonPhong.EXECUTE_SELECT_ALL);
        model.sinhVien = model.sinhVien.coverResultSet(resultSet, SinhVien.EXECUTE_SELECT_ALL);

        if (model.muonPhong.getIdTaiKhoan() == null) {
            model.muonPhong = null;
        }
        if (model.phong.getTenPhong() == null) {
            model.phong = null;
        }
        if (model.sinhVien.getIdSV() == null) {
            model.sinhVien = null;
        }
        if (model.taiKhoan.getIdTaiKhoan() == null) {
            model.taiKhoan = null;
        }
        return model;
    }

    @Override
    public String getExecuteSQL(int type) {
        switch (type) {
            case EXECUTE_SELECT_BY_ID_PHONG:
                return "SELECT [id_phong], [so_tang], [ten_phong], [is_cho_muon], [luot_dat], [is_trong], [id_muon_phong], [id_tai_khoan], [ly_do], [tg_muon], [tg_tra], [tg_tra_thuc_te], [email], [mat_khau], [is_phan_quyen], [ten], [sdt], [id_sinh_vien], [ten_sinh_vien], [email_sv] "
                        + "FROM view_thong_tin_muon_phong "
                        + "WHERE so_tang = ? AND id_phong = ?";
            // AND [tg_tra_thuc_te] IS NULL;
            default:
                throw new RuntimeException("Không thể lấy câu SQL bằng kiểu có mã là: " + type);
        }
    }

    @Override
    public Object[] getExecuteData(int type) {
        switch (type) {
            case EXECUTE_SELECT_BY_ID_PHONG:
                return new Object[]{this.soTang, this.idPhong};
            default:
                throw new RuntimeException("Không thể lấy dữ liệu cho câu SQL bằng kiểu có mã là: " + type);
        }
    }    

    public static void main(String[] args) {
        ThongTinMuonPhong ttmp = new ThongTinMuonPhong();
        ttmp.setSoTang(0);
        ttmp.setIdPhong(2);
        List<ThongTinMuonPhong> ttmpList = DatabaseManager.executeQuery(ttmp, EXECUTE_SELECT_BY_ID_PHONG);
        ttmpList.forEach(tt -> {
            System.out.println(tt.getSinhVien());
        });
    }

}
