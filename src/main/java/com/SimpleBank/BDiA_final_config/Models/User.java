package com.SimpleBank.BDiA_final_config.Models;

public class User {
    private Long Id;
    private String firstName;
    private String lastName;
    private Long   accountID;
    private String email;
    private String password;
    private Integer userRole;

    public User(String firstName, String lastName, String email, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public Long getId(){
        return this.Id;
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

    public Integer getUserRole(){return this.userRole;}

    public void setId(Long id){this.Id = id;}

    public void setAccountID(Long accountID){this.accountID = accountID;}

    public void setPassword(String password){this.password = password;}

    public void setUserRole (Integer userRole){this.userRole = 1;}

}
