package com.SimpleBank.BDiA_final_config.queries;

public class Queries {
    public static final String saveUserQuery = "INSERT INTO users (email, password, account_id, firstname, lastname) VALUES (?,?,?,?,?)";
    public static final String saveUserRoleQuery = "INSERT INTO user_role (email, role) VALUES (?,'USER')";
    public static final String selectAccountID = "SELECT account_id FROM accounts WHERE account_id = (?)";
    public static final String createAcoount = "INSERT INTO accounts (account_id, ammount, creation_date) VALUES (?,?,?) ";
}
