package poro.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import poro.model.helper.JDBC;

/**
 *
 * @author vinh
 */
public class DatabaseManager {

    /**
     * Select dữ liệu của đối tượng trong database theo điều kiện cụ thể
     *
     * @param <T> kiểu dữ liệu sẽ trả về
     * @param typeSelect Kiểu select (Quy định riêng theo từng đối tượng)
     * @param data Select dự trên đối tượng này, cũng như dữ liệu cần thiết để select
     * @return Một danh sách cách đối tượng select được
     */
    public <T extends ExecuteDatabase> ArrayList<T> select(int typeSelect, T data) {
        int columnCount = data.getData().length;
        Object[] row = new Object[columnCount];
        ArrayList<T> result = new ArrayList<>();
        try {
            ResultSet rs = JDBC.executeQuery(data.getSqlSelect(typeSelect), data.getDataSelect(typeSelect));

            while (rs.next()) {
                for (int i = 0; i < columnCount; i++) {
                    row[i] = rs.getObject(i + 1);
                }
                result.add(data.<T>coverData(row));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return result;
    }

    /**
     * Select dữ liệu của đối tượng trong database theo mặc định
     *
     * @param <T> kiểu dữ liệu sẽ trả về
     * @param data Select dự trên đối tượng này, cũng như dữ liệu cần thiết để select
     * @return Một danh sách cách đối tượng select được
     */
    public <T extends ExecuteDatabase> ArrayList<T> select(T data) {
        return this.select(0, data);
    }
    
    public void insert() {
        
    }
}
