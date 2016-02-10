package com.kma.ais_dekanat.model;

import javax.persistence.*;
import java.util.Set;


@Entity
public class UniversityGroup {
    private Integer groupId;
    private Department department;
    private Integer course;
    private String name;
    private Set<Student> students;
    private Set<FinalTest> finals;
    private Set<Syllabus> syllabuses;

    @Id
    @GeneratedValue
    @Column(name = "group_id")
    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    @ManyToOne
    @JoinColumn
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "group")
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @OneToMany(mappedBy = "group")
    public Set<FinalTest> getFinals() {
        return finals;
    }

    public void setFinals(Set<FinalTest> finals) {
        this.finals = finals;
    }

    @OneToMany(mappedBy = "group")
    public Set<Syllabus> getSyllabuses() {
        return syllabuses;
    }

    public void setSyllabuses(Set<Syllabus> syllabuses) {
        this.syllabuses = syllabuses;
    }
}
