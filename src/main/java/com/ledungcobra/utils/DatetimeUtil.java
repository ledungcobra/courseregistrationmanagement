package com.ledungcobra.utils;

import com.ledungcobra.applicationcontext.AppContext;
import lombok.SneakyThrows;

import java.util.Date;

public class DatetimeUtil
{

    public static boolean isDate(String data)
    {
        try
        {
            AppContext.dateFormat.parse(data);
            return true;
        } catch (Exception e)
        {
            return false;
        }
    }

    @SneakyThrows
    public static Date getCurrentDate()
    {
        return   AppContext.dateFormat.parse("12-6-2021");
    }
}
