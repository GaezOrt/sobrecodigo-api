package com.example.medial.repository;

import com.example.medial.model.entity.Technology;
import com.example.medial.model.entity.UserTechnologies;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTechnologyRepository extends CrudRepository<UserTechnologies, Long> {

    @Query(value = "select * from dbo.user_technologies where dbo.user_technologies.user_id = ?1",
            nativeQuery = true)
    List<UserTechnologies> findByTechnologiesByUser(Long userId);

}
