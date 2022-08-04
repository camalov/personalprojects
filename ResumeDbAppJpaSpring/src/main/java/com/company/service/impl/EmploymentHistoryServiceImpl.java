package com.company.service.impl;

import com.company.dao.inter.EmploymentHistoryDaoInter;
import com.company.entity.EmploymentHistory;
import com.company.service.inter.EmploymentHistoryServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmploymentHistoryServiceImpl implements EmploymentHistoryServiceInter {

    @Autowired
    EmploymentHistoryDaoInter employmentHistoryDao;

    @Override
    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int userId) {
        return employmentHistoryDao.getAllEmploymentHistoryByUserId(userId);
    }

    @Override
    public int addEmploymentHistory(EmploymentHistory employmentHistory, int userId) {
        return employmentHistoryDao.addEmploymentHistory(employmentHistory, userId);
    }

    @Override
    public boolean updateEmploymentHistory(EmploymentHistory employmentHistory) {
        return employmentHistoryDao.updateEmploymentHistory(employmentHistory);
    }

    @Override
    public boolean remove(int userId) {
        return employmentHistoryDao.remove(userId);
    }
}
