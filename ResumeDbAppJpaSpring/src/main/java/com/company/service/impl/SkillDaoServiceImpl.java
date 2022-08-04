package com.company.service.impl;

import com.company.dao.inter.SkillDaoInter;
import com.company.entity.Skill;
import com.company.service.inter.SkillDaoServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SkillDaoServiceImpl implements SkillDaoServiceInter {

    @Autowired
    SkillDaoInter skillDao;

    @Override
    public List<Skill> getAll() {
        return skillDao.getAll();
    }

    @Override
    public List<Skill> getByName(String name) {
        return skillDao.getByName(name);
    }

    @Override
    public int addSkill(Skill skill) {
        return skillDao.addSkill(skill);
    }

    @Override
    public boolean updateSkill(Skill skill) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
