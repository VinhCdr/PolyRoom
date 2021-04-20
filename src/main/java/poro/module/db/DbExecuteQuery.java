package poro.module.db;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author vinh
 */
public interface DbExecuteQuery extends DbExecute{

    /**
     * Hàm hàm lấy dữ liệu từ {@link ResultSet} vào đối tượng (hàm không tự next)
     *
     * @param resultSet Dữ liệu vào theo thứ tự nhất định
     * @param type Loại select đã chọn
     * @param <T> Đối tượng sẽ trả về
     * @return Đối tượng mới
     */
    public <T extends DbExecuteQuery> T coverResultSet(ResultSet resultSet, int type) throws SQLException;

}
