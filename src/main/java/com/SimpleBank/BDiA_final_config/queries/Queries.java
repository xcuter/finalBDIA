package com.SimpleBank.BDiA_final_config.queries;

public class Queries {
    public static final String saveUserQuery = "INSERT INTO users (email, password, account_id, firstname, lastname) VALUES (?,?,?,?,?)";
    public static final String saveUserRoleQuery = "INSERT INTO user_role (email, role) VALUES (?,'USER')";
}
