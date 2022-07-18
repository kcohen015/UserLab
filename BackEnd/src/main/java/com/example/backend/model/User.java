package com.example.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    private int uid;
    private String  uName;
    private String pWord;

    public User() {
    }

    public User(int id, String uName, String pWord) {
        this.uid = uid;
        this.uName = uName;
        this.pWord = pWord;
    }

    public int getId() {
        return uid;
    }

    public void setId(int id) {
        this.uid = uid;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getpWord() {
        return pWord;
    }

    public void setpWord(String pWord) {
        this.pWord = pWord;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + uid +
                ", uName='" + uName + '\'' +
                ", pWord='" + pWord + '\'' +
                '}';
    }
}
