package com.example.medial.jobs.repositories;

import com.example.medial.jobs.models.Job;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JobsRepository extends CrudRepository<Job, Long> {

    @Query(value = "select * from dbo.jobs",
            nativeQuery = true)
    List<Job> findAll();

}
