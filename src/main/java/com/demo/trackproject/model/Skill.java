package com.demo.trackproject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Skill {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    @OneToMany(mappedBy = "skill",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @NotFound(action = NotFoundAction.IGNORE)
    private Set<EmployeeSkillProficiency> employeeSkillProficiencies;

    public Set<EmployeeSkillProficiency> getEmployeeSkillProficiencies() {
        return employeeSkillProficiencies;
    }

    public void setEmployeeSkillProficiencies(Set<EmployeeSkillProficiency> employeeSkillProficiencies) {
        this.employeeSkillProficiencies = employeeSkillProficiencies;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
