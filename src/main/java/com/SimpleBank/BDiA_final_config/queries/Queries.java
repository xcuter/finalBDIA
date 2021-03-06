package com.SimpleBank.BDiA_final_config.queries;

public class Queries {
    public static final String saveUserQuery = "INSERT INTO users (email, password, account_id, firstname, lastname) VALUES (?,?,?,?,?)";
    public static final String saveUserRoleQuery = "INSERT INTO user_role (email, role) VALUES (?,'USER')";
    public static final String selectAccountID = "SELECT account_id FROM accounts WHERE account_id = (?)";
    public static final String createAcoount = "INSERT INTO accounts (account_id, ammount, creation_date) VALUES (?,?,?) ";
    public static final String logOperation = "INSERT INTO operations (uuid, operation_name,time_stamp,toAccount,ammount) VALUES (?,?,?,?,?)";
    public static final String addAmmount = "UPDATE accounts SET ammount = ammount+(?) WHERE account_id = (?)";
    public static final String selectUser = "SELECT account_id AS account, firstname AS firstn, lastname AS lastn FROM users WHERE email = (?)";
    public static final String selectAmmount = "SELECT (ammount) AS ammount FROM accounts WHERE account_id= (?)";
}
