package com.SimpleBank.BDiA_final_config.Servlets;

import com.SimpleBank.BDiA_final_config.DAOs.AccountDAO;
import com.SimpleBank.BDiA_final_config.DAOs.UserDAO;
import com.SimpleBank.BDiA_final_config.Models.User;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.HttpMethodConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/addAmmount")
@ServletSecurity(
        value = @HttpConstraint(rolesAllowed = {"USER"}),
        httpMethodConstraints = {
                @HttpMethodConstraint(value = "POST", rolesAllowed = {"USER"}),
                @HttpMethodConstraint(value = "GET", rolesAllowed = {"USER"})
        })
public class addAmmountServlet extends HttpServlet  {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserDAO userDAO = new UserDAO();
        AccountDAO accDao = new AccountDAO();
        double ammount = 1.0d;
        User user = new User();
        try {
            user = userDAO.getUserInfo(request.getUserPrincipal().getName());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            ammount = accDao.getAmmount(user.getAccountID());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            ammount = Double.parseDouble(request.getParameter("ammount"));
            accDao.addAmmount(user, ammount);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        response.sendRedirect(request.getContextPath()+"/protectedUserContext");
    }

}
