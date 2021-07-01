package com.SimpleBank.BDiA_final_config.Models;

public class UserRegistration {
    private String FirstName;
    private String LastName;
    private String email;
    private String password;

    public UserRegistration(String firstName, String lastName, String email , String password) {
        this.FirstName = firstName;
        this.LastName = lastName;
        this.email = email;
        this.password = password;

    }

    public String getFirstName() {
        return this.FirstName;
    }


    public String getLastName() {
        return this.LastName;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }
}
