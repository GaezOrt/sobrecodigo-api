package com.example.medial.repository;

import com.example.medial.model.entity.ProjectParticipation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectsParticipationRepository extends CrudRepository<ProjectParticipation, Long> {

    @Query(value = "select * from dbo.projects_participation WHERE user_id = ?1",
            nativeQuery = true)
    List<ProjectParticipation> findByUserId(Long userId);

}
