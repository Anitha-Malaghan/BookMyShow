package com.example.bookmyshow1.repository;


import com.example.bookmyshow1.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findUserById(long userId);
}
