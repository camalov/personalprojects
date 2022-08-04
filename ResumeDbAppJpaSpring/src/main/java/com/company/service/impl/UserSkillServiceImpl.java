package com.company.service.impl;

import com.company.dao.inter.UserSkillDaoInter;
import com.company.entity.UserSkill;
import com.company.service.inter.UserSkillServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserSkillServiceImpl implements UserSkillServiceInter {

    @Autowired
    UserSkillDaoInter userSkillDao;

    @Override
    public List<UserSkill> getAllSkillByUserId(int userId) {
        return userSkillDao.getAllSkillByUserId(userId);
    }

    @Override
    public List<UserSkill> getUserSkillById(int userId, int skillId) {
        return userSkillDao.getUserSkillById(userId, skillId);
    }

    @Override
    public int addUserSkill(UserSkill userSkill) {
        return userSkillDao.addUserSkill(userSkill);
    }

    @Override
    public boolean updateUserSkill(UserSkill userSkill) {
        return userSkillDao.updateUserSkill(userSkill);
    }

    @Override
    public boolean remove(int userId) {
        return userSkillDao.remove(userId);
    }

    @Override
    public boolean removeSelectedItems(int[] userSkillsId) {
        return userSkillDao.removeSelectedItems(userSkillsId);
    }

}
