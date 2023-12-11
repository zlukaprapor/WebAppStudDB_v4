package com.edu.webappstuddb_v4.services;

import com.edu.webappstuddb_v4.models.Discipline;

import com.edu.webappstuddb_v4.repositories.DisciplineRepository;
import com.edu.webappstuddb_v4.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import java.util.List;
@Service
@Slf4j
@RequiredArgsConstructor

public class DisciplineService {

    private final DisciplineRepository disciplineRepository;
    private  final UserRepository userRepository;
    public List<Discipline> getDisciplinesForStudent(Long studentId) {
        return disciplineRepository.findByStudentId(studentId);
    }
    public void saveDiscipline(Discipline discipline) {
        log.info("Saving new {}", discipline);
        disciplineRepository.save(discipline);
    }

    public void deleteDiscipline(Long disciplineId) {
        disciplineRepository.deleteById(disciplineId);
    }
}

