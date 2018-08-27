package com.demo.trackproject.service;

import com.demo.trackproject.dao.SkillDAO;
import com.demo.trackproject.model.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class SkillService {
    @Autowired
    private SkillDAO skillDAO;
    @Transactional
    public long save(Skill skill){
        return skillDAO.addSkill(skill);
    }

    public Skill get(long id){
        return skillDAO.getSkill(id);
    }

    public List<Skill> list(){
        return skillDAO.listSkills();
    }

    @Transactional
    public Skill update(Skill skill){
        return skillDAO.updateSkill(skill);
    }

    @Transactional
    public void delete(long id){
        skillDAO.deleteSkillById(id);
    }
}
