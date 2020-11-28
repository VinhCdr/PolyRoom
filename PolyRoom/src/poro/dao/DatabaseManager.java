package poro.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import poro.Config;

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
    public static <T extends DatabaseImport> ArrayList<T> select(T importer, int typeSelect) {
        int columnCount = importer.getInfo().length;
        Object[] row = new Object[columnCount];
        ArrayList<T> result = new ArrayList<>();
        try {
            ResultSet rs = DatabaseManager.executeQuery(importer.getSqlSelect(typeSelect), importer.getInfoSelect(typeSelect));

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
        return DatabaseManager.select(importer, 0);
    }

    /**
     * Insert dữ liệu vào database
     *
     * @param importer Dữ liệu sẽ insert vào database
     */
    public static void insert(DatabaseImport importer) {
        DatabaseManager.executeUpdate(importer.getSqlInsert(), importer.getInfo());
    }

    /**
     * Update dữ liệu đã có trong database
     *
     * @param importer dữ liệu sẽ update (dựa vào id của dữ liệu)
     */
    public static void update(DatabaseImport importer) {
        DatabaseManager.executeUpdate(importer.getSqlUpdate(), importer.getInfoUpdate());
    }

    /**
     * Delete dữ liệu đã có trong database
     *
     * @param importer dữ liệu sẽ delete (dựa vào id của dữ liệu)
     */
    public static void delete(DatabaseImport importer) {
        DatabaseManager.executeUpdate(importer.getSqlDelete(), importer.getInfoDelete());
    }

    static {
        config = new Config();
    }

    private static Config config;
    private static Connection connect = null;

    /**
     * Xây dựng PreparedStatement
     *
     * @param sql là câu lệnh SQL chứa có thể chứa tham số. Nó có thể là một lời
     * gọi thủ tục lưu
     * @param args là danh sách các giá trị được cung cấp cho các tham số trong
     * câu lệnh sql
     * @return PreparedStatement tạo được
     * @throws java.sql.SQLException lỗi sai cú pháp
     */
    private static PreparedStatement prepareStatement(String sql, Object... args) throws SQLException {

        PreparedStatement pstmt = null;
        if (sql.trim().startsWith("{")) {
            pstmt = openConnect().prepareCall(sql);
        } else {
            pstmt = openConnect().prepareStatement(sql);
        }
        for (int i = 0; i < args.length; i++) {
            pstmt.setObject(i + 1, args[i]);
        }
        return pstmt;
    }

    /**
     * Thực hiện câu lệnh SQL thao tác (INSERT, UPDATE, DELETE) hoặc thủ tục lưu
     * thao tác dữ liệu
     *
     * @param sql là câu lệnh SQL chứa có thể chứa tham số. Nó có thể là một lời
     * gọi thủ tục lưu
     * @param args là danh sách các giá trị được cung cấp cho các tham số trong
     * câu lệnh sql *
     */
    private static void executeUpdate(String sql, Object... args) {
        try {
            PreparedStatement stmt = prepareStatement(sql, args);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Thực hiện câu lệnh SQL truy vấn (SELECT) hoặc thủ tục lưu truy vấn dữ
     * liệu
     *
     * @param sql là câu lệnh SQL chứa có thể chứa tham số. Nó có thể là một lời
     * gọi thủ tục lưu
     * @param args là danh sách các giá trị được cung cấp cho các tham số trong
     * câu lệnh sql
     * @return một đối resultSet chứa giá trị của dữ liệu select được
     */
    private static ResultSet executeQuery(String sql, Object... args) {
        try {
            PreparedStatement stmt = prepareStatement(sql, args);
            return stmt.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    private static Connection openConnect() {
        try {
            if (connect == null || connect.isClosed()) {
                Class.forName(config.getDbDriver());
                connect = DriverManager.getConnection(config.getDbURL(), config.getDbUser(), config.getDbPassword());
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return connect;
    }
}
