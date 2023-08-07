package com.example.mithbin.repositories;

import com.example.mithbin.models.UserModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID> {
    @Query(value = "SELECT * FROM TB_USERS WHERE EXTRACT(YEAR FROM age(NOW(), birth_at)) BETWEEN :minAge AND :maxAge", nativeQuery = true)
    Page<UserModel> findByAgeBetween(Double minAge, Double maxAge, Pageable page);
}
