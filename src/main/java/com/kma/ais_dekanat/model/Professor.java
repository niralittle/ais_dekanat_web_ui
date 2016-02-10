package com.kma.ais_dekanat.model;

import javax.persistence.*;


@Entity
public class Professor {
    private Integer professorId;
    private String fullName;
    private String academicDegree;
    private Cathedra cathedra;

    @Id
    @GeneratedValue
    @Column(name = "professor_id")
    public Integer getProfessorId() {
        return professorId;
    }

    public void setProfessorId(Integer professorId) {
        this.professorId = professorId;
    }

    @Column(name = "full_name")
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Column(name = "academic_degree")
    public String getAcademicDegree() {
        return academicDegree;
    }

    public void setAcademicDegree(String academicDegree) {
        this.academicDegree = academicDegree;
    }

    @ManyToOne
    @JoinColumn
    public Cathedra getCathedra() {
        return cathedra;
    }

    public void setCathedra(Cathedra cathedra) {
        this.cathedra = cathedra;
    }
}
