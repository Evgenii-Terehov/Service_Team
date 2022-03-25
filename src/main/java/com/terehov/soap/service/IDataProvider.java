package com.terehov.soap.service;

import com.terehov.soap.model.GroupsEntity;
import com.terehov.soap.model.StudentsEntity;

import javax.jws.WebMethod;
import java.util.List;

public interface IDataProvider {

    /**
     * работа со студентами
     */
    @WebMethod
    public StudentsEntity insertUser(StudentsEntity entity);

    @WebMethod
    StudentsEntity getUserById(int id);

    @WebMethod
    List<StudentsEntity> getListUsersByListOfId(List<Integer> listOfId);

    @WebMethod
    List<StudentsEntity> selectAllUsers();

    @WebMethod
    boolean updateUser(StudentsEntity entity);

    @WebMethod
    boolean deleteUser(int id);

    /**
     * работа с группами
     */
    @WebMethod
    public GroupsEntity insertGroup(GroupsEntity entity);

    @WebMethod
    boolean deleteGroup(int id);

    @WebMethod
    boolean updateGroup(GroupsEntity entity);

    /**
     * для сервис-отправителя
     */
    public Object getInfoAboutLectorTeamStudent(int id);
}
