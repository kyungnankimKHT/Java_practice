package com.kh.practice.set.view;

import com.kh.practice.set.controller.LotteryController;
import com.kh.practice.set.model.vo.Lottery;

import java.util.Scanner;

public class LotteryMenu {
    private Scanner sc = new Scanner(System.in);
    private LotteryController lc = new LotteryController();

    public void mainMenu() {
        while (true) {
            System.out.println("===== 로또 관리 프로그램 =====");
            System.out.println("1. 추첨 대상 추가");
            System.out.println("2. 추첨 대상 삭제");
            System.out.println("3. 당첨자 발표");
            System.out.println("4. 정렬된 당첨자 발표");
            System.out.println("5. 특정 대상 당첨 여부 검색");
            System.out.println("6. 프로그램 종료");
            System.out.print("메뉴 선택 : ");
            int menu = sc.nextInt();
            sc.nextLine(); // 버퍼 비우기

            switch (menu) {
                case 1:
                    insertObject();
                    break;
                case 2:
                    deleteObject();
                    break;
                case 3:
                    winObject();
                    break;
                case 4:
                    sortedWinObject();
                    break;
                case 5:
                    searchWinner();
                    break;
                case 6:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }

    public void insertObject() {
        System.out.print("이름 : ");
        String name = sc.nextLine();
        System.out.print("전화번호 : ");
        String phone = sc.nextLine();

        Lottery l = new Lottery(name, phone);
        boolean result = lc.insertObject(l);

        if (result) {
            System.out.println("추가 성공!");
        } else {
            System.out.println("추가 실패!");
        }
    }

    public void deleteObject() {
        System.out.print("삭제할 대상의 이름 : ");
        String name = sc.nextLine();
        System.out.print("삭제할 대상의 전화번호 : ");
        String phone = sc.nextLine();

        Lottery l = new Lottery(name, phone);
        boolean result = lc.deleteObject(l);

        if (result) {
            System.out.println("삭제 성공!");
        } else {
            System.out.println("삭제 실패!");
        }
    }

    public void winObject() {
        System.out.println("===== 당첨자 목록 =====");
        lc.winObject().forEach(System.out::println);
    }

    public void sortedWinObject() {
        System.out.println("===== 정렬된 당첨자 목록 =====");
        lc.sortedWinObject().forEach(System.out::println);
    }

    public void searchWinner() {
        System.out.print("검색할 대상의 이름 : ");
        String name = sc.nextLine();
        System.out.print("검색할 대상의 전화번호 : ");
        String phone = sc.nextLine();

        Lottery l = new Lottery(name, phone);
        boolean result = lc.searchWinner(l);

        if (result) {
            System.out.println("당첨되었습니다!");
        } else {
            System.out.println("당첨되지 않았습니다.");
        }
    }
}
