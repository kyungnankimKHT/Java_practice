package com.kh.practice.token.view;

import java.util.Scanner;

import com.kh.practice.token.controller.TokenController;

public class TokenMenu {
	// 1. 스캐너 만들기 완
	Scanner sc = new Scanner(System.in);
	TokenController tc = new TokenController();

	public void mainMenu() {
		System.out.println("===== 토큰 처리 프로그램 =====");
		tokenMenu();
		// inputMenu();
	}

	public void tokenMenu() {
		System.out.print("처리할 문자열 입력 : ");
		String input = sc.nextLine();

		System.out.println("====== [토큰 처리 결과] ======");
		System.out.println("공백으로 분리한 문자열 : " + tc.afterToken(input));
		System.out.println("첫 글자 대문자 : " + tc.firstCap(input));
		inputMenu(input);
	}

	public void inputMenu(String input) {
		// 첫글자 대문자 // 찾을 문자 입력하고 // 찾을 문자 개수
		System.out.print("문자열 입력 : ");
		String findInput = sc.nextLine();

		char findChar = findInput.charAt(0);
		int count = tc.findChar(input, findChar);
		System.out.println("'" + findChar + "' 문자 개수 : " + count);
	}
}
