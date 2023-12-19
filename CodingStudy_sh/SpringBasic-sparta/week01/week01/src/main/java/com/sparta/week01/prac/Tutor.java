package com.sparta.week01.prac;

public class Tutor {
    private String name;
    private int bio;

    public Tutor() {
        // new Tutor를 이용할수 잇도록 해주는 기본 생성자이다.
    }

    /** name,bio받는 생성자*/
    public Tutor(String name, int bio) {
        this.name = name;
        this.bio = bio;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBio(int bio) {
        this.bio = bio;
    }

    public String getName() {
        return this.name;
    }

    public int getBio() {
        return this.bio;
    }
}
