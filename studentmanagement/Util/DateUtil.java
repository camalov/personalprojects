package com.project.studentmanagement.Util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
    public static Date formatDate(Date date, String format) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.parse(dateFormat.format(date));
    }

    public static LocalDate formatLocalDate(LocalDate date, String format) {
        DateTimeFormatter dtfInput = DateTimeFormatter.ofPattern("u-M-d H:m:s.S", Locale.ENGLISH);
        LocalDateTime ldt = LocalDateTime.parse(date.toString(), dtfInput);
        // Alternatively, the old way:
        // LocalDateTime ldt = dtfInput.parse(strDate, LocalDateTime::from);
        date = ldt.toLocalDate();
        System.out.println(date);
        return date;
    }

    public static String formatStringDate(Date date, String format) {
        if (date == null) {
            return null;
        }

        DateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }

    public static String formatStringDate(String date, String format) {
        DateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }

    public static Date convertFormatDate(String date, String format) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.parse(date);
    }

    public static Date parse(String date) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat();
        return dateFormat.parse(date);
    }

    public static <T extends Object> boolean dateIsEmpty(T object) {
        if (object == null || object.toString().trim() == "") {
            return true;
        }
        return false;
    }

    /*@Deprecated
    public static boolean controlFormat(String date) {
        if (date.isEmpty() || date == null || date == "0000-00-00 00:00:00") {
            return false;
        }
        return true;
    }
     */
}
