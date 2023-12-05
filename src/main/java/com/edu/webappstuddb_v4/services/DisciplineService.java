package com.edu.webappstuddb_v4.services;

import com.edu.webappstuddb_v4.models.Discipline;

import com.edu.webappstuddb_v4.repositories.DisciplineRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import java.util.List;
@Service
@Slf4j
@RequiredArgsConstructor

public class DisciplineService {

    private final DisciplineRepository disciplineRepository;

    public List<Discipline> getDisciplinesForStudent(Long studentId) {
        return disciplineRepository.findByStudentId(studentId);
    }
    public void saveDiscipline(Discipline discipline) {
        log.info("Saving new {}", discipline);
        disciplineRepository.save(discipline);
    }

    public Discipline getDisciplineById(Long disciplineId) {
        return disciplineRepository.findById(disciplineId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid discipline Id: " + disciplineId));
    }
}

