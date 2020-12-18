package poro.module.db.data;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import poro.module.CalendarManager;
import poro.module.db.DbExecuteQuery;

/**
 * 
 * @author vinh
 */
public class MuonPhong implements DbExecuteQuery{

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
    public static final int EXECUTE_SELECT_BY_ID = 1;
    public static final int EXECUTE_INSERT = 2;
    public static final int EXECUTE_UPDATE_BY_ID = 3;
    public static final int EXECUTE_DELETE_BY_ID = 4;
    
    @Override
    public MuonPhong coverResultSet(ResultSet rs, int type) throws SQLException {
        MuonPhong mp = new MuonPhong();
        mp.setIdMuonPhong(rs.getInt(""));
        return mp;
    }

    @Override
    public String getExecuteSQL(int type) {
        switch (type) {
            case EXECUTE_SELECT_ALL:
                
            default:
                throw new RuntimeException("Không thể lấy câu SQL bằng kiểu có mã là: " + type);
        }
    }

    @Override
    public Object[] getExecuteData(int type) {
        switch (type) {
            case EXECUTE_SELECT_ALL:
                
            default:
                throw new RuntimeException("Không thể lấy dữ liệu cho câu SQL bằng kiểu có mã là: " + type);
        }
    }

}