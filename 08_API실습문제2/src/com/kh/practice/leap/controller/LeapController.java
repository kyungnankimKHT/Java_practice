package com.kh.practice.leap.controller;

import java.util.Calendar;

public class LeapController {

    public boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public long leapDate(Calendar c) {
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int day = c.get(Calendar.DAY_OF_MONTH);

        long totalDays = 0;

        for (int i = 1; i < year; i++) {
            if (isLeapYear(i)) {
                totalDays += 366;
            } else {
                totalDays += 365;
            }
        }

        for (int i = 1; i < month; i++) {
            if (i == 2) {
                totalDays += isLeapYear(year) ? 29 : 28;
            } else if (i == 4 || i == 6 || i == 9 || i == 11) {
                totalDays += 30;
            } else {
                totalDays += 31;
            }
        }

        totalDays += day;

        return totalDays;
    }
}
