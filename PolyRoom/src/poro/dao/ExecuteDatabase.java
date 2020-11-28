package poro.dao;

/**
 *
 * @author vinh
 */
public interface ExecuteDatabase {

    /**
     * Hàm cover mãng object thành đối tượng
     *
     * @param <T> Đối tượng sẽ trả về
     * @param data Dữ liệu vào theo thứ tự nhất định
     * @return Đối tượng mới
     */
    public <T extends ExecuteDatabase> T coverData(Object[] data);

    /**
     * Hàm trả về mãng đối tượng theo thứ tự nhất định
     */
    public Object[] getData();
    

    /**
     * Hàm trả về câu lệnh select sql theo mong muốn
     *
     * @param type Loại lệnh select sql mong muốn
     * @return Một câu lệnh sql select
     */
    public String getSqlSelect(int type);

    /**
     * Hàm trả về dữ liệu cần thiết để select theo mong muốn
     *
     * @param type Loại dữ liệu select mong muốn
     * @return Một mãng các tham số đầu vào
     */
    public Object[] getDataSelect(int type);

    /**
     * Hàm trả về câu lệnh insert sql
     *
     * @param type Loại lệnh select sql mong muốn
     * @return Một câu lệnh sql select
     */
    public String getSqlInsert();
}
