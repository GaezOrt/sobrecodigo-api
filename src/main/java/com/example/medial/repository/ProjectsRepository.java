package com.example.medial.repository;

import com.example.medial.model.entity.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectsRepository extends CrudRepository<Project, Long> {

    @Query(value = "select * from dbo.projects",
            nativeQuery = true)
    List<Project> findAll();

}
