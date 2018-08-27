package com.demo.trackproject.dao.impl;

import com.demo.trackproject.dao.EmployeeSkillProficiencyDAO;
import com.demo.trackproject.model.EmployeeSkillProficiency;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeSkillProficiencyDAOImpl implements EmployeeSkillProficiencyDAO {

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public long addEmployeeSkillProficiency(EmployeeSkillProficiency employeeSkillProficiency) {
        sessionFactory.getCurrentSession().save(employeeSkillProficiency);
        return employeeSkillProficiency.getId();
    }

    @Override
    public EmployeeSkillProficiency getEmployeeSkillProficiency(long employeeSkillProficiencyId) {
        EmployeeSkillProficiency employeeSkillProficiency = (EmployeeSkillProficiency) sessionFactory.getCurrentSession().get(EmployeeSkillProficiency.class,employeeSkillProficiencyId);
        return employeeSkillProficiency;
    }

    @Override
    public List<EmployeeSkillProficiency> listEmployeeSkillProficiencies() {
        List<EmployeeSkillProficiency> employeeSkillProficiencies = sessionFactory.getCurrentSession().createCriteria(EmployeeSkillProficiency.class).list();
        return employeeSkillProficiencies;
    }

    @Override
    public EmployeeSkillProficiency updateEmployeeSkillProficiency(EmployeeSkillProficiency employeeSkillProficiency) {
        sessionFactory.getCurrentSession().saveOrUpdate(employeeSkillProficiency);
        return employeeSkillProficiency;
    }

    @Override
    public void deleteEmployeeSkillProficiency(EmployeeSkillProficiency employeeSkillProficiency) {
        sessionFactory.getCurrentSession().delete(employeeSkillProficiency);

    }

    @Override
    public EmployeeSkillProficiency updateEmployeeSkillProficiencyById(long employeeSkillProficiencyId, EmployeeSkillProficiency employeeSkillProficiency) {
        EmployeeSkillProficiency newEmployeeSkillProficiency = (EmployeeSkillProficiency) sessionFactory.getCurrentSession().get(EmployeeSkillProficiency.class,employeeSkillProficiencyId);
        newEmployeeSkillProficiency.setEmployee(employeeSkillProficiency.getEmployee());
        newEmployeeSkillProficiency.setProficiency(employeeSkillProficiency.getProficiency());
        newEmployeeSkillProficiency.setSkill(employeeSkillProficiency.getSkill());
        this.updateEmployeeSkillProficiency(newEmployeeSkillProficiency);
        return newEmployeeSkillProficiency;
    }

    @Override
    public void deleteEmployeeSkillProficiencyById(long employeeSkillProficiencyId) {
        EmployeeSkillProficiency employeeSkillProficiency = (EmployeeSkillProficiency) sessionFactory.getCurrentSession().get(EmployeeSkillProficiency.class,employeeSkillProficiencyId);
        this.deleteEmployeeSkillProficiency(employeeSkillProficiency);
    }
}
