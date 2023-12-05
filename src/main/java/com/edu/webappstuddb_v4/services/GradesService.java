package com.edu.webappstuddb_v4.services;

import com.edu.webappstuddb_v4.models.Grade;
import com.edu.webappstuddb_v4.repositories.GradeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor

public class GradesService {
    private final GradeRepository gradeRepository;

    public List<Grade> listGradesByStudentId(Long studentId) {
        return gradeRepository.findByStudentId(studentId);
    }
    public void saveGrade(Grade grade) {
        log.info("Saving new {}", grade);
        gradeRepository.save(grade);
    }
    public void deleteGrade(Long gradeId) {
        gradeRepository.deleteById(gradeId);
    }
}