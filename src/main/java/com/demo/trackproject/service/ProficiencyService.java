package com.demo.trackproject.service;

import com.demo.trackproject.dao.ProficiencyDAO;
import com.demo.trackproject.model.Proficiency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ProficiencyService {
    @Autowired
    private ProficiencyDAO proficiencyDAO;
    @Transactional
    public long save(Proficiency proficiency){
        return proficiencyDAO.addProficiency(proficiency);
    }

    public Proficiency get(long id){
        return proficiencyDAO.getProficiency(id);
    }

    public List<Proficiency> list(){
        return proficiencyDAO.listProficiencies();
    }

    @Transactional
    public Proficiency update(Proficiency proficiency){
        return proficiencyDAO.updateProficiency(proficiency);
    }

    @Transactional
    public void delete(long id){
        proficiencyDAO.deleteProficiencyById(id);
    }
}
