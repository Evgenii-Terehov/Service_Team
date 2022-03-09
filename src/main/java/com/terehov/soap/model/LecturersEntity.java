package com.terehov.soap.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "lecturers", schema = "public", catalog = "soap_service_team_db")
public class LecturersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "name", nullable = true, length = -1)
    private String name;
    @Basic
    @Column(name = "last_name", nullable = true, length = -1)
    private String lastName;
    @Basic
    @Column(name = "url_tg", nullable = true, length = -1)
    private String urlTg;
    @OneToMany(mappedBy = "lecturersByLecturerId")
    private Collection<GroupsEntity> groupsById;

    public LecturersEntity() {
    }

    public LecturersEntity(int id) {
        this.id = id;
    }

    public LecturersEntity(String name, String lastName, String urlTg) {
        this.name = name;
        this.lastName = lastName;
        this.urlTg = urlTg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUrlTg() {
        return urlTg;
    }

    public void setUrlTg(String urlTg) {
        this.urlTg = urlTg;
    }

    public Collection<GroupsEntity> getGroupsById() {
        return groupsById;
    }

    public void setGroupsById(Collection<GroupsEntity> groupsById) {
        this.groupsById = groupsById;
    }

    @Override
    public String toString() {
        return "LecturersEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", urlTg='" + urlTg + '\'' +
                ", groupsById=" + groupsById +
                '}';
    }
}
