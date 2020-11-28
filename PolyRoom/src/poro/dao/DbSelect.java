package poro.dao;

/**
 *
 * @author vinh
 */
public interface DbSelect {

    /**
     * Hàm cover mãng object thành đối tượng
     *
     * @param <T> Đối tượng sẽ trả về
     * @param data Dữ liệu vào theo thứ tự nhất định
     * @return Đối tượng mới
     */
    public <T extends DbSelect> T coverData(Object[] data);

    /**
     * Lấy thông tin theo thứ tự nhất định từ đối tượng
     *
     * @return mãng dữ liệu
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

}
