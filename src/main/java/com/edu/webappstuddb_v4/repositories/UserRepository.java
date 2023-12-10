package com.edu.webappstuddb_v4.repositories;

import com.edu.webappstuddb_v4.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
