package poro.module;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Quản lý thời gian
 *
 * @author vinh
 */
public class CalendarManager {

    public static final String DATE_HOUR_FULL_FORMAT = "dd/MM/yyyy HH:mm:ss";
    public static final String DATE_HOUR_FORMAT = "dd/MM/yyyy HH:mm";
    public static final String DATE_FORMAT = "dd/MM/yyyy";

    /**
     * Lấy ngày hiện tại
     * @return Thời gian hiện tại
     */
    public static Date getNow() {
        return new Date();
    }

    /**
     * Thêm mili giây vào thời gian
     * @param date đối tượng date origin
     * @param time số ms muốn thêm vào
     * @return đối tượng date mới với thời gian bị thay đổi
     */
    public static Date addTimes(Date date, Long time) {
        return new Date(date.getTime() + time);
    }

    /**
     * Chuyển đối tượng date thành chuổi
     * @param date Đối tượng Date
     * @param format Định dạng thời gian
     * @return Chuổi thời gian theo định dạng
     */
    public static String getString(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * Chuyển chuổi thành thời gian
     * @param date Chuổi muốn chuyển
     * @param format Định dạng thời gian
     * @return Một đối tượng Date
     */
    public static Date getDateByString(String date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            return sdf.parse(date);
        } catch (ParseException ex) {
            System.out.println(date + " -> " + format);
            throw new RuntimeException("Không thể chuyển chuổi thành đối tượng Date", ex);
        }
    }

    /**
     * Kiểm tra năm nhuận hay không
     * @param year Năm muốn kiểm tra
     * @return <code>true</code> nếu năm nhuận
     */
    public static boolean isLeapYear(int year) {
        boolean leap = year % 400 == 0;
        leap |= year % 4 == 0 && year % 100 != 0;
        return leap;
    }

    /**
     * Lấy ra số ngày có trong năm, tháng được truyền vào
     * @param year Năm muốn kiểm tra
     * @param month Tháng muốn kiểm tra
     * @return số ngày có trong năm ấy, tháng ấy, kiểm tra chính xác
     */
    public static int getDaysOf(int year, int month) {
        boolean leap = isLeapYear(year);
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                return leap ? 29 : 28;
            default:
                throw new RuntimeException("Không có tháng: " + month);
        }
    }

}
