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
@Table(name = "user", schema = "public", catalog = "service_team")
public class UserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "first_name")
    private String firstName;
    @Basic
    @Column(name = "last_name")
    private String lastName;
    @Basic
    @Column(name = "id_telegram")
    private Long idTelegram;

    @OneToMany(mappedBy = "idUserEntity")
    private List<UsersInClassEntity> usersInClassEntitiesFK;

    @OneToMany(mappedBy = "idUserEntity")
    private List<UsersInGroupEntity> usersInGroupEntitiesFK;

    @OneToMany(mappedBy = "idUserEntity")
    private List<TaskEntity> taskEntitiesFK;

    public UserEntity(int id) {
        this.id = id;
    }

    public UserEntity(int id, String firstName, String lastName, Long idTelegram) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.idTelegram = idTelegram;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getIdTelegram() {
        return idTelegram;
    }

    public void setIdTelegram(Long idTelegram) {
        this.idTelegram = idTelegram;
    }

    public List<UsersInClassEntity> getUsersInClassEntitiesFK() {
        return usersInClassEntitiesFK;
    }

    public void setUsersInClassEntitiesFK(List<UsersInClassEntity> usersInClassEntitiesFK) {
        this.usersInClassEntitiesFK = usersInClassEntitiesFK;
    }

    public List<UsersInGroupEntity> getUsersInGroupEntitiesFK() {
        return usersInGroupEntitiesFK;
    }

    public void setUsersInGroupEntitiesFK(List<UsersInGroupEntity> usersInGroupEntitiesFK) {
        this.usersInGroupEntitiesFK = usersInGroupEntitiesFK;
    }

    public List<TaskEntity> getTaskEntitiesFK() {
        return taskEntitiesFK;
    }

    public void setTaskEntitiesFK(List<TaskEntity> taskEntitiesFK) {
        this.taskEntitiesFK = taskEntitiesFK;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", idTelegram=" + idTelegram +
                ", usersInClassEntitiesFK=" + usersInClassEntitiesFK +
                ", usersInGroupEntitiesFK=" + usersInGroupEntitiesFK +
                ", taskEntitiesFK=" + taskEntitiesFK +
                '}';
    }
}
