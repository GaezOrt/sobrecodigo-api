package com.example.medial.repository;

import com.example.medial.model.entity.JobPosition;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobsPositionRepository extends CrudRepository<JobPosition, Long> {

    @Query(value = "select * from dbo.positions",
            nativeQuery = true)
    List<JobPosition> findAll();

}
