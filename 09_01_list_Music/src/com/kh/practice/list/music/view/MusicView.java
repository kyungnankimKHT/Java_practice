package com.kh.practice.list.music.view;

import com.kh.practice.list.music.controller.MusicController;
import com.kh.practice.list.music.model.vo.Music;

import java.util.Scanner;

public class MusicView {
    private Scanner sc = new Scanner(System.in);
    private MusicController mc = new MusicController();

    public void mainMenu() {
        while (true) {
            System.out.println("===== 음악 관리 프로그램 =====");
            System.out.println("1. 음악 추가");
            System.out.println("2. 첫 번째 위치에 음악 추가");
            System.out.println("3. 음악 전체 목록");
            System.out.println("4. 음악 검색");
            System.out.println("5. 음악 삭제");
            System.out.println("6. 음악 수정");
            System.out.println("7. 음악 제목 오름차순 정렬");
            System.out.println("8. 음악 가수명 내림차순 정렬");
            System.out.println("9. 프로그램 종료");
            System.out.print("메뉴 선택 : ");
            int menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1:
                    addList();
                    break;
                case 2:
                    addAtZero();
                    break;
                case 3:
                    printAll();
                    break;
                case 4:
                    searchMusic();
                    break;
                case 5:
                    removeMusic();
                    break;
                case 6:
                    setMusic();
                    break;
                case 7:
                    ascTitle();
                    break;
                case 8:
                    descSinger();
                    break;
                case 9:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }

    public void addList() {
        System.out.print("곡명 : ");
        String title = sc.nextLine();
        System.out.print("가수명 : ");
        String singer = sc.nextLine();

        Music music = new Music(title, singer);
        int result = mc.addList(music);

        if (result > 0) {
            System.out.println("곡 추가 성공!");
        } else {
            System.out.println("곡 추가 실패!");
        }
    }

    public void addAtZero() {
        System.out.print("곡명 : ");
        String title = sc.nextLine();
        System.out.print("가수명 : ");
        String singer = sc.nextLine();

        Music music = new Music(title, singer);
        int result = mc.addAtZero(music);

        if (result > 0) {
            System.out.println("첫 위치에 곡 추가 성공!");
        } else {
            System.out.println("첫 위치에 곡 추가 실패!");
        }
    }

    public void printAll() {
        System.out.println("===== 음악 전체 목록 =====");
        for (Music music : mc.printAll()) {
            System.out.println(music);
        }
    }

    public void searchMusic() {
        System.out.print("검색할 곡명 : ");
        String title = sc.nextLine();
        Music music = mc.searchMusic(title);

        if (music != null) {
            System.out.println("검색 결과 : " + music);
        } else {
            System.out.println("검색 결과가 없습니다.");
        }
    }

    public void removeMusic() {
        System.out.print("삭제할 곡명 : ");
        String title = sc.nextLine();
        Music music = mc.removeMusic(title);

        if (music != null) {
            System.out.println("삭제 성공 : " + music);
        } else {
            System.out.println("삭제할 곡이 없습니다.");
        }
    }

    public void setMusic() {
        System.out.print("수정할 곡명 : ");
        String title = sc.nextLine();
        System.out.print("새로운 가수명 : ");
        String singer = sc.nextLine();

        Music music = new Music(title, singer);
        Music prevMusic = mc.setMusic(title, music);

        if (prevMusic != null) {
            System.out.println("수정 성공 : " + prevMusic + " -> " + music);
        } else {
            System.out.println("수정할 곡이 없습니다.");
        }
    }

    public void ascTitle() {
        int result = mc.ascTitle();
        if (result > 0) {
            System.out.println("곡명 오름차순 정렬 성공!");
        } else {
            System.out.println("정렬할 곡이 없습니다.");
        }
    }

    public void descSinger() {
        int result = mc.descSinger();
        if (result > 0) {
            System.out.println("가수명 내림차순 정렬 성공!");
        } else {
            System.out.println("정렬할 곡이 없습니다.");
        }
    }
}
