package com.kh.practice.list.music.controller;

import com.kh.practice.list.music.model.compare.AscTitle;
import com.kh.practice.list.music.model.vo.Music;

import java.util.ArrayList;
import java.util.List;

public class MusicController {
    private List<Music> list = new ArrayList<>();

    public int addList(Music music) {
        list.add(music);
        return list.size();
    }

    public int addAtZero(Music music) {
        list.add(0, music);
        return list.size();
    }

    public List<Music> printAll() {
        return list;
    }

    public Music searchMusic(String title) {
        for (Music music : list) {
            if (music.getTitle().equals(title)) {
                return music;
            }
        }
        return null;
    }

    public Music removeMusic(String title) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTitle().equals(title)) {
                return list.remove(i);
            }
        }
        return null;
    }

    public Music setMusic(String title, Music music) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTitle().equals(title)) {
                return list.set(i, music);
            }
        }
        return null;
    }

    public int ascTitle() {
        list.sort(new AscTitle());
        return list.size();
    }

    public int descSinger() {
        list.sort((o1, o2) -> o2.getSinger().compareTo(o1.getSinger()));
        return list.size();
    }
}
