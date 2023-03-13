package com.example.medial.projects.repositories;

import com.example.medial.projects.models.Project;
import com.example.medial.projects.models.ProjectParticipation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectsParticipationRepository extends CrudRepository<ProjectParticipation, Long> {

    @Query(value = "select * from dbo.projects_participation WHERE user_id = ?1",
            nativeQuery = true)
    List<ProjectParticipation> findByUserId(Long userId);

}
