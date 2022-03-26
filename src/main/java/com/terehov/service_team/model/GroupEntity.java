package com.terehov.service_team.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "group", schema = "public", catalog = "service_team")
public class GroupEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "color")
    private String color;

    @OneToMany(mappedBy = "idGroupEntity")
    private List<UsersInGroupEntity> idGroupEntity;

    @OneToMany(mappedBy = "idClassEntity")
    private List<GroupInClassEntity> groupInClassEntitiesFK;

    public GroupEntity(int id) {
        this.id = id;
    }

    public GroupEntity(String color) {
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<UsersInGroupEntity> getIdGroupEntity() {
        return idGroupEntity;
    }

    public void setIdGroupEntity(List<UsersInGroupEntity> idGroupEntity) {
        this.idGroupEntity = idGroupEntity;
    }

    public List<GroupInClassEntity> getGroupInClassEntitiesFK() {
        return groupInClassEntitiesFK;
    }

    public void setGroupInClassEntitiesFK(List<GroupInClassEntity> groupInClassEntitiesFK) {
        this.groupInClassEntitiesFK = groupInClassEntitiesFK;
    }

    @Override
    public String toString() {
        return "GroupEntity{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", idGroupEntity=" + idGroupEntity +
                ", groupInClassEntitiesFK=" + groupInClassEntitiesFK +
                '}';
    }
}
