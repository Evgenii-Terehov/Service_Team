package com.terehov.service_team.service;

import com.terehov.service_team.model.*;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;


public interface TeamService{

//Методы работы с группой

    Boolean createGroup(String color);
    Boolean deleteGroup(Integer idGroup);

    Boolean changeGroupColor(Integer idGroup, String color);
    Boolean addUserToGroup(Integer idGroup, Integer idUser, String role);
    Boolean choiceRoleUserToGroup(Integer idGroup, Integer idUser, String role);
    Boolean removeUserFromGroup(Integer idUser);

    List<UserEntity> getListUsersByListOfId(List<Integer> listOfId);

    UserEntity getUserById(Integer id);

    UsersInGroupEntity getUserFromGroup(Integer idUser);

    UsersInGroupEntity getTeamLeaderGroup(Integer idGroup);

    UsersInClassEntity getUserClass(Integer idUser);

    UsersInClassEntity getLectorGroup(Integer idClass);

    Boolean insertUser(UserEntity entity);

    GroupEntity getGroupById(Integer idGroup);

    List<UserEntity> selectAllUsers();

    boolean deleteUser(int id);

    Boolean insertGroup(GroupEntity entity);
}
