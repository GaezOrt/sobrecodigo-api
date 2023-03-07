package com.example.medial.user.repositories;

import com.example.medial.user.models.Password;
import com.example.medial.user.models.Usuario;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

    public interface PasswordRepository extends CrudRepository<Password, Long> {

    @Query(value = "select * from dbo.password",
            nativeQuery = true)
    List<Password> findAll();

    @Query(value = "select * from [dbo].[password] WHERE user_id = ?1",
            nativeQuery = true)
   Password findPasswordByUserId(Long id);

    @Modifying
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Query(value = "INSERT INTO [solveit].[password] (password, user_id) VALUES(?1, ?2)",
            nativeQuery = true)
    void insertarUsuarioPassword(String password, Long userId);

    @Modifying
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Query(value = "UPDATE [solveit].[password] SET password_recovery_code = ?1 WHERE user_id = ?2",
            nativeQuery = true)
    void addPasswordCode(String code, Long userId);

    @Modifying
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Query(value = "UPDATE [solveit].[password] SET password = ?1 WHERE user_id = ?2",
            nativeQuery = true)
    void updatePassword(String password, Long userId);

}
