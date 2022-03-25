package com.terehov.soap.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "groups", schema = "public", catalog = "soap_service_team_db")
public class GroupsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "specializations", nullable = true, length = -1)
    private String specializations;
    @Basic
    @Column(name = "number", nullable = true)
    private Integer number;
    @Basic
    @Column(name = "lecturer_id", nullable = true)
    private Integer lecturerId;
    @ManyToOne
    @JoinColumn(name = "lecturer_id", referencedColumnName = "id")
    private LecturersEntity lecturersByLecturerId;

    public GroupsEntity() {
    }

    public GroupsEntity(int id) {
        this.id = id;
    }

    public GroupsEntity(int id, String specializations,
                        Integer number, Integer lecturerId,
                        LecturersEntity lecturersByLecturerId) {
        this.id = id;
        this.specializations = specializations;
        this.number = number;
        this.lecturerId = lecturerId;
        this.lecturersByLecturerId = lecturersByLecturerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpecializations() {
        return specializations;
    }

    public void setSpecializations(String specializations) {
        this.specializations = specializations;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(Integer lecturerId) {
        this.lecturerId = lecturerId;
    }

    public LecturersEntity getLecturersByLecturerId() {
        return lecturersByLecturerId;
    }

    public void setLecturersByLecturerId(LecturersEntity lecturersByLecturerId) {
        this.lecturersByLecturerId = lecturersByLecturerId;
    }

    @Override
    public String toString() {
        return "GroupsEntity{" +
                "id=" + id +
                ", specializations='" + specializations + '\'' +
                ", number=" + number +
                ", lecturerId=" + lecturerId +
                ", lecturersByLecturerId=" + lecturersByLecturerId +
                '}';
    }
}
