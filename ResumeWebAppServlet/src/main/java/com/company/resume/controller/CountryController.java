package com.company.resume.controller;

import com.company.dao.inter.CountryDaoInter;
import com.company.dao.inter.UserDaoInter;
import com.company.entity.Country;
import com.company.entity.User;
import com.company.main.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CountryController", urlPatterns = {"/country"})
public class CountryController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CountryDaoInter countryDao = Context.instanceCountryDao();
        List<Country> countries = countryDao.getAll();
        String refererUrl = request.getHeader("referer");
        String customRedirectUrl = request.getParameter("redirectUrl");
        request.setAttribute("countries", countries);

        if (customRedirectUrl != null && !customRedirectUrl.trim().isEmpty()) {
            request.getRequestDispatcher(customRedirectUrl).forward(request, response);
        } else {
            request.getRequestDispatcher(refererUrl).forward(request, response);
        }
    }

}