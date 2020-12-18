package poro.module.db.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import poro.module.db.DbExecuteQuery;

/**
 * @author vinh
 */
public class ThongTinSinhVien implements DbExecuteQuery {

    private String idSV;
    private String email;
    private String tenSV;
    private int idMuonPhong;

    public String getIdSV() {
        return idSV;
    }

    public void setIdSV(String idSV) {
        this.idSV = idSV;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public int getIdMuonPhong() {
        return idMuonPhong;
    }

    public void setIdMuonPhong(int idMuonPhong) {
        this.idMuonPhong = idMuonPhong;
    }

    public static final int EXECUTE_SELECT_ALL = 0;
    public static final int EXECUTE_SELECT_BY_ID = 1;
    public static final int EXECUTE_INSERT = 2;
    public static final int EXECUTE_UPDATE_BY_ID = 3;
    public static final int EXECUTE_DELETE_BY_ID = 4;

    @Override
    public ThongTinSinhVien coverResultSet(ResultSet rs, int type) throws SQLException {
        ThongTinSinhVien model = new ThongTinSinhVien();
        model.setIdSV(rs.getString("id_sinh_vien"));
        model.setEmail(rs.getString("email"));
        model.setTenSV(rs.getString("ten_sinh_vien"));
        model.setIdMuonPhong(rs.getInt("id_muon_phong"));
        return model;
    }

    @Override
    public String getExecuteSQL(int type) {
        switch (type) {
            case EXECUTE_SELECT_ALL:
                return "SELECT id_sinh_vien, email, ten_sinh_vien, id_muon_phong FROM [thong_tin_sinh_vien];";
            case EXECUTE_SELECT_BY_ID:
                return "SELECT id_sinh_vien, email, ten_sinh_vien, id_muon_phong FROM [thong_tin_sinh_vien] WHERE id_sinh_vien LIKE ?";
            case EXECUTE_INSERT:
                return "INSERT INTO [thong_tin_sinh_vien] ([id_sinh_vien],[email], [ten_sinh_vien], [id_muon_phong]) "
                        + "VALUES "
                        + "(?, ?, ?, ?)";
            case EXECUTE_UPDATE_BY_ID:
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
                return new Object[]{this.idSV};
            case EXECUTE_INSERT:
                return new Object[]{this.idSV, this.email, this.tenSV, this.idMuonPhong};
            case EXECUTE_UPDATE_BY_ID:
            default:
                throw new RuntimeException("Không thể lấy dữ liệu cho câu SQL bằng kiểu có mã là: " + type);
        }
    }

}
