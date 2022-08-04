package com.company.resume.util;

import com.company.dao.inter.EmploymentHistoryDaoInter;
import com.company.entity.EmploymentHistory;
import com.company.entity.User;
import com.company.main.Context;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class EmploymentHistoryRequestUtil {

    public static List<EmploymentHistory> getAllByUserId(int userId) {
        EmploymentHistoryDaoInter employmentHistoryDao = Context.instanceEmploymentHistoryDao();
        List<EmploymentHistory> employmentHistoryList = employmentHistoryDao.getAllEmploymentHistoryByUserId(userId);
        return employmentHistoryList;
    }


    public static int addEmploymentHistory(EmploymentHistory employmentHistory, int userId) {
        int resultId;

        EmploymentHistoryDaoInter employmentHistoryDao = Context.instanceEmploymentHistoryDao();
        resultId = employmentHistoryDao.addEmploymentHistory(employmentHistory, userId);

        return resultId;
    }

    public static boolean updateEmploymentHistory(EmploymentHistory employmentHistory) {
        boolean result;

        EmploymentHistoryDaoInter employmentHistoryDao = Context.instanceEmploymentHistoryDao();
        result = employmentHistoryDao.updateEmploymentHistory(employmentHistory);

        return result;
    }

    public static void fillEmploymentHistory(HttpServletRequest request, EmploymentHistory employmentHistory) {
        int employmentHistoryId = Integer.valueOf(request.getParameter("employmentHistoryId"));
        String jobDescription = request.getParameter("employmentHistory");
        int userId = Integer.valueOf(request.getParameter("id"));

        if (jobDescription.trim().equals("")) {
            jobDescription = "";
        }


        User u = new User();
        u.setId(userId);

        employmentHistory.setId(employmentHistoryId);
        employmentHistory.setUser(u);
        employmentHistory.setJobDescription(jobDescription);
    }
}
