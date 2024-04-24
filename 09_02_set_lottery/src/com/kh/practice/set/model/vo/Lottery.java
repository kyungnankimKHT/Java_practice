package com.kh.practice.set.model.vo;

import java.util.Objects;

public class Lottery implements Comparable<Lottery> {
    private String name;
    private String phone;

    public Lottery() {
    }

    public Lottery(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Lottery{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phone);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Lottery lottery = (Lottery) obj;
        return Objects.equals(name, lottery.name) && Objects.equals(phone, lottery.phone);
    }

    @Override
    public int compareTo(Lottery o) {
        return this.name.compareTo(o.name);
    }
}
