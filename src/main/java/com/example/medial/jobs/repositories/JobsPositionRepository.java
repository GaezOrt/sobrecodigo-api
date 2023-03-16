package com.example.medial.jobs.repositories;

import com.example.medial.jobs.models.Job;
import com.example.medial.jobs.models.JobPosition;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JobsPositionRepository extends CrudRepository<JobPosition, Long> {

    @Query(value = "select * from dbo.positions",
            nativeQuery = true)
    List<JobPosition> findAll();

}
