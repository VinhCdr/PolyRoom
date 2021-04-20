package poro.module.db.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import poro.module.db.DbExecuteQuery;

/**
 *
 * @author vinh
 */
public class MuonPhong implements DbExecuteQuery {

    public MuonPhong() {
    }

    public MuonPhong(int idMuonPhong, String idTaiKhoan, int soTang, int idPhong, Date tgMuon, Date tgTra, Date tgTraThucTe, String lyDo) {
        this.idMuonPhong = idMuonPhong;
        this.idTaiKhoan = idTaiKhoan;
        this.soTang = soTang;
        this.idPhong = idPhong;
        this.tgMuon = tgMuon;
        this.tgTra = tgTra;
        this.tgTraThucTe = tgTraThucTe;
        this.lyDo = lyDo;
    }

    private int idMuonPhong;
    private String idTaiKhoan;
    private int soTang;
    private int idPhong;
    private Date tgMuon;
    private Date tgTra;
    private Date tgTraThucTe;
    private String lyDo;

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    public int getIdMuonPhong() {
        return idMuonPhong;
    }

    public void setIdMuonPhong(int idMuonPhong) {
        this.idMuonPhong = idMuonPhong;
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

    public int getIdPhong() {
        return idPhong;
    }

    public void setIdPhong(int idPhong) {
        this.idPhong = idPhong;
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

    public Date getTgTraThucTe() {
        return tgTraThucTe;
    }

    public void setTgTraThucTe(Date tgTraThucTe) {
        this.tgTraThucTe = tgTraThucTe;
    }

    public static final int EXECUTE_SELECT_ALL = 0;
    public static final int EXECUTE_SELECT_BY_ID_PHONG = 1;
    public static final int EXECUTE_INSERT = 2;
    public static final int EXECUTE_UPDATE_BY_ID = 3;
    public static final int EXECUTE_SELECT_LAST_INSERT = 4;
    public static final int EXECUTE_SELECT_BY_ID = 5;

    @SuppressWarnings("unchecked")
	@Override
    public MuonPhong coverResultSet(ResultSet rs, int type) throws SQLException {
        MuonPhong mp = new MuonPhong();
        mp.setIdMuonPhong(rs.getInt("id_muon_phong"));
        mp.setIdTaiKhoan(rs.getString("id_tai_khoan"));
        mp.setSoTang(rs.getInt("so_tang"));
        mp.setIdPhong(rs.getInt("id_phong"));
        mp.setTgMuon(rs.getTimestamp("tg_muon"));
        mp.setTgTra(rs.getTimestamp("tg_tra"));
        mp.setTgTraThucTe(rs.getTimestamp("tg_tra_thuc_te"));
        mp.setLyDo(rs.getString("ly_do"));
        return mp;
    }

    @Override
    public String getExecuteSQL(int type) {
        switch (type) {
            case EXECUTE_SELECT_ALL:
                return "SELECT "
                        + "[id_muon_phong], [id_tai_khoan], [so_tang], [id_phong], [tg_muon], [tg_tra], [tg_tra_thuc_te], [ly_do] "
                        + "FROM [muon_phong] "
                        + "WHERE [tg_tra_thuc_te] IS NULL;";
            case EXECUTE_SELECT_BY_ID_PHONG:
                return "SELECT "
                        + "[id_muon_phong], [id_tai_khoan], [so_tang], [id_phong], [tg_muon], [tg_tra], [tg_tra_thuc_te], [ly_do]"
                        + "FROM [muon_phong] "
                        + "WHERE [so_tang] = ? AND [id_phong] = ? AND  [tg_tra_thuc_te] IS NULL;";
            case EXECUTE_INSERT:
                return "INSERT INTO [muon_phong]([id_tai_khoan], [so_tang], [id_phong], [tg_muon], [tg_tra], [tg_tra_thuc_te], [ly_do]) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?);";
            case EXECUTE_UPDATE_BY_ID:
                return "UPDATE [muon_phong] SET "
                        + "[id_tai_khoan] = ?, "
                        + "[so_tang] = ?, "
                        + "[id_phong] = ?, "
                        + "[tg_muon] = ?, "
                        + "[tg_tra] = ?, "
                        + "[tg_tra_thuc_te] = ?, "
                        + "[ly_do] = ? "
                        + "WHERE [id_muon_phong] = ?;";
            case EXECUTE_SELECT_LAST_INSERT:
                return "SELECT "
                        + "[id_muon_phong], [id_tai_khoan], [so_tang], [id_phong], [tg_muon], [tg_tra], [tg_tra_thuc_te], [ly_do] "
                        + "FROM [muon_phong] "
                        + "WHERE [tg_tra_thuc_te] IS NULL "
                        + "ORDER BY [id_muon_phong] DESC;";
            case EXECUTE_SELECT_BY_ID:
                return "SELECT "
                        + "[id_muon_phong], [id_tai_khoan], [so_tang], [id_phong], [tg_muon], [tg_tra], [tg_tra_thuc_te], [ly_do] "
                        + "FROM [muon_phong] "
                        + "WHERE [tg_tra_thuc_te] IS NULL AND [id_muon_phong] = ?;";
            default:
                throw new RuntimeException("Không thể lấy câu SQL bằng kiểu có mã là: " + type);
        }
    }

    @Override
    public Object[] getExecuteData(int type) {
        switch (type) {
            case EXECUTE_SELECT_ALL:
                return new Object[0];
            case EXECUTE_SELECT_BY_ID_PHONG:
                return new Object[]{this.getSoTang(), this.getIdMuonPhong()};
            case EXECUTE_INSERT:
                return new Object[]{this.getIdTaiKhoan(), this.getSoTang(), this.getIdPhong(), this.getTgMuon(), this.getTgTra(), this.getTgTraThucTe(), this.getLyDo()};
            case EXECUTE_UPDATE_BY_ID:
                return new Object[]{this.getIdTaiKhoan(), this.getSoTang(), this.getIdPhong(), this.getTgMuon(), this.getTgTra(), this.getTgTraThucTe(), this.getLyDo(), this.getIdMuonPhong()};
            case EXECUTE_SELECT_LAST_INSERT:
                return new Object[0];
            case EXECUTE_SELECT_BY_ID:
                return new Object[]{this.getIdMuonPhong()};
            default:
                throw new RuntimeException("Không thể lấy dữ liệu cho câu SQL bằng kiểu có mã là: " + type);
        }
    }

}
