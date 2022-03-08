package com.terehov.soap.model;

import javax.persistence.*;

@Entity
@Table(name = "service_team", schema = "public", catalog = "soap_service_team_db")
public class ServiceTeamEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "firstname", nullable = false, length = 30)
    private String firstname;
    @Basic
    @Column(name = "lastname", nullable = false, length = 30)
    private String lastname;
    @Basic
    @Column(name = "groupname", nullable = false, length = 30)
    private String groupname;
    @Basic
    @Column(name = "role", nullable = false, length = 20)
    private String role;
    @Basic
    @Column(name = "phonenumber", nullable = false, length = -1)
    private String phonenumber;

    public ServiceTeamEntity(int id) {
        this.id = id;
    }

    public ServiceTeamEntity() {
    }

    public ServiceTeamEntity(String firstname, String lastname,
                             String groupname, String role, String phonenumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.groupname = groupname;
        this.role = role;
        this.phonenumber = phonenumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    @Override
    public String toString() {
        return "ServiceTeamEntity{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", groupname='" + groupname + '\'' +
                ", role='" + role + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                '}';
    }
}
