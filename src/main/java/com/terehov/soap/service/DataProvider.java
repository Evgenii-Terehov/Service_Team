package com.terehov.soap.service;

import com.terehov.soap.model.*;
import com.terehov.soap.util.HibernateUtil;
import com.terehov.soap.Constants;

// для соединения по soap класса и его методов
import javax.jws.WebMethod;
import javax.jws.WebService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

@WebService(endpointInterface = "com/terehov/soap/service/IDataProvider")
public class DataProvider implements IDataProvider {

    private static final Logger logger = LogManager.getLogger(IDataProvider.class);

    /**
     * методы для работы со студентами в группах
     */
    @Override
    @WebMethod
    public StudentsEntity insertUser(StudentsEntity entity) {
        Transaction transaction = null;
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            entity = (StudentsEntity) session.merge(entity);
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
    public StudentsEntity getUserById(int id) {
        Transaction transaction = null;
        StudentsEntity users;
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            users = session.get(StudentsEntity.class, id);
            transaction.commit();
            logger.info(StudentsEntity.class.getSimpleName() + Constants.FOUND);

            return users;

        } catch (Exception e) {
            logger.info(e.getClass() + e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            return null;
        }
    }

    @Override
    public List<StudentsEntity> getListUsersByListOfId(List<Integer> listOfId) {
        Transaction transaction = null;
        StudentsEntity users;
        List<StudentsEntity> list = new ArrayList<>();
        try (Session session = getSession()) {
            transaction = session.beginTransaction();

            for(Integer id : listOfId) {
                users = session.get(StudentsEntity.class, id);
                list.add(users);
            }

            transaction.commit();
            logger.info(StudentsEntity.class.getSimpleName() + Constants.FOUND);

            return list;

        } catch (Exception e) {
            logger.info(e.getClass() + e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            return null;
        }
    }

    @WebMethod
    @Override
    public List<StudentsEntity> selectAllUsers() {
        Transaction transaction;
        List<StudentsEntity> list = new ArrayList<>();
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            list = session.createQuery("from StudentsEntity ", StudentsEntity.class).list();
            transaction.commit();
            logger.info("Records were selected");
            return list;
        } catch (Exception e) {
            logger.error(e.getClass() + e.getMessage());
            return list;
        }
    }

    @WebMethod
    @Override
    public boolean updateUser(StudentsEntity entity) {
        Transaction transaction = null;
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
            logger.info(entity.getClass().getSimpleName() + Constants.UPDATED);
            return true;
        } catch (Exception e) {
            logger.error(e.getClass() + e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
    }

    @WebMethod
    @Override
    public boolean deleteUser(int id) {
        Transaction transaction = null;
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            session.delete(new StudentsEntity(id));
            transaction.commit();
            logger.info(StudentsEntity.class.getSimpleName() + id + Constants.DELETED);
            return true;
        } catch (Exception e) {
            logger.error(e.getClass() + e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
    }


    /**
     * методы для работы с группами
     */
    @Override
    public GroupsEntity insertGroup(GroupsEntity entity) {
        Transaction transaction = null;
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            entity = (GroupsEntity) session.merge(entity);
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
    public boolean deleteGroup(int id) {
        Transaction transaction = null;
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            session.delete(new GroupsEntity(id));
            transaction.commit();
            logger.info(GroupsEntity.class.getSimpleName() + id + Constants.DELETED);
            return true;
        } catch (Exception e) {
            logger.error(e.getClass() + e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
    }

    @Override
    public boolean updateGroup(GroupsEntity entity) {
        Transaction transaction = null;
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
            logger.info(entity.getClass().getSimpleName() + Constants.UPDATED);
            return true;
        } catch (Exception e) {
            logger.error(e.getClass() + e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
    }

    /**
     * метод для сервис-отправителя
     * return: объект с id лектора, название команды, имя и фамилия студента
     */
    @Override
    public List<Object> getInfoAboutLectorTeamStudent(int id) {
        Transaction transaction;
        List<Object> returnedObject = new ArrayList<>();
        StudentsEntity users = null;
        LecturersEntity lecturers = null;
        TeamsEntity teams = null;
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            /**
             * Если значение оказывается false, проверка
             * утверждения getId, getTeamName, getName считается проваленной
             * и выбрасывается AssertionError
             */
            assert false;
            logger.info(StudentsEntity.class.getSimpleName() + "AssertionError");
            returnedObject.add(lecturers.getId());
            returnedObject.add(teams.getTeamName());
            returnedObject.add(users.getName());
            returnedObject.add(users.getLastName());

            transaction.commit();
            logger.info(StudentsEntity.class.getSimpleName() + Constants.FOUND);

            return returnedObject;

        } catch (Exception e) {
            logger.info(e.getClass() + e.getMessage());
            return null;
        }
    }

    Session getSession() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        return sessionFactory.openSession();
    }
}
