package com.ledungcobra.utils;

import lombok.Getter;

public class Constants {


    public static final String THU_2 = "Thứ 2";
    public static final String THU_3 = "Thứ 3";
    public static final String THU_4 = "Thứ 4";
    public static final String THU_5 = "Thứ 5";
    public static final String THU_6 = "Thứ 6";
    public static final String THU_7 = "Thứ 7";
    public static final String CHU_NHAT = "Chủ nhật";
    public static final String HK1 = "HK1";
    public static final String HK2 = "HK2";
    public static final String HK3 = "HK3";

    public static final String[] DAY_IN_WEEK = new String[]{
            THU_2,
            THU_3,
            THU_4,
            THU_5,
            THU_6,
            THU_7,
            CHU_NHAT
    };

    public static final String COURSE_CHECK_CONSTRAINT_DAY_IN_WEEK = "CONSTRAINT COURSE_CHECK_CONSTRAINT_DAY_IN_WEEK CHECK (DAY_TO_STUDY_IN_WEEK IN ('" + THU_2 + "'," +
            "'" + THU_3 + "'," +
            "'" + THU_4 + "'," +
            "'" + THU_5 + "'," +
            "'" + THU_6 + "'," +
            "'" + THU_7 + "'," +
            "'" + CHU_NHAT + "'))";
    public static final String SEMESTER_CHECK_CONSTRAINT_SEMESTER_NAME = "CONSTRAINT CHECK (SEMESTER_NAME IN ( '" + HK1 + "','" + HK2 + "','" + HK3 + "'))";
    ;

    public static final String USERNAME = "18120331";

    public static final String SHOW = "Show";
    public static final String HIDE = "Hide";
    public static final String[] SEMESTER = new String[]{
            "HK1",
            "HK2",
            "HK3"
    };

    public static final String[] SHIFTS_IN_DAY = new String[]{
            "7:30 - 9:30",
            "9:30 - 11:30",
            "13:30 - 15-30",
            "15:30 - 17-30"
    };


}
