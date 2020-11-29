package poro.module;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author vinh
 */
public class FileManager {

    FileOutputStream fos;
    FileInputStream fis;
    String path;

    /**
     * Tạo đối tượng quản lý file trực tiếp
     *
     * @param path Đường dẫn đến file
     * @see #setPath(java.lang.String)
     */
    public FileManager(String path) {
        this.path = path;
    }

    /**
     * Đặt lại đường dẫn file
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Ghi dữ liệu vào file
     *
     * @param data Dữ liệu sẽ ghi
     * @see #writeString(java.lang.String) 
     */
    public void write(byte[] data) {
        try {
            fos = new FileOutputStream(path);
            fos.write(data);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Đọc dữ liệu từ file
     *
     * @return Dữ liệu của file
     * @see #readString() 
     */
    public byte[] read() {
        try {
            fis = new FileInputStream(new File(path));
            byte[] data = new byte[fis.available()];
            fis.read(data);
            return data;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return new byte[0];
    }

    /**
     * Đọc dữ liệu từ file và trả về dạng chuổi (thích hợp khi đọc file văn bản)
     * 
     * @return Văn bản trong file
     * @see #read() 
     */
    public String readString() {
        return new String(read());
    }

    /**
     * Ghi dữ liệu vào file với dữ liệu là chuổi văn vản
     * 
     * @param src Dữ liệu đầu vào
     * @see #write(byte[]) 
     */
    public void writeString(String src) {
        write(src.getBytes());
    }

}
