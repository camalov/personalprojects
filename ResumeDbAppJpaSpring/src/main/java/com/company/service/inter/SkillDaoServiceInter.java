package com.company.service.inter;

import com.company.entity.Skill;

import java.util.List;

public interface SkillDaoServiceInter {
    public List<Skill> getAll();
    
    public List<Skill> getByName(String name);
    
    public int addSkill(Skill skill);
    
    public boolean updateSkill(Skill skill);
}
