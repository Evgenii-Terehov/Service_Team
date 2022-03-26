package com.terehov.service_team.service;

import com.terehov.service_team.model.*;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface TeamService{

//Методы работы с группой
    @WebMethod
    Boolean createGroup(String color);
    @WebMethod
    Boolean deleteGroup(Integer idGroup);

    @WebMethod
    Boolean changeGroupColor(Integer idGroup, String color);
    @WebMethod
    Boolean addUserToGroup(Integer idGroup, Integer idUser, String role);
    @WebMethod
    Boolean choiceRoleUserToGroup(Integer idGroup, Integer idUser, String role);
    @WebMethod
    Boolean removeUserFromGroup(Integer idUser);

    @WebMethod
    List<UserEntity> getListUsersByListOfId(List<Integer> listOfId);

    @WebMethod
    UserEntity getUserById(Integer id);

    @WebMethod
    UsersInGroupEntity getUserFromGroup(Integer idUser);

    @WebMethod
    UsersInGroupEntity getTeamLeaderGroup(Integer idGroup);

    @WebMethod
    UsersInClassEntity getUserClass(Integer idUser);

    @WebMethod
    UsersInClassEntity getLectorGroup(Integer idClass);

    @WebMethod
    Boolean insertUser(UserEntity entity);

    @WebMethod
    GroupEntity getGroupById(Integer idGroup);

    @WebMethod
    List<UserEntity> selectAllUsers();

    @WebMethod
    boolean deleteUser(int id);

    @WebMethod
    Boolean insertGroup(GroupEntity entity);
}
