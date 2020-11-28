package poro.dao;

/**
 *
 * @author vinh
 */
public interface DbInsert {

    /**
     * Dùng để lấy câu lệnh insert sql
     *
     * @param type Loại lệnh select sql mong muốn
     * @return Một câu lệnh sql select
     */
    public String getSqlInsert(int type);

    /**
     * Dùng để lấy thông tin insert
     *
     * @return Một mãng các giá trị cần thiết để insert
     */
    public Object[] getInfoInsert(int type);

}
