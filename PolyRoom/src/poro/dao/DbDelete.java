package poro.dao;

/**
 *
 * @author vinh
 */
public interface DbDelete {

    /**
     * Dùng để lấy câu lệnh delete sql
     *
     * @return Một câu lệnh delete sql
     */
    public String getSqlDelete(int type);

    /**
     * Dùng để lấy thông tin delete
     *
     * @return Một mãng các giá trị cần thiết để delete
     */
    public Object[] getInfoDelete(int type);
}
