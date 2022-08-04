package com.company.dao.impl;

import com.company.dao.inter.EmploymentHistoryDaoInter;
import com.company.entity.EmploymentHistory;
import com.company.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmploymentHistoryDaoImpl implements EmploymentHistoryDaoInter {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int userId) {
        Query query = em.createNamedQuery("EmploymentHistory.findAllEmploymentHistoryByUserId", EmploymentHistory.class);
        query.setParameter("userId", userId);

        List<EmploymentHistory> employmentHistoryList = query.getResultList();

        return employmentHistoryList;
    }

    @Override
    public int addEmploymentHistory(EmploymentHistory employmentHistory, int userId) {
        int result = -1;

        employmentHistory.setUser(new User(userId));

        em.persist(employmentHistory);

        return result = employmentHistory.getId();
/*
        Query query = em.createNativeQuery("insert into employment_history(header, begin_date, end_date, job_description, user_id) values(?1, ?2, ?3, ?4, ?5)");
        BigInteger biid = (BigInteger) query.getSingleResult();
        result = biid.longValue();

        User user = new User();
        user.setId(userId);

        query.setParameter(1, employmentHistory.getHeader());
        query.setParameter(2, (Date) employmentHistory.getBeginDate());
        query.setParameter(3, (Date) employmentHistory.getBeginDate());
        query.setParameter(4, employmentHistory.getJobDescription());
        query.setParameter(5, user.getId());

        query.executeUpdate();
*/
    }

    @Override
    public boolean updateEmploymentHistory(EmploymentHistory employmentHistory) {
        em.merge(employmentHistory);

        return true;
    }

    @Override
    public boolean remove(int userId) {
        em.remove(getAllEmploymentHistoryByUserId(userId).get(0));

        return true;
    }
}
