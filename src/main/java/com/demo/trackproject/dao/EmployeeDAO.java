package com.demo.trackproject.dao;

import com.demo.trackproject.model.Employee;
import java.util.List;

public interface EmployeeDAO {
    public long addEmployee(Employee employee);
    public Employee getEmployee(long employeeId);
    public List<Employee> listEmployees();
    public Employee updateEmployee(Employee employee);
    public void deleteEmployee(Employee employee);
    public Employee updateEmployeeById(long employeeId,Employee employee);
    public void deleteEmployeeById(long employeeId);
}
