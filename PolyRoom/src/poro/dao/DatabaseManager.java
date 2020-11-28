package poro.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import poro.model.JDBC;

/**
 *
 * @author vinh
 */
public class DatabaseManager {

    /**
     * Select dữ liệu của đối tượng trong database theo điều kiện cụ thể
     *
     * @param typeSelect Kiểu select (Quy định riêng theo từng đối tượng)
     * @param importer Select dự trên đối tượng này, cũng như dữ liệu cần thiết
     * để select
     * @param <T> kiểu dữ liệu sẽ trả về
     * @return Một danh sách cách đối tượng select được
     * @see #insert(poro.dao.DatabaseImport)
     */
    public <T extends DatabaseImport> ArrayList<T> select(T importer, int typeSelect) {
        int columnCount = importer.getInfo().length;
        Object[] row = new Object[columnCount];
        ArrayList<T> result = new ArrayList<>();
        try {
            ResultSet rs = JDBC.executeQuery(importer.getSqlSelect(typeSelect), importer.getInfoSelect(typeSelect));

            while (rs.next()) {
                for (int i = 0; i < columnCount; i++) {
                    row[i] = rs.getObject(i + 1);
                }
                result.add(importer.<T>coverData(row));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return result;
    }

    /**
     * Select dữ liệu của đối tượng trong database theo mặc định
     *
     * @param importer Select dự trên đối tượng này, cũng như dữ liệu cần thiết
     * để select
     * @param <T> kiểu dữ liệu sẽ trả về
     * @return Một danh sách cách đối tượng select được
     * @see #select(poro.dao.DatabaseImport, int)
     */
    public <T extends DatabaseImport> ArrayList<T> select(T importer) {
        return this.select(importer, 0);
    }

    /**
     * Insert dữ liệu vào database
     *
     * @param importer Dữ liệu sẽ insert vào database
     */
    public void insert(DatabaseImport importer) {
        JDBC.executeUpdate(importer.getSqlInsert(), importer.getInfo());
    }

    /**
     * Update dữ liệu đã có trong database
     * 
     * @param importer dữ liệu sẽ update (dựa vào id của dữ liệu)
     */
    public void update(DatabaseImport importer) {
        JDBC.executeUpdate(importer.getSqlUpdate(), importer.getInfoUpdate());
    }
}
