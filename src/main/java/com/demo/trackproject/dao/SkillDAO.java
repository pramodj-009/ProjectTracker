package com.demo.trackproject.dao;

import com.demo.trackproject.model.Skill;

import java.util.List;

public interface SkillDAO {
    public long addSkill(Skill skill);
    public Skill getSkill(long skillId);
    public List<Skill> listSkills();
    public Skill updateSkill(Skill skill);
    public void deleteSkill(Skill skill);
    public Skill updateSkillById(long skillId,Skill skill);
    public void deleteSkillById(long skillId);
}
