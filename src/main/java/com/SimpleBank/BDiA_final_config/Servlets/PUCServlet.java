package com.SimpleBank.BDiA_final_config.Servlets;

import com.SimpleBank.BDiA_final_config.DAOs.AccountDAO;
import com.SimpleBank.BDiA_final_config.DAOs.UserDAO;
import com.SimpleBank.BDiA_final_config.Models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.HttpMethodConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/protectedUserContext")
@ServletSecurity(
        value = @HttpConstraint(rolesAllowed = {"USER"}),
        httpMethodConstraints = {
                @HttpMethodConstraint(value = "POST", rolesAllowed = {"USER"}),
                @HttpMethodConstraint(value = "GET", rolesAllowed = {"USER"})
        })
public class PUCServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        request.setAttribute("FullName", user.getFullName());
        request.setAttribute("accountID", user.getAccountID());
        request.setAttribute("ammount", ammount);


        request.getRequestDispatcher("/WEB-INF/views/protectedUserContext.jsp").forward(request, response);
    }
}

