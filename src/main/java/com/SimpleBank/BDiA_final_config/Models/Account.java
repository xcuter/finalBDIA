package com.SimpleBank.BDiA_final_config.Models;

import java.sql.Date;
import java.util.Calendar;
import java.util.concurrent.ThreadLocalRandom;


public class Account {
    private Long accountID;
    private Double ammount;
    private Date creationTime;
    public Account(){
        this.accountID = ThreadLocalRandom.current().nextLong(10000,1000000);
        this.ammount = 0.0d;
        creationTime = new Date(Calendar.getInstance().getTime().getTime());
    } //todo account constructor and model definition


    public Long getAccountID() {
        return this.accountID;
    }

    public Double getAmmount(){
        return this.ammount;
    }

    public Date getCreationTime(){
        return this.creationTime;
    }

    public void setAmmount(Double ammount){
        this.ammount+= ammount;
    }
}
