package poro.module.db.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
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
    private Date tgBatDauF, tgKetThucF;
    private String idTaiKhoanMuon;

    public void setIdTaiKhoanMuon(String idTaiKhoanMuon) {
        this.idTaiKhoanMuon = idTaiKhoanMuon;
    }

    public void setTgBatDauF(Date tgBatDauF) {
        this.tgBatDauF = tgBatDauF;
    }

    public void setTgKetThucF(Date tgKetThucF) {
        this.tgKetThucF = tgKetThucF;
    }

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
    public static final int EXECUTE_SELECT_TIM_PHONG = 2;
    public static final int EXECUTE_SELECT_KIEM_TRA_PHONG = 3;
    public static final int EXECUTE_SELECT_BY_ID_TAI_KHOAN = 4;

    @SuppressWarnings("unchecked")
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

            case EXECUTE_SELECT_TIM_PHONG:
                return "SELECT [id_phong], [so_tang], [ten_phong], [is_cho_muon], [luot_dat], [is_trong], [id_muon_phong], [id_tai_khoan], [ly_do], [tg_muon], [tg_tra], [tg_tra_thuc_te], [email], [mat_khau], [is_phan_quyen], [ten], [sdt], [id_sinh_vien], [ten_sinh_vien], [email_sv] "
                        + "FROM view_thong_tin_muon_phong "
                        + "WHERE NOT [ten_phong] = ANY ( "
                        + "    SELECT ten_phong "
                        + "    FROM phong INNER JOIN muon_phong ON phong.so_tang = muon_phong.so_tang AND phong.id_phong = muon_phong.id_phong "
                        + "    WHERE (? BETWEEN [tg_muon] AND [tg_tra] OR ? BETWEEN [tg_muon] AND [tg_tra] OR tg_muon BETWEEN ? AND ?) AND ([tg_tra_thuc_te] IS NULL AND [id_muon_phong] IS NOT NULL)"
                        + "    GROUP BY ten_phong"
                        + ") AND [is_cho_muon] = 1;";

            case EXECUTE_SELECT_KIEM_TRA_PHONG:
                return "SELECT [id_phong], [so_tang], [ten_phong], [is_cho_muon], [luot_dat], [is_trong], [id_muon_phong], [id_tai_khoan], [ly_do], [tg_muon], [tg_tra], [tg_tra_thuc_te], [email], [mat_khau], [is_phan_quyen], [ten], [sdt], [id_sinh_vien], [ten_sinh_vien], [email_sv] "
                        + "FROM view_thong_tin_muon_phong "
                        + "WHERE NOT [ten_phong] = ANY ( "
                        + "    SELECT ten_phong "
                        + "    FROM phong INNER JOIN muon_phong ON phong.so_tang = muon_phong.so_tang AND phong.id_phong = muon_phong.id_phong "
                        + "    WHERE (? BETWEEN [tg_muon] AND [tg_tra] OR ? BETWEEN [tg_muon] AND [tg_tra] OR tg_muon BETWEEN ? AND ?) AND ([tg_tra_thuc_te] IS NULL AND [id_muon_phong] IS NOT NULL) "
                        + "    GROUP BY ten_phong"
                        + ") AND so_tang = ? AND id_phong = ?;";

            case EXECUTE_SELECT_BY_ID_TAI_KHOAN:
                return "SELECT [id_phong], [so_tang], [ten_phong], [is_cho_muon], [luot_dat], [is_trong], [id_muon_phong], [id_tai_khoan], [ly_do], [tg_muon], [tg_tra], [tg_tra_thuc_te], [email], [mat_khau], [is_phan_quyen], [ten], [sdt], [id_sinh_vien], [ten_sinh_vien], [email_sv] "
                        + "FROM view_thong_tin_muon_phong "
                        + "WHERE [tg_tra_thuc_te] IS NULL AND [id_tai_khoan] LIKE ?";

            default:
                throw new RuntimeException("Không thể lấy câu SQL bằng kiểu có mã là: " + type);
        }
    }

    @Override
    public Object[] getExecuteData(int type) {
        switch (type) {
            case EXECUTE_SELECT_BY_ID_PHONG:
                return new Object[]{this.soTang, this.idPhong};
            case EXECUTE_SELECT_TIM_PHONG:
                return new Object[]{this.tgBatDauF, this.tgKetThucF, this.tgBatDauF, this.tgKetThucF};
            case EXECUTE_SELECT_KIEM_TRA_PHONG:
                return new Object[]{this.tgBatDauF, this.tgKetThucF, this.tgBatDauF, this.tgKetThucF, this.soTang, this.idPhong};
            case EXECUTE_SELECT_BY_ID_TAI_KHOAN:
                return new Object[]{this.idTaiKhoanMuon};
            default:
                throw new RuntimeException("Không thể lấy dữ liệu cho câu SQL bằng kiểu có mã là: " + type);
        }
    }

}
