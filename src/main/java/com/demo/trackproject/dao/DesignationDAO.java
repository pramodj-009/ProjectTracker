package com.demo.trackproject.dao;

import com.demo.trackproject.model.Designation;

import java.util.List;

public interface DesignationDAO {
    public long addDesignation(Designation designation);
    public Designation getDesignation(long designationId);
    public List<Designation> listDesignations();
    public Designation editDesignation(Designation designation);
    public void deleteDesignation(Designation designation);
    public Designation updateDesignationById(long designationId,Designation designation);
    public void deleteDesignationById(long designationId);
}
