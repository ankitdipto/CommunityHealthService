package com.ankitdipto.Community_Health_Management.USER;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<MyUser,Long>{
    Optional<MyUser> findByUsername(String username);

    @Query(value = "SELECT COUNT(*) FROM users",
    nativeQuery = true)
    long countNoOfUsers();
}
