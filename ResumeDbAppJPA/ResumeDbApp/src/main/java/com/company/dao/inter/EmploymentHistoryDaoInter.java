package com.company.dao.inter;

import com.company.entity.EmploymentHistory;

import java.util.List;

public interface EmploymentHistoryDaoInter {
    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int userId);

    public int addEmploymentHistory(EmploymentHistory employmentHistory, int userId);

    public boolean updateEmploymentHistory(EmploymentHistory employmentHistory);

    public boolean remove(int userId);
}
