package com.demo.trackproject.dao.impl;

import com.demo.trackproject.dao.SkillDAO;
import com.demo.trackproject.model.Skill;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SkilDAOImpl implements SkillDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public long addSkill(Skill skill) {
        sessionFactory.getCurrentSession().save(skill);
        return skill.getId();
    }

    @Override
    public Skill getSkill(long skillId) {
        Skill skill = (Skill) sessionFactory.getCurrentSession().get(Skill.class,skillId);
        return skill;
    }

    @Override
    public List<Skill> listSkills() {
        List<Skill> skills = sessionFactory.getCurrentSession().createCriteria(Skill.class).list();
        return skills;
    }

    @Override
    public Skill updateSkill(Skill skill) {
        sessionFactory.getCurrentSession().saveOrUpdate(skill);
        return skill;
    }

    @Override
    public void deleteSkill(Skill skill) {
        sessionFactory.getCurrentSession().delete(skill);
    }

    @Override
    public Skill updateSkillById(long skillId, Skill skill) {
        Skill newSkill = (Skill) sessionFactory.getCurrentSession().get(Skill.class,skillId);
        newSkill.setName(skill.getName());
        newSkill.setEmployeeSkillProficiencies(skill.getEmployeeSkillProficiencies());
        this.updateSkill(newSkill);
        return newSkill;
    }

    @Override
    public void deleteSkillById(long skillId) {
        Skill skill = (Skill) sessionFactory.getCurrentSession().get(Skill.class,skillId);
        this.deleteSkill(skill);
    }
}
