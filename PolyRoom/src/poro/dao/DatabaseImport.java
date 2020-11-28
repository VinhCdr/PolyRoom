package poro.dao;

/**
 *
 * @author vinh
 */
public interface DatabaseImport {

    /**
     * Hàm cover mãng object thành đối tượng
     *
     * @param <T> Đối tượng sẽ trả về
     * @param data Dữ liệu vào theo thứ tự nhất định
     * @return Đối tượng mới
     */
    public <T extends DatabaseImport> T coverData(Object[] data);

    /**
     * Hàm trả về mãng đối tượng theo thứ tự nhất định
     */
    public Object[] getInfo();

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
    public Object[] getInfoSelect(int type);

    /**
     * Hàm trả về câu lệnh insert sql
     *
     * @param type Loại lệnh select sql mong muốn
     * @return Một câu lệnh sql select
     */
    public String getSqlInsert();
}
