package com.example.student.bai01_tuan23;

public class NhanVien {
    private String id;
    private String name;
    private boolean gender;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
    public NhanVien(){

    }
    @Override
    public String toString(){
        return this.id + "-" + this.name;
    }
}
