package com.qwli7.test.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    private static final String STANDARD_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private DateUtil() {
        super();
    }


    public static String format(Date date) {
        return new SimpleDateFormat(STANDARD_FORMAT).format(date);
    }
}
