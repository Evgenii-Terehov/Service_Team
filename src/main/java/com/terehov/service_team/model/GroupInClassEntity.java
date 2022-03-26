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
@Table(name = "group_in_class", schema = "public", catalog = "service_team")
public class GroupInClassEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_class")
    private GroupEntity idClassEntity;

    @ManyToOne
    @JoinColumn(name = "id_group")
    private ClassEntity idGroupEntity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public GroupEntity getIdClassEntity() {
        return idClassEntity;
    }

    public void setIdClassEntity(GroupEntity idClassEntity) {
        this.idClassEntity = idClassEntity;
    }

    public ClassEntity getIdGroupEntity() {
        return idGroupEntity;
    }

    public void setIdGroupEntity(ClassEntity idGroupEntity) {
        this.idGroupEntity = idGroupEntity;
    }

    @Override
    public String toString() {
        return "GroupInClassEntity{" +
                "id=" + id +
                ", idClassEntity=" + idClassEntity +
                ", idGroupEntity=" + idGroupEntity +
                '}';
    }
}
