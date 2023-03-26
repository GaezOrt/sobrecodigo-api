package com.example.medial.repository;

import com.example.medial.model.entity.Password;
import com.example.medial.model.entity.TechnologyColorsIcon;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TechnologyColorsIconRepository extends CrudRepository<TechnologyColorsIcon, Long> {

    @Query(value = "select * from dbo.technologies_colors_icon",
            nativeQuery = true)
    List<TechnologyColorsIcon> findAll();

    @Query(value = "select * from [dbo].[technologies_colors_icon] WHERE technology_id = ?1",
            nativeQuery = true)
    TechnologyColorsIcon findIconByTechnology(Long id);

}
