package poro.gui.exception;

/**
 * Các lỗi sẽ được đưa ra màn hình dựa trên Exception này
 * 
 * @author vinh
 */
public class ToViewException extends Exception{
	private static final long serialVersionUID = 1L;

	public ToViewException(String string) {
        super(string);
    }

    public ToViewException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }
    
}
