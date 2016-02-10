package com.kma.ais_dekanat.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name = "final_report")
public class FinalReport implements Serializable{
    private FinalTest finalTest;
    private Student student;
    private Integer grade;

    @Id
    @ManyToOne
    public FinalTest getFinalTest() {
        return finalTest;
    }

    public void setFinalTest(FinalTest finalTest) {
        this.finalTest = finalTest;
    }

    @Id
    @ManyToOne
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}
