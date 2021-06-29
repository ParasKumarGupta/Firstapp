package com.example.firstapp;

public class UserDataR {

    public UserDataR(){

    }
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public UserDataR(String name,String password){
        this.name=name;
        this.password=password;
    }
    public UserDataR(String name,String password,String email){
        this.name=name;
        this.password=password;
        this.email=email;
    }

    private String password;
    private String email;

}
