package com.terehov.service_team.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users_in_class", schema = "public", catalog = "service_team")
public class UsersInClassEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_class")
    private ClassEntity idClassEntity;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserEntity idUserEntity;

    @Basic
    @Column(name = "role")
    private String role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClassEntity getIdClassEntity() {
        return idClassEntity;
    }

    public void setIdClassEntity(ClassEntity idClassEntity) {
        this.idClassEntity = idClassEntity;
    }

    public UserEntity getIdUserEntity() {
        return idUserEntity;
    }

    public void setIdUserEntity(UserEntity idUserEntity) {
        this.idUserEntity = idUserEntity;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UsersInClassEntity{" +
                "id=" + id +
                ", idClassEntity=" + idClassEntity +
                ", idUserEntity=" + idUserEntity +
                ", role='" + role + '\'' +
                '}';
    }
}
