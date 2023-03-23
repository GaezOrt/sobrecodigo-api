package com.example.medial.repository;

import com.example.medial.model.entity.Currency;
import com.example.medial.model.entity.Technology;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TechnologiesRepository extends CrudRepository<Technology, Long> {

    @Query(value = "select * from dbo.technologies",
            nativeQuery = true)
    List<Technology> findAll();

    @Query(value = "select * from dbo.technologies where dbo.technology = ?1",
            nativeQuery = true)
    Technology findByTechnologyName(String technology);


}
