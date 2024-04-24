package com.kh.practice.chap02_abstractNInterface.run;

import com.kh.practice.chap02_abstractNInterface.controller.PhoneController;

public class Run {
    public static void main(String[] args) {
        PhoneController controller = new PhoneController();
        String[] result = controller.method();

        for (String phoneInfo : result) {
            System.out.println(phoneInfo);
        }
    }
}
