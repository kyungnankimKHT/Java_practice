package com.kh.hw.member.view;

import com.kh.hw.member.controller.MemberController;
import com.kh.hw.member.model.vo.Member;

import java.util.Scanner;

public class MemberMenu {
    private Scanner sc = new Scanner(System.in);
    private MemberController mc = new MemberController();

    public MemberMenu() {}

    public void mainMenu() {
        while (true) {
            System.out.println("===== 회원 관리 프로그램 =====");
            System.out.println("1. 회원 등록");
            System.out.println("2. 회원 검색");
            System.out.println("3. 회원 정보 수정");
            System.out.println("4. 회원 삭제");
            System.out.println("5. 전체 회원 출력");
            System.out.println("0. 프로그램 종료");
            System.out.print("메뉴 선택: ");
            int menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1:
                    insertMember();
                    break;
                case 2:
                    searchMember();
                    break;
                case 3:
                    updateMember();
                    break;
                case 4:
                    deleteMember();
                    break;
                case 5:
                    printAll();
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }

    public void insertMember() {
        System.out.print("ID: ");
        String id = sc.nextLine();
        if (mc.checkId(id)) {
            System.out.println("이미 존재하는 ID입니다.");
            return;
        }
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Gender (M/F): ");
        char gender = sc.nextLine().charAt(0);
        System.out.print("Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        mc.insertMember(id, name, password, email, gender, age);
        System.out.println("회원 등록이 완료되었습니다.");
    }

    public void searchMember() {
        while (true) {
            System.out.println("===== 회원 검색 =====");
            System.out.println("1. ID 검색");
            System.out.println("2. 이름 검색");
            System.out.println("3. 이메일 검색");
            System.out.println("0. 이전 메뉴로 돌아가기");
            System.out.print("메뉴 선택: ");
            int menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1:
                    searchId();
                    break;
                case 2:
                    searchName();
                    break;
                case 3:
                    searchEmail();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }

    public void searchId() {
        System.out.print("검색할 ID를 입력하세요: ");
        String id = sc.nextLine();
        String result = mc.searchId(id);
        System.out.println(result);
    }

    public void searchName() {
        System.out.print("검색할 이름을 입력하세요: ");
        String name = sc.nextLine();
        System.out.println("===== 검색 결과 =====");
        for (int i = 0; i < mc.existMemberNum(); i++) {
            if (mc.printAll()[i].getName().equals(name)) {
                System.out.println(mc.printAll()[i].inform());
            }
        }
    }

    public void searchEmail() {
        System.out.print("검색할 이메일을 입력하세요: ");
        String email = sc.nextLine();
        System.out.println("===== 검색 결과 =====");
        for (int i = 0; i < mc.existMemberNum(); i++) {
            if (mc.printAll()[i].getEmail().equals(email)) {
                System.out.println(mc.printAll()[i].inform());
            }
        }
    }

    public void updateMember() {
        while (true) {
            System.out.println("===== 회원 정보 수정 =====");
            System.out.println("1. 비밀번호 수정");
            System.out.println("2. 이름 수정");
            System.out.println("3. 이메일 수정");
            System.out.println("0. 이전 메뉴로 돌아가기");
            System.out.print("메뉴 선택: ");
            int menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1:
                    updatePassword();
                    break;
                case 2:
                    updateName();
                    break;
                case 3:
                    updateEmail();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }

    public void updatePassword() {
        System.out.print("비밀번호를 수정할 ID를 입력하세요: ");
        String id = sc.nextLine();
        System.out.print("새로운 비밀번호를 입력하세요: ");
        String password = sc.nextLine();
        boolean result = mc.updatePassword(id, password);
        if (result) {
            System.out.println("비밀번호가 수정되었습니다.");
        } else {
            System.out.println("해당 ID를 찾을 수 없습니다.");
        }
    }

    public void updateName() {
        System.out.print("이름을 수정할 ID를 입력하세요: ");
        String id = sc.nextLine();
        System.out.print("새로운 이름을 입력하세요: ");
        String name = sc.nextLine();
        boolean result = mc.updateName(id, name);
        if (result) {
            System.out.println("이름이 수정되었습니다.");
        } else {
            System.out.println("해당 ID를 찾을 수 없습니다.");
        }
    }

    public void updateEmail() {
        System.out.print("이메일을 수정할 ID를 입력하세요: ");
        String id = sc.nextLine();
        System.out.print("새로운 이메일을 입력하세요: ");
        String email = sc.nextLine();
        boolean result = mc.updateEmail(id, email);
        if (result) {
            System.out.println("이메일이 수정되었습니다.");
        } else {
            System.out.println("해당 ID를 찾을 수 없습니다.");
        }
    }

    public void deleteMember() {
        while (true) {
            System.out.println("===== 회원 삭제 =====");
            System.out.println("1. 한 명 삭제");
            System.out.println("2. 전체 삭제");
            System.out.println("0. 이전 메뉴로 돌아가기");
            System.out.print("메뉴 선택: ");
            int menu = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (menu) {
                case 1:
                    deleteOne();
                    break;
                case 2:
                    deleteAll();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }

    public void deleteOne() {
        System.out.print("삭제할 회원의 ID를 입력하세요: ");
        String id = sc.nextLine();
        boolean result = mc.delete(id);
        if (result) {
            System.out.println("회원이 삭제되었습니다.");
        } else {
            System.out.println("해당 ID를 찾을 수 없습니다.");
        }
    }

    public void deleteAll() {
        mc.delete();
        System.out.println("전체 회원이 삭제되었습니다.");
    }

    public void printAll() {
        System.out.println("===== 전체 회원 목록 =====");
        Member[] members = mc.printAll();
        for (int i = 0; i < mc.existMemberNum(); i++) {
            System.out.println(members[i].inform());
        }
    }
}
