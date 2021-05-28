package com.ledungcobra.utils;

import com.ledungcobra.applicationcontext.AppContext;

public class DatetimeUtil {

    public static boolean isDate(String data) {
        try {
            AppContext.dateFormat.parse(data);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
