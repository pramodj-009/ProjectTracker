package com.demo.trackproject.service;

import com.demo.trackproject.dao.EmployeeDAO;
import com.demo.trackproject.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class EmployeeService {
    @Autowired
    private EmployeeDAO employeeDAO;
    @Transactional
    public long save(Employee employee){
        return employeeDAO.addEmployee(employee);
    }

    public Employee get(long id){
        return employeeDAO.getEmployee(id);
    }

    public List<Employee> list(){
        return employeeDAO.listEmployees();
    }

    @Transactional
    public Employee update(Employee employee){
        return employeeDAO.updateEmployee(employee);
    }

    @Transactional
    public void delete(long id){
        employeeDAO.deleteEmployeeById(id);
    }
}
