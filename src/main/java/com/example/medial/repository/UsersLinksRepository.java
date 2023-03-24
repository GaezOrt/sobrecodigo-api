package com.example.medial.repository;

import com.example.medial.model.entity.Currency;
import com.example.medial.model.entity.UsersLinks;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersLinksRepository extends CrudRepository<UsersLinks, Long> {

    @Query(value = "select * from dbo.users_links",
            nativeQuery = true)
    List<UsersLinks> findAll();

    @Query(value = "select * from dbo.users_links where user_id = ?1",
            nativeQuery = true)
    UsersLinks findByUserId(Long userId);

}
