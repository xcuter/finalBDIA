package com.SimpleBank.BDiA_final_config.Models;

public class User {
    private String firstName;
    private String lastName;
    private Long accountID;
    private String email;
    private String password;

    public User(){
        this.firstName=null;
        this.lastName=null;
        this.email=null;
        this.password=null;
        this.accountID=0L;
    }
    public User(String firstName, String lastName, String email, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }


    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getFullName(){
        return this.firstName + " " + this.lastName;
    }

    public String getPassword(){ return this.password;}

    public String getEmail(){return this.email;}

    public Long getAccountID(){return this.accountID;}



    public void setAccountID(Long accountID){this.accountID = accountID;}

    public void setPassword(String password){this.password = password;}
    public void setFirstName(String firstName){this.firstName = firstName;}
    public void setLastName(String lastName){this.lastName = lastName;}
    public void  setEmail(String email){this.email = email;}



}
