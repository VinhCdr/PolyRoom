package poro.model.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import poro.model.helper.JDBC;

/**
 *
 * @author vinh
 */
abstract public class Dao {

    /**
     * Select dữ liệu của đối tượng trong database
     * @param <T> kiểu dữ liệu sẽ trả về
     * @param typeSelect Kiểu select (Quy định riêng theo từng đối tượng)
     * @return Một ArrayList trả về danh sách cách đối tượng select được
     */
    public <T extends Dao> ArrayList<T> select(int typeSelect) {
        this.typeSelect =  typeSelect;
        int columnCount = this.getData().length;
        Object[] row = new Object[columnCount];
        ArrayList<T> result = new ArrayList<>();
        try {
            ResultSet rs = JDBC.executeQuery(getSqlSelect(), getDataSelect());

            while (rs.next()) {
                for (int i = 0; i < columnCount; i++) {
                    row[i] = rs.getObject(i + 1);
                }
                result.add(this.<T>setData(row));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return result;
    }
    
    
    public <T extends Dao> ArrayList<T> select(){
        return select(0);
    }

    /**
     * Kiểu select khi gọi 
     */
    protected int typeSelect = 0;
    
    /**
     * Hàm trả về câu lệnh select trong sql dựa vào dữ liệu đã có sẵn trong đối
     * tượng
     *
     * @author: vinh
     * @return một câu lệnh sql select phù hợp
     */
    abstract protected String getSqlSelect();

    abstract protected Object[] getDataSelect();
    
    /**
     * Hàm chuyển các thuộc tính trong đối tượng thành một mãng Object
     *
     * @author: vinh
     */
    abstract protected Object[] getData();

    /**
     * Hàm chuyển mãng object thành đối tượng
     *
     * @author: vinh
     * @param <T> Là kiểu dữ liệu sẽ trả về
     */
    abstract protected <T extends Dao> T setData(Object[] data);
}
