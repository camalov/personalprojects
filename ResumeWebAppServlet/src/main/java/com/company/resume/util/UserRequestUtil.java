package com.company.resume.util;

import com.company.dao.inter.UserDaoInter;
import com.company.entity.User;
import com.company.main.Context;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserRequestUtil {
    public static void checkRequest(HttpServletRequest request, HttpServletResponse response) {
        String userIdStr = request.getParameter("id");
        if (userIdStr == null || userIdStr.trim().isEmpty()) {
            throw new IllegalArgumentException("id is not specified");
        }
    }

    public static User processRequest(HttpServletRequest request, HttpServletResponse response) {
        UserRequestUtil.checkRequest(request, response);
        int userId = Integer.parseInt(request.getParameter("id"));
        UserDaoInter userDao = Context.instanceUserDao();
        User user = userDao.getById(userId);

        if (user == null) {
            throw new IllegalArgumentException("There is no user with this id");
        }

        return user;
    }

}
