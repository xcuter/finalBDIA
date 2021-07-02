package com.SimpleBank.BDiA_final_config.DAOs;

import com.SimpleBank.BDiA_final_config.Models.Account;
import com.SimpleBank.BDiA_final_config.Models.Operation;
import com.SimpleBank.BDiA_final_config.Models.User;

import java.sql.Connection;
import java.sql.SQLException;

public class OperationDAO extends BaseDAO{
        public void logOperation(User user, Account account) throws SQLException {
            Operation operation = new Operation();
            try(Connection connection = getConnection()) {

            }
        }
}
