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
@Table(name = "task", schema = "public", catalog = "postgres")
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

}
