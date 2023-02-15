package com.example.saqbaq;

public class Student {

    private int id;
    private String name;
    private String rollNo;
    private int sabaq;
    private int sabqi;
    private int manzil;

    public Student(int id, String name, String rollNo, int sabaq, int sabqi, int manzil) {
        this.id = id;
        this.name = name;
        this.rollNo = rollNo;
        this.sabaq = sabaq;
        this.sabqi = sabqi;
        this.manzil = manzil;
    }

    public Student() {
        this.id = 0;
        this.name = "";
        this.rollNo = "";
        this.sabaq = 0;
        this.sabqi = 0;
        this.manzil = 0;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public int getSabaq() {
        return sabaq;
    }

    public void setSabaq(int sabaq) {
        this.sabaq = sabaq;
    }

    public int getSabqi() {
        return sabqi;
    }

    public void setSabqi(int sabqi) {
        this.sabqi = sabqi;
    }

    public int getManzil() {
        return manzil;
    }

    public void setManzil(int manzil) {
        this.manzil = manzil;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", rollNo='" + rollNo + '\'' +
                ", sabaq=" + sabaq +
                ", sabqi=" + sabqi +
                ", manzil=" + manzil;
    }
}
