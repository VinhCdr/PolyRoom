package poro.dao;

/**
 *
 * @author vinh
 */
public interface DbUpdate {
    
    /**
     * Dùng để lấy câu lệnh update sql
     *
     * @return Một câu lệnh update sql
     */
    public String getSqlUpdate(int type);

    /**
     * Dùng để lấy thông tin update
     *
     * @return Một mãng các giá trị cần thiết để update
     */
    public Object[] getInfoUpdate(int type);

}
