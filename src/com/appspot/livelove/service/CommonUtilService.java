package com.appspot.livelove.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtilService {
    private static final String DATE_PATTERN = "yyyy.MM.dd HH:mm";
    private static SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);

    public static Date string2date(String value) {
        try {
            return sdf.parse(value);
        } catch (ParseException e) {
            return null;
        }
    }
}
