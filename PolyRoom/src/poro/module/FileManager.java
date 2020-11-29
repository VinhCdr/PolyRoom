package poro.module;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import poro.Config;

/**
 *
 * @author vinh
 */
public class FileManager {

    FileOutputStream fos;
    FileInputStream fis;
    String path;

    public FileManager(String path) {
        this.path = path;
    }
    
    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void write(byte[] data) {
        try {
            fos = new FileOutputStream(path);
            fos.write(data);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

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

    public <T> T readJson(Class<T> classOfT) {
        Gson gson = new Gson();
        String json = new String(read());
        return gson.fromJson(json, classOfT);
    }

    public void writeJson(Object src) {
        Gson gson = new Gson();
        String json = gson.toJson(src);
        write(json.getBytes());
    }

    public static void main(String[] args) {
    }

}
