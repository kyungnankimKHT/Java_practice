package com.kh.practice.set.controller;

import com.kh.practice.set.model.vo.Lottery;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class LotteryController {
    private Set<Lottery> lottery = new HashSet<>();
    private Set<Lottery> win = new HashSet<>();

    public boolean insertObject(Lottery l) {
        return lottery.add(l);
    }

    public boolean deleteObject(Lottery l) {
        return lottery.remove(l);
    }

    public Set<Lottery> winObject() {
        return win;
    }

    public TreeSet<Lottery> sortedWinObject() {
        return new TreeSet<>(win);
    }

    public boolean searchWinner(Lottery l) {
        return win.contains(l);
    }
}
