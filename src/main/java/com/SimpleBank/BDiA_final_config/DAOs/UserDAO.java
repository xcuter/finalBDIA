package com.SimpleBank.BDiA_final_config.DAOs;

import com.SimpleBank.BDiA_final_config.Models.User;
import com.SimpleBank.BDiA_final_config.queries.Queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;



public class UserDAO extends BaseDAO {

        public void save(User user){
            saveUser(user);
            saveUserRole(user);
            //  createAccount();
        }

        private void saveUserRole(User user){
            try(Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(Queries.saveUserRoleQuery)) {
                statement.setString(1, user.getEmail());
                statement.execute();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        private void saveUser(User user) {
            try(Connection connection = getConnection();
                PreparedStatement statement =connection.prepareStatement(Queries.saveUserQuery, Statement.RETURN_GENERATED_KEYS)) {
                System.out.println(Queries.saveUserQuery);
                statement.setString(1, user.getEmail());
                statement.setString(2, user.getPassword());
                Random rnd = new Random(); //todo account generation and assignment
                statement.setLong(3, rnd.nextLong());
                statement.setString(4, user.getFirstName());
                statement.setString(5, user.getLastName());
                System.out.println(statement);
                statement.execute();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

