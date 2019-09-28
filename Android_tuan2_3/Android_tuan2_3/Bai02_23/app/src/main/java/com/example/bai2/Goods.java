package com.example.bai2;

public class Goods {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Goods(String id,String name){
        super();
        this.name = name;
        this.id = id;
    }
    public  Goods(){
        super();
    }
    public String toString(){
        return this.id + "-" + this.name;
    }
}
