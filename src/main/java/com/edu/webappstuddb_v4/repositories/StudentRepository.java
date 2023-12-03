package com.edu.webappstuddb_v4.repositories;

import com.edu.webappstuddb_v4.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByName(String name);
}
