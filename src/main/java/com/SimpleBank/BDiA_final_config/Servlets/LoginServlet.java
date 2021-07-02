package com.SimpleBank.BDiA_final_config.Servlets;

import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.HttpMethodConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
@ServletSecurity(
        value = @HttpConstraint(rolesAllowed = {"USER"}),
        httpMethodConstraints = {
                @HttpMethodConstraint(value = "POST", rolesAllowed = {"USER"}),
                @HttpMethodConstraint(value = "GET", rolesAllowed = {"USER"})
        }
)
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect(request.getContextPath()+"/protectedUserContext");
    }
}
