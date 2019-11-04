package com.example.doanandroid;

import java.util.Date;
import java.util.Timer;

public class DetailTable {
    private int maDetail;
    private int maTable;
    private String Day;
    private String contentDetail;
    private String time;

    public DetailTable(int maDetail, int maTable, String day, String contentDetail, String time) {
        this.maDetail = maDetail;
        this.maTable = maTable;
        Day = day;
        this.contentDetail = contentDetail;
        this.time = time;
    }

    public DetailTable() {
    }
    public DetailTable(String contentDetail,String time,int maDetail){
        this.contentDetail = contentDetail;
        this.time = time;
        this.maDetail = maDetail;
    }
    @Override
    public String toString() {
        return "DetailTable{" +
                "maDetail=" + maDetail +
                ", maTable=" + maTable +
                ", Day='" + Day + '\'' +
                ", contentDetail='" + contentDetail + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public int getMaDetail() {
        return maDetail;
    }

    public void setMaDetail(int maDetail) {
        this.maDetail = maDetail;
    }

    public int getMaTable() {
        return maTable;
    }

    public void setMaTable(int maTable) {
        this.maTable = maTable;
    }

    public String getDay() {
        return Day;
    }

    public void setDay(String day) {
        Day = day;
    }

    public String getContentDetail() {
        return contentDetail;
    }

    public void setContentDetail(String contentDetail) {
        this.contentDetail = contentDetail;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
