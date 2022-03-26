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
@Table(name = "users_in_group", schema = "public", catalog = "service_team")
public class UsersInGroupEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_group")
    private GroupEntity idGroupEntity;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserEntity idUserEntity;

    @Basic
    @Column(name = "role")
    private String role;

    public UsersInGroupEntity(Integer idGroupEntity, Integer idUserEntity, String role) {
        this.idGroupEntity = new GroupEntity(idGroupEntity);
        this.idUserEntity = new UserEntity(idUserEntity);
        this.role = role;
    }

    public UsersInGroupEntity(Integer idUserEntity) {
        this.idUserEntity = new UserEntity(idUserEntity);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public GroupEntity getIdGroupEntity() {
        return idGroupEntity;
    }

    public void setIdGroupEntity(GroupEntity idGroupEntity) {
        this.idGroupEntity = idGroupEntity;
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
        return "UsersInGroupEntity{" +
                "id=" + id +
                ", idGroupEntity=" + idGroupEntity +
                ", idUserEntity=" + idUserEntity +
                ", role='" + role + '\'' +
                '}';
    }
}
