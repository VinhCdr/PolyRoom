package poro.module.db.data;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import poro.module.db.DbExecuteQuery;

/**
 *
 * @author vinh
 */
public class TaiKhoan implements DbExecuteQuery, Serializable {

    private String idTaiKhoan;
    private String email;
    private String matKhau;
    private boolean phanQuyen;
    private String ten;
    private String sdt;

    public TaiKhoan() {

    }

    public TaiKhoan(String idTaiKhoan, String email, String matKhau, boolean phanQuyen, String ten, String sdt) {
        this.idTaiKhoan = idTaiKhoan;
        this.email = email;
        this.matKhau = matKhau;
        this.phanQuyen = phanQuyen;
        this.ten = ten;
        this.sdt = sdt;
    }

    public String getIdTaiKhoan() {
        return idTaiKhoan;
    }

    public void setIdTaiKhoan(String idTaiKhoan) {
        this.idTaiKhoan = idTaiKhoan;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    
    /**
     * @return true là quản lý, false là người mượn
     */
    public boolean isPhanQuyen() {
        return phanQuyen;
    }

    public void setPhanQuyen(boolean phanQuyen) {
        this.phanQuyen = phanQuyen;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public static final int EXECUTE_SELECT_ALL = 0;
    public static final int EXECUTE_SELECT_BY_USER_OR_EMAIL_AND_PASS = 1;
    public static final int EXECUTE_INSERT = 2;
    public static final int EXECUTE_UPDATE_BY_ID_OR_MAIL = 3;
    public static final int EXECUTE_DELETE_BY_ID_OR_MAIL = 4;
    public static final int EXECUTE_SELECT_BY_MAIL = 5;
    public static final int EXECUTE_SELECT_BY_ID = 6;

    @Override
    public TaiKhoan coverResultSet(ResultSet resultSet, int type) throws SQLException {
        TaiKhoan tk = new TaiKhoan();
        tk.setIdTaiKhoan(resultSet.getString("id_tai_khoan"));
        tk.setEmail(resultSet.getString("email"));
        tk.setMatKhau(resultSet.getString("mat_khau"));
        tk.setPhanQuyen(resultSet.getBoolean("is_phan_quyen"));
        tk.setTen(resultSet.getString("ten"));
        tk.setSdt(resultSet.getString("sdt"));
        return tk;
    }

    @Override
    public String getExecuteSQL(int type) {
        switch (type) {
            case EXECUTE_SELECT_BY_USER_OR_EMAIL_AND_PASS:
                return "SELECT id_tai_khoan, email, mat_khau, is_phan_quyen, ten, sdt FROM tai_khoan WHERE (id_tai_khoan LIKE ? OR email LIKE ?) AND mat_khau LIKE ?";
            case EXECUTE_SELECT_ALL:
                return "SELECT id_tai_khoan, email, mat_khau, is_phan_quyen, ten, sdt FROM tai_khoan";
            case EXECUTE_SELECT_BY_MAIL:
                return "SELECT id_tai_khoan, email, mat_khau, is_phan_quyen, ten, sdt FROM tai_khoan WHERE email LIKE ?";
            case EXECUTE_INSERT:
                return "INSERT INTO tai_khoan(id_tai_khoan, email, mat_khau, is_phan_quyen, ten, sdt) VALUES (?, ?, ?, ?, ?, ?);";
            case EXECUTE_UPDATE_BY_ID_OR_MAIL:
                return "UPDATE tai_khoan SET id_tai_khoan = ?, email = ?, mat_khau = ?, is_phan_quyen = ?, ten = ?, sdt = ? WHERE (id_tai_khoan LIKE ? OR email LIKE ?);";
            case EXECUTE_DELETE_BY_ID_OR_MAIL:
                return "DELETE FROM tai_khoan WHERE id_tai_khoan LIKE ? OR email LIKE ?";
            case EXECUTE_SELECT_BY_ID:
                return "SELECT id_tai_khoan, email, mat_khau, is_phan_quyen, ten, sdt FROM tai_khoan WHERE id_tai_khoan LIKE ?";
            default:
                throw new RuntimeException("Không thể lấy câu SQL bằng kiểu có mã là: " + type);
        }
    }

    @Override
    public Object[] getExecuteData(int type) {
        switch (type) {
            case EXECUTE_SELECT_BY_USER_OR_EMAIL_AND_PASS:
                return new Object[]{this.idTaiKhoan, this.email, this.matKhau};
            case EXECUTE_SELECT_ALL:
                return new Object[0];
            case EXECUTE_SELECT_BY_MAIL:
                return new Object[]{this.getEmail()};
            case EXECUTE_INSERT:
                return new Object[]{this.idTaiKhoan, this.email, this.matKhau, this.phanQuyen, this.ten, this.sdt};
            case EXECUTE_UPDATE_BY_ID_OR_MAIL:
                return new Object[]{this.idTaiKhoan, this.email, this.matKhau, this.phanQuyen, this.ten, this.sdt, this.idTaiKhoan, this.email};
            case EXECUTE_DELETE_BY_ID_OR_MAIL:
                return new Object[]{this.idTaiKhoan, this.email};
            case EXECUTE_SELECT_BY_ID:
                return new Object[]{this.idTaiKhoan};
            default:
                throw new RuntimeException("Không thể lấy dữ liệu cho câu SQL bằng kiểu có mã là: " + type);
        }
    }

}
