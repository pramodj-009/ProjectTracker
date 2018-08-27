package com.demo.trackproject.service;

import com.demo.trackproject.dao.EmployeeSkillProficiencyDAO;
import com.demo.trackproject.model.EmployeeSkillProficiency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class EmployeeSkillProficiencyService {
    @Autowired
    private EmployeeSkillProficiencyDAO employeeSkillProficiencyDAO;
    @Transactional
    public long save(EmployeeSkillProficiency employeeSkillProficiency){
        return employeeSkillProficiencyDAO.addEmployeeSkillProficiency(employeeSkillProficiency);
    }

    public EmployeeSkillProficiency get(long id){
        return employeeSkillProficiencyDAO.getEmployeeSkillProficiency(id);
    }

    public List<EmployeeSkillProficiency> list(){
        return employeeSkillProficiencyDAO.listEmployeeSkillProficiencies();
    }

    @Transactional
    public EmployeeSkillProficiency update(EmployeeSkillProficiency employeeSkillProficiency){
        return employeeSkillProficiencyDAO.updateEmployeeSkillProficiency(employeeSkillProficiency);
    }

    @Transactional
    public void delete(long id){
        employeeSkillProficiencyDAO.deleteEmployeeSkillProficiencyById(id);
    }
}
