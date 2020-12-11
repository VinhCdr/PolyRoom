package poro.module.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import poro.module.Config;

/**
 * Quản lý cơ sỡ dữ liệu
 *
 * @author vinh
 */
public class DatabaseManager {

    static {
        try {
            Class.forName(Config.DB_DRIVER);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
    }

    private static Connection connect = null;

    /**
     * Mở kết nối đến cơ sỡ dữ liệu
     *
     * @return Đối tượng kết nối đến csdl
     */
    private static Connection openConnect() {
        try {
            if (connect == null || connect.isClosed()) {
                connect = DriverManager.getConnection(Config.DB_URL, Config.DB_USER, Config.DB_PASSWORD);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return connect;
    }

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
    private static PreparedStatement getPreStm(String sql, Object... args) throws SQLException {
        PreparedStatement pstmt;
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
     * Select dữ liệu của đối tượng trong database theo điều kiện cụ thể
     *
     * @param importer Select dự trên đối tượng này, cũng như dữ liệu cần thiết
     * @param type Kiểu select (Quy định riêng theo từng đối tượng) để select
     * @param <T> kiểu dữ liệu sẽ trả về
     * @return Một danh sách cách đối tượng select được
     */
    public static <T extends DbExecuteQuery> ArrayList<T> executeQuery(T importer, int type) {
        ArrayList<T> result = new ArrayList<>();
        try {
            PreparedStatement preStm = getPreStm(importer.getExecuteSQL(type), importer.getExecuteData(type));
            ResultSet rs = preStm.executeQuery();
            while (rs.next()) {
                T objSelect = importer.<T>coverResultSet(rs, type);
                result.add(objSelect);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return result;
    }

    /**
     * Insert, update, delete dữ liệu vào database theo kiểu cụ thể
     *
     * @param importer Dữ liệu sẽ thực hiện execute
     * @param type Kiểu câu lệnh execute
     * @return Số dòng đã thay đổi trong cơ sỡ dữ liệu
     */
    public static int executeUpdate(DbExecute importer, int type) {
        int result = 0;
        try {
            PreparedStatement preStm = getPreStm(importer.getExecuteSQL(type), importer.getExecuteData(type));
            result = preStm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return result;
    }

    public static void close() {
        try {
            connect.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

}
