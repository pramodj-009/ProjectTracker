package com.demo.trackproject.dao.impl;

import com.demo.trackproject.dao.DesignationDAO;
import com.demo.trackproject.model.Designation;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DesignationDAOImpl implements DesignationDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public long addDesignation(Designation designation) {
        sessionFactory.getCurrentSession().save(designation);
        return designation.getId();
    }

    @Override
    public Designation getDesignation(long designationId) {
        Designation designation = (Designation) sessionFactory.getCurrentSession().get(Designation.class,designationId);
        return designation;
    }

    @Override
    public List<Designation> listDesignations() {
        List<Designation> designations = sessionFactory.getCurrentSession().createCriteria(Designation.class).list();
        return designations;
    }

    @Override
    public Designation editDesignation(Designation designation)
    {
        sessionFactory.getCurrentSession().saveOrUpdate(designation);
        return designation;
    }

    @Override
    public void deleteDesignation(Designation designation) {
        sessionFactory.getCurrentSession().delete(designation);
    }

    @Override
    public Designation updateDesignationById(long designationId, Designation designation) {
        Designation newDesignation = (Designation) sessionFactory.getCurrentSession().get(Designation.class,designationId);
        newDesignation.setTitle(designation.getTitle());
        newDesignation.setEmployees(designation.getEmployees());
        this.editDesignation(newDesignation);
        return newDesignation;
    }

    @Override
    public void deleteDesignationById(long designationId) {
        Designation designation = (Designation) sessionFactory.getCurrentSession().get(Designation.class,designationId);
        this.deleteDesignation(designation);
    }
}
