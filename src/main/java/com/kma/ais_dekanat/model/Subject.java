package com.kma.ais_dekanat.model;

import javax.persistence.*;
import java.util.Set;


@Entity
public class Subject {
    private Integer subjectId;
    private String name;
    private FinalType finalType;
    private Syllabus syllabus;
    private Set<FinalTest> finalTests;

    @Id
    @GeneratedValue
    @Column(name = "subject_id")
    public Integer getSubjectId() {
        return subjectId;
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

    @ManyToOne
    @JoinColumn
    public Syllabus getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(Syllabus syllabus) {
        this.syllabus = syllabus;
    }

    @OneToMany(mappedBy = "subject")
    public Set<FinalTest> getFinalTests() {
        return finalTests;
    }

    public void setFinalTests(Set<FinalTest> finalTests) {
        this.finalTests = finalTests;
    }
}
