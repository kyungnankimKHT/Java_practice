package com.kh.practice.generics.controller;

import com.kh.practice.generics.model.vo.Farm;

import java.util.ArrayList;
import java.util.HashMap;

public class FarmController {
    private HashMap<Farm, Integer> hMap = new HashMap<>();
    private ArrayList<Farm> list = new ArrayList<>();

    public boolean addNewKind(Farm f, int amount) {
        if (!hMap.containsKey(f)) {
            hMap.put(f, amount);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeKind(Farm f) {
        if (hMap.containsKey(f)) {
            hMap.remove(f);
            return true;
        } else {
            return false;
        }
    }

    public boolean changeAmount(Farm f, int amount) {
        if (hMap.containsKey(f)) {
            hMap.put(f, amount);
            return true;
        } else {
            return false;
        }
    }

    public HashMap<Farm, Integer> printFarm() {
        return hMap;
    }

    public boolean buyFarm(Farm f) {
        if (hMap.containsKey(f)) {
            list.add(f);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeFarm(Farm f) {
        if (list.contains(f)) {
            list.remove(f);
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Farm> printBuyFarm() {
        return list;
    }
}
