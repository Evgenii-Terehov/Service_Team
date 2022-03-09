package com.terehov.soap.model;

import javax.persistence.*;
import java.util.Collection;

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
    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private GroupsEntity groupsByGroupId;
    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "id")
    private TeamsEntity teamsByTeamId;
    @OneToMany(mappedBy = "studentsByTeamLeaderId")
    private Collection<TeamsEntity> teamsById;

    public StudentsEntity() {
    }

    public StudentsEntity(int id) {
        this.id = id;
    }

    public StudentsEntity(String name, String lastName, String urlTg) {
        this.name = name;
        this.lastName = lastName;
        this.urlTg = urlTg;
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

    public GroupsEntity getGroupsByGroupId() {
        return groupsByGroupId;
    }

    public void setGroupsByGroupId(GroupsEntity groupsByGroupId) {
        this.groupsByGroupId = groupsByGroupId;
    }

    public TeamsEntity getTeamsByTeamId() {
        return teamsByTeamId;
    }

    public void setTeamsByTeamId(TeamsEntity teamsByTeamId) {
        this.teamsByTeamId = teamsByTeamId;
    }

    public Collection<TeamsEntity> getTeamsById() {
        return teamsById;
    }

    public void setTeamsById(Collection<TeamsEntity> teamsById) {
        this.teamsById = teamsById;
    }

    @Override
    public String toString() {
        return "StudentsEntity{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", urlTg='" + urlTg + '\'' +
                '}';
    }
}
