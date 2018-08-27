package com.demo.trackproject.dao.impl;

import com.demo.trackproject.dao.EmployeeDAO;
import com.demo.trackproject.model.Employee;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public long addEmployee(Employee employee) {
        sessionFactory.getCurrentSession().save(employee);
        return employee.getId();
    }

    @Override
    public Employee getEmployee(long employeeId) {
        Employee employee = (Employee) sessionFactory.getCurrentSession().get(Employee.class,employeeId);
        return employee;
    }

    @Override
    public List<Employee> listEmployees() {
        List<Employee> employees = sessionFactory.getCurrentSession().createCriteria(Employee.class).list();
        return employees;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        sessionFactory.getCurrentSession().saveOrUpdate(employee);
        return employee;
    }

    @Override
    public void deleteEmployee(Employee employee) {
        sessionFactory.getCurrentSession().delete(employee);
    }

    @Override
    public Employee updateEmployeeById(long employeeId, Employee employee) {
        Employee newEmployee = (Employee) sessionFactory.getCurrentSession().get(Employee.class,employeeId);
        newEmployee.setFirstName(employee.getFirstName());
        newEmployee.setLastName(employee.getLastName());
        newEmployee.setActive(employee.isActive());
        newEmployee.setDesignation(employee.getDesignation());
        newEmployee.setDob(employee.getDob());
        newEmployee.setDoj(employee.getDoj());
        newEmployee.setSalary(employee.getSalary());
        newEmployee.setProjects(employee.getProjects());
        newEmployee.setEmployeeSkillProficiencies(employee.getEmployeeSkillProficiencies());
        this.updateEmployee(newEmployee);
        return newEmployee;
    }

    @Override
    public void deleteEmployeeById(long employeeId) {
        Employee employee = (Employee) sessionFactory.getCurrentSession().get(Employee.class,employeeId);
        this.deleteEmployee(employee);
    }
}
