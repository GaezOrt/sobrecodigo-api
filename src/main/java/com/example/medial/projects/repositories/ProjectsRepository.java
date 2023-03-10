package com.example.medial.projects.repositories;

import com.example.medial.projects.models.Project;
import com.example.medial.user.models.Password;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProjectsRepository extends CrudRepository<Project, Long> {

    @Query(value = "select * from dbo.projects",
            nativeQuery = true)
    List<Project> findAll();

}
