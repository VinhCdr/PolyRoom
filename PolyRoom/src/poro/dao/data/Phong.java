package poro.dao.data;

import poro.dao.DbDelete;
import poro.dao.DbInsert;
import poro.dao.DbSelect;
import poro.dao.DbUpdate;

/**
 * 
 * @author vinh
 */
public class Phong implements DbSelect, DbInsert, DbUpdate, DbDelete{

    private int soTang;
    private int idPhong;
    private String tenPhong;
    private boolean choMuon;

    public Phong() {
        
    }
    
    private Phong(Object[] data) {
        this.soTang = (int) data[0];
        this.idPhong = (int) data[1];
        this.tenPhong = (String) data[2];
        this.choMuon = (boolean) data[3];
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

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public boolean isChoMuon() {
        return choMuon;
    }

    public void setChoMuon(boolean choMuon) {
        this.choMuon = choMuon;
    }

    @Override
    public Phong coverData(Object[] data) {
        return new Phong(data);
    }

    @Override
    public Object[] getInfo() {
        return new Object[] {this.soTang, this.idPhong, this.tenPhong, this.choMuon};
    }

    @Override
    public String getSqlSelect(int type) {
        return "SELECT so_tang, id_phong, ten_phong, is_cho_muon FROM phong";
    }

    @Override
    public Object[] getInfoSelect(int type) {
        return new Object[0];
//        return new Object[] {this.soTang, this.idPhong, this.tenPhong, this.choMuon};
    }

    @Override
    public String getSqlInsert(int type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] getInfoInsert(int type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSqlUpdate(int type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] getInfoUpdate(int type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSqlDelete(int type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] getInfoDelete(int type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}