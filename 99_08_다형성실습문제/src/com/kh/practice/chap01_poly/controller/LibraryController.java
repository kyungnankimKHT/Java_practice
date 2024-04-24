package com.kh.practice.chap01_poly.controller;

import com.kh.practice.chap01_poly.model.vo.Book;
import com.kh.practice.chap01_poly.model.vo.Member;
import java.util.Arrays;

public class LibraryController {
    private Member mem;
    private Book[] bList = new Book[5];

    public void insertMember(Member mem) {
        this.mem = mem;
    }

    public Member myInfo() {
        return mem;
    }

    public Book[] selectAll() {
        return bList;
    }

    public Book[] searchBook(String keyword) {
        Book[] searchResult = new Book[5];
        int count = 0;
        for (Book book : bList) {
            if (book.getTitle().contains(keyword)) {
                searchResult[count++] = book;
            }
        }

        return Arrays.copyOfRange(searchResult, 0, count);
    }

    public int rentBook(int index) {
        if (bList[index] instanceof com.kh.practice.chap01_poly.model.vo.AniBook) {
            com.kh.practice.chap01_poly.model.vo.AniBook aniBook = (com.kh.practice.chap01_poly.model.vo.AniBook) bList[index];
            if (mem.getAge() < aniBook.getAccessAge()) {
                return 1;
            }
        } else if (bList[index] instanceof com.kh.practice.chap01_poly.model.vo.CookBook) {
            com.kh.practice.chap01_poly.model.vo.CookBook cookBook = (com.kh.practice.chap01_poly.model.vo.CookBook) bList[index];
            if (cookBook.isCoupon()) {
                mem.setCouponCount(mem.getCouponCount() + 1);
                return 2;
            }
        }

        return 0;
    }
}
