package com.kma.ais_dekanat.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Subject {
    private Integer subjectId;
    private String name;
    private FinalType finalType;
    private Set<FinalTest> finalTests;
    private Professor professor;

    @Id
    @GeneratedValue
    @Column(name = "subject_id")
    public Integer getSubjectId() {
        return subjectId;
    }

    @ManyToOne
    @JoinColumn
    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "final_type")
    @Enumerated(EnumType.ORDINAL)
    public FinalType getFinalType() {
        return finalType;
    }

    public void setFinalType(FinalType finalType) {
        this.finalType = finalType;
    }

    @OneToMany(mappedBy = "subject")
    public Set<FinalTest> getFinalTests() {
        return finalTests;
    }

    public void setFinalTests(Set<FinalTest> finalTests) {
        this.finalTests = finalTests;
    }
}
