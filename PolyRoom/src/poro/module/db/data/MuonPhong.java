package poro.module.db.data;


import java.util.*;

/**
 * 
 * @author vinh
 */
public class MuonPhong{

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

}