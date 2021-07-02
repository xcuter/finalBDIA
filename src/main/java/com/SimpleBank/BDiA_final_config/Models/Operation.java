package com.SimpleBank.BDiA_final_config.Models;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

public class Operation {
    private UUID uuid;
    private String operationName;
    private Date timeStamp;
    private String toAccount;
    private Double ammount;

    public Operation(){
        this.uuid = UUID.randomUUID();
        this.operationName = "null";
        this.timeStamp.getTime();
        this.toAccount = "null";

    }

    public UUID getUuid() {
        return uuid;
    }

    public String getOperationName(){
        return this.operationName;
    }

    public String getToAccount(){
        return this.toAccount;
    }
}
