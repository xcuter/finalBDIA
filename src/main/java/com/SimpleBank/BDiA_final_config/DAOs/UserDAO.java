package com.SimpleBank.BDiA_final_config.DAOs;

import com.SimpleBank.BDiA_final_config.Models.User;
import com.SimpleBank.BDiA_final_config.queries.Queries;

import java.sql.*;


public class UserDAO extends BaseDAO {

        public void save(User user){
            saveUser(user);
            saveUserRole(user);
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
                statement.setString(1, user.getEmail());
                statement.setString(2, user.getPassword());
                statement.setLong(3, user.getAccountID());
                statement.setString(4, user.getFirstName());
                statement.setString(5, user.getLastName());
                statement.execute();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        public void updateAmmount(String email) throws SQLException {
            getUserInfo(email);
        }

        public void getUserInfo(String email) throws SQLException {
            User user;
            try (Connection connection = getConnection()) {
                PreparedStatement userSelect = connection.prepareStatement(Queries.selectUser);
                userSelect.setString(1, email);
                userSelect.execute();
                ResultSet set = userSelect.getResultSet();
                while (set.next()){
                    System.out.println(set);
                }
            }
        }
    }

