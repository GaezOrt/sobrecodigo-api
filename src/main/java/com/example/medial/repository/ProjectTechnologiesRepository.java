package com.example.medial.repository;

import com.example.medial.model.entity.Currency;
import com.example.medial.model.entity.ProjectTechnologies;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectTechnologiesRepository extends CrudRepository<ProjectTechnologies, Long> {

    @Query(value = "select * from dbo.projects_technologies",
            nativeQuery = true)
    List<ProjectTechnologies> findAll();

    @Query(value = "select * from dbo.projects_technologies where project_id = ?1",
            nativeQuery = true)
    List<ProjectTechnologies> findByProject(Long project);

}
