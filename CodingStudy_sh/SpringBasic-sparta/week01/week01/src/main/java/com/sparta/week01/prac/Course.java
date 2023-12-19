package com.sparta.week01.prac;

public class Course {
    private String title;
    private String tutor;
    private int days;

    /**
     * Course 기본 생성자
     */
    public Course() {

    }

    /**
     * Course 생성자
     */
    public Course(String title, String tutor, int days) {
        this.title = title;
        this.tutor = tutor;
        this.days = days;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public void setDays(int days) {
        this.days = days;
    }
    public String getTitle() {
        return title;
    }

    public String getTutor() {
        return tutor;
    }

    public int getDays() {
        return days;
    }

}
