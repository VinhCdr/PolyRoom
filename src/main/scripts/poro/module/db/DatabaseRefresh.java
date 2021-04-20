package poro.module.db;

/**
 *
 * @author vinh
 */
public class DatabaseRefresh {
    
	/**
	 * Refresh lại cơ sỡ dữ liệu
	 */
    public static void refresh() {
        DatabaseManager.executeUpdate(rc, -1);
    }
    
    private static DbExecute rc = new DbExecute() {
        
        @Override
        public String getExecuteSQL(int type) {
            return "{call sp_refresh_poro}";
        }

        @Override
        public Object[] getExecuteData(int type) {
            return new Object[0];
        }
    };
}
