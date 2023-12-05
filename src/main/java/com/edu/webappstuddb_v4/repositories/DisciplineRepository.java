package com.edu.webappstuddb_v4.repositories;

import com.edu.webappstuddb_v4.models.Discipline;
import com.edu.webappstuddb_v4.models.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface DisciplineRepository extends JpaRepository<Discipline, Long> {
    List<Discipline> findByStudentId (Long studentId);
}
