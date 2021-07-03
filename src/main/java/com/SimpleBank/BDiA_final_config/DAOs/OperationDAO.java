package com.SimpleBank.BDiA_final_config.DAOs;

import com.SimpleBank.BDiA_final_config.Models.Account;
import com.SimpleBank.BDiA_final_config.Models.Operation;
import com.SimpleBank.BDiA_final_config.Models.User;
import com.SimpleBank.BDiA_final_config.queries.Queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OperationDAO extends BaseDAO{
        public void logOperation(User user, Long toAccount, String operationName) throws SQLException {
            Operation operation = new Operation();
            try(Connection connection = getConnection()) {
                PreparedStatement operationLog = connection.prepareStatement(Queries.logOperation);
                operationLog.setString(1, operation.getUuid().toString());
                operationLog.setString(2, operation.getOperationName());
                operationLog.setDate(3, operation.getTimeStamp());
                operationLog.setString(4, operation.getToAccount());
                operationLog.setDouble(5, operation.getAmmount());
                operationLog.execute();
            }
        }
}
