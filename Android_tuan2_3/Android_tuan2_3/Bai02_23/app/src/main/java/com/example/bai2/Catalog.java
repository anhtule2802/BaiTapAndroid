package com.example.bai2;

import java.util.ArrayList;

public class Catalog extends Goods {
    private ArrayList<Product> listSp=null;
    public Catalog(String ma, String name){
        super(ma,name);
        this.listSp = new ArrayList<>();
    }
    public Catalog(){
        super();
        this.listSp = new ArrayList<>();
    }

    public Boolean isDuplicate(Product p)
    {
        for(Product p1 : listSp)
        {
            if(p1.getId().trim().equalsIgnoreCase(p.getId().trim()))
                return true;

        }
        return false;
    }
    public Boolean addProduct(Product p){
        boolean duplicate = isDuplicate(p);
        if(!duplicate)
        {
            p.setDmuc(this);
            return listSp.add(p);
        }
        return !duplicate;
    }

    public ArrayList<Product> getListSp() {
        return listSp;
    }
    public int size(){
        return listSp.size();
    }
    public Product get(int i)
    {
        return listSp.get(i);
    }
}
