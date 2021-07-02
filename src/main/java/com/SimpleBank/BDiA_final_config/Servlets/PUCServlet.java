package com.SimpleBank.BDiA_final_config.Servlets;

import com.SimpleBank.BDiA_final_config.DAOs.AccountDAO;
import com.SimpleBank.BDiA_final_config.DAOs.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.HttpMethodConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
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
        String username = request.getUserPrincipal().getName();
        request.setAttribute("user", username);
        request.getRequestDispatcher("/WEB-INF/views/protectedUserContext.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO userDAO = new UserDAO();
        AccountDAO accountDAO = new AccountDAO();
             PrintWriter writer = response.getWriter();
              writer.println(request.getParameter("ammount"));
            }
}
