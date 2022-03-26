package com.terehov.service_team.controller;

import com.terehov.service_team.model.GroupEntity;
import com.terehov.service_team.model.UserEntity;
import com.terehov.service_team.model.UsersInClassEntity;
import com.terehov.service_team.model.UsersInGroupEntity;

import com.terehov.service_team.service.TeamService;
import com.terehov.service_team.service.TeamServiceImpl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    private static final TeamService teamService = new TeamServiceImpl();

    @PostMapping("/groups/new")
    public Boolean createGroup(String color) {
        return teamService.createGroup(color);
    }

    @PostMapping("/groups/{id}/change_color")
    public Boolean changeGroupColor(@PathVariable("id") Integer idGroup, String color) {
        return teamService.changeGroupColor(idGroup, color);
    }

    @GetMapping("/users/{id}")
    public UserEntity getUserById(@PathVariable("id") Integer id) {
        return teamService.getUserById(id);
    }

    @PostMapping("/groups/delete/{id}")
    public Boolean deleteGroup(@PathVariable("id") Integer idGroup) {
        return teamService.deleteGroup(idGroup);
    }

    @GetMapping("/groups/change-color/{id}")
    public void changeColorForGroup(@PathVariable("id") Integer idGroup, String color) {
        teamService.getGroupById(idGroup).setColor(color);
    }

    @PostMapping("/groups/add_user/{id_group}")
    public Boolean addUserToGroup(@PathVariable("id_group") Integer idGroup, Integer idUser, String role) {
         teamService.getGroupById(idGroup);
    return teamService.addUserToGroup(idGroup, idUser, role);
    }

    @GetMapping("/groups/choice_user_role/{id}")
    public Boolean choiceRoleUserToGroup(@PathVariable("id") Integer idGroup, Integer idUser, String role) {
        return teamService.choiceRoleUserToGroup(idGroup, idUser, role);
    }

    @PostMapping("/groups/remove_user/{id_user}")
    public Boolean removeUserFromGroup(@PathVariable("id_user") Integer idUser) {
        return teamService.removeUserFromGroup(idUser);
    }

    @PostMapping("/users/insert_user")
    public Boolean insertUser(UserEntity entity) {
        return teamService.insertUser(entity);
    }

    @GetMapping("/groups/get_user_from_group")
    public UsersInGroupEntity getUserFromGroup(Integer idUser) {
        return teamService.getUserFromGroup(idUser);
    }

    @GetMapping("/groups/team_leader")
    public UsersInGroupEntity getTeamLeaderGroup(Integer idGroup) {
        return teamService.getTeamLeaderGroup(idGroup);
    }

    @GetMapping("/class/user_in_class/{id_user}")
    public UsersInClassEntity getUserClass(@PathVariable("id_user") Integer idUser) {
        return teamService.getUserClass(idUser);
    }

    @GetMapping("/group/group_lector/{id_class}")
    public UsersInClassEntity getLectorGroup(@PathVariable("id_class") Integer idClass) {
        return teamService.getLectorGroup(idClass);
    }

    @GetMapping("/group/{group_id}")
    public GroupEntity getGroupById(@PathVariable("group_id") Integer id) {
        return teamService.getGroupById(id);
    }

    @GetMapping("/users/list_users_by_id")
    public List<UserEntity> getListUsersByListOfId(List<Integer> listOfId) {
        return teamService.getListUsersByListOfId(listOfId);
    }

    @GetMapping("/users")
    public List<UserEntity> selectAllUsers() {
        return teamService.selectAllUsers();
    }

    @PostMapping("/users/update")
    public boolean updateUser(UserEntity entity) {
        return teamService.insertUser((entity));
    }

    @PostMapping("/users/delete")
    public boolean deleteUser(int id) {
        return teamService.deleteUser(id);
    }

    @PostMapping("/groups/insert")
    public Boolean insertGroup(GroupEntity entity) {
        return teamService.insertGroup(entity);
    }

    @PutMapping("/groups/update")
    public boolean updateGroup(GroupEntity entity) {
        return teamService.insertGroup(entity);
    }
}
