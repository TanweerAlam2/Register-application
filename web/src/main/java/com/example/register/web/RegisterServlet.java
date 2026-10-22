package com.example.register.web;

import com.example.register.domain.*;
import com.example.register.service.RegistrationService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private RegistrationService registrationService;

    @Override
    public void init() {
        registrationService = AppBootstrap.registrationService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RegistrationResult result = registrationService.register(new RegistrationRequest(
                request.getParameter("fullName"),
                request.getParameter("email"),
                request.getParameter("password")));
        request.setAttribute("result", result);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}