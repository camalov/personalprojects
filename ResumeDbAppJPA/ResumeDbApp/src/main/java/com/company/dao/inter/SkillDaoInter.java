package com.company.dao.inter;

import com.company.entity.Skill;

import java.util.List;

public interface SkillDaoInter {
    public List<Skill> getAll();
    
    public List<Skill> getByName(String name);
    
    public int addSkill(Skill skill);
    
    public boolean updateSkill(Skill skill);
}
