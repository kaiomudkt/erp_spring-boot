package com.example.mithbin.core.repositories;

import com.example.mithbin.core.models.UserModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID> {
    @Query(value = "SELECT * FROM TB_USERS WHERE EXTRACT(YEAR FROM age(NOW(), birth_at)) BETWEEN :minAge AND :maxAge", nativeQuery = true)
    Page<UserModel> findByAgeBetween(Double minAge, Double maxAge, Pageable page);

    @Query(value = "SELECT * FROM TB_USERS as obj WHERE LOWER(obj.name) LIKE LOWER(CONCAT('%', :name, '%'))", nativeQuery = true)
    Page<UserModel> findByName(String name, Pageable page);

    // @Query("SELECT u FROM TB_USERS u WHERE u.login = :login")
    // UserModel findByLogin(@Param("login") String login);
    @Query("SELECT u FROM UserModel u WHERE u.login = :login")
    UserModel findByLogin(@Param("login") String login);

}
