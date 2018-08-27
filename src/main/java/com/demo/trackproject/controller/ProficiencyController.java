package com.demo.trackproject.controller;

import com.demo.trackproject.model.Proficiency;
import com.demo.trackproject.service.ProficiencyService;
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
public class ProficiencyController {

    @Autowired
    ProficiencyService proficiencyService;

    @RequestMapping(value = "/proficiency",method = RequestMethod.GET)
    public ResponseEntity getAllProficiencies(){
        List proficiencies = proficiencyService.list();
        return new ResponseEntity(proficiencies,HttpStatus.OK);
    }

    @RequestMapping(value = "/proficiency",method = RequestMethod.POST)
    public ResponseEntity saveProficiency(@RequestBody Proficiency proficiency){
        proficiencyService.save(proficiency);
        return new ResponseEntity(proficiency, HttpStatus.OK);
    }

    @RequestMapping(value = "/proficiency/{id}",method = RequestMethod.GET)
    public ResponseEntity getProficiency(@PathVariable long id){
        Proficiency proficiency = proficiencyService.get(id);
        if (proficiency==null){
            return new ResponseEntity("Proficiency not found for id: "+id,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(proficiency,HttpStatus.OK);
    }

    @RequestMapping(value = "/proficiency",method = RequestMethod.PUT)
    public ResponseEntity updateProficiency(@RequestBody Proficiency proficiency){
        proficiency = proficiencyService.update(proficiency);
        return new ResponseEntity(proficiency, HttpStatus.OK);
    }

    @RequestMapping(value = "/proficiency/{id}",method = RequestMethod.DELETE)
    public ResponseEntity deleteProficiency(@PathVariable long id){
        proficiencyService.delete(id);
        return new ResponseEntity("Deleted: "+id,HttpStatus.OK);
    }
}
