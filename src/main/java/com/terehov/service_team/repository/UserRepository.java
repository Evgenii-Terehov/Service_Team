package com.terehov.service_team.repository;

import com.terehov.service_team.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity getUserEntitiesById (Integer idUser);
}
