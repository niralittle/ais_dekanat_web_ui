package com.kma.ais_dekanat.model;

import javax.persistence.*;
import java.util.Set;


@Entity
public class Cathedra {
    private Integer cathedraId;
    private String name;
    private Department department;
    private Set<Professor> professors;

    @Id
    @GeneratedValue
    @Column(name = "cathedra_id")
    public Integer getCathedraId() {
        return cathedraId;
    }

    public void setCathedraId(Integer cathedraId) {
        this.cathedraId = cathedraId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    @JoinColumn
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @OneToMany(mappedBy = "cathedra")
    public Set<Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(Set<Professor> professors) {
        this.professors = professors;
    }
}
