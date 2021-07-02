package com.SimpleBank.BDiA_final_config.Servlets;

import com.SimpleBank.BDiA_final_config.Models.UserRegistration;
import com.SimpleBank.BDiA_final_config.Service.UserRegisterService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


    @WebServlet("/signup")
    public class SignupServlet extends HttpServlet {
        private final UserRegisterService us = new UserRegisterService();

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            request.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(request,response);
            System.out.println(request.getContextPath());
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
            UserRegistration userRegistration = getUserData(request);
            UserRegisterService userRegisterService = new UserRegisterService();
            userRegisterService.register(userRegistration);
            response.sendRedirect(request.getContextPath());
        }

        private UserRegistration getUserData(HttpServletRequest request) {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            return new UserRegistration(firstName,lastName,email,password);
        }
    }

