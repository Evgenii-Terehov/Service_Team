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
@Table(name = "class", schema = "public", catalog = "service_team")
public class ClassEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "class_name")
    private String className;

    @OneToMany(mappedBy = "idClassEntity")
    private List<UsersInClassEntity> usersInClassEntitiesFK;

    @OneToMany(mappedBy = "idGroupEntity")
    private List<GroupInClassEntity> groupInClassEntitiesFK;

    @OneToMany(mappedBy = "idClassEntity")
    private List<TaskEntity> taskEntitiesFK;

    public ClassEntity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<UsersInClassEntity> getUsersInClassEntitiesFK() {
        return usersInClassEntitiesFK;
    }

    public void setUsersInClassEntitiesFK(List<UsersInClassEntity> usersInClassEntitiesFK) {
        this.usersInClassEntitiesFK = usersInClassEntitiesFK;
    }

    public List<GroupInClassEntity> getGroupInClassEntitiesFK() {
        return groupInClassEntitiesFK;
    }

    public void setGroupInClassEntitiesFK(List<GroupInClassEntity> groupInClassEntitiesFK) {
        this.groupInClassEntitiesFK = groupInClassEntitiesFK;
    }

    public List<TaskEntity> getTaskEntitiesFK() {
        return taskEntitiesFK;
    }

    public void setTaskEntitiesFK(List<TaskEntity> taskEntitiesFK) {
        this.taskEntitiesFK = taskEntitiesFK;
    }

    @Override
    public String toString() {
        return "ClassEntity{" +
                "id=" + id +
                ", className='" + className + '\'' +
                ", usersInClassEntitiesFK=" + usersInClassEntitiesFK +
                ", groupInClassEntitiesFK=" + groupInClassEntitiesFK +
                ", taskEntitiesFK=" + taskEntitiesFK +
                '}';
    }
}
