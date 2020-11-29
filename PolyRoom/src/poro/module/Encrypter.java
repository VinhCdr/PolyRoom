package poro.module;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author vinh
 */
public class Encrypter {
    
    /**
     * Mã hóa 1 chiều, chuyển dữ liệu sang dạng MD5
     *
     * @param data là dữ liệu sẽ mã hóa
     * @return Một chuổi đã mã MD5
     */
    public String toMD5(byte[] data) {
        try {
            MessageDigest mesageDiagest = MessageDigest.getInstance("MD5");
            mesageDiagest.update(data);
            BigInteger bigInt = new BigInteger(1, mesageDiagest.digest());
            return bigInt.toString(32);
        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException("Có lỗi trong quá trình mã hóa dữ liệu 1 chiều", ex);
        }
    }
    
    /**
     * Mã hóa 1 chiều, chuyển dữ liệu sang dạng MD5
     *
     * @param data là dữ liệu sẽ mã hóa
     * @return Một chuổi đã mã MD5
     * @see #toMD5(byte[])
     */
    public String toMD5(String data) {
        return toMD5(data.getBytes());
    }
}
