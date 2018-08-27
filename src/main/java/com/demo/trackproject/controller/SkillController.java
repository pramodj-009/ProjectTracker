package com.demo.trackproject.controller;

import com.demo.trackproject.model.Skill;
import com.demo.trackproject.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SkillController {
    @Autowired
    SkillService skillService;

    @RequestMapping(value = "/skill",method = RequestMethod.GET)
    public ResponseEntity getAllSkills(){
        return new ResponseEntity(skillService.list(),HttpStatus.OK);
    }

    @RequestMapping(value = "/skill",method = RequestMethod.POST)
    public ResponseEntity createSkill(@RequestBody Skill skill){
        skillService.save(skill);
        return new ResponseEntity(skill,HttpStatus.OK);
    }

    @RequestMapping(value = "/skill/{id}",method = RequestMethod.GET)
    public  ResponseEntity getSkill(@PathVariable long id){
        Skill skill = skillService.get(id);
        if(skill == null){
            return new ResponseEntity("No Skill present for id : "+id,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(skill,HttpStatus.OK);
    }

    @RequestMapping(value = "/skill/{id}",method = RequestMethod.PUT)
    public  ResponseEntity updateSkill(@PathVariable long id,@RequestBody Skill skill){
        skill = skillService.update(skill);
        if(skill == null){
            return new ResponseEntity("No Skill present for id : "+id,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(skill,HttpStatus.OK);
    }

    @RequestMapping(value = "/skill/{id}",method = RequestMethod.DELETE)
    public ResponseEntity deleteSkill(@PathVariable long id){
        skillService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
