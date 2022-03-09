package com.terehov.soap.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "teams", schema = "public", catalog = "soap_service_team_db")
public class TeamsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "team_name", nullable = true, length = -1)
    private String teamName;
    @Basic
    @Column(name = "group_id", nullable = true)
    private Integer groupId;
    @Basic
    @Column(name = "team_leader_id", nullable = true)
    private Integer teamLeaderId;
    @OneToMany(mappedBy = "teamsByTeamId")
    private Collection<StudentsEntity> studentsById;
    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private GroupsEntity groupsByGroupId;
    @ManyToOne
    @JoinColumn(name = "team_leader_id", referencedColumnName = "id")
    private StudentsEntity studentsByTeamLeaderId;

    public TeamsEntity() {
    }

    public TeamsEntity(int id) {
        this.id = id;
    }

    public TeamsEntity(String teamName) {
        this.teamName = teamName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getTeamLeaderId() {
        return teamLeaderId;
    }

    public void setTeamLeaderId(Integer teamLeaderId) {
        this.teamLeaderId = teamLeaderId;
    }

    public Collection<StudentsEntity> getStudentsById() {
        return studentsById;
    }

    public void setStudentsById(Collection<StudentsEntity> studentsById) {
        this.studentsById = studentsById;
    }

    public GroupsEntity getGroupsByGroupId() {
        return groupsByGroupId;
    }

    public void setGroupsByGroupId(GroupsEntity groupsByGroupId) {
        this.groupsByGroupId = groupsByGroupId;
    }

    public StudentsEntity getStudentsByTeamLeaderId() {
        return studentsByTeamLeaderId;
    }

    public void setStudentsByTeamLeaderId(StudentsEntity studentsByTeamLeaderId) {
        this.studentsByTeamLeaderId = studentsByTeamLeaderId;
    }

    @Override
    public String toString() {
        return "TeamsEntity{" +
                "id=" + id +
                ", teamName='" + teamName + '\'' +
                ", groupId=" + groupId +
                ", teamLeaderId=" + teamLeaderId +
                ", studentsById=" + studentsById +
                ", groupsByGroupId=" + groupsByGroupId +
                ", studentsByTeamLeaderId=" + studentsByTeamLeaderId +
                '}';
    }
}
