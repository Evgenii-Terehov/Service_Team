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
@Table(name = "task", schema = "public", catalog = "service_team")
public class TaskEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserEntity idUserEntity;

    @ManyToOne
    @JoinColumn(name = "id_class")
    private ClassEntity idClassEntity;

    @Basic
    @Column(name = "task_name")
    private String taskName;
    @Basic
    @Column(name = "task_text")
    private String taskText;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserEntity getIdUserEntity() {
        return idUserEntity;
    }

    public void setIdUserEntity(UserEntity idUserEntity) {
        this.idUserEntity = idUserEntity;
    }

    public ClassEntity getIdClassEntity() {
        return idClassEntity;
    }

    public void setIdClassEntity(ClassEntity idClassEntity) {
        this.idClassEntity = idClassEntity;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskText() {
        return taskText;
    }

    public void setTaskText(String taskText) {
        this.taskText = taskText;
    }

    @Override
    public String toString() {
        return "TaskEntity{" +
                "id=" + id +
                ", idUserEntity=" + idUserEntity +
                ", idClassEntity=" + idClassEntity +
                ", taskName='" + taskName + '\'' +
                ", taskText='" + taskText + '\'' +
                '}';
    }
}
