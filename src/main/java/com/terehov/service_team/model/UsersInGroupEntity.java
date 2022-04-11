package com.terehov.service_team.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
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

    @Column(name = "id_group")
    private Integer idGroupEntity;

    @Column(name = "id_user")
    private Integer idUserEntity;

    @Basic
    @Column(name = "role")
    private String role;

    public UsersInGroupEntity(Integer idGroupEntity, Integer idUserEntity, String role) {
        this.idGroupEntity = idGroupEntity;
        this.idUserEntity = idUserEntity;
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
