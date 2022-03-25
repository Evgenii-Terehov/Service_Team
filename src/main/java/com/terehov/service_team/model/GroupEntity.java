package com.terehov.service_team.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "group", schema = "public", catalog = "postgres")
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

}
