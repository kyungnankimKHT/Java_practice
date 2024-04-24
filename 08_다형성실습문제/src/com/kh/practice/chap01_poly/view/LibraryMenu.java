package com.kh.practice.chap01_poly.view;

import com.kh.practice.chap01_poly.controller.LibraryController;
import com.kh.practice.chap01_poly.model.vo.Book;
import com.kh.practice.chap01_poly.model.vo.Member;
import java.util.Scanner;

public class LibraryMenu {
    private LibraryController lc = new LibraryController();
    private Scanner sc = new Scanner(System.in);

    public void mainMenu() {
        while (true) {
            System.out.println("===== 메인 메뉴 =====");
            System.out.println("1. 도서 전체 목록 보기");
            System.out.println("2. 도서 검색");
            System.out.println("3. 도서 대여");
            System.out.println("4. 종료");
            System.out.print("메뉴 선택: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    selectAll();
                    break;
                case 2:
                    searchBook();
                    break;
                case 3:
                    rentBook();
                    break;
                case 4:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }

    public void selectAll() {
        Book[] books = lc.selectAll();
        System.out.println("===== 도서 전체 목록 =====");
        for (Book book : books) {
            if (book != null) {
                System.out.println(book);
            }
        }
    }

    public void searchBook() {
        System.out.print("검색할 제목 키워드를 입력하세요: ");
        String keyword = sc.nextLine();
        Book[] searchResult = lc.searchBook(keyword);
        if (searchResult.length == 0) {
            System.out.println("검색 결과가 없습니다.");
        } else {
            System.out.println("===== 검색 결과 =====");
            for (Book book : searchResult) {
                System.out.println(book);
            }
        }
    }

    public void rentBook() {
        System.out.print("대여할 도서 번호를 입력하세요: ");
        int index = sc.nextInt();
        int result = lc.rentBook(index);
        switch (result) {
            case 0:
                System.out.println("도서 대여가 완료되었습니다.");
                break;
            case 1:
                System.out.println("나이 제한으로 인해 대여할 수 없습니다.");
                break;
            case 2:
                System.out.println("요리학원 쿠폰이 발급되었습니다.");
                break;
            default:
                System.out.println("알 수 없는 오류가 발생했습니다.");
        }
    }
}
