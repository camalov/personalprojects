package com.company.dao.impl;

import com.company.dao.inter.SkillDaoInter;
import com.company.entity.Skill;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class SkillDaoImpl implements SkillDaoInter {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Skill> getAll() {
        Query query = em.createNamedQuery("Skill.findAll", Skill.class);

        List<Skill> skills = query.getResultList();

        return skills;
    }

    @Override
    public List<Skill> getByName(String name) {
        Query query = em.createNamedQuery("Skill.findByName", Skill.class);
        query.setParameter("name", name);

        List<Skill> skills = query.getResultList();

        return skills;
    }

    @Override
    public int addSkill(Skill skill) {
        int result = -1;

        if (getByName(skill.getName()).size() > 0) {
            return result;
        }

        em.persist(skill);

        return result = skill.getId();
    }

    @Override
    public boolean updateSkill(Skill skill) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
