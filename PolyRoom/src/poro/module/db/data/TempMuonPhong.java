package poro.module.db.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import poro.module.db.DbExecuteQuery;

/**
 * @author Ngọc, vinh
 */
public class TempMuonPhong implements DbExecuteQuery {

    private int idTemp;
    private int idPhong;
    private String idTaiKhoan;
    private int soTang;
    private Date tgMuon;
    private Date tgTra;
    private String idSinhVien;
    private String emailSinhVien;
    private String tenSinhVien;
    private String lyDo;
    private String otp;
    private Date thoiGianDangKy;

    public int getIdTemp() {
        return idTemp;
    }

    public void setIdTemp(int idTemp) {
        this.idTemp = idTemp;
    }

    public int getIdPhong() {
        return idPhong;
    }

    public void setIdPhong(int idPhong) {
        this.idPhong = idPhong;
    }

    public String getIdTaiKhoan() {
        return idTaiKhoan;
    }

    public void setIdTaiKhoan(String idTaiKhoan) {
        this.idTaiKhoan = idTaiKhoan;
    }

    public int getSoTang() {
        return soTang;
    }

    public void setSoTang(int soTang) {
        this.soTang = soTang;
    }

    public Date getTgMuon() {
        return tgMuon;
    }

    public void setTgMuon(Date tgMuon) {
        this.tgMuon = tgMuon;
    }

    public Date getTgTra() {
        return tgTra;
    }

    public void setTgTra(Date tgTra) {
        this.tgTra = tgTra;
    }

    public String getIdSinhVien() {
        return idSinhVien;
    }

    public void setIdSinhVien(String idSinhVien) {
        this.idSinhVien = idSinhVien;
    }

    public String getEmailSinhVien() {
        return emailSinhVien;
    }

    public void setEmailSinhVien(String emailSinhVien) {
        this.emailSinhVien = emailSinhVien;
    }

    public String getTenSinhVien() {
        return tenSinhVien;
    }

    public void setTenSinhVien(String tenSinhVien) {
        this.tenSinhVien = tenSinhVien;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public Date getThoiGianDangKy() {
        return thoiGianDangKy;
    }

    public void setThoiGianDangKy(Date thoiGianDangKy) {
        this.thoiGianDangKy = thoiGianDangKy;
    }

    public static final int EXECUTE_SELECT_ALL = 0;
    public static final int EXECUTE_SELECT_BY_ID = 1;
    public static final int EXECUTE_INSERT = 2;
    public static final int EXECUTE_CONFIRM_BY_ID_OTP = 3;
    public static final int EXECUTE_DELETE_BY_ID = 4;
    public static final int EXECUTE_SELECT_LAST_INSERT = 5;

    @Override
    public TempMuonPhong coverResultSet(ResultSet resultSet, int type) throws SQLException {
        TempMuonPhong tmp = new TempMuonPhong();
        tmp.setIdTemp(resultSet.getInt("id_temp"));
        tmp.setIdPhong(resultSet.getInt("id_phong"));
        tmp.setIdTaiKhoan(resultSet.getString("so_tang"));
        tmp.setTgMuon(resultSet.getTimestamp("tg_muon"));
        tmp.setTgTra(resultSet.getTimestamp("tg_tra"));
        tmp.setIdSinhVien(resultSet.getString("id_sinh_vien"));
        tmp.setEmailSinhVien(resultSet.getString("email_sinh_vien"));
        tmp.setTenSinhVien(resultSet.getString("ten_sinh_vien"));
        tmp.setLyDo(resultSet.getString("ly_do"));
        tmp.setIdTaiKhoan(resultSet.getString("id_tai_khoan"));
        tmp.setOtp(resultSet.getString("otp"));
        tmp.setThoiGianDangKy(resultSet.getTimestamp("tg_dang_ky"));
        return tmp;
    }

    @Override
    public String getExecuteSQL(int type) {
        switch (type) {
            case EXECUTE_SELECT_ALL:
                return "SELECT id_temp, id_phong, so_tang, tg_muon, tg_tra, id_sinh_vien, email_sinh_vien, ten_sinh_vien, ly_do, id_tai_khoan, otp, tg_dang_ky "
                        + "FROM temp_muon_phong_sv;";
            case EXECUTE_SELECT_BY_ID:
                return "SELECT id_temp, id_phong, so_tang, tg_muon, tg_tra, id_sinh_vien, email_sinh_vien, ten_sinh_vien, ly_do, id_tai_khoan, otp, tg_dang_ky "
                        + "FROM temp_muon_phong_sv "
                        + "WHERE id_temp =?;";
            case EXECUTE_INSERT:
                return "INSERT INTO [temp_muon_phong_sv] "
                        + "([so_tang], [id_phong], [tg_muon], [tg_tra], [id_sinh_vien], [email_sinh_vien], [ten_sinh_vien], [ly_do], [id_tai_khoan], [otp], [tg_dang_ky]) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ? , ?, ?, ?);";
            case EXECUTE_CONFIRM_BY_ID_OTP:
                return "{call sp_confirm_temp_sv(?, ?)}";
            case EXECUTE_DELETE_BY_ID:
                return " DELETE FROM [temp_muon_phong_sv] "
                        + "WHERE id_temp =?";
            case EXECUTE_SELECT_LAST_INSERT:
                return "SELECT id_temp, id_phong, so_tang, tg_muon, tg_tra, id_sinh_vien, email_sinh_vien, ten_sinh_vien, ly_do, id_tai_khoan, otp, tg_dang_ky "
                        + "FROM temp_muon_phong_sv "
                        + "ORDER BY id_temp DESC;";
            default:
                throw new RuntimeException("Không thể lấy câu SQL bằng kiểu có mã là: " + type);
        }
    }

    @Override
    public Object[] getExecuteData(int type) {
        switch (type) {
            case EXECUTE_SELECT_ALL:
                return new Object[0];
            case EXECUTE_SELECT_BY_ID:
                return new Object[]{this.idTemp};
            case EXECUTE_INSERT:
                return new Object[]{this.soTang, this.idPhong, this.tgMuon, this.tgTra, this.idSinhVien, this.emailSinhVien, this.tenSinhVien, this.lyDo, this.idTaiKhoan, this.otp, this.thoiGianDangKy};
            case EXECUTE_CONFIRM_BY_ID_OTP:
                return new Object[]{this.idTemp, this.otp};
            case EXECUTE_DELETE_BY_ID:
                return new Object[]{idTemp};
            case EXECUTE_SELECT_LAST_INSERT:
                return new Object[0];
            default:
                throw new RuntimeException("Không thể lấy dữ liệu cho câu SQL bằng kiểu có mã là: " + type);
        }
    }

}
