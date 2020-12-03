package poro.module;

import poro.dao.data.TaiKhoan;

/**
 *
 * @author ASUS
 */
public class Session {
    


    /**
     * Đối tượng này chứa thông tin người sử dụng sau khi đăng nhập
     */
    public static TaiKhoan USER = null;

    /**
     * Xóa thông tin của người sử dụng khi có yêu cầu đăng xuất
     */
    public static void logoff() {
        USER = null;
    }

    /**
     * Kiểm tra xem đăng nhập hay chưa
     *
     * @return đăng nhập hay chưa
     */
    public static boolean isLogin() {
        return USER != null;
    }
}
