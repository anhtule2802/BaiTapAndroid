package com.example.doanandroid;

public class TableCongViec {
    private int maTable;
    private String nameTable;

    public TableCongViec() {
    }
    public TableCongViec(int maTable, String nameTable) {
        this.maTable = maTable;
        this.nameTable = nameTable;
    }

    @Override
    public String toString() {
        return "TableCongViec{" +
                "maTable=" + maTable +
                ", nameTable='" + nameTable + '\'' +
                '}';
    }
    public void setMaTable(int maTable) {
        this.maTable = maTable;
    }

    public void setNameTable(String nameTable) {
        this.nameTable = nameTable;
    }

    public int getMaTable() {
        return maTable;
    }

    public String getNameTable() {
        return nameTable;
    }
}
