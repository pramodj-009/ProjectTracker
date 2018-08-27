package com.demo.trackproject.dao;

import com.demo.trackproject.model.EmployeeSkillProficiency;

import java.util.List;

public interface EmployeeSkillProficiencyDAO {
    public long addEmployeeSkillProficiency(EmployeeSkillProficiency employeeSkillProficiency);
    public EmployeeSkillProficiency getEmployeeSkillProficiency(long employeeSkillProficiencyId);
    public List<EmployeeSkillProficiency> listEmployeeSkillProficiencies();
    public EmployeeSkillProficiency updateEmployeeSkillProficiency(EmployeeSkillProficiency employeeSkillProficiency);
    public void deleteEmployeeSkillProficiency(EmployeeSkillProficiency employeeSkillProficiency);
    public EmployeeSkillProficiency updateEmployeeSkillProficiencyById(long employeeSkillProficiencyId,EmployeeSkillProficiency employeeSkillProficiency);
    public void deleteEmployeeSkillProficiencyById(long employeeSkillProficiencyId);
}
