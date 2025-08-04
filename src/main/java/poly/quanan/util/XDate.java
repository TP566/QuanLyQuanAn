/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.quanan.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author lengh
 */
public class XDate {

    public static final String PATTERN_FULL = "yyyy-MM-dd HH:mm:ss";
    public static final String PATTERN_SHORT = "MM/dd/yyyy";

    private static final SimpleDateFormat formater = new SimpleDateFormat();

    public static Date now() {
        return new Date();
    }

    public static Date parse(String dateTime, String pattern) {
        if (dateTime == null || dateTime.trim().isEmpty()) {
            return null; // hoặc throw new IllegalArgumentException("Chuỗi ngày giờ bị rỗng");
        }
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(pattern);
            return formatter.parse(dateTime);
        } catch (ParseException e) {
            e.printStackTrace(); // Ghi log để debug
            return null;
        }
    }

    public static Date parse(String dateTime) {
        return parse(dateTime, PATTERN_SHORT);
    }

    public static String format(Date dateTime, String pattern) {
        if (dateTime == null) {
            return "";
        }
        formater.applyPattern(pattern);
        return formater.format(dateTime);
    }

    public static String format(Date dateTime) {
        return format(dateTime, PATTERN_SHORT);
    }

    public static void main(String[] args) {
        Date date = XDate.parse("Jan 21, 2024", "MMM dd, yyyy");
        String text = XDate.format(date, "dd-MMM-yyyy");
        System.out.println(text); // => 21-Jan-2024
    }

    public static String toString(Date date, String pattern) {
        if (date == null) {
            return "";
        }
        return new SimpleDateFormat(pattern).format(date);
    }

    public static Date toDate(String text, String pattern) {
        if (text == null || text.trim().isEmpty()) {
            return null;
        }
        try {
            return new SimpleDateFormat(pattern).parse(text);
        } catch (ParseException e) {
            throw new RuntimeException("Loi chuyen doi ngay: " + text);
        }
    }

    public static Date parseMultiFormat(String text) {
        if (text == null || text.trim().isEmpty()) {
            return null;
        }

        String[] patterns = {
            "MM/dd/yyyy", // mặc định bạn đang dùng
            "yyyy-MM-dd", // format SQL Server
            "dd-MM-yyyy", // kiểu Việt Nam
            "yyyy/MM/dd", // một số hệ thống trả ra như vậy
            "dd/MM/yyyy" // người dùng nhập thủ công
        };

        for (String pattern : patterns) {
            try {
                return new SimpleDateFormat(pattern).parse(text);
            } catch (ParseException e) {
                // thử pattern tiếp theo
            }
        }
        throw new RuntimeException("Không parse được ngày: " + text);
    }

}
