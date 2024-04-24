package com.kh.practice.leap.view;

import com.kh.practice.leap.controller.LeapController;

import java.util.Calendar;

public class LeapView {

    public LeapView() {
        LeapController controller = new LeapController();

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        boolean isLeap = controller.isLeapYear(currentYear);
        System.out.println(currentYear + "년은 " + (isLeap ? "윤년" : "평년") + "입니다.");

        long totalDays = controller.leapDate(Calendar.getInstance());
        System.out.println("1년 1월 1일부터 오늘까지 " + totalDays + "일이 지났습니다.");
    }
}
