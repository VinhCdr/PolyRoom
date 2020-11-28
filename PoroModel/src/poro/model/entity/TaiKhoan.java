package poro.model.entity;

/**
 *
 * @author vinh
 */
public class TaiKhoan extends Dao{
    private String idTaiKhoan;
    private String email;
    private String matKhau;
    private boolean phanQuyen;
    private String ten;
    private String sdt;
    
    public TaiKhoan(){
        
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
    protected String getSqlSelect() {
        return "SELECT id_tai_khoan, email, mat_khau, is_phan_quyen, ten, sdt FROM tai_khoan";
    }

    @Override
    protected TaiKhoan setData(Object[] data) {
        this.idTaiKhoan = (String) data[0];
        this.email = (String) data[1];
        this.matKhau = (String) data[2];
        this.phanQuyen = (boolean) data[3];
        this.ten = (String) data[4];
        this.sdt = (String) data[5];
        return this;
    }

    @Override
    protected int getRowCout() {
        return 6;
    }
    
}
