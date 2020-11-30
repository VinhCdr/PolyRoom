package poro.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import poro.module.JavaDatabaseConnectivity;

/**
 *
 * @author vinh
 */
public class DatabaseManager {

    private static final JavaDatabaseConnectivity jdbc;

    static {
        jdbc = new JavaDatabaseConnectivity();
    }

    /**
     * Select dữ liệu của đối tượng trong database theo điều kiện cụ thể
     *
     * @param importer Select dự trên đối tượng này, cũng như dữ liệu cần thiết
     * @param type Kiểu select (Quy định riêng theo từng đối tượng) để select
     * @param <T> kiểu dữ liệu sẽ trả về
     * @return Một danh sách cách đối tượng select được
     * @see #insert(poro.dao.DatabaseImport)
     */
    public static <T extends DbSelect> ArrayList<T> select(T importer, int type) {
        int columnCount = importer.getInfo().length;
        Object[] row = new Object[columnCount];
        ArrayList<T> result = new ArrayList<>();
        try {
            ResultSet rs = jdbc.executeQuery(importer.getSqlSelect(type), importer.getInfoSelect(type));

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
    public static <T extends DbSelect> ArrayList<T> select(T importer) {
        return select(importer, 0);
    }

    /**
     * Insert dữ liệu vào database theo kiểu cụ thể
     *
     * @param importer Dữ liệu sẽ insert vào database
     * @param type Kiễu insert
     */
    public static void insert(DbInsert importer, int type) {
        jdbc.executeUpdate(importer.getSqlInsert(type), importer.getInfoInsert(type));
    }

    /**
     * Insert dữ liệu vào database theo mặc định
     *
     * @param importer Dữ liệu sẽ insert vào database
     */
    public static void insert(DbInsert importer) {
        insert(importer, 0);
    }

    /**
     * Update dữ liệu đã có trong database theo kiểu cụ thể
     *
     * @param importer Dữ liệu sẽ update (dựa vào id của dữ liệu)
     * @param type Kiểu update
     */
    public static void update(DbUpdate importer, int type) {
        jdbc.executeUpdate(importer.getSqlUpdate(type), importer.getInfoUpdate(type));
    }

    /**
     * Update dữ liệu đã có trong database theo mặc định
     *
     * @param importer dữ liệu sẽ update (dựa vào id của dữ liệu)
     */
    public static void update(DbUpdate importer) {
        update(importer, 0);
    }

    /**
     * Delete dữ liệu đã có trong database theo kiểu cụ thể
     *
     * @param importer dữ liệu sẽ delete (dựa vào id của dữ liệu)
     * @param type Kiểu delete
     */
    public static void delete(DbDelete importer, int type) {
        jdbc.executeUpdate(importer.getSqlDelete(type), importer.getInfoDelete(type));
    }

    /**
     * Delete dữ liệu đã có trong database theo mặc định
     *
     * @param importer dữ liệu sẽ delete (dựa vào id của dữ liệu)
     */
    public static void delete(DbDelete importer) {
        delete(importer, 0);
    }

}
