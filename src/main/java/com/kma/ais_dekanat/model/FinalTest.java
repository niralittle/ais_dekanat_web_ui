package com.kma.ais_dekanat.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;


@Entity
@Table(name = "final_test")
public class FinalTest {
    private Integer finalId;
    private UniversityGroup group;
    private Subject subject;
    private Date time;
    private Room room;
    private Set<FinalReport> finalReports;

    @Id
    @GeneratedValue
    @Column(name = "final_id")
    public Integer getFinalId() {
        return finalId;
    }

    public void setFinalId(Integer finalId) {
        this.finalId = finalId;
    }

    @ManyToOne
    @JoinColumn
    public UniversityGroup getGroup() {
        return group;
    }

    public void setGroup(UniversityGroup group) {
        this.group = group;
    }

    @ManyToOne
    @JoinColumn
    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @ManyToOne
    @JoinColumn
    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @OneToMany(mappedBy = "finalTest")
    public Set<FinalReport> getFinalReports() {
        return finalReports;
    }

    public void setFinalReports(Set<FinalReport> finalReports) {
        this.finalReports = finalReports;
    }
}
