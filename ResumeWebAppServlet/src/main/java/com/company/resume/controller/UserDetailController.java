package com.company.resume.controller;

import com.company.dao.inter.UserDaoInter;
import com.company.entity.Country;
import com.company.entity.EmploymentHistory;
import com.company.entity.User;
import com.company.main.Context;
import com.company.resume.util.EmploymentHistoryRequestUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet(name = "UserDetailController", urlPatterns = {"/userdetail"})
public class UserDetailController extends HttpServlet {

    private UserDaoInter userDao = Context.instanceUserDao();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String userIdStr = request.getParameter("id");
            if (userIdStr == null || userIdStr.trim().isEmpty()) {
                throw new IllegalArgumentException("id is not specified");
            }

            int userId = Integer.parseInt(userIdStr);
            UserDaoInter userDao = Context.instanceUserDao();
            User user = userDao.getById(userId);

            if (user == null) {
                throw new IllegalArgumentException("There is no user with this id");
            }

            // util.Date type information converting to sql.Date type
            long time = user.getBirthdate().getTime();
            Date date = new Date(time);
            user.setBirthdate(date);

            request.setAttribute("user", user);
            request.getRequestDispatcher("userdetail.jsp").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.sendRedirect("error?msg=" + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");

        if (action.equals("delete")) {
            doDelete(request, response);
            return;
        }

        if (action.equals("update")) {
            doUpdate(request, response);
            return;
        }


    }

    private void doUpdate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String userIdStr = request.getParameter("id");
            String employmentHistoryIdStr = request.getParameter("employmentHistoryId");
            String jobDescription = request.getParameter("employmentHistory");

            if (userIdStr == null || userIdStr.trim().isEmpty()) {
                throw new NullPointerException();
            }

            int userId = Integer.valueOf(request.getParameter("id"));

            if (employmentHistoryIdStr == null && jobDescription != null) {
                EmploymentHistory eh = new EmploymentHistory();
                eh.setUser(userDao.getById(userId));
                eh.setJobDescription(jobDescription);
                EmploymentHistoryRequestUtil.addEmploymentHistory(eh, userId);
            } else if (jobDescription != null) {
                EmploymentHistory employmentHistory = new EmploymentHistory();
                EmploymentHistoryRequestUtil.fillEmploymentHistory(request, employmentHistory);
                EmploymentHistoryRequestUtil.updateEmploymentHistory(employmentHistory);
            }

            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String profileDesc = request.getParameter("profileDesc");
            String adress = request.getParameter("adress");
            String birthdateStr = request.getParameter("birthdate");
            String birthplaceIdStr = request.getParameter("birthplace");
            String nationalityIdStr = request.getParameter("nationality");
            int birthplaceId = new Integer(birthplaceIdStr);
            int nationalityId = new Integer(nationalityIdStr);
            Country birthplace = new Country(birthplaceId, null, null);
            Country nationality = new Country(nationalityId, null, null);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            long time = sdf.parse(birthdateStr).getTime();
            Date birthdate = new Date(time);

            User u = userDao.getById(userId);
            u.setId(userId);
            u.setName(name);
            u.setSurname(surname);
            u.setEmail(email);
            u.setPhone(phone);
            u.setProfileDesc(profileDesc);
            u.setAdress(adress);
            u.setBirthdate(birthdate);
            u.setBirthplace(birthplace);
            u.setNationality(nationality);
            userDao.updateUser(u);

            request.setAttribute("user", u);
            request.getRequestDispatcher("userdetail.jsp").forward(request, response);
        } catch (IllegalArgumentException | NullPointerException | ParseException ex) {
            request.getRequestDispatcher("error?msg=" + ex.getMessage()).forward(request, response);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDaoInter userDao = Context.instanceUserDao();

        try {
            String userIdStr = request.getParameter("id");

            if (userIdStr == null || userIdStr.trim().isEmpty()) {
                throw new NullPointerException();
            }

            int userId = Integer.parseInt(userIdStr);
            userDao.remove(userId);
            response.sendRedirect("users");
//            request.getRequestDispatcher("users.jsp").forward(request, response);
        } catch (IllegalArgumentException | NullPointerException ex) {
            request.getRequestDispatcher("error?msg=" + ex.getMessage()).forward(request, response);
        }
    }
}
