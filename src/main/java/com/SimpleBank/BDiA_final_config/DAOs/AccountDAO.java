package com.SimpleBank.BDiA_final_config.DAOs;

import com.SimpleBank.BDiA_final_config.Models.Account;
import com.SimpleBank.BDiA_final_config.queries.Queries;

import java.sql.*;


public class AccountDAO extends BaseDAO{

    public Account createAccount() throws SQLException {
        Account account = new Account();
        try(Connection connection = getConnection()){
            PreparedStatement createAccountID = connection.prepareStatement(Queries.createAcoount);
            createAccountID.setLong(1 , account.getAccountID());
            createAccountID.setDouble(2, account.getAmmount());
            createAccountID.setDate(3, account.getCreationTime());
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            int maxCount = 0;
              while (isNull(account) || (maxCount == 10)){
                    account.setNewAccountId();
                    maxCount++;
              }
              createAccountID.execute();
              connection.commit();
              connection.setAutoCommit(true);
              connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        }
        return account;
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
