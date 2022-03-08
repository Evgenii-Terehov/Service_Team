package com.terehov.soap.service;

import com.terehov.soap.util.HibernateUtil;
import com.terehov.soap.Constants;
import com.terehov.soap.model.ServiceTeamEntity;

import javax.jws.WebMethod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class DataProvider implements IDataProvider {

    private static final Logger logger = LogManager.getLogger(IDataProvider.class);

    @Override
    @WebMethod
    public ServiceTeamEntity insertUser(ServiceTeamEntity entity) {
        Transaction transaction = null;
        try (Session session = getSession()){
            transaction = session.beginTransaction();
            entity = (ServiceTeamEntity) session.merge(entity);
            transaction.commit();
            logger.info(entity.getClass().getSimpleName() + Constants.ADDED);
            return entity;
        } catch (Exception e) {
            logger.info(e.getClass() + e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            return null;
        }
    }

    @Override
    @WebMethod
    public String getUserById(Integer id) {
        Transaction transaction = null;
        ServiceTeamEntity users;
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            users = session.get(ServiceTeamEntity.class, id);
            transaction.commit();
            logger.info(ServiceTeamEntity.class.getSimpleName() + Constants.FOUND);

            return (users.getFirstname() + " "
                    + users.getLastname() + " "
                    + users.getGroupname() + " "
                    + users.getRole() + " "
                    + users.getPhonenumber());

        } catch (Exception e) {
            logger.info(e.getClass() + e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            return null;
        }
    }

    @Override
    public List<ServiceTeamEntity> selectAllUsers() {
        Transaction transaction;
        List<ServiceTeamEntity> list = new ArrayList<>();
        try (Session session = getSession()){
            transaction = session.beginTransaction();
            list = session.createQuery("from ServiceTeamEntity ", ServiceTeamEntity.class).list();
            transaction.commit();
            logger.info("Records were selected");
            return list;
        }
        catch (Exception e){
            logger.error(e.getClass() + e.getMessage());
            return list;
        }
    }

    @Override
    public boolean updateUser(ServiceTeamEntity entity) {
        Transaction transaction = null;
        try (Session session = getSession()){
            transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
            logger.info(entity.getClass().getSimpleName() + " updated");
            return true;
        } catch (Exception e){
            logger.error(e.getClass() + e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
    }

    @Override
    public boolean deleteUser(int id) {
        Transaction transaction = null;
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            session.delete(new ServiceTeamEntity(id));
            transaction.commit();
            logger.info(ServiceTeamEntity.class.getSimpleName() + id + " deleted");
            return true;
        } catch (Exception e){
            logger.error(e.getClass() + e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
    }

    Session getSession() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        return sessionFactory.openSession();
    }
}