package com.terehov.service_team.controller;

import com.terehov.service_team.model.GroupEntity;
import com.terehov.service_team.model.UserEntity;
import com.terehov.service_team.model.UsersInClassEntity;
import com.terehov.service_team.model.UsersInGroupEntity;

import com.terehov.service_team.service.TeamServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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

    @PostMapping("/group/{group_id}") ///ERROR
    public GroupEntity getGroupById(@PathVariable("group_id") Integer id) {
        return teamService.getGroupById(id);
    }

    @GetMapping("/groups/by_lector/{id_lector}")
    public List<GroupEntity> getGroupsByLector(@PathVariable("id_lector") Integer idLector) {
        return teamService.getGroupsByLector(idLector);
    }

    @GetMapping("/group/users/{id_group}")
    public List<UserEntity> getAllUsersInGroup(@PathVariable("id_group") Integer idGroup) {
        return teamService.getListUsersInGroup(idGroup);
    }
    @PostMapping("/groups/{id}")
    public Boolean changeGroupColor(@PathVariable("id") Integer idGroup, String color) {
        return teamService.changeGroupColor(idGroup, color);
    }

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

    @GetMapping("/groups/get_user/{id}") ///ERROR
    public UsersInGroupEntity getUserFromGroup(@PathVariable("id") Integer idUser) {
        return teamService.getUserFromGroup(idUser);
    }

    @GetMapping("/groups/team_leader/{group_id}")///NOT NORMAL
    public UserEntity getTeamLeaderOfGroup(@PathVariable("group_id") Integer idGroup) {
        return teamService.getTeamLeaderGroup(idGroup);
    }

    @GetMapping("/group/group_lector/{id_class}")///NOT NORMAL
    public UserEntity getLectorOfGroup(@PathVariable("id_class") Integer idClass) {
        return teamService.getLectorGroup(idClass);
    }

    @GetMapping("/users/{id}")
    public UserEntity getUserById(@PathVariable("id") Integer idUser) {
        return teamService.getUserById( idUser);
    }

    @PostMapping("/users/insert_user")
    public Boolean insertUser(UserEntity entity) {
        return teamService.insertUser(entity);
    }

    @GetMapping("/class/user_in_class/{id_user}")///ERROR
    public UsersInClassEntity getUserClass(@PathVariable("id_user") Integer idUser) {
        return teamService.getUserClass(idUser);
    }

    @GetMapping("/users/list_users_by_id")///ERROR
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
