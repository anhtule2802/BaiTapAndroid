package com.example.student.sqllitedemo;

public class Author {
    private int Id;
    private String Name;
    private String Address;
    private String Email;

    public void setAddress(String address) {
        Address = address;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getId() {
        return Id;
    }

    public String getAddress() {
        return Address;
    }

    public String getEmail() {
        return Email;
    }

    public String getName() {
        return Name;
    }
    public Author(){
        this.Id = 0;
        this.Address = "";
        this.Email = "";
        this.Name = "";
    }
    public Author(int Id,String Name,String Address,String Email){
        this.Id = Id;
        this.Name = Name;
        this.Address = Address;
        this.Email = Email;
    }
    @Override
    public String toString() {
        return "Author{" +
                "id=" + Id +
                ", name='" + Name + '\'' +
                ", address='" + Address + '\'' +
                ", email='" + Email + '\'' +
                '}';
    }
}
