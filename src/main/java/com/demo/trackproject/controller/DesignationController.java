package com.demo.trackproject.controller;

import com.demo.trackproject.model.Designation;
import com.demo.trackproject.service.DesignationService;
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
public class DesignationController {
    @Autowired
    DesignationService designationService;

    @RequestMapping(value = "/designation",method = RequestMethod.GET)
    public ResponseEntity getAllDesignations(){
        List designations = designationService.list();
        return new ResponseEntity(designations,HttpStatus.OK);
    }

    @RequestMapping(value = "/designation",method = RequestMethod.POST)
    public ResponseEntity addDesignation(@RequestBody Designation designation){
        designationService.save(designation);
        return new ResponseEntity(designation,HttpStatus.OK);
    }

    @RequestMapping(value = "/designation/{id}",method = RequestMethod.GET)
    public ResponseEntity getDesignationById(@PathVariable long id){
        Designation designation = designationService.get(id);
        if (designation == null){
            return new ResponseEntity("Designation not found for id: "+id,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(designation,HttpStatus.OK);
    }

    @RequestMapping(value = "/designation",method = RequestMethod.PUT)
    public ResponseEntity updateDesignation(@RequestBody Designation designation){
        designation = designationService.update(designation);
        if(designation == null){
            return new ResponseEntity("Designation not found for id: "+designation.getId(),HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(designation,HttpStatus.OK);
    }

    @RequestMapping(value = "/designation/{id}",method = RequestMethod.DELETE)
    public ResponseEntity deleteDesignation(@PathVariable long id){
        designationService.delete(id);
        return new ResponseEntity("Deleted Designation for id: "+id,HttpStatus.OK);
    }

}
