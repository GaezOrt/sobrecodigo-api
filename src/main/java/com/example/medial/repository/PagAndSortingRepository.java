package com.example.medial.repository;

import com.example.medial.model.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PagAndSortingRepository extends PagingAndSortingRepository<Project, Long> {


    @Override
     Page<Project> findAll(Pageable pageable);
}
