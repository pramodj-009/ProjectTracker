package com.demo.trackproject.dao.impl;

import com.demo.trackproject.dao.ProficiencyDAO;
import com.demo.trackproject.model.Proficiency;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProficiencyDAOImpl implements ProficiencyDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public long addProficiency(Proficiency proficiency) {
        sessionFactory.getCurrentSession().save(proficiency);
        return proficiency.getId();
    }

    @Override
    public Proficiency getProficiency(long proficiencyId) {
        Proficiency proficiency = (Proficiency) sessionFactory.getCurrentSession().get(Proficiency.class,proficiencyId);
        return proficiency;
    }

    @Override
    public List<Proficiency> listProficiencies() {
        List<Proficiency> proficiencies = sessionFactory.getCurrentSession().createCriteria(Proficiency.class).list();
        return proficiencies;
    }

    @Override
    public Proficiency updateProficiency(Proficiency proficiency) {
        sessionFactory.getCurrentSession().saveOrUpdate(proficiency);
        return proficiency;
    }

    @Override
    public void deleteProficiency(Proficiency proficiency) {
        sessionFactory.getCurrentSession().delete(proficiency);
    }

    @Override
    public Proficiency updateProficiencyById(long proficiencyId, Proficiency proficiency) {
        Proficiency newProficiency = (Proficiency) sessionFactory.getCurrentSession().get(Proficiency.class,proficiencyId);
        newProficiency.setCategory(proficiency.getCategory());
        newProficiency.setEmployeeSkillProficiencies(proficiency.getEmployeeSkillProficiencies());
        this.updateProficiency(newProficiency);
        return newProficiency;
    }

    @Override
    public void deleteProficiencyById(long proficiencyId) {
        Proficiency proficiency = (Proficiency) sessionFactory.getCurrentSession().get(Proficiency.class,proficiencyId);
        this.deleteProficiency(proficiency);
    }
}
