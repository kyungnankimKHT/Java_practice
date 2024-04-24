package com.kh.practice.list.music.model.compare;

import com.kh.practice.list.music.model.vo.Music;

import java.util.Comparator;

public class AscTitle implements Comparator<Music> {
    @Override
    public int compare(Music o1, Music o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }
}
