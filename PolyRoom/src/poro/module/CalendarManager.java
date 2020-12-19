package poro.module;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vinh
 */
public class CalendarManager {

    public static final String DATE_HOUR_FULL_FORMAT = "dd/MM/yyyy HH:mm:ss";
    public static final String DATE_HOUR_FORMAT = "dd/MM/yyyy HH:mm";
    public static final String DATE_FORMAT = "dd/MM/yyyy";

    public static Date getNow() {
        return new Date();
    }

    public static Date addTimes(Date date, Long time) {
        return new Date(date.getTime() + time);
    }

    public static String getString(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static Date getDateByString(String date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            return sdf.parse(date);
        } catch (ParseException ex) {
            System.out.println(date + " -> " + format);
            throw new RuntimeException("Không thể chuyển chuổi thành đối tượng Date", ex);
        }
    }

    public static boolean isLeapYear(int year) {
        boolean leap = year % 400 == 0;
        leap |= year % 4 == 0 && year % 100 != 0;
        return leap;
    }

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
