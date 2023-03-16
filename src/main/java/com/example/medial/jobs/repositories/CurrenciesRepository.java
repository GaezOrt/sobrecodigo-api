package com.example.medial.jobs.repositories;

import com.example.medial.jobs.models.Currency;
import com.example.medial.jobs.models.Job;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CurrenciesRepository extends CrudRepository<Currency, Long> {

    @Query(value = "select * from dbo.currencies",
            nativeQuery = true)
    List<Currency> findAll();

}
