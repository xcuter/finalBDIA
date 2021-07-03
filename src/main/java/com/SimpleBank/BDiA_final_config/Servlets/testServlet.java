package com.SimpleBank.BDiA_final_config.Servlets;

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

@WebServlet("/test")
@ServletSecurity(
        value = @HttpConstraint(rolesAllowed = {"USER"}),
        httpMethodConstraints = {
                @HttpMethodConstraint(value = "POST", rolesAllowed = {"USER"}),
                @HttpMethodConstraint(value = "GET", rolesAllowed = {"USER"})
        })
public class testServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String param = request.getParameter("ammount");
        PrintWriter writer = response.getWriter();
        writer.println(param);
        response.sendRedirect(request.getContextPath() + "/protectedUserContext");
    }
}
