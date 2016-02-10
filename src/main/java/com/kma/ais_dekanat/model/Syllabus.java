package com.kma.ais_dekanat.model;

import javax.persistence.*;


@Entity
public class Syllabus {
    private Integer syllabusId;
    private Professor professor;
    private Subject subject;
    private UniversityGroup group;
    private ClassType classType;

    @Id
    @GeneratedValue
    @Column(name = "syllabus_id")
    public Integer getSyllabusId() {
        return syllabusId;
    }

    public void setSyllabusId(Integer syllabusId) {
        this.syllabusId = syllabusId;
    }

    @ManyToOne
    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @ManyToOne
    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @ManyToOne
    public UniversityGroup getGroup() {
        return group;
    }

    public void setGroup(UniversityGroup group) {
        this.group = group;
    }

    @Column(name = "class_type")
    @Enumerated(EnumType.ORDINAL)
    public ClassType getClassType() {
        return classType;
    }

    public void setClassType(ClassType classType) {
        this.classType = classType;
    }
}
