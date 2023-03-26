package com.example.medial.repository;

import com.example.medial.model.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobsRepository extends JpaRepository<Job, Long> {

    @Query(value = "select * from dbo.jobs",
            nativeQuery = true)
    List<Job> findAll();

}
