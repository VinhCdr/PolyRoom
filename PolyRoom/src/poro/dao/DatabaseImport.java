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
     * Dùng để lấy câu lệnh select sql mong muốn
     *
     * @param type Loại lệnh select sql mong muốn
     * @return Một câu lệnh sql select
     */
    public String getSqlSelect(int type);

    /**
     * Dùng để lấy thông tin select mong muốn
     *
     * @param type Loại dữ liệu select mong muốn
     * @return Một mãng các tham số đầu vào
     */
    public Object[] getInfoSelect(int type);

    /**
     * Dùng để lấy câu lệnh insert sql
     *
     * @param type Loại lệnh select sql mong muốn
     * @return Một câu lệnh sql select
     */
    public String getSqlInsert();
    
    /**
     * Dùng để lấy câu lệnh update sql
     *
     * @return Một câu lệnh update sql
     */
    public String getSqlUpdate();
    
    /**
     * Dùng để lấy thông tin update
     *
     * @return Một mãng các giá trị cần thiết để update
     */
    public Object[] getInfoUpdate();
    
    /**
     * Dùng để lấy câu lệnh delete sql
     *
     * @return Một câu lệnh delete sql
     */
    public String getSqlDelete();
    
    /**
     * Dùng để lấy thông tin delete
     *
     * @return Một mãng các giá trị cần thiết để delete
     */
    public Object[] getInfoDelete();
}
