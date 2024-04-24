package com.kh.practice.set.model.compare;

import com.kh.practice.set.model.vo.Lottery;

import java.util.Comparator;

public class SortedLottery implements Comparator<Lottery> {
    @Override
    public int compare(Lottery o1, Lottery o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
