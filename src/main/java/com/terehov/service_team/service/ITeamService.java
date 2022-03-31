package com.terehov.service_team.service;

import com.terehov.service_team.model.*;

import java.util.List;


public interface ITeamService {

//Методы работы с группой

    Boolean createGroup(String color);
    Boolean deleteGroup(Integer idGroup);

    Boolean changeGroupColor(Integer idGroup, String color);
    Boolean addUserToGroup(Integer idGroup, Integer idUser, String role);
    Boolean choiceRoleUserToGroup(Integer idGroup, Integer idUser, String role);
    Boolean removeUserFromGroup(Integer idUser);

    List<UserEntity> getListUsersByListOfId(List<Integer> listOfId);

    List<UserEntity> getListUsersInGroup(Integer idGroup);

    UserEntity getUserById(Integer id);

    UsersInGroupEntity getUserFromGroup(Integer idUser);

    UserEntity getTeamLeaderGroup(Integer idGroup);

    UsersInClassEntity getUserClass(Integer idUser);

    UserEntity getLectorGroup(Integer idClass);

    Boolean insertUser(UserEntity entity);

    GroupEntity getGroupById(Integer idGroup);

    List<UserEntity> selectAllUsers();

    boolean deleteUser(int id);

    Boolean insertGroup(GroupEntity entity);
}
