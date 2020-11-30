package poro.module;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import poro.dao.data.TaiKhoan;

/**
 *
 * @author vinh
 */
public class FileManager {

    File file;

    /**
     * Tạo đối tượng quản lý file trực tiếp
     *
     * @param path Đường dẫn đến file
     * @see #setPath(java.lang.String)
     */
    public FileManager(String path) {
        this.file = new File(path);
    }

    /**
     * Đặt lại đường dẫn file
     */
    public void setPath(String path) {
        this.file = new File(path);
    }

    /**
     * Ghi dữ liệu vào file
     *
     * @param data Dữ liệu sẽ ghi
     * @see #writeString(java.lang.String)
     */
    public void write(byte[] data) {
        try (FileOutputStream fos = new FileOutputStream(file)) {
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
        try (FileInputStream fis = new FileInputStream(file)) {
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

    /**
     * Ghi dữ liệu vào file với dữ liệu là Object
     *
     * @param src Dữ liệu đầu vào
     * @see #write(byte[])
     */
    public void writeObject(Serializable src) {
        try (FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(src);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * Đọc dữ liệu từ file và trả về đối tượng
     *
     * @param <T> Kiểu đối tượng trả về
     * @return Văn bản trong file
     * @see #read()
     */
    public <T extends Serializable> T readObject() {
        try (FileInputStream fis = new FileInputStream(file); 
                ObjectInputStream ois = new ObjectInputStream(fis)){
            return (T) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
