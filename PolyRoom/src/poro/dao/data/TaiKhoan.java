package poro.dao.data;

import java.io.Serializable;
import poro.dao.DbDelete;
import poro.dao.DbUpdate;
import poro.dao.DbSelect;
import poro.dao.DbInsert;

/**
 *
 * @author vinh
 */
public class TaiKhoan implements DbSelect, DbInsert, DbUpdate, DbDelete, Serializable {

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

    public TaiKhoan(Object[] data) {
        this.idTaiKhoan = (String) data[0];
        this.email = (String) data[1];
        this.matKhau = (String) data[2];
        this.phanQuyen = (boolean) data[3];
        this.ten = (String) data[4];
        this.sdt = (String) data[5];
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

    @Override
    public TaiKhoan coverData(Object[] data) {
        return new TaiKhoan(data);
    }

    @Override
    public Object[] getInfo() {
        return new Object[]{this.idTaiKhoan, this.email, this.matKhau, this.phanQuyen, this.ten, this.sdt};
    }

    final public static int SELECT_ALL = 0;
    final public static int SELECT_USER_OR_EMAIL_AND_PASS = 1;

    @Override
    public String getSqlSelect(int type) {
        switch (type) {
            case SELECT_USER_OR_EMAIL_AND_PASS:
                return "SELECT id_tai_khoan, email, mat_khau, is_phan_quyen, ten, sdt FROM tai_khoan WHERE (id_tai_khoan LIKE ? OR email LIKE ?) AND mat_khau LIKE ?";
            case SELECT_ALL:
            default:
                return "SELECT id_tai_khoan, email, mat_khau, is_phan_quyen, ten, sdt FROM tai_khoan";
        }
    }

    @Override
    public Object[] getInfoSelect(int type) {
        switch (type) {
            case SELECT_USER_OR_EMAIL_AND_PASS:
                return new Object[]{this.idTaiKhoan, this.email, this.matKhau};
            case SELECT_ALL:
            default:
                return new Object[0];
        }
    }

    @Override
    public String getSqlInsert(int type) {
        return "INSERT INTO tai_khoan(id_tai_khoan, email, mat_khau, is_phan_quyen, ten, sdt) VALUES (?, ?, ?, ?, ?, ?);";
    }

    @Override
    public Object[] getInfoInsert(int type) {
        return new Object[]{this.idTaiKhoan, this.email, this.matKhau, this.phanQuyen, this.ten, this.sdt};
    }

    @Override
    public String getSqlUpdate(int type) {
        return "UPDATE tai_khoan SET id_tai_khoan = ?, email = ?, mat_khau = ?, is_phan_quyen = ?, ten = ?, sdt = ? WHERE (id_tai_khoan LIKE ? OR email LIKE ?) AND mat_khau LIKE ?;";
    }

    @Override
    public Object[] getInfoUpdate(int type) {
        return new Object[]{this.idTaiKhoan, this.email, this.matKhau, this.phanQuyen, this.ten, this.sdt, this.idTaiKhoan, this.email, this.matKhau};
    }

    @Override
    public String getSqlDelete(int type) {
        return "DELETE FROM tai_khoan WHERE id_tai_khoan LIKE ? OR email LIKE ?";
    }

    @Override
    public Object[] getInfoDelete(int type) {
        return new Object[]{this.idTaiKhoan, this.email};
    }
    
}