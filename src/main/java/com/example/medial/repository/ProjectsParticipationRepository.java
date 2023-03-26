package com.example.medial.repository;

import com.example.medial.model.entity.ProjectParticipation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectsParticipationRepository extends JpaRepository<ProjectParticipation, Long> {

    //@Query(value = "select * from dbo.projects_participation WHERE user_id = ?1", nativeQuery = true)
    //List<ProjectParticipation> findByUserId(Long userId);

    Optional<List<ProjectParticipation>> findByUserId(Long userId);

    @Query(value = "select * from dbo.projects_participation WHERE project_id = ?1", nativeQuery = true)
    List<ProjectParticipation> findParticipantsByProjectId(Long projectId);

}
