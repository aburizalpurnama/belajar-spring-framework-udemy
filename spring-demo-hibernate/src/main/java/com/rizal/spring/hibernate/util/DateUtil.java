package com.rizal.spring.hibernate.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    /**
     * The date formatter
     * - dd: day in month (number)
     * - mm: month in year (number)
     * - yyyy: year
     */

    public static SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");

    // read a date string and parse/convert it to a date
    public static Date parseDate(String dateString) throws ParseException {
        Date date = formatter.parse(dateString);
        return date;
    }

    // read a date and parse/convert it to string
    public static String formatDate(Date date){
        String result = null;

        if (date != null){
            result = formatter.format(date);
        }

        return result;
    }
}
