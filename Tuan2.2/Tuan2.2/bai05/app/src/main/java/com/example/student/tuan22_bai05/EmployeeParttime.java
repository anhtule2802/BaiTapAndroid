package com.example.student.tuan22_bai05;

public class EmployeeParttime extends Employee {

    @Override
    public double TinhLuong() {
        return 150;
    }

    @Override
    public String toString() {
        return super.toString() + " --> Part Time =" + TinhLuong();
    }
}
