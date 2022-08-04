package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.EmploymentHistoryDaoInter;
import com.company.dao.inter.UserSkillDaoInter;
import com.company.entity.EmploymentHistory;
import com.company.entity.User;
import com.company.main.Context;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmploymentHistoryDaoImpl extends AbstractDAO implements EmploymentHistoryDaoInter {

    @Override
    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int userId) {
        List<EmploymentHistory> result = new ArrayList<>();
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement(
                    "select * from employment_history where user_id=?");
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                EmploymentHistory us = getEmploymentHistory(rs);
                result.add(us);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    private EmploymentHistory getEmploymentHistory(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String header = rs.getString("header");
        Date beginDate = rs.getDate("begin_date");
        Date endDate = rs.getDate("end_date");
        String jobDescription = rs.getString("job_description");
        int userId = rs.getInt("user_id");
        EmploymentHistory emp = new EmploymentHistory(id, header, beginDate, endDate, jobDescription, new User(userId));

        return emp;
    }

    @Override
    public int addEmploymentHistory(EmploymentHistory employmentHistory, int userId) {
        int result = -1;

        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("insert into employment_history(header, begin_date, end_date, job_description, user_id) values(?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            User user = new User();
            user.setId(userId);
            stmt.setString(1, employmentHistory.getHeader());
            stmt.setDate(2, employmentHistory.getBeginDate());
            stmt.setDate(3, employmentHistory.getBeginDate());
            stmt.setString(4, employmentHistory.getJobDescription());
            stmt.setInt(5, user.getId());
            stmt.execute();
            ResultSet rs = stmt.getGeneratedKeys();

            while (rs.next()) {
                result = (int) rs.getInt(1);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean updateEmploymentHistory(EmploymentHistory employmentHistory) {
        boolean result = false;
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("update employment_history set header=?, begin_date=?, end_date=?, job_description=? where id=?");
            stmt.setString(1, employmentHistory.getHeader());
            stmt.setDate(2, employmentHistory.getBeginDate());
            stmt.setDate(3, employmentHistory.getEndDate());
            stmt.setString(4, employmentHistory.getJobDescription());
            stmt.setInt(5, employmentHistory.getId());

            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean remove(int userId) {
        try (Connection c = connect();) {
            Statement stmt = c.createStatement();

            EmploymentHistoryDaoInter employmentHistoryDao = Context.instanceEmploymentHistoryDao();

            return stmt.execute("delete from employment_history where user_id=" + userId);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
