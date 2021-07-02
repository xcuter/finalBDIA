package com.SimpleBank.BDiA_final_config.DAOs;

import com.SimpleBank.BDiA_final_config.Models.Account;
import com.SimpleBank.BDiA_final_config.queries.Queries;

import java.sql.*;


public class AccountDAO extends BaseDAO{
    /*public Long createAccount() throws SQLException {
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
    }*/

    //todo with transaction

    public Long createAccount() throws SQLException {
        Account account = new Account();
        try(Connection connection = getConnection()){
            PreparedStatement createAccountID = connection.prepareStatement(Queries.createAcoount);
            createAccountID.setLong(1 , account.getAccountID());
            createAccountID.setDouble(2, account.getAmmount());
            createAccountID.setDate(3, account.getCreationTime());
            connection.setAutoCommit(false);
              while (!isNull(account)){
                    account.setNewAccountId();
              }
              createAccountID.execute();
              connection.commit();
              connection.setAutoCommit(true);
        }
        return account.getAccountID();
    }

    private boolean isNull(Account account) throws SQLException {
        try (Connection connection = getConnection()){
            PreparedStatement selectAccountID = connection.prepareStatement(Queries.selectAccountID);
            selectAccountID.setLong(1, account.getAccountID());
            selectAccountID.execute();
            ResultSet resultSet = selectAccountID.getResultSet();
            if (resultSet.wasNull()){
                return true;
            }
        }
        return false;
    }
}
