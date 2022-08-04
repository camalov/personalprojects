package com.company.resume.entityUI;

import com.company.entity.Skill;

public class SkillUI extends Skill {

    public SkillUI(int id, String name) {
        super(id, name);
    }

    public SkillUI(Skill skill) {
        this(skill.getId(), skill.getName());
    }

    @Override
    public String toString() {
        return getName();
    }
}
