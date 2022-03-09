package com.terehov.soap.model;

import javax.persistence.*;

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
}
