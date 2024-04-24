package com.kh.practice.map.controller;

import com.kh.practice.map.model.vo.Member;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MemberController {
    private Map<String, Member> map = new HashMap<>();

    public boolean joinMembership(String id, Member m) {
        if (!map.containsKey(id)) {
            map.put(id, m);
            return true;
        } else {
            return false;
        }
    }

    public String logIn(String id, String password) {
        if (map.containsKey(id)) {
            Member m = map.get(id);
            if (m.getPassword().equals(password)) {
                return m.getName();
            }
        }
        return null;
    }

    public boolean changePassword(String id, String oldPw, String newPw) {
        if (map.containsKey(id)) {
            Member m = map.get(id);
            if (m.getPassword().equals(oldPw)) {
                m.setPassword(newPw);
                return true;
            }
        }
        return false;
    }

    public void changeName(String id, String newName) {
        if (map.containsKey(id)) {
            Member m = map.get(id);
            m.setName(newName);
        }
    }

    public TreeMap<String, String> sameName(String name) {
        TreeMap<String, String> sameNameMap = new TreeMap<>();
        map.forEach((k, v) -> {
            if (v.getName().equals(name)) {
                sameNameMap.put(k, v.getPassword());
            }
        });
        return sameNameMap;
    }
}
