package com.example.medial.versionado.repositories;

import com.example.medial.user.models.Password;
import com.example.medial.versionado.models.Versionado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface VersionadoRepository extends CrudRepository<Versionado, Long> {


    @Query(value = "select * from solveit.version_control WHERE [solveit].[version_control].version_number = ?1 and [solveit].[version_control].user_agent = ?2",
            nativeQuery = true)
    Versionado findByVersionAndOs(String version, String os);
}
