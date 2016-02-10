package com.kma.ais_dekanat.model;

import javax.persistence.*;
import java.util.Set;


@Entity
public class Student {
    private Integer studentId;
    private String fullName;
    private UniversityGroup group;
    private Set<FinalReport> finalReports;

    @Id
    @GeneratedValue
    @Column(name = "student_id")
    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @ManyToOne
    @JoinColumn
    public UniversityGroup getGroup() {
        return group;
    }

    public void setGroup(UniversityGroup group) {
        this.group = group;
    }

    @OneToMany(mappedBy = "student")
    public Set<FinalReport> getFinalReports() {
        return finalReports;
    }

    public void setFinalReports(Set<FinalReport> finalReports) {
        this.finalReports = finalReports;
    }
}
