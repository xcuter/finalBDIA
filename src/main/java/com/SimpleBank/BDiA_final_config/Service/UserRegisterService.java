package com.SimpleBank.BDiA_final_config.Service;


import com.SimpleBank.BDiA_final_config.DAOs.AccountDAO;
import com.SimpleBank.BDiA_final_config.DAOs.UserDAO;
import com.SimpleBank.BDiA_final_config.Models.User;
import com.SimpleBank.BDiA_final_config.Models.UserRegistration;
import org.apache.commons.codec.digest.DigestUtils;

public class UserRegisterService {
    private final UserDAO usDAO = new UserDAO();
    private final AccountDAO accountDAO = new AccountDAO();

    public void register(UserRegistration userRegistration) {
        User userToRegister = UserMapper.map(userRegistration);
        try {
                userToRegister.setAccountID(accountDAO.createAccount().getAccountID());
                hashPasswordWithSha256(userToRegister);
                usDAO.save(userToRegister);
            } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void hashPasswordWithSha256(User userToRegister) {
        String passwordSha256 = DigestUtils.sha256Hex(userToRegister.getPassword());
        userToRegister.setPassword(passwordSha256);
    }

    private static class UserMapper {
        static User map(UserRegistration userRegistration){
            return new User(
                    userRegistration.getFirstName(),
                    userRegistration.getLastName(),
                    userRegistration.getEmail(),
                    userRegistration.getPassword()
            );
        }
    }


}
