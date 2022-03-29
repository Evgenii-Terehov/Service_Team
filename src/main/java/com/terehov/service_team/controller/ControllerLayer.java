package com.terehov.service_team.controller;

import com.terehov.service_team.model.GroupEntity;
import com.terehov.service_team.model.UserEntity;
import com.terehov.service_team.model.UsersInClassEntity;
import com.terehov.service_team.model.UsersInGroupEntity;

import com.terehov.service_team.service.TeamServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ControllerLayer {

    private final TeamServiceImpl teamService;

    @Autowired
    public ControllerLayer(TeamServiceImpl teamService) {
        this.teamService = teamService;
    }

    @PostMapping("/groups/new/{color}")
    public Boolean createGroupByColor(@PathVariable("color") String color) {
        return teamService.createGroup(color);
    }

    @PostMapping("/groups/insert")
    public Boolean insertGroupByEntity(GroupEntity entity) {
        return teamService.insertGroup(entity);
    }

    @PutMapping("/groups/update")
    public boolean updateGroup(GroupEntity entity) {
        return teamService.insertGroup(entity);
    }

    @PostMapping("/groups/delete/{id}")
    public Boolean deleteGroup(@PathVariable("id") Integer idGroup) {
        return teamService.deleteGroup(idGroup);
    }

    @GetMapping("/group/{group_id}")
    public GroupEntity getGroupById(@PathVariable("group_id") Integer id) {
        return teamService.getGroupById(id);
    }

    @PostMapping("/groups/{id}/change_color")
    public Boolean changeGroupColor(@PathVariable("id") Integer idGroup, String color) {
        return teamService.changeGroupColor(idGroup, color);
    }
//    либо этот вариант
//    @GetMapping("/groups/change-color/{id}")
//    public void changeColorForGroup(@PathVariable("id") Integer idGroup, String color) {
//        teamService.getGroupById(idGroup).setColor(color);
//    }

    @PostMapping("/groups/add_user/{id_group}")
    public Boolean addUserToGroup(@PathVariable("id_group") Integer idGroup, Integer idUser, String role) {
        teamService.getGroupById(idGroup);
        return teamService.addUserToGroup(idGroup, idUser, role);
    }

    @GetMapping("/groups/choice_user_role/{id}")
    public Boolean choiceRoleUserInGroup(@PathVariable("id") Integer idGroup, Integer idUser, String role) {
        return teamService.choiceRoleUserToGroup(idGroup, idUser, role);
    }

    @PostMapping("/groups/remove_user/{id_user}")
    public Boolean removeUserFromGroup(@PathVariable("id_user") Integer idUser) {
        return teamService.removeUserFromGroup(idUser);
    }

    @GetMapping("/groups/get_user/{id}")
    public UsersInGroupEntity getUserFromGroup(@PathVariable("id") Integer idUser) {
        return teamService.getUserFromGroup(idUser);
    }

    @GetMapping("/groups/team_leader")
    public UsersInGroupEntity getTeamLeaderOfGroup(Integer idGroup) {
        return teamService.getTeamLeaderGroup(idGroup);
    }

    @GetMapping("/group/group_lector/{id_class}")
    public UsersInClassEntity getLectorOfGroup(@PathVariable("id_class") Integer idClass) {
        return teamService.getLectorGroup(idClass);
    }

    @GetMapping("/users/{id}")
    public UserEntity getUserById(@PathVariable("id") Integer id) {
        return teamService.getUserById(id);
    }

    @PostMapping("/users/insert_user")
    public Boolean insertUser(UserEntity entity) {
        return teamService.insertUser(entity);
    }

    @GetMapping("/class/user_in_class/{id_user}")
    public UsersInClassEntity getUserClass(@PathVariable("id_user") Integer idUser) {
        return teamService.getUserClass(idUser);
    }

    @GetMapping("/users/list_users_by_id")
    public List<UserEntity> getListOfUsersByIdList(List<Integer> listOfId) {
        return teamService.getListUsersByListOfId(listOfId);
    }

    @GetMapping("/users")
    public List<UserEntity> getAllUsers() {
        return teamService.selectAllUsers();
    }

    @PostMapping("/users/update")
    public boolean updateUserByEntity(UserEntity entity) {
        return teamService.insertUser((entity));
    }

    @PostMapping("/users/delete/{id}")
    public boolean deleteUser(@PathVariable("id") Integer id) {
        return teamService.deleteUser(id);
    }
}
