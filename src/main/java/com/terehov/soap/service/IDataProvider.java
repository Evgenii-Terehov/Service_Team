package com.terehov.soap.service;

import com.terehov.soap.model.ServiceTeamEntity;

import javax.jws.WebMethod;
import java.util.List;

public interface IDataProvider {

    @WebMethod
    public ServiceTeamEntity insertUser(ServiceTeamEntity entity);

    @WebMethod
    String getUserById(Integer id);

    @WebMethod
    List<ServiceTeamEntity> selectAllUsers();

    @WebMethod
    boolean updateUser(ServiceTeamEntity entity);

    @WebMethod
    boolean deleteUser(int id);
}
