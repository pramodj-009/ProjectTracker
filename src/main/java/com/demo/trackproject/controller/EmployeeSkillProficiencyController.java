package com.demo.trackproject.controller;

import com.demo.trackproject.model.EmployeeSkillProficiency;
import com.demo.trackproject.service.EmployeeSkillProficiencyService;
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
public class EmployeeSkillProficiencyController {
    @Autowired
    EmployeeSkillProficiencyService service;

    @RequestMapping(value = "/employeeskillsroficiency",method = RequestMethod.GET)
    public ResponseEntity getAllData(){
        List list = service.list();
        return new ResponseEntity(list,HttpStatus.OK);
    }

    @RequestMapping(value = "/employeeskillsroficiency",method = RequestMethod.POST)
    public ResponseEntity saveData(@RequestBody EmployeeSkillProficiency employeeSkillProficiency){
        service.save(employeeSkillProficiency);
        return new ResponseEntity(employeeSkillProficiency, HttpStatus.OK);
    }

    @RequestMapping(value = "/employeeskillsroficiency/{id}",method = RequestMethod.GET)
    public ResponseEntity getData(@PathVariable long id){
        EmployeeSkillProficiency employeeSkillProficiency = service.get(id);
        if (employeeSkillProficiency==null){
            return new ResponseEntity("Proficiency not found for id: "+id,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(employeeSkillProficiency,HttpStatus.OK);
    }

    @RequestMapping(value = "/employeeskillsroficiency",method = RequestMethod.PUT)
    public ResponseEntity updateData(@RequestBody EmployeeSkillProficiency employeeSkillProficiency){
        employeeSkillProficiency = service.update(employeeSkillProficiency);
        return new ResponseEntity(employeeSkillProficiency, HttpStatus.OK);
    }

    @RequestMapping(value = "/employeeskillsroficiency/{id}",method = RequestMethod.DELETE)
    public ResponseEntity deleteData(@PathVariable long id){
        service.delete(id);
        return new ResponseEntity("Deleted: "+id,HttpStatus.OK);
    }
}
