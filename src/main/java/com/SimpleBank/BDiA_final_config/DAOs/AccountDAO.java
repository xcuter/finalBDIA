package com.SimpleBank.BDiA_final_config.DAOs;

import com.SimpleBank.BDiA_final_config.Models.Account;
import com.SimpleBank.BDiA_final_config.Models.Operation;
import com.SimpleBank.BDiA_final_config.Models.User;
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

    public double getAmmount(Long accountID) throws SQLException {
        double ammount = 0.0d;
        try(Connection connection = getConnection()) {
            PreparedStatement ammountGet = connection.prepareStatement(Queries.selectAmmount);
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            ammountGet.setLong(1, accountID);
            ResultSet rs = ammountGet.executeQuery();
            while (rs.next()){
                ammount = rs.getDouble("ammount");
            }
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        }
        return ammount;
    }

    public void addAmmount(User user,Double ammountToAdd) {
       // Operation operation = new Operation();
        OperationDAO operationDAO = new OperationDAO();
        try(Connection connection = getConnection()){
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            Savepoint savepoint = connection.setSavepoint();
            try(PreparedStatement ammountADD = connection.prepareStatement(Queries.addAmmount);
                PreparedStatement operationADD = connection.prepareStatement(Queries.logOperation)
                ){
                ammountADD.setDouble(1, ammountToAdd);
                ammountADD.setLong(2,user.getAccountID());
                     //todo  operationDAO.logOperation(user,);
                ammountADD.executeUpdate();
                connection.commit();

            }catch (SQLException e){
                e.printStackTrace();
               if(connection!=null){
                   try {
                       connection.rollback(savepoint);
                   }catch (Exception ex){
                       ex.printStackTrace();
                   }
               }
            }
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            connection.setAutoCommit(true);
            } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    }

