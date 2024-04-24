package com.kh.hw.member.controller;

import com.kh.hw.member.model.vo.Member;

public class MemberController {
    private static final int SIZE = 10;
    private Member[] members = new Member[SIZE];
    private int memberCount = 0;

    public int existMemberNum() {
        return memberCount;
    }

    public boolean checkId(String inputId) {
        for (int i = 0; i < memberCount; i++) {
            if (members[i].getId().equals(inputId)) {
                return true;
            }
        }
        return false;
    }

    public void insertMember(String id, String name, String password, String email, char gender, int age) {
        if (memberCount < SIZE) {
            members[memberCount++] = new Member(id, name, password, email, gender, age);
        } else {
            System.out.println("더 이상 회원을 추가할 수 없습니다.");
        }
    }

    public String searchId(String id) {
        for (int i = 0; i < memberCount; i++) {
            if (members[i].getId().equals(id)) {
                return members[i].inform();
            }
        }
        return "해당 ID의 회원이 존재하지 않습니다.";
    }

    public Member[] searchName(String name) {
        Member[] result = new Member[SIZE];
        int count = 0;
        for (int i = 0; i < memberCount; i++) {
            if (members[i].getName().equals(name)) {
                result[count++] = members[i];
            }
        }
        return result;
    }

    public Member[] searchEmail(String email) {
        Member[] result = new Member[SIZE];
        int count = 0;
        for (int i = 0; i < memberCount; i++) {
            if (members[i].getEmail().equals(email)) {
                result[count++] = members[i];
            }
        }
        return result;
    }

    public boolean updatePassword(String id, String password) {
        for (int i = 0; i < memberCount; i++) {
            if (members[i].getId().equals(id)) {
                members[i].setPassword(password);
                return true;
            }
        }
        return false;
    }

    public boolean updateName(String id, String name) {
        for (int i = 0; i < memberCount; i++) {
            if (members[i].getId().equals(id)) {
                members[i].setName(name);
                return true;
            }
        }
        return false;
    }

    public boolean updateEmail(String id, String email) {
        for (int i = 0; i < memberCount; i++) {
            if (members[i].getId().equals(id)) {
                members[i].setEmail(email);
                return true;
            }
        }
        return false;
    }

    public boolean delete(String id) {
        for (int i = 0; i < memberCount; i++) {
            if (members[i].getId().equals(id)) {
                members[i] = members[memberCount - 1];
                members[memberCount - 1] = null;
                memberCount--;
                return true;
            }
        }
        return false;
    }

    public void delete() {
        members = new Member[SIZE];
        memberCount = 0;
    }

    public Member[] printAll() {
        Member[] result = new Member[memberCount];
        System.arraycopy(members, 0, result, 0, memberCount);
        return result;
    }
}
