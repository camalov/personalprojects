package com.company.resume.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.company.dao.inter.UserDaoInter;
import com.company.entity.User;
import com.company.main.Context;
import com.company.resume.util.ControllerUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

    private UserDaoInter userDao = Context.instanceUserDao();
    private BCrypt.Verifyer verifyer = BCrypt.verifyer();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            User u = userDao.findByEmail(email);

            if (u == null) {
                throw new IllegalArgumentException("user doesn't exist!");
            }

            BCrypt.Result result = verifyer.verify(password.toCharArray(), u.getPassword().toCharArray());

            if (!result.verified) {
                throw new IllegalArgumentException("email or password is incorrect!");
            }

            request.getSession().setAttribute("loggedInUser", u);
            response.sendRedirect("users");
        } catch (Exception ex) {
            ex.printStackTrace();
            ControllerUtil.sendRedirectErrorPage(response, ex);
        }
    }
}