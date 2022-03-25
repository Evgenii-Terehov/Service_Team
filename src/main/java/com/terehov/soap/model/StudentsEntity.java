package com.terehov.soap.model;

import javax.persistence.*;

@Entity
@Table(name = "students", schema = "public", catalog = "soap_service_team_db")
public class StudentsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "name", nullable = true, length = -1)
    private String name;
    @Basic
    @Column(name = "last_name", nullable = true, length = -1)
    private String lastName;
    @Basic
    @Column(name = "url_tg", nullable = true, length = -1)
    private String urlTg;
    @Basic
    @Column(name = "group_id", nullable = true)
    private Integer groupId;
    @Basic
    @Column(name = "team_id", nullable = true)
    private Integer teamId;

    public StudentsEntity() {
    }

    public StudentsEntity(int id) {
        this.id = id;
    }

    public StudentsEntity(String name, String lastName,
                          String urlTg, Integer groupId,
                          Integer teamId) {
        this.name = name;
        this.lastName = lastName;
        this.urlTg = urlTg;
        this.groupId = groupId;
        this.teamId = teamId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUrlTg() {
        return urlTg;
    }

    public void setUrlTg(String urlTg) {
        this.urlTg = urlTg;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    @Override
    public String toString() {
        return "StudentsEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", urlTg='" + urlTg + '\'' +
                ", groupId=" + groupId +
                ", teamId=" + teamId +
                '}';
    }
}
