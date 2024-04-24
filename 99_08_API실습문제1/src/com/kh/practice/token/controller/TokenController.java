package com.kh.practice.token.controller;

public class TokenController {
	public TokenController() {
		
	}
	//입력된 문자열의 첫 글자를 대문자로 변환 후 반환
	// 예를 들어 "java"라는 문자열이 입력되면 자동으로 Java로 변경되게 만들어줌
	//subString(처음시작하는인덱스값,끝나는인덱스값)
	//subString(처음시작하는인덱스값) -> 내가 원하는 숫자부터 끝까지보기
	//toUpperCase = 문자를 모두 대문자로 변경하는 것
	
	public String firstCap(String input) {
		return input.substring(0,1).toUpperCase() + input.substring(1);
	}
	  public String afterToken(String str) {
	        String[] tokens = str.split(" ");
	        StringBuilder result = new StringBuilder();

	        for (String token : tokens) {
	            result.append(token).append("-");
	        }

	        return result.toString().trim();
	    }

	    public int findChar(String input, char one) {
	        int count = 0;
	        for (char c : input.toCharArray()) {
	            if (c == one) {
	                count++;
	            }
	        }
	        return count;
	    }
	}
