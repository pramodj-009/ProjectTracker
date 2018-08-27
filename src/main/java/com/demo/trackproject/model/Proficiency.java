package com.demo.trackproject.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Proficiency {
    @Id
    @GeneratedValue
    private long id;
    private String category;
    @OneToMany(mappedBy = "proficiency",fetch = FetchType.EAGER)
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
