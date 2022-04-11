package com.terehov.service_team.repository;

import com.terehov.service_team.model.GroupEntity;
import com.terehov.service_team.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<GroupEntity, Integer> {
    GroupEntity getGroupEntitiesById (Integer idGroup);
}
