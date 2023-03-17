package com.example.medial.repository;

import com.example.medial.model.entity.Currency;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurrenciesRepository extends CrudRepository<Currency, Long> {

    @Query(value = "select * from dbo.currencies",
            nativeQuery = true)
    List<Currency> findAll();

}
