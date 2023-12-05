package com.edu.webappstuddb_v4.repositories;

import com.edu.webappstuddb_v4.models.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface GradeRepository extends JpaRepository<Grade, Long> {
    List<Grade> findByStudentId(Long studentId);
}
