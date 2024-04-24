package com.kh.practice.generics.view;

import com.kh.practice.generics.controller.FarmController;
import com.kh.practice.generics.model.vo.Farm;

import java.util.Scanner;

public class FarmMenu {
    private Scanner sc = new Scanner(System.in);
    private FarmController fc = new FarmController();

    public void mainMenu() {
        while (true) {
            System.out.println("===== 농산물 관리 프로그램 =====");
            System.out.println("1. 직원 메뉴");
            System.out.println("2. 고객 메뉴");
            System.out.println("3. 프로그램 종료");
            System.out.print("메뉴 선택 : ");
            int menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1:
                    adminMenu();
                    break;
                case 2:
                    customerMenu();
                    break;
                case 3:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }

    public void adminMenu() {
        while (true) {
            System.out.println("===== 직원 메뉴 =====");
            System.out.println("1. 새로운 농산물 추가");
            System.out.println("2. 농산물 삭제");
            System.out.println("3. 농산물 수량 변경");
            System.out.println("4. 농산물 출력");
            System.out.println("5. 메인 메뉴로 돌아가기");
            System.out.print("메뉴 선택 : ");
            int menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1:
                    addNewKind();
                    break;
                case 2:
                    removeKind();
                    break;
                case 3:
                    changeAmount();
                    break;
                case 4:
                    printFarm();
                    break;
                case 5:
                    System.out.println("메인 메뉴로 돌아갑니다.");
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }

    public void customerMenu() {
        while (true) {
            System.out.println("===== 고객 메뉴 =====");
            System.out.println("1. 농산물 구매");
            System.out.println("2. 구매 취소");
            System.out.println("3. 구매 목록 출력");
            System.out.println("4. 메인 메뉴로 돌아가기");
            System.out.print("메뉴 선택 : ");
            int menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1:
                    buyFarm();
                    break;
                case 2:
                    removeFarm();
                    break;
                case 3:
                    printBuyFarm();
                    break;
                case 4:
                    System.out.println("메인 메뉴로 돌아갑니다.");
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }

    public void addNewKind() {
        System.out.print("농산물 종류 : ");
        String kind = sc.nextLine();
        System.out.print("수량 : ");
        int amount = sc.nextInt();
        sc.nextLine();

        Farm f = new Farm(kind);
        boolean result = fc.addNewKind(f, amount);

        if (result) {
            System.out.println("농산물 추가 성공!");
        } else {
            System.out.println("농산물 추가 실패!");
        }
    }

    public void removeKind() {
        System.out.print("농산물 종류 : ");
        String kind = sc.nextLine();

        Farm f = new Farm(kind);
        boolean result = fc.removeKind(f);

        if (result) {
            System.out.println("농산물 삭제 성공!");
        } else {
            System.out.println("농산물 삭제 실패!");
        }
    }

    public void changeAmount() {
        System.out.print("농산물 종류 : ");
        String kind = sc.nextLine();
        System.out.print("변경할 수량 : ");
        int amount = sc.nextInt();
        sc.nextLine();

        Farm f = new Farm(kind);
        boolean result = fc.changeAmount(f, amount);

        if (result) {
            System.out.println("농산물 수량 변경 성공!");
        } else {
            System.out.println("농산물 수량 변경 실패!");
        }
    }

    public void printFarm() {
        System.out.println("===== 농산물 출력 =====");
        System.out.println(fc.printFarm());
    }

    public void buyFarm() {
        System.out.print("농산물 종류 : ");
        String kind = sc.nextLine();

        Farm f = new Farm(kind);
        boolean result = fc.buyFarm(f);

        if (result) {
            System.out.println("농산물 구매 성공!");
        } else {
            System.out.println("농산물 구매 실패!");
        }
    }

    public void removeFarm() {
        System.out.print("취소할 농산물 종류 : ");
        String kind = sc.nextLine();

        Farm f = new Farm(kind);
        boolean result = fc.removeFarm(f);

        if (result) {
            System.out.println("농산물 구매 취소 성공!");
        } else {
            System.out.println("농산물 구매 취소 실패!");
        }
    }

    public void printBuyFarm() {
        System.out.println("===== 구매 목록 출력 =====");
        System.out.println(fc.printBuyFarm());
    }
}
