package poro.dao;

/**
 *
 * @author vinh
 */
public interface DbExecute {

    /**
     * Dùng để lấy câu lệnh execute
     *
     * @param type Loại lệnh select sql mong muốn
     * @return Một câu lệnh sql select
     */
    public String getExecuteSQL(int type);

    /**
     * Dùng để lấy thông tin execute
     *
     * @param type Loại lệnh select sql mong muốn
     * @return Một mãng các giá trị cần thiết để insert
     */
    public Object[] getExecuteData(int type);

}
