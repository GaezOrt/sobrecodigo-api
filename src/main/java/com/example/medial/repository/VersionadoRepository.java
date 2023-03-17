package com.example.medial.repository;

import com.example.medial.model.entity.Versionado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VersionadoRepository extends CrudRepository<Versionado, Long> {


    @Query(value = "select * from version_control WHERE [dbo].[version_control].version_number = ?1 and [dbo].[version_control].user_agent = ?2",
            nativeQuery = true)
    Versionado findByVersionAndOs(String version, String os);
}
