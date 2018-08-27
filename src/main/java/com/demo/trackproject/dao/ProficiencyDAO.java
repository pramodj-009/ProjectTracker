package com.demo.trackproject.dao;

import com.demo.trackproject.model.Proficiency;

import java.util.List;

public interface ProficiencyDAO {
    public long addProficiency(Proficiency proficiency);
    public Proficiency getProficiency(long proficiencyId);
    public List<Proficiency> listProficiencies();
    public Proficiency updateProficiency(Proficiency proficiency);
    public void deleteProficiency(Proficiency proficiency);
    public Proficiency updateProficiencyById(long proficiencyId,Proficiency proficiency);
    public void deleteProficiencyById(long proficiencyId);
}
