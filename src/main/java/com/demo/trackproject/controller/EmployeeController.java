package com.demo.trackproject.controller;

import com.demo.trackproject.model.Employee;
import com.demo.trackproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/employee",method = RequestMethod.GET)
    public ResponseEntity getAllEmployees(){
        List employees = employeeService.list();
        return new ResponseEntity(employees,HttpStatus.OK);
    }

    @RequestMapping(value = "/employee",method = RequestMethod.POST)
    public ResponseEntity saveEmployee(@RequestBody Employee employee){
        employeeService.save(employee);
        return new ResponseEntity(employee,HttpStatus.OK);
    }

    @RequestMapping(value = "/employee/{id}",method = RequestMethod.GET)
    public ResponseEntity getEmployee(@PathVariable long id){
        Employee employee = employeeService.get(id);
        if (employee == null){
            return new ResponseEntity("Employee not found for id: "+id,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(employee,HttpStatus.OK);
    }

    @RequestMapping(value = "/employee",method = RequestMethod.PUT)
    public ResponseEntity updateEmployee(@RequestBody Employee employee){
        employee = employeeService.update(employee);
        return new ResponseEntity(employee,HttpStatus.OK);
    }

    @RequestMapping(value = "/employee/{id}",method = RequestMethod.DELETE)
    public ResponseEntity deleteEmployee(@PathVariable long id){
        employeeService.delete(id);
        return new ResponseEntity("Deleted Employee for id: "+id,HttpStatus.OK);
    }
}
