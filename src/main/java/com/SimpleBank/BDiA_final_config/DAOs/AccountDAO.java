package com.SimpleBank.BDiA_final_config.DAOs;

import com.SimpleBank.BDiA_final_config.Models.Account;
import com.SimpleBank.BDiA_final_config.queries.Queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AccountDAO extends BaseDAO{
    public Long createAccount() throws SQLException {
        Account account = new Account();
        try(Connection connection = getConnection()){
            PreparedStatement statement = connection.prepareStatement(Queries.selectAccountID);
            statement.setLong(1,account.getAccountID());
            statement.execute();
            ResultSet set = statement.getResultSet();
            statement = connection.prepareStatement(Queries.createAcoount);
            if(!set.wasNull()){
                statement.setLong(1 , account.getAccountID());
                statement.setDouble(2 , account.getAmmount());
                statement.setDate(3, account.getCreationTime());
                statement.execute();
                return account.getAccountID();
            }
        }
        return null;
    }
}
