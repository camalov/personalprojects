package com.company.dao.impl;

import com.company.dao.inter.UserSkillDaoInter;
import com.company.entity.UserSkill;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserSkillDaoImpl implements UserSkillDaoInter {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<UserSkill> getAllSkillByUserId(int userId) {
        Query query = em.createNamedQuery("UserSkill.findByAllUserId", UserSkill.class);
        query.setParameter("userId", userId);

        List<UserSkill> userSkills = query.getResultList();

        return userSkills;
    }

    @Override
    public List<UserSkill> getUserSkillById(int userId, int skillId) {
        Query query = em.createNamedQuery("UserSkill.findByUserId", UserSkill.class);
        query.setParameter("userId", userId);
        query.setParameter("skillId", skillId);

        List<UserSkill> userSkills = query.getResultList();

        return userSkills;
    }

    @Override
    public int addUserSkill(UserSkill userSkill) {
        int result = -1;
        int count = getUserSkillById(userSkill.getUser().getId(), userSkill.getSkill().getId()).size();

        if (count > 0) {
            return result;
        }

        em.persist(userSkill);

        return result = userSkill.getId();
    }

    @Override
    public boolean updateUserSkill(UserSkill userSkill) {
        int count = getUserSkillById(userSkill.getUser().getId(), userSkill.getSkill().getId()).size();

        if (count > 0) {
            return false;
        }

        em.merge(userSkill);

        return true;
    }

    @Override
    public boolean remove(int userId) {
        Query query = em.createQuery("delete from UserSkill us where us.user.id in(:userId)");
        query.setParameter("userId", userId);

        query.executeUpdate();

        return true;
    }

    @Override
    public boolean removeSelectedItems(int[] userSkillsId) {
        int[] selectedUserSkillsId = userSkillsId;

        Query query = em.createQuery("delete from UserSkill us where us.user.id in(:userId)");

        for (int i = 0; i < selectedUserSkillsId.length; i++) {
            query.setParameter("userId", selectedUserSkillsId[i]);
            query.executeUpdate();
        }

        return true;
    }

}
