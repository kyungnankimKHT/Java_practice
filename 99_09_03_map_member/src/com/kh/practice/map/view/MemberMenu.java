package com.kh.practice.map.view;

import com.kh.practice.map.controller.MemberController;
import com.kh.practice.map.model.vo.Member;

import java.util.Scanner;

public class MemberMenu {
    private Scanner sc = new Scanner(System.in);
    private MemberController mc = new MemberController();

    public void mainMenu() {
        while (true) {
            System.out.println("===== 회원 관리 프로그램 =====");
            System.out.println("1. 회원가입");
            System.out.println("2. 로그인");
            System.out.println("3. 비밀번호 변경");
            System.out.println("4. 이름 변경");
            System.out.println("5. 같은 이름 가진 사람 출력");
            System.out.println("6. 프로그램 종료");
            System.out.print("메뉴 선택 : ");
            int menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1:
                    joinMembership();
                    break;
                case 2:
                    logIn();
                    break;
                case 3:
                    changePassword();
                    break;
                case 4:
                    changeName();
                    break;
                case 5:
                    sameName();
                    break;
                case 6:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }

    public void joinMembership() {
        System.out.print("아이디 : ");
        String id = sc.nextLine();
        System.out.print("비밀번호 : ");
        String password = sc.nextLine();
        System.out.print("이름 : ");
        String name = sc.nextLine();

        Member m = new Member(password, name);
        boolean result = mc.joinMembership(id, m);

        if (result) {
            System.out.println("회원가입 성공!");
        } else {
            System.out.println("회원가입 실패!");
        }
    }

    public void logIn() {
        System.out.print("아이디 : ");
        String id = sc.nextLine();
        System.out.print("비밀번호 : ");
        String password = sc.nextLine();

        String result = mc.logIn(id, password);

        if (result != null) {
            System.out.println(result + "님, 환영합니다!");
        } else {
            System.out.println("로그인 실패! 아이디 또는 비밀번호를 확인해주세요.");
        }
    }

    public void changePassword() {
        System.out.print("아이디 : ");
        String id = sc.nextLine();
        System.out.print("기존 비밀번호 : ");
        String oldPw = sc.nextLine();
        System.out.print("새로운 비밀번호 : ");
        String newPw = sc.nextLine();

        boolean result = mc.changePassword(id, oldPw, newPw);

        if (result) {
            System.out.println("비밀번호 변경 성공!");
        } else {
            System.out.println("비밀번호 변경 실패!");
        }
    }

    public void changeName() {
        System.out.print("아이디 : ");
        String id = sc.nextLine();
        System.out.print("새로운 이름 : ");
        String newName = sc.nextLine();

        mc.changeName(id, newName);
        System.out.println("이름 변경 성공!");
    }

    public void sameName() {
        System.out.print("검색할 이름 : ");
        String name = sc.nextLine();
        mc.sameName(name).forEach((k, v) -> System.out.println(k + " : " + v));
    }
}
