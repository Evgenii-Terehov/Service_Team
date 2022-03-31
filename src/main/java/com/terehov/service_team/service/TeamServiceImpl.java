package com.terehov.service_team.service;

import com.terehov.service_team.model.GroupEntity;
import com.terehov.service_team.model.UserEntity;
import com.terehov.service_team.model.UsersInClassEntity;
import com.terehov.service_team.model.UsersInGroupEntity;

import com.terehov.service_team.repository.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service //чтобы указать что класс - компонент спринга
public class TeamServiceImpl implements ITeamService {

    //переменные для инициализации репозиториев
    private final UserRepository userRepository;
    private final GroupRepository groupRepository;
    private final UsersInGroupRepository usersInGroupRepository;
    private final UsersInClassRepository usersInClassRepository;
    private final ClassRepository classRepository;

    //связывание репозиториев и контроллера через конструктор и инициализация репозиториев
    @Autowired
    public TeamServiceImpl(UserRepository userRepository,
                            GroupRepository groupRepository,
                            UsersInGroupRepository usersInGroupRepository,
                            UsersInClassRepository usersInClassRepository,
                           ClassRepository classRepository) {
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
        this.usersInGroupRepository = usersInGroupRepository;
        this.usersInClassRepository = usersInClassRepository;
        this.classRepository = classRepository;
    }

    private static final Logger logger = LogManager.getLogger(ITeamService.class);

    @Override
    public Boolean createGroup(String color) {
        try {
        groupRepository.save(new GroupEntity(color));
        logger.info(color.getClass().getSimpleName() + " Group added. The color is " + color);
        return true;
        } catch (Exception e) {
            logger.error(e.getClass() + e.getMessage());
            return false;
        }
    }

    @Override
    public Boolean deleteGroup(Integer idGroup) {
        try{
            groupRepository.deleteById(idGroup);
            return true;
        } catch (Exception e) {
            logger.error(e.getClass() + e.getMessage());
            return false;
        }
    }

    @Override
    public Boolean changeGroupColor(Integer idGroup, String color) {
        try {
            groupRepository.getById(idGroup).setColor(color);
            return true;
        } catch (Exception e) {
            logger.error(e.getClass() + e.getMessage());
            return false;
        }
    }

    @Override
    public Boolean addUserToGroup(Integer idGroup, Integer idUser, String role) {
        try {
            usersInGroupRepository.save(new UsersInGroupEntity(idGroup, idUser, role));
            return true;
        }catch (Exception e) {
            logger.error(e.getClass() + e.getMessage());
            return false;
        }
    }

    @Override
    public Boolean choiceRoleUserToGroup(Integer idGroup, Integer idUser, String role) {
        try {
            usersInGroupRepository.save(new UsersInGroupEntity(idGroup, idUser, role));
            return true;
        } catch (Exception e) {
            logger.error(e.getClass() + e.getMessage());
            return false;
        }
    }

    @Override
    public Boolean removeUserFromGroup(Integer idUser) {
        try {
            usersInGroupRepository.deleteById(idUser);
            return true;
        } catch (Exception e) {
            logger.error(e.getClass() + e.getMessage());
            return false;
        }
    }

    @Override
    public Boolean insertUser(UserEntity entity) {
        try {
            userRepository.save(entity);
            return true;
        } catch (Exception e) {
            logger.error(e.getClass() + e.getMessage());
            return false;
        }
    }

    @Override
    public UserEntity getUserById(Integer id) {
        try {
            return userRepository.getById(id);
        } catch (Exception e) {
            logger.error(e.getClass() + e.getMessage());
            return null;
        }
    }

    @Override
    public UsersInGroupEntity getUserFromGroup(Integer idUser) {
        try {
            return usersInGroupRepository.getById(idUser);
        } catch (Exception e) {
            logger.error(e.getClass() + e.getMessage());
            return null;
        }
    }

    @Override
    public UserEntity getTeamLeaderGroup(Integer idGroup) {
        UserEntity teamLeader = new UserEntity();
        try {
            for (UsersInGroupEntity user : groupRepository.getById(idGroup).getIdGroupEntity()) {
                if (user.getRole().equals("Team leader")) {
                    teamLeader = userRepository.getById(user.getId());
                }
            }
            return teamLeader;
        } catch (Exception e) {
            logger.error(e.getClass() + e.getMessage());
            return null;
        }
    }

    @Override
    public UsersInClassEntity getUserClass(Integer idUser) {
        try{
            return usersInClassRepository.getById(idUser);
        } catch (Exception e) {
            logger.error(e.getClass() + e.getMessage());
            return null;
        }
    }

    @Override
    public UserEntity getLectorGroup(Integer idClass) {
        UserEntity lector = new UserEntity();
        try {
            for (UsersInClassEntity user : classRepository.getById(idClass).getUsersInClassEntitiesFK()) {
                if (user.getRole().equals("Lector")) {
                    lector = userRepository.getById(user.getId());
                }
            }
            return lector;
        } catch (Exception e) {
            logger.error(e.getClass() + e.getMessage());
            return null;
        }
    }

    @Override
    public GroupEntity getGroupById(Integer idGroup) {
        try {
            return groupRepository.getById(idGroup);
        } catch (Exception e) {
            logger.error(e.getClass() + e.getMessage());
            return null;
        }
    }

    @Override
    public List<UserEntity> getListUsersInGroup(Integer idGroup) {
        List<UserEntity> usersList = new ArrayList<>();
        try {
            for (UsersInGroupEntity user : groupRepository.getById(idGroup).getIdGroupEntity()) {
                if (!user.getRole().equals("Student")) {
                    usersList.add(userRepository.getById(user.getId()));
                }
            }
            return usersList;
        } catch (Exception e) {
            logger.error(e.getClass() + e.getMessage());
            return null;
        }
    }

    @Override
    public List<UserEntity> getListUsersByListOfId(List<Integer> listOfId) {
        List<UserEntity> list = new ArrayList<>();
        try {
            for (int id : listOfId) {
                list.add(userRepository.getById(id));
            }
            return list;
        } catch (Exception e) {
            logger.error(e.getClass() + e.getMessage());
            return null;
        }
    }

    @Override
    public List<UserEntity> selectAllUsers() {
        try {
            return userRepository.findAll();
        } catch (Exception e) {
            logger.error(e.getClass() + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteUser(int id) {
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            logger.error(e.getClass() + e.getMessage());
            return false;
        }
    }

    @Override
    public Boolean insertGroup(GroupEntity entity) {
        try {
            groupRepository.save(entity);
            return true;
        } catch (Exception e) {
            logger.error(e.getClass() + e.getMessage());
            return false;
        }
    }
}
