package com.company.service.inter;

import com.company.entity.UserSkill;

import java.util.List;

public interface UserSkillServiceInter {

    public List<UserSkill> getAllSkillByUserId(int userId);

    public List<UserSkill> getUserSkillById(int userId, int skillId);
    
    public int addUserSkill(UserSkill userSkill);
    
    public boolean updateUserSkill(UserSkill userSkill);
    
    public boolean remove(int userId);
    
    public boolean removeSelectedItems(int[] userSkillsId);
}
