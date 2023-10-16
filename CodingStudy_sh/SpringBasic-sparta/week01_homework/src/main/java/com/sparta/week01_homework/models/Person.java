package com.sparta.week01_homework.models;

public class Person {
    private String name;
    private String address;
    private int age;
    private String job;

    //getter
    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public int getAge() {
        return this.age;
    }

    public String getJob() {
        return this.job;
    }

    //setter
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
