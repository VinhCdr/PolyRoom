package poro.module;

import poro.module.db.DatabaseManager;
import poro.module.db.data.TaiKhoan;

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

    public static void exit() {
        try {
            logoff();
            DatabaseManager.close();
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            System.exit(0);
        }
    }
}
