package com.example.medial.repository;

import com.example.medial.model.entity.Usuario;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface UsersRepository extends CrudRepository<Usuario, Long> {

    @Query(value = "select * from dbo.dim_user",
            nativeQuery = true)
    List<Usuario> findAll();

    @Query(value = "select * from [dbo].[dim_user] WHERE email = ?1",
            nativeQuery = true)
   Usuario findByEmail(String email);

    @Query(value = "select * from [dbo].[dim_user] WHERE id = ?1",
            nativeQuery = true)
    Usuario findByUniqueId(Long id);

    @Query(value = "select du.* from [dbo].[dim_user] du JOIN [dbo].[password] pw on du.id=pw.user_id where du.email =?1 and pw.[password] = ?2",
            nativeQuery = true)
    Usuario userExists(String email, String password);

    @Modifying
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Query(value = "UPDATE [solveit].[user]  SET first_name = ?1, last_name = ?2, birth_date = ?3, country = ?4, document=?5 WHERE id = ?6",
            nativeQuery = true)
    void insertarUsuarioSecondStep(String firstName, String lastName, Date birthDate, Long country, String document, Long id);

    @Query(value = "select TOP 5 * from dbo.dim_user order by id desc",
            nativeQuery = true)
    List<Usuario> findMostActive();

}
